package com.qhn.bhne.baseproject.wight;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.request.target.SimpleTarget;
import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.entity.Songs;
import com.qhn.bhne.baseproject.utils.DisplayUtil;
import com.qhn.bhne.baseproject.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qhn
 * on 2017/1/17 0017.
 */

public class DisView extends RelativeLayout {
    private ImageView mIvNeedle;//唱针
    private ViewPager mVpContain;//唱盘切换容器
    private ViewPagerAdapter mViewPagerAdapter;
    private ObjectAnimator mNeedleAnimator;//唱针动画
    private List<View> mDisLayouts;//唱盘视图集合
    private List<Songs> mMusicDatas;//歌曲数据
    private List<ObjectAnimator> mDiscAnimators;
    private Boolean mViewPagerIsOffset;//标记ViewPager是否处于偏移的状态
    private Boolean mIsNeedStartPlayAnimator;//标记唱针复位后，是否需要重新偏移到唱片处
    private MusicStatus musicStatus = MusicStatus.STOP;
    public static final int DURATION_NEEDLE_ANIAMTOR = 500;
    private NeedleAnimatorStatus needleAnimatorStatus = NeedleAnimatorStatus.IN_FAR_END;
    private IPlayInfo mIPlayInfo;
    private int mScreenWidth, mScreenHeight;
    private Context mContext;
    private SimpleTarget<Bitmap> simpleTarget;

    public interface IPlayInfo {
        //用于更新标题栏变化
        void onMusicInfoChanged(String musicName, String musicAuthor);

        //用于更新背景图片
        void onMusicPicChanged(String musicPicRes);

        //用于更新音乐播放状态
        void onMusicChanged(MusicChangedStatus musicChangedStatus);
    }

    public enum MusicStatus {//标记音乐当前的状态，只有播放，暂停，停止三种
        PLAY, PAUSE, STOP
    }

    public enum MusicChangedStatus {//音乐切换状态：播放、暂停、上/下一首、停止
        PLAY, PAUSE, STOP, LAST, NEXT
    }

    public enum NeedleAnimatorStatus {
        //移动时，从唱盘远处移动
        TO_FAR_END,
        //移动时，从唱盘近处移动
        TO_NEAR_END,
        //静止时，在唱盘远处
        IN_FAR_END,
        //静止时，在唱盘近处
        IN_NEAR_END
    }

    public DisView(Context context) {
        super(context, null);
    }

