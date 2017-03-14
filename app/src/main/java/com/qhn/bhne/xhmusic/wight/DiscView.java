package com.qhn.bhne.xhmusic.wight;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.application.App;
import com.qhn.bhne.xhmusic.common.MusicConstants;
import com.qhn.bhne.xhmusic.mvp.entity.GlobalPlayMusic;
import com.qhn.bhne.xhmusic.mvp.entity.SongInfo;
import com.qhn.bhne.xhmusic.mvp.entity.Songs;
import com.qhn.bhne.xhmusic.utils.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * @author quhuainan
 *         created on 2017/3/5 0005
 */

public class DiscView extends RelativeLayout {
    private Context mContext;
    //盘针
    private ImageView mIvNeedle;
    //页面切换viewpager
    private ViewPager mVpContain;
    //页面切换viewpager的适配器
    private ViewPagerAdapter mViewPagerAdapter;
    //盘针动画
    private ObjectAnimator mNeedleAnimator;
    //唱盘中唱片的数据源
    private List<View> mDiscLayouts = new ArrayList<>();


    private int playListPosition = 0;
    //动画集合
    private List<ObjectAnimator> mDiscAnimators = new ArrayList<>();

    /*标记ViewPager是否处于偏移的状态*/
    private boolean mViewPagerIsOffset = false;

    /*标记唱针复位后，是否需要重新偏移到唱片处*/
    private boolean mIsNeed2StartPlayAnimator = false;

    //音乐默认状态
    private MusicConstants.MusicStatus musicStatus = MusicConstants.MusicStatus.STOP;

    //唱针默认动画时长
    public static final int DURATION_NEEDLE_ANIMATOR = 500;

    //唱针动画状态
    private NeedleAnimatorStatus needleAnimatorStatus = NeedleAnimatorStatus.IN_FAR_END;

    //对外部暴露的接口，用于动态改变唱片的信息
    private IPlayInfo mIPlayInfo;

    //屏幕的宽和高
    private int mScreenWidth, mScreenHeight;

    private GlobalPlayMusic currentPlayMusic;

    private List<Songs> mSongsList = new ArrayList<>();

    /*唱针当前所处的状态*/
    private enum NeedleAnimatorStatus {
        /*移动时：从唱盘往远处移动*/
        TO_FAR_END,
        /*移动时：从远处往唱盘移动*/
        TO_NEAR_END,
        /*静止时：离开唱盘*/
        IN_FAR_END,
        /*静止时：贴近唱盘*/
        IN_NEAR_END
    }


    /*DiscView需要触发的音乐切换状态：播放、暂停、上/下一首、停止*/
    public enum MusicChangedStatus {
        PLAY, PAUSE, NEXT, LAST, STOP
    }

    public interface IPlayInfo {
        /*用于更新标题栏变化*/
        void onMusicInfoChanged(String musicName, String musicAuthor);

        /*用于更新背景图片*/
        void onMusicPicChanged(String musicPicRes);

        /*用于更新音乐播放状态*/
        void onMusicChanged(MusicChangedStatus musicChangedStatus);
    }

    private static final String TAG = "DiscView";

    public DiscView(Context context) {
        this(context, null);
    }

