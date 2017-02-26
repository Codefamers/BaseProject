package com.qhn.bhne.baseproject.di.module;

import android.content.Context;

import com.qhn.bhne.baseproject.application.App;
import com.qhn.bhne.baseproject.db.DaoSession;
import com.qhn.bhne.baseproject.di.scope.ContextLife;
import com.qhn.bhne.baseproject.di.scope.PerApp;
import com.qhn.bhne.baseproject.mvp.entity.CurrentPlayMusic;
import com.qhn.bhne.baseproject.utils.RxBus;
import com.socks.library.KLog;

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
    public CurrentPlayMusic provideCurrentPlayMusic() {
        return new CurrentPlayMusic();
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


}
