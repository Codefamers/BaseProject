package com.qhn.bhne.xhmusic.di.component;

import android.app.Activity;
import android.content.Context;

import com.qhn.bhne.xhmusic.di.module.ActivityModule;

import com.qhn.bhne.xhmusic.di.scope.ContextLife;
import com.qhn.bhne.xhmusic.di.scope.PerActivity;
import com.qhn.bhne.xhmusic.mvp.localMusic.LocalMusicActivity;
import com.qhn.bhne.xhmusic.mvp.localMusic.ScanMusicActivity;
import com.qhn.bhne.xhmusic.mvp.ui.activities.MainActivity;
import com.qhn.bhne.xhmusic.mvp.ui.activities.MusicListActivity;
import com.qhn.bhne.xhmusic.mvp.ui.activities.PlayMusicActivity;
import com.qhn.bhne.xhmusic.mvp.ui.activities.SearchActivity;
import com.qhn.bhne.xhmusic.mvp.ui.activities.SongMenuTypeActivity;


import dagger.Component;

/**
 * Created by qhn
 * on 2016/10/26 0026.
 */
@PerActivity//如果component中依赖的有其他Component注入的时候也要将该component的module实例化
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife
    Context getApplicationContext();

    Activity getActivity();

    void inject(MainActivity mainActivity);

    void inject(MusicListActivity musicListActivity);

    void inject(PlayMusicActivity playMusicActivity);

    void inject(SearchActivity searchActivity);

    void inject(SongMenuTypeActivity songMenuTypeActivity);

    void inject(ScanMusicActivity scanMusicActivity);

    void inject(LocalMusicActivity localMusicActivity);

}
