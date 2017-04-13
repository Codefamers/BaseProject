package com.qhn.bhne.xhmusic.di.component;

import android.app.Activity;
import android.content.Context;

import com.qhn.bhne.xhmusic.di.module.ActivityModule;
import com.qhn.bhne.xhmusic.di.module.ApplicationModule;
import com.qhn.bhne.xhmusic.di.module.FragmentModule;
import com.qhn.bhne.xhmusic.di.scope.ContextLife;
import com.qhn.bhne.xhmusic.di.scope.PerFragment;
import com.qhn.bhne.xhmusic.mvp.localMusic.LocalMusicFragment;
import com.qhn.bhne.xhmusic.mvp.localMusic.SingleMusicFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.BroadcastFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.RecommendMusicFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.MVListFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.RankFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.SearchAlbumFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.SearchMVFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.SearchRecommendFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.SearchResultFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.SearchSongMenuFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.SearchSongFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.SingerFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.SongMenuFragment;

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

    void inject(SingleMusicFragment mFragment);


}
