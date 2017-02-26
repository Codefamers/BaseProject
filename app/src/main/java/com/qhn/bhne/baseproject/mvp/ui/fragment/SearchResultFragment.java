package com.qhn.bhne.baseproject.mvp.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.ui.adapter.OnLinePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by qhn
 * on 2017/2/25 0025.
 */

public class SearchResultFragment extends BaseFragment {
    public static final String QUERY = "query";
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.vp_success_view)
    ViewPager vpSuccessView;


    @Override
    protected void initInjector() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_result;
    }

    @Override
    protected void initViews(View mFragmentView) {
        initViewPager();
    }

    private void initViewPager() {


        SingleSongFragment singleSongFragment=new SingleSongFragment();
        tabs.setTabMode(TabLayout.MODE_FIXED);
        List<String> tabTitles = new ArrayList<>();
        tabTitles.add("单曲");
        tabTitles.add("歌单");
        tabTitles.add("专辑");
        tabTitles.add("MV");
        List<Fragment> tabFragmentList = new ArrayList<>();
        tabFragmentList.add(singleSongFragment);
        tabFragmentList.add(new SearchSongMenuFragment());
        tabFragmentList.add(new SearchAlbumFragment());
        tabFragmentList.add(new SearchMvFragment());
        tabs.setupWithViewPager(vpSuccessView);
        OnLinePagerAdapter mainPagerAdapter = new OnLinePagerAdapter(getChildFragmentManager(), tabTitles, tabFragmentList, null);
        vpSuccessView.setAdapter(mainPagerAdapter);
    }

    @Override
    protected View getSuccessView() {
        return vpSuccessView;
    }


}
