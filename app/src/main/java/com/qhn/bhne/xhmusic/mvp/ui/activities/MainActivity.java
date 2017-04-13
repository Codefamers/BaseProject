package com.qhn.bhne.xhmusic.mvp.ui.activities;


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

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.mvp.entity.db.ArtistInfo;
import com.qhn.bhne.xhmusic.mvp.entity.db.FolderInfo;
import com.qhn.bhne.xhmusic.mvp.entity.GlobalPlayMusic;
import com.qhn.bhne.xhmusic.mvp.entity.SearchAlbum;
import com.qhn.bhne.xhmusic.mvp.entity.db.SongInfo;
import com.qhn.bhne.xhmusic.mvp.model.impl.LocalMusicInfoProvider;
import com.qhn.bhne.xhmusic.mvp.ui.activities.base.BaseActivity;
import com.qhn.bhne.xhmusic.mvp.ui.adapter.OnLinePagerAdapter;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.RecommendMusicFragment;
import com.qhn.bhne.xhmusic.mvp.localMusic.LocalMusicFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.RankFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.BroadcastFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.SongMenuFragment;
import com.qhn.bhne.xhmusic.mvp.ui.service.MusicService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements SongMenuFragment.SongMenuFragmentListener,RecommendMusicFragment.OnClickMoreButtonListener{

    private static final int SONG_MENU_PAGE = 3;
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
    GlobalPlayMusic currentPlayMusic;
    // @Inject
    //GlobalPlayMusic currentPlayMusic2;
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
        Intent in = new Intent(this, MusicService.class);
        startService(in);
    }

    private void initMicroPlayer() {
        relMicroPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        tabFragmentList.add(new RecommendMusicFragment());
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
                    int categoryID=data.getIntExtra(CHOOSE_SONG_MENU_TYPE,-1);
                    if (categoryID!=-1) {
                        songMenuFragment.setCategoryID(categoryID);
                    }

                    break;
            }
        }
    }

    @Override
    public void onClickButton(View view) {

        switch (view.getId()) {
            case R.id.btn_hot_music:
                viewPager.setCurrentItem(SONG_MENU_PAGE,true);
                break;
            case R.id.btn_exclusive_report:
                //startActivity(new Intent(MainActivity.this, SampleChooserActivity.class));
                //Toast.makeText(activity, "独家报道", Toast.LENGTH_SHORT).show();
               /* new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<SearchAlbum> album= LocalMusicInfoProvider.queryAlbums(MainActivity.this);
                        album.size();
                        List<SongInfo> songInfos= LocalMusicInfoProvider.queryMusic(MainActivity.this, 3);
                        songInfos.size();
                        List<FolderInfo> folder= LocalMusicInfoProvider.queryFolder(MainActivity.this);
                        folder.size();
                        List<ArtistInfo> artistInfos= LocalMusicInfoProvider.queryArtist(MainActivity.this);
                        artistInfos.size();
                    }
                }).start();*/

                break;
            case R.id.btn_new_music:

                //Toast.makeText(activity, "新歌排行", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_good_mv:
                //Toast.makeText(activity, "推荐MV", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
