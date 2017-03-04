package com.qhn.bhne.baseproject.di.component;

import android.app.Activity;
import android.content.Context;

import com.qhn.bhne.baseproject.di.module.FragmentModule;
import com.qhn.bhne.baseproject.di.scope.ContextLife;
import com.qhn.bhne.baseproject.di.scope.PerFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.BroadcastFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.RecommendMusicFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.MVListFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.RankFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.SearchAlbumFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.SearchMVFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.SearchRecommendFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.SearchResultFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.SearchSongMenuFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.SearchSongFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.SongMenuFragment;

import dagger.Component;

/**
 * Created by qhn
 * on 2016/10/27 0027.
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    @ContextLife("Fragment")
    Context getActivityContext();

    Activity getActivity();

    void inject(BroadcastFragment songMenuFragment);

    void inject(MVListFragment mvListFragment);

    void inject(RankFragment rankFragment);

    void inject(SearchRecommendFragment searchRecommendFragment);

    void inject(SearchResultFragment searchResultFragment);

    void inject(SearchSongFragment singleSongFragment);

    void inject(SearchSongMenuFragment searchSongMenuFragment);

    void inject(SearchAlbumFragment searchAlbumFragment);

    void inject(SearchMVFragment searchMvFragment);

    void inject(RecommendMusicFragment kugouRemmendMusicFragment);

    void inject(SongMenuFragment songMenuFragment);
}
