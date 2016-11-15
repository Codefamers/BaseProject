package com.qhn.bhne.baseproject.mvp.ui.activities;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.ui.activities.base.BaseActivity;
import com.qhn.bhne.baseproject.mvp.ui.adapter.OnLinePagerAdapter;
import com.qhn.bhne.baseproject.mvp.ui.adapter.pagerAdapter.MainPagerAdapter;
import com.qhn.bhne.baseproject.mvp.ui.fragment.FindFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.LocalMusicFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.MVListFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.MusicListFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.OnlineMusicFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.RankFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.RecommendMusicFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.SongMenuFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabs;

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    /*@BindView(R.id.fab)
    FloatingActionButton fab;*/
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;





    @Override
    protected void initInjector() {
        mActivityComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        //initNavigation();
        mIsHasNavigationView=true;
        initViewPager();
    }

    private void initViewPager() {
        tabs.setTabMode(TabLayout.MODE_FIXED);
        List<String> tabTitles=new ArrayList<>();
        tabTitles.add("推荐");
        tabTitles.add("电台");
        tabTitles.add("榜单");
        //tabTitles.add("发现");
        tabTitles.add("本地");
        tabTitles.add("MV");
        List<Fragment> tabFragmentList=new ArrayList<>();
        tabFragmentList.add(new RecommendMusicFragment());
        tabFragmentList.add(new SongMenuFragment());
        tabFragmentList.add(new RankFragment());
        tabFragmentList.add(new LocalMusicFragment());
        tabFragmentList.add(new MVListFragment());
        tabs.setupWithViewPager(viewPager);
        OnLinePagerAdapter mainPagerAdapter=new OnLinePagerAdapter(getSupportFragmentManager(),tabTitles,tabFragmentList, null);
        viewPager.setAdapter(mainPagerAdapter);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_download:
                Toast.makeText(this, "下载", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_search:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
