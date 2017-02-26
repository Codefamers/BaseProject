package com.qhn.bhne.baseproject.mvp.ui.activities;


import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.entity.CurrentPlayMusic;
import com.qhn.bhne.baseproject.mvp.entity.Songs;
import com.qhn.bhne.baseproject.mvp.ui.activities.base.BaseActivity;
import com.qhn.bhne.baseproject.mvp.ui.service.MusicService;
import com.qhn.bhne.baseproject.wight.BackgroundAnimationRelativeLayout;
import com.qhn.bhne.baseproject.wight.DiscView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.BlurTransformation;

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

    @Inject
    CurrentPlayMusic currentPlayMusic;
    private MusicService musicService;
    private Handler mMusicHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mSeekBar.setProgress(mSeekBar.getProgress() + 1000);
            mTvMusicDuration.setText(duration2Time(mSeekBar.getProgress()));
            startUpdateSeekBarProgress();
        }
    };

    private ServiceConnection musicSC = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.DataBinder dataBinder = (MusicService.DataBinder) service;
            musicService = dataBinder.getMusicService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private int mMusicQuality;//当前的歌曲品质
    private Songs mCurrentSong;//当前播放的歌曲
    private int playListPosition;//当前歌曲的播放位置
    private List<Songs> mSongsList;//当前播放歌曲列表

    @Override
    protected void initViews() {
        makeStatusBarTransparent();
        initMusicData();
        Intent in = new Intent(this, MusicService.class);
        startService(in);
        bindService(in, musicSC, BIND_AUTO_CREATE);
        mDisc.setPlayInfoListener(this);
        mIvLast.setOnClickListener(this);
        mIvNext.setOnClickListener(this);
        mIvPlayOrPause.setOnClickListener(this);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //拖动滑块位置发生改变时触发的方法
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTvMusicDuration.setText(duration2Time(progress));
            }

            //开始滑动
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                startUpdateSeekBarProgress();

            }

            //停止滑动
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekTo(seekBar.getProgress());
                stopUpdateSeekBarProgress();
            }
        });
        mTvMusicDuration.setText(duration2Time(0));
        mTvTotalMusicDuration.setText(duration2Time(0));
        mDisc.setMusicDataList(currentPlayMusic);
        mDisc.play();

    }

    private void stopUpdateSeekBarProgress() {
        mMusicHandler.removeMessages(MUSIC_MESSAGE);
    }

    @Override
    protected void initInjector() {
        getmActivityComponent().inject(this);
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

    private void initMusicData() {
        playListPosition = currentPlayMusic.getPlayPosition();
        mMusicQuality = currentPlayMusic.getMusicQuality();
        mSongsList = currentPlayMusic.getCurrentPlaySongList();
        mCurrentSong = mSongsList.get(playListPosition);

       // updateMusicDurationInfo(mCurrentSong.getUrlList().get(mMusicQuality).getDuration());

    }

    private void try2UpdateMusicPicBackground(final String musicPicRes) {
        if (mRootLayout.isNeed2UpdateBackground(musicPicRes)) {
            Glide.with(getBaseContext()).load(musicPicRes).bitmapTransform(new BlurTransformation(getBaseContext(), 8)).into(new SimpleTarget<GlideDrawable>() {
                @Override
                public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                    resource.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);

                    mRootLayout.setForeground(resource);
                    mRootLayout.beginAnimation();
                }
            });
        }
    }


    @Override
    public void onMusicInfoChanged(String musicName, String musicAuthor) {
        getSupportActionBar().setTitle(musicName);
        getSupportActionBar().setSubtitle(musicAuthor);
    }

    @Override
    public void onMusicPicChanged(String musicPicRes) {
        try2UpdateMusicPicBackground(musicPicRes);
    }

    @Override
    public void onMusicChanged(DiscView.MusicChangedStatus musicChangedStatus) {
        switch (musicChangedStatus) {
            case PLAY:
                play();
                break;

            case PAUSE:
                pause();
                break;

            case NEXT:

                next();
                break;

            case LAST:
                last();
                break;

            case STOP:
                stop();
                break;
        }
    }


    @Override
    public void onClick(View v) {
        if (v == mIvPlayOrPause) {
            mDisc.playOrPause();
        } else if (v == mIvNext) {
            mDisc.next(playListPosition);
        } else if (v == mIvLast) {
            mDisc.last(playListPosition);


        }
    }


    private void play() {
        mIvPlayOrPause.setImageResource(R.drawable.ic_pause);
        musicService.getMusicAction(MusicService.ACTION_OPT_MUSIC_PLAY);
        startUpdateSeekBarProgress();
    }

    private void pause() {
        mIvPlayOrPause.setImageResource(R.drawable.ic_play);
        musicService.getMusicAction(MusicService.ACTION_OPT_MUSIC_PAUSE);
        stopUpdateSeekBarProgress();
    }

    private void stop() {
        stopUpdateSeekBarProgress();
        mIvPlayOrPause.setImageResource(R.drawable.ic_play);
        mTvMusicDuration.setText(duration2Time(0));
        mTvTotalMusicDuration.setText(duration2Time(0));
        mSeekBar.setProgress(0);
    }

    private void next() {
        stopUpdateSeekBarProgress();
       // updateMusicDurationInfo(mCurrentSong.getUrlList().get(mMusicQuality).getDuration());
        currentPlayMusic.setPlayPosition(playListPosition);
        musicService.getMusicAction(MusicService.ACTION_OPT_MUSIC_PLAY);


    }

    private void last() {
        stopUpdateSeekBarProgress();
       // updateMusicDurationInfo(mCurrentSong.getUrlList().get(mMusicQuality).getDuration());
        currentPlayMusic.setPlayPosition(playListPosition);
        musicService.getMusicAction(MusicService.ACTION_OPT_MUSIC_PLAY);

    }

    private void complete(boolean isOver) {
        if (isOver) {
            mDisc.stop();
        } else {
            mDisc.next(playListPosition);
        }
    }


    private void seekTo(int position) {
        Intent intent = new Intent(MusicService.ACTION_OPT_MUSIC_SEEK_TO);
        intent.putExtra(MusicService.PARAM_MUSIC_SEEK_TO, position);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void startUpdateSeekBarProgress() {
        /*避免重复发送Message*/
        stopUpdateSeekBarProgress();
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


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
/*
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
}*/
