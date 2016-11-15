package com.qhn.bhne.baseproject.di.component;

import android.app.Activity;
import android.content.Context;

import com.qhn.bhne.baseproject.di.module.FragmentModule;
import com.qhn.bhne.baseproject.di.scope.ContextLife;
import com.qhn.bhne.baseproject.di.scope.PerFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.MVListFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.OnlineMusicFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.RankFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.RecommendMusicFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.SongMenuFragment;


import dagger.Component;

/**
 * Created by qhn
 * on 2016/10/27 0027.
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {
    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(OnlineMusicFragment OnlineFragment);
    void inject(RecommendMusicFragment recommendFragment);
    void inject(SongMenuFragment songMenuFragment);
    void inject(MVListFragment mvListFragment);
    void inject(RankFragment rankFragment);
}
