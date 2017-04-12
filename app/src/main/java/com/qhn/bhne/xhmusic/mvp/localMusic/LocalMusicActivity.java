package com.qhn.bhne.xhmusic.mvp.localMusic;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.mvp.ui.activities.ScanMusicActivity;
import com.qhn.bhne.xhmusic.mvp.ui.activities.base.BaseActivity;
import com.qhn.bhne.xhmusic.mvp.ui.adapter.OnLinePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LocalMusicActivity extends BaseActivity {
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.vp_success_view)
    ViewPager vpSuccessView;

    @Override
    protected void initViews() {
        initViewpager();
    }

    private void initViewpager() {
        tabs.setTabMode(TabLayout.MODE_FIXED);
        List<String> tabTitles = new ArrayList<>();
        tabTitles.add("单曲");
        tabTitles.add("歌手");
        tabTitles.add("专辑");
        tabTitles.add("MV");
        List<Fragment> tabFragmentList = new ArrayList<>();
        tabFragmentList.add(new LocalMusicFragment());
        tabFragmentList.add(new LocalMusicFragment());
        tabFragmentList.add(new LocalMusicFragment());
        tabFragmentList.add(new LocalMusicFragment());
        tabs.setupWithViewPager(vpSuccessView);
        OnLinePagerAdapter mainPagerAdapter = new OnLinePagerAdapter(getSupportFragmentManager(), tabTitles, tabFragmentList, null);
        vpSuccessView.setAdapter(mainPagerAdapter);
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_local_music;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_local_music_activity, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:

                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
            case R.id.action_scan:
                startActivity(new Intent(LocalMusicActivity.this, ScanMusicActivity.class));
                break;
            case R.id.action_sort:
                Toast.makeText(this, "排序", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_upgrade_quality:
                Toast.makeText(this, "升级音质", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }


}