    public DisView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public DisView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScreenHeight = DisplayUtil.getScreenHeight(context);
        mScreenWidth = DisplayUtil.getScreenWidth(context);
        mContext = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initData();
        initDiscBackground();
        initViewPager();
        initNeedle();
        initObjectAnimator();
    }

    private void initData() {
        mDisLayouts = new ArrayList<>();
        mMusicDatas = new ArrayList<>();
        mDiscAnimators = new ArrayList<>();
    }

    public void setPlayInfoListener(IPlayInfo listener) {
        this.mIPlayInfo = listener;
    }

    public void setmMusicDatas(List<Songs> musicDataList) {
        if (musicDataList.isEmpty()) return;
        mDisLayouts.clear();
        mMusicDatas.clear();
        mDiscAnimators.clear();
        mMusicDatas.addAll(musicDataList);
        int i = 0;
        for (Songs songs : musicDataList) {
            View discLayout = LayoutInflater.from(getContext()).inflate(R.layout.layout_disc, mVpContain, false);
            ImageView disc = (ImageView) discLayout.findViewById(R.id.ivDisc);
            disc.setImageDrawable(getDiscDrawable(songs.getPicUrl()));
            mDiscAnimators.add(getDiscObjectAnimator(disc, i++));
            mDisLayouts.add(discLayout);
        }
        mViewPagerAdapter.notifyDataSetChanged();
        Songs songs = musicDataList.get(0);
        if (mIPlayInfo != null) {
            mIPlayInfo.onMusicInfoChanged(songs.getName(), songs.getSingerName());
            mIPlayInfo.onMusicPicChanged(songs.getPicUrl());
        }
    }

    private ObjectAnimator getDiscObjectAnimator(ImageView disc, int i) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(disc, View.ROTATION, 0, 360);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setDuration(20 * 1000);
        objectAnimator.setInterpolator(new LinearInterpolator());
        return objectAnimator;
    }

    //得到唱盘图片,唱盘图片由空心圆盘及音乐专辑图片合成
    private Drawable getDiscDrawable(String picUrl) {
        int discSize = (int) (mScreenWidth * DisplayUtil.SCALE_DISC_SIZE);
        int musicPicSize = (int) (mScreenWidth * DisplayUtil.SCALE_MUSIC_PIC_SIZE);
        Bitmap bitmapDisc = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_disc), discSize, discSize, false);
        Bitmap bitmapMusicPic = getMusicPicBitmap(musicPicSize, picUrl);

        BitmapDrawable discDrawable = new BitmapDrawable(bitmapDisc);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmapMusicPic);
        discDrawable.setAntiAlias(true);//抗锯齿
        roundedBitmapDrawable.setAntiAlias(true);

        Drawable[] drawables = new Drawable[2];
        drawables[0] = roundedBitmapDrawable;
        drawables[1] = discDrawable;

        LayerDrawable layerDrawable = new LayerDrawable(drawables);
        int musicPicMargin = (int) ((DisplayUtil.SCALE_DISC_SIZE - DisplayUtil.SCALE_MUSIC_PIC_SIZE) * mScreenWidth / 2);
        layerDrawable.setLayerInset(0, musicPicMargin, musicPicMargin, musicPicMargin, musicPicMargin);
        return layerDrawable;
    }

    private Bitmap getMusicPicBitmap(int musicPicSize, String picUrl) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;


        int imageWidth = options.outWidth;
        int sample = imageWidth / musicPicSize;
        int dstSample = 1;
        if (sample > dstSample) {
            dstSample = sample;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = dstSample;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        byte[] imageBytes = MyUtils.getImage(picUrl);
        return Bitmap.createScaledBitmap(BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length, options), musicPicSize, musicPicSize, true);
    }

    private void initDiscBackground() {
        ImageView mDiscBackground = (ImageView) findViewById(R.id.ivDiscBlackgound);
        mDiscBackground.setImageDrawable(getDisBackgroundDrawable());
        int marginTop = (int) (DisplayUtil.SCALE_DISC_MARGIN_TOP * mScreenWidth);
        RelativeLayout.LayoutParams layoutParams = (LayoutParams) mDiscBackground.getLayoutParams();
        layoutParams.setMargins(0, marginTop, 0, 0);
        mDiscBackground.setLayoutParams(layoutParams);
    }


    private void initViewPager() {
        mViewPagerAdapter = new ViewPagerAdapter();
        mVpContain = (ViewPager) findViewById(R.id.vpDiscContain);
        mVpContain.setOverScrollMode(View.OVER_SCROLL_NEVER);//不懂为什么
        mVpContain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int lastPositionOffsetPixels = 0;
            int currentItem = 0;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (lastPositionOffsetPixels >= positionOffsetPixels) {//左滑
                    if (positionOffset < 0.5) {
                        notifyMusicInfoChanged(position);
                    } else {
                        notifyMusicInfoChanged(mVpContain.getCurrentItem());
                    }
                } else if (lastPositionOffsetPixels < positionOffsetPixels) {//右滑
                    if (positionOffset > 0.5) {
                        notifyMusicInfoChanged(position + 1);
                    } else {
                        notifyMusicInfoChanged(position);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {
                resetOtherDiscAnimation(position);
                notifyMusicPicChanged(position);
                if (position > currentItem) {
                    notifyMusicStatusChanged(MusicChangedStatus.NEXT);
                } else {
                    notifyMusicStatusChanged(MusicChangedStatus.LAST);
                }
                currentItem = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                doWithAnimatorOnPageScroll(state);
            }
        });
        mVpContain.setAdapter(mViewPagerAdapter);
        //不懂是干嘛的
        RelativeLayout.LayoutParams layoutParams = (LayoutParams) mVpContain.getLayoutParams();
        int marginTop = (int) (DisplayUtil.SCALE_DISC_MARGIN_TOP * mScreenHeight);
        layoutParams.setMargins(0, marginTop, 0, 0);
        mVpContain.setLayoutParams(layoutParams);
    }


    private void initNeedle() {
        mIvNeedle = (ImageView) findViewById(R.id.ivNeedle);
        int needleWidth = (int) (DisplayUtil.SCALE_NEEDLE_WIDTH * mScreenWidth);
        int needleHeight = (int) (DisplayUtil.SCALE_NEEDLE_HEIGHT * mScreenHeight);

        int marginTop = (int) (DisplayUtil.SCALE_NEEDLE_MARGIN_TOP * mScreenHeight) * -1;
        int marginLeft = (int) (DisplayUtil.SCALE_NEEDLE_MARGIN_LEFT * mScreenWidth);

        Bitmap originBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_music_needle);
        Bitmap bitmap = Bitmap.createScaledBitmap(originBitmap, needleWidth, needleHeight, false);
        RelativeLayout.LayoutParams layoutParams = (LayoutParams) mIvNeedle.getLayoutParams();
        layoutParams.setMargins(marginLeft, marginTop, 0, 0);
        int pivotX = (int) (DisplayUtil.SCALE_NEEDLE_PIVOT_X * mScreenWidth);
        int pivotY = (int) (DisplayUtil.SCALE_NEEDLE_PIVOT_Y * mScreenWidth);
        mIvNeedle.setPivotX(pivotX);
        mIvNeedle.setPivotY(pivotY);
        mIvNeedle.setRotation(DisplayUtil.ROTATION_INIT_NEEDLE);
        mIvNeedle.setImageBitmap(bitmap);
        mIvNeedle.setLayoutParams(layoutParams);


    }

    private void initObjectAnimator() {
        mNeedleAnimator = ObjectAnimator.ofFloat(mIvNeedle, View.ROTATION, DisplayUtil.ROTATION_INIT_NEEDLE, 0);
        mNeedleAnimator.setDuration(DURATION_NEEDLE_ANIAMTOR);
        mNeedleAnimator.setInterpolator(new AccelerateInterpolator());
        mNeedleAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                //计算出动画执行状态根据唱针目前的状态
                if (needleAnimatorStatus == NeedleAnimatorStatus.IN_FAR_END) {
                    needleAnimatorStatus = NeedleAnimatorStatus.TO_NEAR_END;
                } else if (needleAnimatorStatus == NeedleAnimatorStatus.IN_NEAR_END) {
                    needleAnimatorStatus = NeedleAnimatorStatus.TO_FAR_END;
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (needleAnimatorStatus == NeedleAnimatorStatus.TO_NEAR_END) {
                    needleAnimatorStatus = NeedleAnimatorStatus.IN_NEAR_END;
                    int index = mVpContain.getCurrentItem();
                    playDiscAnimator(index);
                    musicStatus = MusicStatus.PLAY;
                } else if (needleAnimatorStatus == NeedleAnimatorStatus.TO_FAR_END) {
                    needleAnimatorStatus = NeedleAnimatorStatus.IN_FAR_END;
                    if (musicStatus == MusicStatus.STOP) {
                        mIsNeedStartPlayAnimator = true;
                    }
                }
                if (mIsNeedStartPlayAnimator) {
                    mIsNeedStartPlayAnimator = false;
                    //只有viewpager不在偏移状态时，才开始唱盘旋转动画
                    if (!mViewPagerIsOffset) {
                        DisView.this.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                playAnimator();
                            }
                        }, 50);
                    }
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }


    private void doWithAnimatorOnPageScroll(int state) {
        switch (state) {
            case ViewPager.SCROLL_STATE_IDLE:
                break;
            case ViewPager.SCROLL_STATE_SETTLING:
                mViewPagerIsOffset = false;
                if (musicStatus == MusicStatus.PLAY) {
                    playAnimator();
                }
                break;
            case ViewPager.SCROLL_STATE_DRAGGING:
                mViewPagerIsOffset = true;
                pauseAnimator();
                break;
        }
    }

    //得到唱盘背后的半透明的圆形背景
    private Drawable getDisBackgroundDrawable() {
        int discSize = (int) (mScreenWidth * DisplayUtil.SCALE_DISC_SIZE);
        Bitmap bitmapDisc = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R
                .mipmap.ic_disc_blackground), discSize, discSize, false);
        RoundedBitmapDrawable roundDiscDrawable = RoundedBitmapDrawableFactory.create
                (getResources(), bitmapDisc);
        return roundDiscDrawable;

    }

    private void resetOtherDiscAnimation(int position) {
        for (int i = 0; i < mDisLayouts.size(); i++) {
            if (position == i) continue;
            mDiscAnimators.get(position).cancel();
            ImageView imageView = (ImageView) mDisLayouts.get(i).findViewById(R.id.ivDisc);
            imageView.setRotation(0);

        }
    }

    //播放唱盘动画
    private void playDiscAnimator(int index) {
        ObjectAnimator objectAnimator = mDiscAnimators.get(index);
        if (objectAnimator.isPaused()) {
            objectAnimator.resume();
        } else {
            objectAnimator.start();
        }
        if (musicStatus != MusicStatus.PLAY) {
            notifyMusicStatusChanged(MusicChangedStatus.PLAY);
        }
    }

    //播放指针动画
    private void playAnimator() {
        //唱针在远处时,直接播放动画
        if (needleAnimatorStatus == NeedleAnimatorStatus.IN_FAR_END) {
            mNeedleAnimator.start();
        }
        //唱针处于往远端移动时，设置标记，等动画结束后再播放动画
        else if (needleAnimatorStatus == NeedleAnimatorStatus.TO_FAR_END) {
            mIsNeedStartPlayAnimator = true;
        }
    }

    //暂停动画
    private void pauseAnimator() {
        //音乐暂停时，暂停唱盘动画
        if (needleAnimatorStatus == NeedleAnimatorStatus.IN_NEAR_END) {
            int index = mVpContain.getCurrentItem();
            pauseDisAnimator(index);
        } else if (needleAnimatorStatus == NeedleAnimatorStatus.TO_NEAR_END) {
            mNeedleAnimator.reverse();
            needleAnimatorStatus = NeedleAnimatorStatus.TO_FAR_END;
        }
        if (musicStatus == MusicStatus.STOP) {
            notifyMusicStatusChanged(MusicChangedStatus.STOP);
        } else if (musicStatus == MusicStatus.PAUSE) {
            notifyMusicStatusChanged(MusicChangedStatus.PAUSE);
        }
    }

    private void pauseDisAnimator(int index) {
        ObjectAnimator objectAnimator = mDiscAnimators.get(index);
        objectAnimator.pause();
        mNeedleAnimator.reverse();
    }

    //改变音乐信息
    private void notifyMusicInfoChanged(int position) {
        if (mIPlayInfo != null) {
            Songs songs = mMusicDatas.get(position);
            mIPlayInfo.onMusicInfoChanged(songs.getName(), songs.getSingerName());
        }
    }

    //改变音乐状态
    private void notifyMusicStatusChanged(MusicChangedStatus musicChangedStatus) {
        if (mIPlayInfo != null) {
            mIPlayInfo.onMusicChanged(musicChangedStatus);
        }
    }

    //改变唱盘照片
    private void notifyMusicPicChanged(int position) {
        if (mIPlayInfo != null) {
            Songs songs = mMusicDatas.get(position);
            mIPlayInfo.onMusicPicChanged(songs.getPicUrl());
        }
    }

    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View discLayout = mDisLayouts.get(position);
            container.addView(discLayout);
            return discLayout;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mDisLayouts.get(position));
        }

        @Override
        public int getCount() {
            return mDisLayouts.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    //音乐停止
    public void stop() {
        musicStatus = MusicStatus.STOP;
        pauseAnimator();
    }

    //音乐播放或者暂停
    public void playOrPause() {
        if (musicStatus == MusicStatus.PLAY) {
            pause();
        } else {
            play();
        }
    }

    public void next() {
        int currentItem = mVpContain.getCurrentItem();
        if (currentItem == mMusicDatas.size() - 1) {
            Toast.makeText(mContext, "已经达到最后一首", Toast.LENGTH_SHORT).show();
        } else {
            selectMusicWithButton();
            mVpContain.setCurrentItem(currentItem + 1, true);
        }
    }

    public void last() {
        int currentItem = mVpContain.getCurrentItem();
        if (currentItem == 0) {
            Toast.makeText(mContext, "已经是第一首", Toast.LENGTH_SHORT).show();
        } else {
            selectMusicWithButton();
            mVpContain.setCurrentItem(currentItem - 1, true);
        }
    }

    public Boolean isPlaying() {
        return musicStatus == MusicStatus.PLAY;
    }

    private void pause() {
        musicStatus = MusicStatus.PAUSE;
        pauseAnimator();
    }

    private void play() {
        playAnimator();
    }

    private void selectMusicWithButton() {
        if (musicStatus== MusicStatus.PLAY) {
            mIsNeedStartPlayAnimator=true;
            pauseAnimator();
        }else if (musicStatus==MusicStatus.PAUSE){
            play();
        }
    }


}
