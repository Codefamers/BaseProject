package com.qhn.bhne.xhmusic.mvp.ui.activities;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
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
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.mvp.entity.GlobalPlayMusic;
import com.qhn.bhne.xhmusic.mvp.entity.db.SongInfo;
import com.qhn.bhne.xhmusic.mvp.entity.Songs;
import com.qhn.bhne.xhmusic.mvp.ui.activities.base.BaseActivity;
import com.qhn.bhne.xhmusic.mvp.ui.service.MusicService;
import com.qhn.bhne.xhmusic.wight.BackgroundAnimationRelativeLayout;
import com.qhn.bhne.xhmusic.wight.DiscView;
import com.socks.library.KLog;

import java.util.Formatter;
import java.util.List;
import java.util.Locale;

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


    private Handler mMusicHandler = new Handler();
    private final Runnable updateProgressAction = new Runnable() {
        @Override
        public void run() {
            updateProgress();
        }
    };
    //全局音乐信息
    @Inject
    GlobalPlayMusic globalPlayMusic;
    @Inject
    ExoPlayer player;
    private int mMusicQuality;//当前的歌曲品质
    private SongInfo mCurrentSong;//当前播放的歌曲
    private int playListPosition;//当前歌曲的播放位置
    private List<Songs> mSongsList;//当前播放歌曲列表

    private BroadcastReceiver mMusicReceiver;
    private LocalBroadcastManager localBroadcastManager;//广播管理器
    private int playProgress;//播放进度
    private StringBuilder formatBuilder;
    private Formatter formatter;
    private static final int PROGRESS_BAR_MAX = 1000;

    @Override
    protected void initInjector() {
        getActivityComponent().inject(this);
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
        //bindPlayService();
        //注册本地广播
        initMusicReceiver();
        //初始化唱盘
        initDisc();
        //初始化seekBar
        initSeekBar();
        //初始化其他组件
        initPlayMusicView();


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (globalPlayMusic.getIsPlay())
            preparePlayMusic();

    }

    //注册广播
    private void initMusicReceiver() {
        mMusicReceiver = new MusicReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MusicService.ACTION_STATUS_MUSIC_PLAY);
        intentFilter.addAction(MusicService.ACTION_STATUS_MUSIC_PAUSE);
        intentFilter.addAction(MusicService.ACTION_STATUS_MUSIC_DURATION);
        intentFilter.addAction(MusicService.ACTION_STATUS_MUSIC_COMPLETE);
        intentFilter.addAction(MusicService.ACTION_STATUS_MUSIC_PREPARE);
        intentFilter.addAction(MusicService.ACTION_STATUS_MUSIC_IDLE);

        //intentFilter.addAction(MusicService.ACTION_OPT_MUSIC_SEEK_TO);
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
                mDisc.play();
            } else if (action.equals(MusicService.ACTION_STATUS_MUSIC_PREPARE)) {
                Toast.makeText(context, "缓存中", Toast.LENGTH_SHORT).show();
            } else if (action.equals(MusicService.ACTION_STATUS_MUSIC_IDLE)) {
                Toast.makeText(context, "空闲中", Toast.LENGTH_SHORT).show();

            } else if (action.equals(MusicService.ACTION_STATUS_MUSIC_COMPLETE)) {
                complete();
            } else if (action.equals(MusicService.ACTION_STATUS_MUSIC_PAUSE)) {
                mDisc.pause();
            } else if (action.equals(MusicService.ACTION_STATUS_MUSIC_DURATION)) {
                /*int duration = intent.getIntExtra(MusicService.PARAM_MUSIC_DURATION, 0);
                updateMusicDurationInfo(duration);*/
            }
        }
    }

    //初始化播放页面的控件
    private void initPlayMusicView() {
        mIvLast.setOnClickListener(this);
        mIvNext.setOnClickListener(this);
        mIvPlayOrPause.setOnClickListener(this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void preparePlayMusic() {
        sendBroadcastEvent(MusicService.ACTION_OPT_MUSIC_PREPARE);
        KLog.d("广播发送成功");
    }

    //初始化数据
    private void initMusicData() {
        playListPosition = globalPlayMusic.getPlayPosition();
        mMusicQuality = globalPlayMusic.getMusicQuality();
        mSongsList = globalPlayMusic.getCurrentPlaySongList();
        mCurrentSong = mSongsList.get(playListPosition).getSongInfo();
        playProgress = globalPlayMusic.getProgress();
        formatBuilder = new StringBuilder();
        formatter = new Formatter(formatBuilder, Locale.getDefault());
    }

    //初始化唱盘
    private void initDisc() {
        mDisc.setPlayInfoListener(this);
        mDisc.setMusicDataList(globalPlayMusic);
        mDisc.scrollToSelectPosition(globalPlayMusic.getPlayPosition());

    }

    //初始化seekbar
    private void initSeekBar() {
        mSeekBar.setMax(PROGRESS_BAR_MAX);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //拖动滑块位置发生改变时触发的方法
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser) {
                    long position = positionValue(progress);
                    if (mTvTotalMusicDuration != null) {
                        mTvTotalMusicDuration.setText(stringToTime(position));
                    }
                    if (player != null) {
                        seekTo(position);
                    }
                }
            }

            //开始滑动
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            //停止滑动
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekTo(positionValue(seekBar.getProgress()));
            }
        });
        updateProgress();

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
                if (player.getPlayWhenReady()) {
                    sendBroadcastEvent(MusicService.ACTION_OPT_MUSIC_PAUSE);
                } else
                    sendBroadcastEvent(MusicService.ACTION_OPT_MUSIC_PLAY);
                //mDisc.playOrPause();
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
                preparePlayMusic();
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

    //更新进度条 duration总时长,position 当前的位置,bufferPosition缓存位置
    private void updateProgress() {

        long duration = player == null ? 0 : player.getDuration();
        long position = player == null ? 0 : player.getCurrentPosition();
        long bufferPosition = player == null ? 0 : player.getBufferedPosition();
        int playbackState = player == null ? ExoPlayer.STATE_IDLE : player.getPlaybackState();
        mTvMusicDuration.setText(stringToTime(position));
        mTvTotalMusicDuration.setText(stringToTime(duration));
        mSeekBar.setProgress(progressBarValue(position));
        mSeekBar.setSecondaryProgress(progressBarValue(bufferPosition));

        mMusicHandler.removeCallbacks(updateProgressAction);

        if (playbackState != ExoPlayer.STATE_IDLE ) {
            long delayMs;
            if (player.getPlayWhenReady() && playbackState == ExoPlayer.STATE_READY) {
                delayMs = 1000 - (position % 1000);
                if (delayMs < 200) {
                    delayMs += 1000;
                }
            } else {
                delayMs = 1000;
            }
            mMusicHandler.postDelayed(updateProgressAction, delayMs);
        }
    }

    private void play() {
        mIvPlayOrPause.setImageResource(R.drawable.play_rdi_btn_pause);
        globalPlayMusic.setIsPlay(!globalPlayMusic.getIsPlay());
        globalPlayMusic.setPlayStatus(ExoPlayer.STATE_READY);
        //sendBroadcastEvent(MusicService.ACTION_OPT_MUSIC_PLAY);
        updateProgress();
    }

    private void pause() {
        mIvPlayOrPause.setImageResource(R.drawable.play_rdi_btn_play);
        globalPlayMusic.setIsPlay(!globalPlayMusic.getIsPlay());
        globalPlayMusic.setPlayStatus(ExoPlayer.STATE_READY);
        //sendBroadcastEvent(MusicService.ACTION_OPT_MUSIC_PAUSE);
        updateProgress();
    }

    private void stop() {
        mIvPlayOrPause.setImageResource(R.drawable.play_rdi_btn_play);
        globalPlayMusic.setPlayStatus(ExoPlayer.STATE_IDLE);
        updateProgress();
    }

    private void next() {
        sendBroadcastEvent(MusicService.ACTION_OPT_MUSIC_NEXT);
        updateProgress();
    }

    private void last() {
        sendBroadcastEvent(MusicService.ACTION_OPT_MUSIC_LAST);
        updateProgress();

    }

    private void complete() {
        verifyNext();
    }


    private void seekTo(long position) {
        Intent intent = new Intent(MusicService.ACTION_OPT_MUSIC_SEEK_TO);
        intent.putExtra(MusicService.PARAM_MUSIC_SEEK_TO, position);
        localBroadcastManager.sendBroadcast(intent);
    }


    //将position转化为时间
    private String stringToTime(long timeMs) {
        if (timeMs == C.TIME_UNSET) {
            timeMs = 0;
        }
        long totalSeconds = (timeMs + 500) / 1000;
        long seconds = totalSeconds % 60;
        long minutes = (totalSeconds / 60) % 60;
        long hours = totalSeconds / 3600;
        formatBuilder.setLength(0);
        return hours > 0 ? formatter.format("%d:%02d:%02d", hours, minutes, seconds).toString()
                : formatter.format("%02d:%02d", minutes, seconds).toString();
    }

    //将position转化为progress
    private int progressBarValue(long position) {
        long duration = player == null ? C.TIME_UNSET : player.getDuration();
        return duration == C.TIME_UNSET || duration == 0 ? 0
                : (int) ((position * PROGRESS_BAR_MAX) / duration);
    }

    //将progress 转换为 position
    private long positionValue(int progress) {
        long duration = player == null ? C.TIME_UNSET : player.getDuration();
        return duration == C.TIME_UNSET ? 0 : ((duration * progress) / PROGRESS_BAR_MAX);
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

