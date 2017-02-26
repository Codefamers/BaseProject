package com.qhn.bhne.baseproject.mvp.ui.fragment;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.ui.adapter.OnLinePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by qhn
 * on 2016/11/2 0002.
 */

public class OnlineMusicFragment extends BaseFragment {
    @BindView(R.id.tab_online_music)
    TabLayout tabOnlineMusic;
    @BindView(R.id.vp_online_music)
    ViewPager vpOnlineMusic;
    @Inject
    Activity activity;

    @Override
    protected void initInjector() {
        fragmentComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_online_music;
    }

    @Override
    protected void initViews(View mFragmentView) {
        tabOnlineMusic.setTabMode(TabLayout.MODE_FIXED);
        List<String> tabTitles = new ArrayList<>();
        tabTitles.add("个性推荐");
        tabTitles.add("歌单");
        tabTitles.add("排行榜");
        List<Fragment> tabFragmentList = new ArrayList<>();
        tabFragmentList.add(new RecommendMusicFragment());
        tabFragmentList.add(new MusicListFragment());
        tabFragmentList.add(new MusicListFragment());
        tabOnlineMusic.setupWithViewPager(vpOnlineMusic);
        OnLinePagerAdapter mainPagerAdapter = new OnLinePagerAdapter(getActivity().getSupportFragmentManager(), tabTitles, tabFragmentList, null);
        vpOnlineMusic.setAdapter(mainPagerAdapter);

    }

    @Override
    protected View getSuccessView() {
        return null;
    }


}
