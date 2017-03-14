package com.qhn.bhne.xhmusic.di.component;

import android.content.Context;

import com.google.android.exoplayer2.ExoPlayer;
import com.qhn.bhne.xhmusic.db.DaoSession;
import com.qhn.bhne.xhmusic.di.module.ApplicationModule;
import com.qhn.bhne.xhmusic.di.scope.ContextLife;
import com.qhn.bhne.xhmusic.mvp.entity.GlobalPlayMusic;
import com.qhn.bhne.xhmusic.utils.RxBus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by qhn
 * on 2016/10/27 0027.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ContextLife("Application")
    Context getApplication();
    GlobalPlayMusic getCurrentPlayMusic();
    DaoSession getDaoSession();
    RxBus getRxBus();
    ExoPlayer getExoPlayer();

}