    public DiscView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiscView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScreenWidth = DisplayUtil.getScreenWidth(context);
        mScreenHeight = DisplayUtil.getScreenHeight(context);
        mContext=context;

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        initDiscBackground();
        initViewPager();
        initNeedle();
        initObjectAnimator();
    }



    //初始化底盘
    private void initDiscBackground() {
        ImageView mDiscBackground = (ImageView) findViewById(R.id.ivDiscBlackgound);
        //根据当前屏幕的大小获取对应比例的底盘尺寸
        int discSize = (int) (mScreenWidth * DisplayUtil.SCALE_DISC_SIZE);

        //动态获取背景图片的对应的位置
        int marginTop = (int) (DisplayUtil.SCALE_DISC_MARGIN_TOP * mScreenHeight*1.06);
        //int marginTop2 = (int) (DisplayUtil.SCALE_NEEDLE_MARGIN_TOP * mScreenHeight);
        LayoutParams layoutParams = (LayoutParams) mDiscBackground
                .getLayoutParams();
        layoutParams.height = discSize;
        layoutParams.width = discSize;
        layoutParams.setMargins(0, marginTop, 0, 0);

        mDiscBackground.setLayoutParams(layoutParams);
        Glide.with(mContext).load(R.drawable.ic_disc_blackground).centerCrop().bitmapTransform(new CropCircleTransformation(mContext)).into(mDiscBackground);

    }


    //初始化viewpager
    private void initViewPager() {
        mViewPagerAdapter = new ViewPagerAdapter(mSongsList, mDiscLayouts);
        mVpContain = (ViewPager) findViewById(R.id.vpDiscContain);
        mVpContain.setCurrentItem(playListPosition);
        //取消滑动结束时出现颜色渐变
        mVpContain.setOverScrollMode(View.OVER_SCROLL_NEVER);

        mVpContain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int lastPositionOffsetPixels = 0;
            int currentItem = playListPosition;

            //当页面滚动时回调 position当前页面所处的位置，positionOffset 偏移的比例，positionOffsetPixels 偏移的像素点
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {
                //手指向左滑
                if (lastPositionOffsetPixels > positionOffsetPixels) {
                    if (positionOffset < 0.5) {//滑动幅度小于
                        notifyMusicInfoChanged(position);
                    } else {
                        notifyMusicInfoChanged(mVpContain.getCurrentItem());
                    }
                }
                //右滑
                else if (lastPositionOffsetPixels < positionOffsetPixels) {
                    if (positionOffset > 0.5) {
                        notifyMusicInfoChanged(position + 1);
                    } else {
                        notifyMusicInfoChanged(position);
                    }
                }
                //记录上一次滑动时的所处的像素点，多次滑动时有用
                lastPositionOffsetPixels = positionOffsetPixels;
            }

            //当滑动到新页面时回调
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

            //当滑动状态改变时回调
            @Override
            public void onPageScrollStateChanged(int state) {
                doWithAnimatorOnPageScroll(state);
            }
        });
        mVpContain.setAdapter(mViewPagerAdapter);
        //mVpContain.setCurrentItem(currentPlayMusic.getPlayPosition());
        int marginTop = (int) (DisplayUtil.SCALE_NEEDLE_MARGIN_TOP * mScreenHeight*3.5);
       // int marginTop = (int) (DisplayUtil.SCALE_DISC_MARGIN_TOP * mScreenHeight);
        LayoutParams layoutParams = (LayoutParams) mVpContain
                .getLayoutParams();

        layoutParams.setMargins(0, 0,0, marginTop );
        mVpContain.setLayoutParams(layoutParams);


    }

    //取消其他页面上的动画，并将图片旋转角度复原
    private void resetOtherDiscAnimation(int position) {
        for (int i = 0; i < mDiscLayouts.size(); i++) {
            if (position == i) continue;
            mDiscAnimators.get(position).cancel();
            ImageView imageView = (ImageView) mDiscLayouts.get(i).findViewById(R.id.ivDisc);
            imageView.setRotation(0);
        }
    }

    //跟随滑动状态来改变toolbar上的信息
    public void notifyMusicInfoChanged(int position) {
        if (mIPlayInfo != null) {
            //需要变动的地方
            SongInfo musicData = mSongsList.get(position).getSongInfo();
            mIPlayInfo.onMusicInfoChanged(musicData.getSongName(), musicData.getSingerName());
        }
    }

    //动态设置指针的位置以及偏移角度
    private void initNeedle() {
        mIvNeedle = (ImageView) findViewById(R.id.ivNeedle);

        int needleWidth = (int) (DisplayUtil.SCALE_NEEDLE_WIDTH * mScreenWidth);
        int needleHeight = (int) (DisplayUtil.SCALE_NEEDLE_HEIGHT * mScreenHeight);

        /*设置手柄的外边距为负数，让其隐藏一部分*/
        int marginTop = (int) (DisplayUtil.SCALE_NEEDLE_MARGIN_TOP * mScreenHeight) * -1;
        int marginLeft = (int) (DisplayUtil.SCALE_NEEDLE_MARGIN_LEFT * mScreenWidth);

        Bitmap originBitmap = BitmapFactory.decodeResource(getResources(), R.drawable
                .ic_needle);
        Bitmap bitmap = Bitmap.createScaledBitmap(originBitmap, needleWidth, needleHeight, false);

        RelativeLayout.LayoutParams layoutParams = (LayoutParams) mIvNeedle.getLayoutParams();
        layoutParams.setMargins(marginLeft,marginTop, 0, 0);

        int pivotX = (int) (DisplayUtil.SCALE_NEEDLE_PIVOT_X * mScreenWidth);
        int pivotY = (int) (DisplayUtil.SCALE_NEEDLE_PIVOT_Y * mScreenWidth);

        mIvNeedle.setPivotX(pivotX);
        mIvNeedle.setPivotY(pivotY);
        mIvNeedle.setRotation(DisplayUtil.ROTATION_INIT_NEEDLE);
        mIvNeedle.setImageBitmap(bitmap);
        mIvNeedle.setLayoutParams(layoutParams);
    }

    //初始化唱针动画
    private void initObjectAnimator() {
        mNeedleAnimator = ObjectAnimator.ofFloat(mIvNeedle, View.ROTATION, DisplayUtil
                .ROTATION_INIT_NEEDLE, 0);
        mNeedleAnimator.setDuration(DURATION_NEEDLE_ANIMATOR);
        mNeedleAnimator.setInterpolator(new AccelerateInterpolator());
        mNeedleAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                //根据动画开始前NeedleAnimatorStatus的状态，即可得出动画进行时NeedleAnimatorStatus的状态

                //当指针在远处静止时，那么其动画状态就应该是移动到近处
                if (needleAnimatorStatus == NeedleAnimatorStatus.IN_FAR_END) {
                    needleAnimatorStatus = NeedleAnimatorStatus.TO_NEAR_END;
                } else if (needleAnimatorStatus == NeedleAnimatorStatus.IN_NEAR_END) {
                    needleAnimatorStatus = NeedleAnimatorStatus.TO_FAR_END;
                }
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //指针动画结束后，重新定义指针动画状态属性并开始播放/暂停唱盘动画
                if (needleAnimatorStatus == NeedleAnimatorStatus.TO_NEAR_END) {
                    needleAnimatorStatus = NeedleAnimatorStatus.IN_NEAR_END;//唱针停在唱盘上
                    int index = mVpContain.getCurrentItem();//获取当前vp显示的位置
                    playDiscAnimator(index);//播放唱盘的动画
                    musicStatus = MusicConstants.MusicStatus.PLAY;//音乐状态为播放
                } else if (needleAnimatorStatus == NeedleAnimatorStatus.TO_FAR_END) {
                    needleAnimatorStatus = NeedleAnimatorStatus.IN_FAR_END;
                    if (musicStatus == MusicConstants.MusicStatus.STOP) {
                        mIsNeed2StartPlayAnimator = true;
                    }
                }

                if (mIsNeed2StartPlayAnimator) {
                    mIsNeed2StartPlayAnimator = false;

                    // 只有在ViewPager不处于偏移状态时，才开始唱盘旋转动画

                    if (!mViewPagerIsOffset) {
                        /*延时500ms*/
                        DiscView.this.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                playAnimator();
                            }
                        }, 50);
                    }
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //播放唱盘动画
    private void playDiscAnimator(int index) {
        ObjectAnimator objectAnimator = mDiscAnimators.get(index);
        if (objectAnimator.isPaused()) {
            objectAnimator.resume();
        } else {
            objectAnimator.start();
        }

        //唱盘动画可能执行多次，只有不是音乐不在播放状态，在回调执行播放
        if (musicStatus != MusicConstants.MusicStatus.PLAY) {
            notifyMusicStatusChanged(MusicChangedStatus.PLAY);
        }
    }

    /*暂停唱盘动画*/
    private void pauseDiscAnimator(int index) {
        ObjectAnimator objectAnimator = mDiscAnimators.get(index);
        objectAnimator.pause();
        mNeedleAnimator.reverse();
    }

    private void doWithAnimatorOnPageScroll(int state) {
        switch (state) {
            case ViewPager.SCROLL_STATE_IDLE://viewPage处于闲置状态
            case ViewPager.SCROLL_STATE_SETTLING: {//viewPage处于滑动状态但是这种滑动状态是自己控制的
                Log.d(TAG, "doWithAnimatorOnPageScroll: 滑动---自己控制");
                mViewPagerIsOffset = false;
                if (musicStatus == MusicConstants.MusicStatus.PLAY) {
                    playAnimator();
                }
                break;
            }
            case ViewPager.SCROLL_STATE_DRAGGING: {//viewPage处于滑动状态但是这种滑动状态是外界控制的
                Log.d(TAG, "doWithAnimatorOnPageScroll: 滑动---不属于自己控制");
                mViewPagerIsOffset = true;
                pauseAnimator();
                break;
            }
        }
    }

    //注入回调接口
    public void setPlayInfoListener(IPlayInfo listener) {
        this.mIPlayInfo = listener;
    }


    //注入数据源，初始化数据
    public void setMusicDataList(GlobalPlayMusic currentPlayMusic) {

        if (currentPlayMusic.getCurrentPlaySongList().isEmpty()) return;
        playListPosition = 0;
        mDiscLayouts.clear();
        mSongsList.clear();
        mDiscAnimators.clear();

        this.currentPlayMusic = currentPlayMusic;
        mSongsList.addAll(currentPlayMusic.getCurrentPlaySongList());
        playListPosition = currentPlayMusic.getPlayPosition();

        for (Songs songs : mSongsList) {
            View discLayout = LayoutInflater.from(mContext).inflate(R.layout.layout_disc,
                    null);
            mDiscLayouts.add(discLayout);
            ImageView disc=(ImageView) (discLayout.findViewById(R.id.ivDisc));
            mDiscAnimators.add(getDiscObjectAnimator(disc));
        }

        mViewPagerAdapter.notifyDataSetChanged();

        SongInfo musicData = mSongsList.get(playListPosition).getSongInfo();
        if (mIPlayInfo != null) {
            mIPlayInfo.onMusicInfoChanged(musicData.getSongName(), musicData.getSingerName());
            mIPlayInfo.onMusicPicChanged(musicData.getImgUrl().replace("{size}", "400"));
        }

    }
    public void scrollToSelectPosition(int playListPosition){
        mVpContain.setCurrentItem(playListPosition,true);
    }
    //定义唱盘动画
    private ObjectAnimator getDiscObjectAnimator(ImageView disc) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(disc, View.ROTATION, 0, 360);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setDuration(20 * 1000);
        objectAnimator.setInterpolator(new LinearInterpolator());
        return objectAnimator;
    }

    //activity结束时需要调用的方法
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /*播放动画*/
    private void playAnimator() {
        /*唱针处于远端时，直接播放动画*/
        if (needleAnimatorStatus == NeedleAnimatorStatus.IN_FAR_END) {
            mNeedleAnimator.start();
        }
        /*唱针处于往远端移动时，设置标记，等动画结束后再播放动画*/
        else if (needleAnimatorStatus == NeedleAnimatorStatus.TO_FAR_END) {
            mIsNeed2StartPlayAnimator = true;
        }
    }

    /*暂停动画*/
    private void pauseAnimator() {
        /*播放时暂停动画*/
        if (needleAnimatorStatus == NeedleAnimatorStatus.IN_NEAR_END) {
            int index = mVpContain.getCurrentItem();
            pauseDiscAnimator(index);
        }
        /*唱针往唱盘移动时暂停动画*/
        else if (needleAnimatorStatus == NeedleAnimatorStatus.TO_NEAR_END) {
            mNeedleAnimator.reverse();
            /**
             * 若动画在没结束时执行reverse方法，则不会执行监听器的onStart方法，此时需要手动设置
             * */
            needleAnimatorStatus = NeedleAnimatorStatus.TO_FAR_END;
        }
        /**
         * 动画可能执行多次，只有音乐处于停止 / 暂停状态时，才执行暂停命令
         * */
        if (musicStatus == MusicConstants.MusicStatus.STOP) {
            notifyMusicStatusChanged(MusicChangedStatus.STOP);
        } else if (musicStatus == MusicConstants.MusicStatus.PAUSE) {
            notifyMusicStatusChanged(MusicChangedStatus.PAUSE);
        }
    }


    public void notifyMusicPicChanged(int position) {
        if (mIPlayInfo != null) {
            SongInfo musicData = mSongsList.get(position).getSongInfo();
             mIPlayInfo.onMusicPicChanged(musicData.getImgUrl().replace("{size}","400"));
        }
    }

    public void notifyMusicStatusChanged(MusicChangedStatus musicChangedStatus) {
        if (mIPlayInfo != null) {
            mIPlayInfo.onMusicChanged(musicChangedStatus);
        }
    }

    public void play() {

        playAnimator();
    }


    public void pause() {
        musicStatus = MusicConstants.MusicStatus.PAUSE;
        pauseAnimator();
    }

    public void stop() {
        musicStatus = MusicConstants.MusicStatus.STOP;
        pauseAnimator();
    }

    public void playOrPause() {
        if (musicStatus == MusicConstants.MusicStatus.PLAY) {
            pause();
        } else {
            play();
        }

    }


    public void next(int index) {
        selectMusicWithButton();
        mVpContain.setCurrentItem(index, true);
    }

    public void last(int index) {

        selectMusicWithButton();
        mVpContain.setCurrentItem(index, true);

    }

    public boolean isPlaying() {
        return musicStatus == MusicConstants.MusicStatus.PLAY;
    }

    private void selectMusicWithButton() {
        if (musicStatus == MusicConstants.MusicStatus.PLAY) {
            mIsNeed2StartPlayAnimator = true;
            pauseAnimator();
        } else if (musicStatus == MusicConstants.MusicStatus.PAUSE) {
            play();
        }
    }

    class ViewPagerAdapter extends PagerAdapter {

        private List<Songs> songsList;
        private List<View> mViewList;

        public ViewPagerAdapter(List<Songs> songsList, List<View> mViewList) {
            this.songsList = songsList;
            this.mViewList = mViewList;

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            FrameLayout discLayout = (FrameLayout) mViewList.get(position);
            container.addView(discLayout);
            final ImageView imgRecord= (ImageView) discLayout.findViewById(R.id.iv_disc_record);
            final ImageView disc= (ImageView) (discLayout.findViewById(R.id.ivDisc));



            final int musicPicSize = (int) (mScreenWidth * DisplayUtil.SCALE_MUSIC_PIC_SIZE);
            int musicPicMargin = (int) ((DisplayUtil.SCALE_DISC_SIZE - DisplayUtil
                    .SCALE_MUSIC_PIC_SIZE) * mScreenWidth / 2);
            int discSize = (int) (mScreenWidth * DisplayUtil.SCALE_DISC_SIZE);

            FrameLayout.LayoutParams musicPicParams = (FrameLayout.LayoutParams) disc
                    .getLayoutParams();

            musicPicParams.height = musicPicSize;
            musicPicParams.width = musicPicSize;

            musicPicParams.setMargins(musicPicMargin, musicPicMargin, musicPicMargin,
                    musicPicMargin);
            disc.setLayoutParams(musicPicParams);

            FrameLayout.LayoutParams dicRecordParams = (FrameLayout.LayoutParams) imgRecord
                    .getLayoutParams();

            dicRecordParams.height = discSize;
            dicRecordParams.width = discSize;

            dicRecordParams.setMargins(musicPicMargin, musicPicMargin, musicPicMargin,
                    musicPicMargin);
            imgRecord.setLayoutParams(dicRecordParams);

            Glide.with(mContext).load(R.drawable.ic_disc).error(R.raw.ic_music1).bitmapTransform(new CropCircleTransformation(mContext)).into(new SimpleTarget<GlideDrawable>() {
                @Override
                public void onResourceReady(final GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                    imgRecord.setBackground(resource);

                }
            });
            SongInfo songInfo = songsList.get(position).getSongInfo();
            Glide.with(mContext).load(songInfo.getImgUrl().replace("{size}","400" +
                    "")).bitmapTransform(new CropCircleTransformation(mContext)).into(new SimpleTarget<GlideDrawable>() {
                @Override
                public void onResourceReady(GlideDrawable discDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                    disc.setImageDrawable(discDrawable);

                }
            });



            return discLayout;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView(mViewList.get(position));
        }

        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }


}
