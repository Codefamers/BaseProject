package com.qhn.bhne.xhmusic.di.module;

import android.content.Context;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.AdaptiveVideoTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.qhn.bhne.xhmusic.application.App;
import com.qhn.bhne.xhmusic.db.DaoSession;
import com.qhn.bhne.xhmusic.di.scope.ContextLife;
import com.qhn.bhne.xhmusic.mvp.entity.GlobalPlayMusic;
import com.qhn.bhne.xhmusic.mvp.model.impl.LocalMusicInfoProvider;
import com.qhn.bhne.xhmusic.utils.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by qhn
 * on 2016/10/27 0027.
 */
@Module
public class ApplicationModule {
    private App mApplication;

    public ApplicationModule(App mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    @ContextLife//返回的对象为单例并且生命周期与context相同，且该context的类型为Application类型
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    public App provideApp() {
        return mApplication;
    }

    @Singleton
    @Provides
    public GlobalPlayMusic provideCurrentPlayMusic() {
        return new GlobalPlayMusic();
    }

    @Singleton
    @Provides
    public DaoSession provideDaoSession() {
        return mApplication.getDaoSession();
    }

    @Singleton
    @Provides
    public RxBus provideRxBus() {
        return RxBus.getInstance();
    }

    @Singleton
    @Provides
    public ExoPlayer provideExoPlayer() {
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory = new
                AdaptiveVideoTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);

        //2.创建一个默认的加载控制器 loadControl
        LoadControl loadControl = new DefaultLoadControl();
        //3.创建一个Player
        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(mApplication.getApplicationContext(), trackSelector, loadControl);
        return player;
    }

    @Singleton
    @Provides
    public LocalMusicInfoProvider provideLocalMusicInfoProvider() {
        return new LocalMusicInfoProvider();
    }
}
