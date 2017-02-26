package com.qhn.bhne.baseproject.di.component;

import android.content.Context;

import com.qhn.bhne.baseproject.db.DaoSession;
import com.qhn.bhne.baseproject.di.module.ApplicationModule;
import com.qhn.bhne.baseproject.di.scope.ContextLife;
import com.qhn.bhne.baseproject.di.scope.PerApp;
import com.qhn.bhne.baseproject.mvp.entity.CurrentPlayMusic;
import com.qhn.bhne.baseproject.mvp.ui.activities.base.BaseActivity;
import com.qhn.bhne.baseproject.utils.RxBus;

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
    CurrentPlayMusic getCurrentPlayMusic();
    DaoSession getDaoSession();
    RxBus getRxBus();

}
