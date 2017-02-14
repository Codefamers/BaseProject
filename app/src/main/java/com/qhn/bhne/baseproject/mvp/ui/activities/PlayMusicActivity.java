package com.qhn.bhne.baseproject.mvp.ui.activities;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveVideoTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.entity.MusicData;
import com.qhn.bhne.baseproject.mvp.entity.Songs;
import com.qhn.bhne.baseproject.mvp.ui.activities.base.BaseActivity;
import com.qhn.bhne.baseproject.mvp.ui.service.MusicService;
import com.qhn.bhne.baseproject.utils.DisplayUtil;
import com.qhn.bhne.baseproject.utils.FastBlurUtil;
import com.qhn.bhne.baseproject.wight.BackgroundAnimationRelativeLayout;
import com.qhn.bhne.baseproject.wight.DiscView;
import com.socks.library.KLog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.qhn.bhne.baseproject.wight.DisView.DURATION_NEEDLE_ANIAMTOR;

public class PlayMusicActivity extends BaseActivity implements DiscView.IPlayInfo, View
        .OnClickListener {
    private static final int MUSIC_MESSAGE = 0;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.discview)
    DiscView mDisc;
    /* @BindView(R.id.img_like)
     ImageButton imgLike;
     @BindView(R.id.img_download)
     ImageButton imgDownload;
     @BindView(R.id.img_comment)
     ImageButton imgComment;
     @BindView(R.id.img_more_operation)
     ImageButton imgMoreOperation;*/
    @BindView(R.id.tvCurrentTime)
    TextView mTvMusicDuration;
    @BindView(R.id.tvTotalTime)
    TextView mTvTotalMusicDuration;
    /* @BindView(R.id.img_play_pattern)
     ImageButton imgPlayPattern;*/
    @BindView(R.id.ivLast)
    ImageView mIvLast;
    @BindView(R.id.ivPlayOrPause)
    ImageView mIvPlayOrPause;
    @BindView(R.id.ivNext)
    ImageView mIvNext;
    /*@BindView(R.id.img_play_list)
    ImageButton imgPlayList;*/
    @BindView(R.id.musicSeekBar)
    SeekBar mSeekBar;
    @BindView(R.id.activity_play_music)
    BackgroundAnimationRelativeLayout mRootLayout;
    public static final String PARAM_MUSIC_LIST = "PARAM_MUSIC_LIST";
    private MusicReceiver mMusicReceiver = new MusicReceiver();
    private List<MusicData> mMusicDatas = new ArrayList<>();
    private List<Songs> mSongsList=new ArrayList<>();
    private SimpleExoPlayer player;
    private Handler mMusicHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mSeekBar.setProgress(mSeekBar.getProgress() + 1000);
            mTvMusicDuration.setText(duration2Time(mSeekBar.getProgress()));
            startUpdateSeekBarProgress();
        }
    };


    @Override
    protected void initViews() {
        initMusicDatas();
        initMusicReceiver();
        initPlayer();
        mDisc.setPlayInfoListener(this);
        mIvLast.setOnClickListener(this);
        mIvNext.setOnClickListener(this);
        mIvPlayOrPause.setOnClickListener(this);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTvMusicDuration.setText(duration2Time(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                stopUpdateSeekBarProgress();
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekTo(seekBar.getProgress());
                startUpdateSeekBarProgress();
            }
        });
        mTvMusicDuration.setText(duration2Time(0));
        mTvTotalMusicDuration.setText(duration2Time(0));
        mDisc.setMusicDataList(mMusicDatas);


    }

    private void initPlayer() {

        //1.创建渲染器TrackSelector
        BandwidthMeter bandwidthMeter=new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory=new
                AdaptiveVideoTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector=new DefaultTrackSelector(videoTrackSelectionFactory);

        //2.创建一个默认的加载控制器 loadControl
        LoadControl loadControl=new DefaultLoadControl();
        //3.创建一个Player
        player= ExoPlayerFactory.newSimpleInstance(this,trackSelector,loadControl);
        DefaultBandwidthMeter bandwidthMete=new DefaultBandwidthMeter();
        DataSource.Factory dataSourceFactory=new DefaultDataSourceFactory(this, Util.getUserAgent(this, "ExoPlayerDemo"),bandwidthMete);
        ExtractorsFactory extractorsFactory=new DefaultExtractorsFactory();
        Uri uri=Uri.parse("http://om5.alicdn.com/197/1964894197/2100285652/1775713590_59789536_l.mp3?" +
                "auth_key=84e1627f5f5606c9131c30d54523ab03-1487559600-0-null");
        MediaSource audioSource=new ExtractorMediaSource(uri,dataSourceFactory,extractorsFactory,null,null);
        player.prepare(audioSource);

    }


    private void stopUpdateSeekBarProgress() {
        mMusicHandler.removeMessages(MUSIC_MESSAGE);
    }

    private void initMusicReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MusicService.ACTION_STATUS_MUSIC_PLAY);
        intentFilter.addAction(MusicService.ACTION_STATUS_MUSIC_PAUSE);
        intentFilter.addAction(MusicService.ACTION_STATUS_MUSIC_DURATION);
        intentFilter.addAction(MusicService.ACTION_STATUS_MUSIC_COMPLETE);
        /*注册本地广播*/
        LocalBroadcastManager.getInstance(this).registerReceiver(mMusicReceiver, intentFilter);
    }


    @Override
    protected void initInjector() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_play_music;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_play_music, menu);
        return true;
    }

    private void stopUpdateSeekBarProgree() {
        mMusicHandler.removeMessages(MUSIC_MESSAGE);
    }

    /*设置透明状态栏*/
    private void makeStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    private void initMusicDatas() {
        MusicData musicData1 = new MusicData(R.raw.music1, R.raw.ic_music1, "寻", "三亩地");
        MusicData musicData2 = new MusicData(R.raw.music2, R.raw.ic_music2, "Nightingale", "YANI");
        MusicData musicData3 = new MusicData(R.raw.music3, R.raw.ic_music3, "Cornfield Chase", "Hans Zimmer");

        mMusicDatas.add(musicData1);
        mMusicDatas.add(musicData2);
        mMusicDatas.add(musicData3);

        Intent intent = new Intent(this, MusicService.class);
        intent.putExtra(PARAM_MUSIC_LIST, (Serializable) mMusicDatas);
        startService(intent);
    }

    private void try2UpdateMusicPicBackground(final int musicPicRes) {
        if (mRootLayout.isNeed2UpdateBackground(musicPicRes)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final Drawable foregroundDrawable = getForegroundDrawable(musicPicRes);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mRootLayout.setForeground(foregroundDrawable);
                            mRootLayout.beginAnimation();
                        }
                    });
                }
            }).start();
        }
    }

    private Drawable getForegroundDrawable(int musicPicRes) {
        /*得到屏幕的宽高比，以便按比例切割图片一部分*/
        final float widthHeightSize = (float) (DisplayUtil.getScreenWidth(PlayMusicActivity.this)
                * 1.0 / DisplayUtil.getScreenHeight(this) * 1.0);

        Bitmap bitmap = getForegroundBitmap(musicPicRes);
        int cropBitmapWidth = (int) (widthHeightSize * bitmap.getHeight());
        int cropBitmapWidthX = (int) ((bitmap.getWidth() - cropBitmapWidth) / 2.0);

        /*切割部分图片*/
        Bitmap cropBitmap = Bitmap.createBitmap(bitmap, cropBitmapWidthX, 0, cropBitmapWidth,
                bitmap.getHeight());
        /*缩小图片*/
        Bitmap scaleBitmap = Bitmap.createScaledBitmap(cropBitmap, bitmap.getWidth() / 50, bitmap
                .getHeight() / 50, false);
        /*模糊化*/
        final Bitmap blurBitmap = FastBlurUtil.doBlur(scaleBitmap, 8, true);

        final Drawable foregroundDrawable = new BitmapDrawable(blurBitmap);
        /*加入灰色遮罩层，避免图片过亮影响其他控件*/
        foregroundDrawable.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
        return foregroundDrawable;
    }

    private Bitmap getForegroundBitmap(int musicPicRes) {
        int screenWidth = DisplayUtil.getScreenWidth(this);
        int screenHeight = DisplayUtil.getScreenHeight(this);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;

        BitmapFactory.decodeResource(getResources(), musicPicRes, options);
        int imageWidth = options.outWidth;
        int imageHeight = options.outHeight;

        if (imageWidth < screenWidth && imageHeight < screenHeight) {
            return BitmapFactory.decodeResource(getResources(), musicPicRes);
        }

        int sample = 2;
        int sampleX = imageWidth / DisplayUtil.getScreenWidth(this);
        int sampleY = imageHeight / DisplayUtil.getScreenHeight(this);

        if (sampleX > sampleY && sampleY > 1) {
            sample = sampleX;
        } else if (sampleY > sampleX && sampleX > 1) {
            sample = sampleY;
        }

        options.inJustDecodeBounds = false;
        options.inSampleSize = sample;
        options.inPreferredConfig = Bitmap.Config.RGB_565;

        return BitmapFactory.decodeResource(getResources(), musicPicRes, options);
    }

    @Override
    public void onMusicInfoChanged(String musicName, String musicAuthor) {
        getSupportActionBar().setTitle(musicName);
        getSupportActionBar().setSubtitle(musicAuthor);
    }

    @Override
    public void onMusicPicChanged(int musicPicRes) {
        try2UpdateMusicPicBackground(musicPicRes);
    }

    @Override
    public void onMusicChanged(DiscView.MusicChangedStatus musicChangedStatus) {
        switch (musicChangedStatus) {
            case PLAY: {
                play();
                break;
            }
            case PAUSE: {
                pause();
                break;
            }
            case NEXT: {
                next();
                break;
            }
            case LAST: {
                last();
                break;
            }
            case STOP: {
                stop();
                break;
            }
        }
    }


    @Override
    public void onClick(View v) {
        if (v == mIvPlayOrPause) {
            mDisc.playOrPause();


        } else if (v == mIvNext) {
            mDisc.next();
        } else if (v == mIvLast) {
            mDisc.last();
        }
    }

    private void play() {
        mIvPlayOrPause.setImageResource(R.drawable.ic_pause);

        optMusic(MusicService.ACTION_OPT_MUSIC_PLAY);
        startUpdateSeekBarProgress();

        player.setPlayWhenReady(true);

    }

    private void pause() {
        mIvPlayOrPause.setImageResource(R.drawable.ic_play);
        optMusic(MusicService.ACTION_OPT_MUSIC_PAUSE);
        stopUpdateSeekBarProgree();
        player.stop();
    }

    private void stop() {
        stopUpdateSeekBarProgree();
        mIvPlayOrPause.setImageResource(R.drawable.ic_play);
        mTvMusicDuration.setText(duration2Time(0));
        mTvTotalMusicDuration.setText(duration2Time(0));
        mSeekBar.setProgress(0);
    }

    private void next() {

        mRootLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                optMusic(MusicService.ACTION_OPT_MUSIC_NEXT);
            }
        }, DURATION_NEEDLE_ANIAMTOR);
        stopUpdateSeekBarProgree();
        mTvMusicDuration.setText(duration2Time(0));
        mTvTotalMusicDuration.setText(duration2Time(0));
    }

    private void last() {
        mRootLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                optMusic(MusicService.ACTION_OPT_MUSIC_LAST);
            }
        }, DURATION_NEEDLE_ANIAMTOR);
        stopUpdateSeekBarProgree();
        mTvMusicDuration.setText(duration2Time(0));
        mTvTotalMusicDuration.setText(duration2Time(0));
    }

    private void complete(boolean isOver) {
        if (isOver) {
            mDisc.stop();
        } else {
            mDisc.next();
        }
    }

    private void optMusic(final String action) {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(action));
    }

    private void seekTo(int position) {
        Intent intent = new Intent(MusicService.ACTION_OPT_MUSIC_SEEK_TO);
        intent.putExtra(MusicService.PARAM_MUSIC_SEEK_TO, position);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void startUpdateSeekBarProgress() {
        /*避免重复发送Message*/
        stopUpdateSeekBarProgree();
        mMusicHandler.sendEmptyMessageDelayed(0, 1000);
    }

    /*根据时长格式化称时间文本*/
    private String duration2Time(int duration) {
        int min = duration / 1000 / 60;
        int sec = duration / 1000 % 60;

        return (min < 10 ? "0" + min : min + "") + ":" + (sec < 10 ? "0" + sec : sec + "");
    }

    private void updateMusicDurationInfo(int totalDuration) {
        mSeekBar.setProgress(0);
        mSeekBar.setMax(totalDuration);
        mTvTotalMusicDuration.setText(duration2Time(totalDuration));
        mTvMusicDuration.setText(duration2Time(0));
        startUpdateSeekBarProgress();
    }

    class MusicReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(MusicService.ACTION_STATUS_MUSIC_PLAY)) {
                mIvPlayOrPause.setImageResource(R.mipmap.ic_pause);
                int currentPosition = intent.getIntExtra(MusicService.PARAM_MUSIC_CURRENT_POSITION, 0);
                mSeekBar.setProgress(currentPosition);
                if (!mDisc.isPlaying()) {
                    mDisc.playOrPause();
                }
            } else if (action.equals(MusicService.ACTION_STATUS_MUSIC_PAUSE)) {
                mIvPlayOrPause.setImageResource(R.drawable.ic_play);
                if (mDisc.isPlaying()) {
                    mDisc.playOrPause();
                }
            } else if (action.equals(MusicService.ACTION_STATUS_MUSIC_DURATION)) {
                int duration = intent.getIntExtra(MusicService.PARAM_MUSIC_DURATION, 0);
                updateMusicDurationInfo(duration);
            } else if (action.equals(MusicService.ACTION_STATUS_MUSIC_COMPLETE)) {
                boolean isOver = intent.getBooleanExtra(MusicService.PARAM_MUSIC_IS_OVER, true);
                complete(isOver);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMusicReceiver);
    }

}
