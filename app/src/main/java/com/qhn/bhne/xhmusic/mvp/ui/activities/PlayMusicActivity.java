package com.qhn.bhne.xhmusic.mvp.ui.activities;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.mvp.entity.GlobalPlayMusic;
import com.qhn.bhne.xhmusic.mvp.entity.SongInfo;
import com.qhn.bhne.xhmusic.mvp.entity.Songs;
import com.qhn.bhne.xhmusic.mvp.ui.activities.base.BaseActivity;
import com.qhn.bhne.xhmusic.mvp.ui.service.MusicService;
import com.qhn.bhne.xhmusic.wight.BackgroundAnimationRelativeLayout;
import com.qhn.bhne.xhmusic.wight.DiscView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends BaseActivity implements DiscView.IPlayInfo, View
        .OnClickListener {
    private static final int MUSIC_MESSAGE = 0;

    @BindView(R.id.view_disc)
    DiscView mDisc;
    @BindView(R.id.tvCurrentTime)
    TextView mTvMusicDuration;
    @BindView(R.id.tvTotalTime)
    TextView mTvTotalMusicDuration;
    @BindView(R.id.ivLast)
    ImageView mIvLast;
    @BindView(R.id.ivPlayOrPause)
    ImageView mIvPlayOrPause;
    @BindView(R.id.ivNext)
    ImageView mIvNext;
    @BindView(R.id.musicSeekBar)
    SeekBar mSeekBar;
    @BindView(R.id.activity_play_music)
    BackgroundAnimationRelativeLayout mRootLayout;
    @BindView(R.id.img_playing_fav)
    ImageView imgPlayingFav;
    @BindView(R.id.img_playing_down)
    ImageView imgPlayingDown;
    @BindView(R.id.img_playing_cmt)
    ImageView imgPlayingCmt;
    @BindView(R.id.playing_more)
    ImageView playingMore;
    @BindView(R.id.ll_music_opt)
    LinearLayout llMusicOpt;
    @BindView(R.id.img_playing_mode)
    ImageView imgPlayingMode;
    @BindView(R.id.img_playing_playlist)
    ImageView imgPlayingPlaylist;


    private Handler mMusicHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mSeekBar.setProgress(mSeekBar.getProgress() + 1000);
            mTvMusicDuration.setText(duration2Time(mSeekBar.getProgress()));
            startUpdateSeekBarProgress();
        }
    };

    //全局音乐信息
    @Inject
    GlobalPlayMusic globalPlayMusic;
    private int mMusicQuality;//当前的歌曲品质
    private SongInfo mCurrentSong;//当前播放的歌曲
    private int playListPosition;//当前歌曲的播放位置
    private List<Songs> mSongsList;//当前播放歌曲列表

    private BroadcastReceiver mMusicReceiver;
    private LocalBroadcastManager localBroadcastManager;//广播管理器
    private int playProgress;//播放进度

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
        if (item.getItemId() == R.id.action_share) {
            test();
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_play_music, menu);
        return true;
    }

    @Override
    protected void initViews() {

        //设置状态栏透明
        setTransparency(true);
        //初始化数据
        initMusicData();
        //启动service
        bindPlayService();
        //注册本地广播
        initMusicReceiver();
        //初始化唱盘
        initDisc();
        //初始化seekBar
        initSeekBar();
        //初始化其他组件
        initPlayMusicView();


    }

    //注册广播
    private void initMusicReceiver() {
        mMusicReceiver = new MusicReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MusicService.ACTION_STATUS_MUSIC_PLAY);
        intentFilter.addAction(MusicService.ACTION_STATUS_MUSIC_PAUSE);
        intentFilter.addAction(MusicService.ACTION_STATUS_MUSIC_DURATION);
        intentFilter.addAction(MusicService.ACTION_STATUS_MUSIC_COMPLETE);
        /*注册本地广播*/
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.registerReceiver(mMusicReceiver, intentFilter);
    }

    //发送广播
    private void sendBroadcastEvent(final String action) {
        localBroadcastManager.sendBroadcast(new Intent(action));
    }

    //接收广播
    class MusicReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(MusicService.ACTION_STATUS_MUSIC_PLAY)) {
                mIvPlayOrPause.setImageResource(R.drawable.ic_pause);
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

    //初始化播放页面的控件
    private void initPlayMusicView() {
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
        if (globalPlayMusic.getIsPlay())
            mDisc.play();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    //初始化数据
    private void initMusicData() {
        playListPosition = globalPlayMusic.getPlayPosition();
        mMusicQuality = globalPlayMusic.getMusicQuality();
        mSongsList = globalPlayMusic.getCurrentPlaySongList();
        mCurrentSong = mSongsList.get(playListPosition).getSongInfo();
        playProgress = globalPlayMusic.getProgress();
    }

    //初始化唱盘
    private void initDisc() {
        mDisc.setPlayInfoListener(this);
        mDisc.setMusicDataList(globalPlayMusic);
        mDisc.scrollToSelectPosition(globalPlayMusic.getPlayPosition());

    }

    //初始化seekbar
    private void initSeekBar() {
        int totalDuration = mCurrentSong.getTimeLength();

        mSeekBar.setProgress(playProgress);
        mSeekBar.setMax(totalDuration);
        mTvTotalMusicDuration.setText(duration2Time(totalDuration));
        mTvMusicDuration.setText(duration2Time(playProgress * totalDuration));
    }

    //绑定service
    private void bindPlayService() {
        Intent in = new Intent(this, MusicService.class);
        startService(in);
    }


    @OnClick({R.id.ivPlayOrPause, R.id.ivNext, R.id.ivLast, R.id.img_playing_fav, R.id.img_playing_down, R.id.img_playing_cmt, R.id.playing_more, R.id.ll_music_opt, R.id.img_playing_mode, R.id.img_playing_playlist})
    public void onClick(View view) {
        switch (view.getId()) {
            //播放或者暂停
            case R.id.ivPlayOrPause:

                mDisc.playOrPause();
                break;
            //下一首
            case R.id.ivNext:
                verifyNext();


                break;
            //上一首
            case R.id.ivLast:
                verifyLast();


                break;
            //收藏
            case R.id.img_playing_fav:
                test();
                break;
            //下载
            case R.id.img_playing_down:
                test();
                break;
            //评论
            case R.id.img_playing_cmt:
                test();
                break;
            //更多
            case R.id.playing_more:
                test();
                break;
            //播放模式
            case R.id.img_playing_mode:
                test();
                break;
            //播放列表
            case R.id.img_playing_playlist:
                test();
                break;
        }
    }

    private void verifyLast() {
        if (playListPosition-- != 0) {
            globalPlayMusic.setPlayPosition(playListPosition);
            mDisc.last(playListPosition);

        } else {
            Toast.makeText(this, "已到第一首", Toast.LENGTH_SHORT).show();
        }
    }

    private void verifyNext() {
        if (playListPosition++ <= mSongsList.size()) {
            globalPlayMusic.setPlayPosition(playListPosition);
            mDisc.next(playListPosition);

        } else {
            Toast.makeText(this, "已到最后一首", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMusicInfoChanged(String musicName, String musicAuthor) {
        getSupportActionBar().setTitle(musicName);
        getSupportActionBar().setSubtitle(musicAuthor);
    }

    //更换背景
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

    private void stopUpdateSeekBarProgress() {
        mMusicHandler.removeMessages(MUSIC_MESSAGE);
    }

    //更新背景
    private void try2UpdateMusicPicBackground(final String musicPicRes) {

        if (mRootLayout.isNeed2UpdateBackground(musicPicRes)) {
            BlurTransformation blurTransformation = new BlurTransformation(getBaseContext(), 80);
            Glide.with(getBaseContext()).load(musicPicRes).bitmapTransform(blurTransformation).into(new SimpleTarget<GlideDrawable>() {
                @Override
                public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                    resource.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                    mRootLayout.setForeground(resource);
                    mRootLayout.beginAnimation();

                }
            });

        }

    }


    private void play() {
        mIvPlayOrPause.setImageResource(R.drawable.play_rdi_btn_pause);
        globalPlayMusic.setIsPlay(!globalPlayMusic.getIsPlay());
        sendBroadcastEvent(MusicService.ACTION_OPT_MUSIC_PLAY);
        startUpdateSeekBarProgress();
    }

    private void pause() {

        mIvPlayOrPause.setImageResource(R.drawable.play_rdi_btn_play);
        globalPlayMusic.setIsPlay(!globalPlayMusic.getIsPlay());
        sendBroadcastEvent(MusicService.ACTION_OPT_MUSIC_PAUSE);
        stopUpdateSeekBarProgress();
    }

    private void stop() {
        stopUpdateSeekBarProgress();
        mIvPlayOrPause.setImageResource(R.drawable.play_rdi_btn_play);
        mTvMusicDuration.setText(duration2Time(0));
        mTvTotalMusicDuration.setText(duration2Time(mCurrentSong.getTimeLength()));
        mSeekBar.setProgress(0);
    }

    private void next() {
        stopUpdateSeekBarProgress();
        updateMusicDurationInfo(mCurrentSong.getTimeLength());
        sendBroadcastEvent(MusicService.ACTION_OPT_MUSIC_NEXT);


    }

    private void last() {
        stopUpdateSeekBarProgress();
        updateMusicDurationInfo(mCurrentSong.getTimeLength());
        sendBroadcastEvent(MusicService.ACTION_OPT_MUSIC_LAST);


    }

    private void complete(boolean isOver) {
        if (isOver) {
            mDisc.stop();
        } else {
            verifyNext();
        }
    }


    private void seekTo(int position) {
        Intent intent = new Intent(MusicService.ACTION_OPT_MUSIC_SEEK_TO);
        intent.putExtra(MusicService.PARAM_MUSIC_SEEK_TO, position);
        localBroadcastManager.sendBroadcast(intent);
    }

    private void startUpdateSeekBarProgress() {
        /*避免重复发送Message*/
        stopUpdateSeekBarProgress();
        mMusicHandler.sendEmptyMessageDelayed(0, 1000);
    }

    /*根据时长格式化称时间文本*/
    private String duration2Time(int duration) {
        int min = duration / 60;
        int sec = duration % 60;

        return (min < 10 ? "0" + min : min + "") + ":" + (sec < 10 ? "0" + sec : sec + "");
    }

    private void updateMusicDurationInfo(int totalDuration) {
        initSeekBar();
        startUpdateSeekBarProgress();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //防止handler泄漏，导致activity无法回收
        mMusicHandler.removeMessages(MUSIC_MESSAGE);
        mUnbinder.unbind();
        localBroadcastManager.unregisterReceiver(mMusicReceiver);

    }


    public void test() {
        Toast.makeText(this, "点击了按钮", Toast.LENGTH_SHORT).show();
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
