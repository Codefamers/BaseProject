package com.qhn.bhne.baseproject.mvp.ui.service;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;

import com.google.android.exoplayer2.DefaultLoadControl;
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
import com.qhn.bhne.baseproject.application.App;
import com.qhn.bhne.baseproject.common.MusicConstants;
import com.qhn.bhne.baseproject.di.component.DaggerServiceComponent;
import com.qhn.bhne.baseproject.mvp.entity.CurrentPlayMusic;
import com.qhn.bhne.baseproject.mvp.entity.Songs;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by AchillesL on 2016/11/18.
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

    private int mCurrentMusicIndex = 0;
    private int mCurrentMusicQuality = MusicConstants.MUSIC_QUALITY_STANDARD;
    private int lastIndex;//上一次播放的位置
    private boolean mIsMusicPause = false;
    private List<Songs> mMusicDatas = new ArrayList<>();
    private SimpleExoPlayer player;
    private final IBinder dataBinder = new DataBinder();
    private DefaultDataSourceFactory dataSourceFactory;
    private DefaultExtractorsFactory extractorsFactory;
    private MediaSource audioSource;
    @Inject
    CurrentPlayMusic currentPlayMusic;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerServiceComponent.builder()
                .applicationComponent(((App) getApplication()).
                        getApplicationComponent())
                .build()
                .inject(this);
        initData();
        initPlayer();
    }

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


        player.prepare(getAudioSource(mCurrentMusicIndex, MusicConstants.MUSIC_QUALITY_STANDARD));
    }

    private MediaSource getAudioSource(int index, @MusicConstants.MusicQuality int qualityCategory) {
        if (audioSource != null) {
            audioSource.releaseSource();
        }
       // List<Songs.UrlListBean> urlList = mMusicDatas.get(index).getUrlList();
        Uri uri = Uri.parse("");//urlList.get(qualityCategory).getUrl());
        return audioSource = new ExtractorMediaSource(uri, dataSourceFactory, extractorsFactory, null, null);


    }

    @Override
    public IBinder onBind(Intent intent) {

        return dataBinder;
    }

    private void initData() {
        mCurrentMusicIndex = currentPlayMusic.getPlayPosition();
        mMusicDatas = currentPlayMusic.getCurrentPlaySongList();
        mCurrentMusicQuality = currentPlayMusic.getMusicQuality();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.release();
        player = null;

    }

    private void play() {
        initData();
        if (lastIndex != mCurrentMusicIndex) {
            player.prepare(getAudioSource(currentPlayMusic.getPlayPosition(), currentPlayMusic.getMusicQuality()));

        }
        player.setPlayWhenReady(true);
        currentPlayMusic.setMusicStatus(MusicConstants.MusicStatus.PLAY);
        lastIndex = mCurrentMusicIndex;

    }

    private void pause() {
        player.setPlayWhenReady(false);
        mIsMusicPause = true;
        currentPlayMusic.setMusicStatus(MusicConstants.MusicStatus.STOP);
    }

    private void stop() {
        player.stop();
    }

    private void next() {
        if (mCurrentMusicIndex + 1 < mMusicDatas.size()) {
           // play(mCurrentMusicIndex + 1, mCurrentMusicQuality);
        } else {
            stop();
        }
    }

    private void last() {
        if (mCurrentMusicIndex != 0) {

            //play(mCurrentMusicIndex - 1, mCurrentMusicQuality);
        }
    }

    private void seekTo(Intent intent) {
        if (player.isLoading()) {
            int position = intent.getIntExtra(PARAM_MUSIC_SEEK_TO, 0);
            player.seekTo(position);
        }
    }


    public class DataBinder extends Binder {
        public MusicService getMusicService() {
            return MusicService.this;
        }
    }


    public void getMusicAction(String action) {
        if (action.equals(ACTION_OPT_MUSIC_PLAY)) {
            play();
        } else if (action.equals(ACTION_OPT_MUSIC_PAUSE)) {
            pause();
        } else if (action.equals(ACTION_OPT_MUSIC_LAST)) {
            last();
        } else if (action.equals(ACTION_OPT_MUSIC_NEXT)) {
            next();
        } else if (action.equals(ACTION_OPT_MUSIC_SEEK_TO)) {
            //seekTo(intent);
        }
    }
}
