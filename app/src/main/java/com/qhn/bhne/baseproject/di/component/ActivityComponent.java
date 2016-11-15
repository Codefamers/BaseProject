package com.qhn.bhne.baseproject.di.component;

import android.app.Activity;
import android.content.Context;

import com.qhn.bhne.baseproject.di.module.ActivityModule;

import com.qhn.bhne.baseproject.di.scope.ContextLife;
import com.qhn.bhne.baseproject.di.scope.PerActivity;
import com.qhn.bhne.baseproject.mvp.ui.activities.MainActivity;


import dagger.Component;

/**
 * Created by qhn
 * on 2016/10/26 0026.
 */
@PerActivity//如果component中依赖的有其他Component注入的时候也要将该component的module实例化
@Component(dependencies = ApplicationComponent.class,modules =ActivityModule.class )
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(MainActivity mainActivity);

  /* void inject(NewsDetailActivity newsDetailActivity);

    void inject(NewsChannelActivity newsChannelActivity);

    void inject(NewsPhotoDetailActivity newsPhotoDetailActivity);

    void inject(PhotoActivity photoActivity);

    void inject(PhotoDetailActivity photoDetailActivity);*/
}
