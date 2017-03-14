package com.qhn.bhne.xhmusic.mvp.ui.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveVideoTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.qhn.bhne.xhmusic.application.App;
import com.qhn.bhne.xhmusic.common.MusicConstants;
import com.qhn.bhne.xhmusic.di.component.DaggerServiceComponent;
import com.qhn.bhne.xhmusic.mvp.entity.GlobalPlayMusic;
import com.qhn.bhne.xhmusic.mvp.entity.SongInfo;
import com.qhn.bhne.xhmusic.mvp.entity.Songs;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.google.android.exoplayer2.C.TIME_UNSET;

/**
 * @author quhuainan
 *         created on 2017/3/13 0013
 */

public class MusicService extends Service {

    /*操作指令*/
    public static final String ACTION_OPT_MUSIC_PLAY = "ACTION_OPT_MUSIC_PLAY";
    public static final String ACTION_OPT_MUSIC_PAUSE = "ACTION_OPT_MUSIC_PAUSE";
    public static final String ACTION_OPT_MUSIC_NEXT = "ACTION_OPT_MUSIC_NEXT";
    public static final String ACTION_OPT_MUSIC_LAST = "ACTION_OPT_MUSIC_LAST";
    public static final String ACTION_OPT_MUSIC_SEEK_TO = "ACTION_OPT_MUSIC_SEEK_TO";

    /*状态指令*/
    public static final String ACTION_STATUS_MUSIC_PLAY = "ACTION_STATUS_MUSIC_PLAY";
    public static final String ACTION_STATUS_MUSIC_PAUSE = "ACTION_STATUS_MUSIC_PAUSE";
    public static final String ACTION_STATUS_MUSIC_COMPLETE = "ACTION_STATUS_MUSIC_COMPLETE";
    public static final String ACTION_STATUS_MUSIC_DURATION = "ACTION_STATUS_MUSIC_DURATION";

    public static final String PARAM_MUSIC_DURATION = "PARAM_MUSIC_DURATION";
    public static final String PARAM_MUSIC_SEEK_TO = "PARAM_MUSIC_SEEK_TO";
    public static final String PARAM_MUSIC_CURRENT_POSITION = "PARAM_MUSIC_CURRENT_POSITION";
    public static final String PARAM_MUSIC_IS_OVER = "PARAM_MUSIC_IS_OVER";
    private static final String ACTION_OPT_MUSIC_STOP = "ACTION_STATUS_MUSIC_STOP";

    private int mCurrentMusicIndex = 0;
    private int mCurrentMusicQuality = MusicConstants.MUSIC_QUALITY_STANDARD;
    private int lastIndex;//上一次播放的位置


    private SimpleExoPlayer player;
    private DefaultDataSourceFactory dataSourceFactory;
    private DefaultExtractorsFactory extractorsFactory;
    private MediaSource audioSource;
    @Inject
    GlobalPlayMusic globalPlayMusic;
    private List<Songs> playList = new ArrayList<>();
    private SongInfo mCurrentSongInfo;
    private BroadcastReceiver mMusicReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private SongInfo lastSongInfo;

    @Override
    public void onCreate() {
        super.onCreate();
        initBoardCastReceiver();
        DaggerServiceComponent.builder()
                .applicationComponent(((App) getApplication()).
                        getApplicationComponent())
                .build()
                .inject(this);
        initData();
        initPlayer();

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        return super.onStartCommand(intent, flags, startId);
    }

    private void initData() {
        mCurrentMusicIndex = globalPlayMusic.getPlayPosition();
        playList = globalPlayMusic.getCurrentPlaySongList();
        mCurrentSongInfo = playList.get(mCurrentMusicIndex).getSongInfo();
        mCurrentMusicQuality = globalPlayMusic.getMusicQuality();
    }

    //初始化播放器组件
    private void initPlayer() {
        //1.创建渲染器TrackSelector
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory = new
                AdaptiveVideoTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);

        //2.创建一个默认的加载控制器 loadControl
        LoadControl loadControl = new DefaultLoadControl();
        //3.创建一个Player
        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector, loadControl);
        DefaultBandwidthMeter bandwidthMete = new DefaultBandwidthMeter();
        dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "ExoPlayerDemo"), bandwidthMete);
        extractorsFactory = new DefaultExtractorsFactory();
        player.prepare(getAudioSource());
    }

    //注册本地广播
    private void initBoardCastReceiver() {
        mMusicReceiver = new MusicServiceReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_OPT_MUSIC_PLAY);
        intentFilter.addAction(ACTION_OPT_MUSIC_PAUSE);
        intentFilter.addAction(ACTION_OPT_MUSIC_NEXT);
        intentFilter.addAction(ACTION_OPT_MUSIC_LAST);
        intentFilter.addAction(ACTION_OPT_MUSIC_SEEK_TO);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.registerReceiver(mMusicReceiver, intentFilter);
    }

    //发送广播
    private void sendBroadcastEvent(final String action) {
        localBroadcastManager.sendBroadcast(new Intent(action));
    }

    public int getDuration() {
        return player.getDuration() == TIME_UNSET ? 0
                : (int) player.getDuration();
    }

    public class MusicServiceReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(ACTION_OPT_MUSIC_PLAY)||action.equals(ACTION_OPT_MUSIC_LAST)||action.equals(ACTION_OPT_MUSIC_NEXT)) {
                play();
            } else if (action.equals(ACTION_OPT_MUSIC_PAUSE)) {
                pause();
            } else if (action.equals(ACTION_OPT_MUSIC_STOP)) {
                stop();
            }else if (action.equals(ACTION_OPT_MUSIC_SEEK_TO)) {
                seekTo(intent);
            }
        }
    }


    private MediaSource getAudioSource() {
        if (audioSource != null) {
            audioSource.releaseSource();
        }
        Uri uri = Uri.parse(mCurrentSongInfo.getUrl());
        return audioSource = new ExtractorMediaSource(uri, dataSourceFactory, extractorsFactory, null, null);
    }

    //播放歌曲 判断播放歌曲是否为同一个是就继续播放，否则就重新播放新歌曲并结束上一次的播放
    private void play() {

        initData();

        if (lastSongInfo==null||!lastSongInfo.getUrl().equals(mCurrentSongInfo.getUrl())) {//不相同
            player.stop();//暂停上一次播放内容
            player.prepare(getAudioSource());//重新准备资源
        }
        player.setPlayWhenReady(true);//继续播放
        lastIndex = mCurrentMusicIndex;
        lastSongInfo = playList.get(lastIndex).getSongInfo();

    }

    private void pause() {
        player.setPlayWhenReady(false);
    }

    private void stop() {
        player.stop();
    }

    private void seekTo(Intent intent) {
        int position = intent.getIntExtra(PARAM_MUSIC_SEEK_TO, 0);
        long seekPosition = player.getDuration() == TIME_UNSET ? 0
                : Math.min(Math.max(0, position), getDuration());
        player.seekTo(seekPosition);
        //player.getBufferedPosition()
        if (player.isLoading()) {

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.release();
        player = null;
        localBroadcastManager.unregisterReceiver(mMusicReceiver);

    }


}
