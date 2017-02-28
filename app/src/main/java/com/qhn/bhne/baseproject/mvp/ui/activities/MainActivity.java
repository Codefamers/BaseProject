package com.qhn.bhne.baseproject.mvp.ui.activities;


import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.common.Constants;
import com.qhn.bhne.baseproject.mvp.entity.CurrentPlayMusic;
import com.qhn.bhne.baseproject.mvp.ui.activities.base.BaseActivity;
import com.qhn.bhne.baseproject.mvp.ui.adapter.OnLinePagerAdapter;
import com.qhn.bhne.baseproject.mvp.ui.fragment.KuGouRecommendMusicFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.LocalMusicFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.MVListFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.RankFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.BroadcastFragment;
import com.qhn.bhne.baseproject.mvp.ui.fragment.SongMenuFragment;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements SongMenuFragment.SongMenuFragmentListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.rel_micro_player)
    RelativeLayout relMicroPlayer;
    @BindView(R.id.img_music_pic)
    ImageView imgMusicPic;
    @BindView(R.id.txt_song_name)
    TextView txtSongName;
    @BindView(R.id.txt_singer_name)
    TextView txtSingerName;
    @BindView(R.id.btn_music_list)
    ImageButton btnMusicList;
    @BindView(R.id.btn_next_music)
    ImageButton btnNextMusic;
    @BindView(R.id.btn_play_music)
    ImageButton btnPlayMusic;
    @Inject
    CurrentPlayMusic currentPlayMusic;
    // @Inject
    //CurrentPlayMusic currentPlayMusic2;
    private static final int REQUEST_CODE = 200;
    public static final String  CHOOSE_SONG_MENU_TYPE= "chooseSongMenuType";
    private SongMenuFragment songMenuFragment;

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
        mIsHasNavigationView = true;
        initViewPager();
        initMicroPlayer();
    }

    private void initMicroPlayer() {
        relMicroPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KLog.d("currentPlayMusic" + currentPlayMusic);
                Intent intent = new Intent(MainActivity.this, MusicListActivity.class);
                startActivity(intent);
                //Toast.makeText(MainActivity.this, "播放位置"+currentPlayMusic.getPlayPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViewPager() {
        tabs.setTabMode(TabLayout.MODE_FIXED);
        List<String> tabTitles = new ArrayList<>();
        tabTitles.add("推荐");
        tabTitles.add("电台");
        tabTitles.add("排行榜");
        tabTitles.add("歌单");
        tabTitles.add("本地");
       // tabTitles.add("MV");
        songMenuFragment=new SongMenuFragment();
        List<Fragment> tabFragmentList = new ArrayList<>();
        tabFragmentList.add(new KuGouRecommendMusicFragment());
        tabFragmentList.add(new BroadcastFragment());
        tabFragmentList.add(new RankFragment());
        tabFragmentList.add(songMenuFragment);
        tabFragmentList.add(new LocalMusicFragment());
       // tabFragmentList.add(new MVListFragment());
        tabs.setupWithViewPager(viewPager);
        OnLinePagerAdapter mainPagerAdapter = new OnLinePagerAdapter(getSupportFragmentManager(), tabTitles, tabFragmentList, null);
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

            case R.id.action_search:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,SearchActivity.class));
                break;
        }
        return false;
    }


    @Override
    public void chooseSongMenuType(int categoryID) {
        Intent in=new Intent(MainActivity.this,SongMenuTypeActivity.class);
        in.putExtra("CATEGORY_ID",categoryID);
        startActivityForResult(in,REQUEST_CODE);
    }

    //使用onActivityResult要注意保持俩个activity在同一个栈中，注意启动模式
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_CODE) {
            switch (resultCode) {
                case SongMenuTypeActivity.REQUEST_CODE:
                    Toast.makeText(this, "返回数据", Toast.LENGTH_SHORT).show();
                    int categoryID=data.getIntExtra(CHOOSE_SONG_MENU_TYPE,0);
                    songMenuFragment.setCategoryID(categoryID);
                    break;
            }
        }
    }
}
