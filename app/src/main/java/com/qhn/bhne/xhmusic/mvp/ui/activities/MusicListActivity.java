package com.qhn.bhne.xhmusic.mvp.ui.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.application.App;
import com.qhn.bhne.xhmusic.listener.ClickAdapterItemListener;
import com.qhn.bhne.xhmusic.listener.LoadMoreListener;
import com.qhn.bhne.xhmusic.mvp.entity.GlobalPlayMusic;
import com.qhn.bhne.xhmusic.mvp.entity.SongMenuIntro;
import com.qhn.bhne.xhmusic.mvp.entity.Songs;
import com.qhn.bhne.xhmusic.mvp.model.MusicListModel;
import com.qhn.bhne.xhmusic.mvp.presenter.impl.MusicListPresentImpl;
import com.qhn.bhne.xhmusic.mvp.ui.adapter.MusicListRecyclerAdapter;
import com.qhn.bhne.xhmusic.mvp.view.MusicListView;
import com.qhn.bhne.xhmusic.utils.DimenUtil;
import com.qhn.bhne.xhmusic.wight.DisableScrollRecyclerView;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.qhn.bhne.xhmusic.common.Constants.SONG_MENU;


public class MusicListActivity extends BaseLoadDataActivity<MusicListPresentImpl, List<Songs>> implements ClickAdapterItemListener<Songs> {


    public static final String SONG_MENU_VIEW = "songMenuView";
    public static final String MUSIC_LIST_MODEL = "musicListModel";
    @Inject
    MusicListRecyclerAdapter adapter;


    @Inject
    GlobalPlayMusic currentPlayMusic;
    @BindView(R.id.ll_cover_view)
    LinearLayout llCoverView;
    @BindView(R.id.txt_collect)
    TextView txtCollect;
    @BindView(R.id.txt_comment)
    TextView txtComment;
    @BindView(R.id.txt_share)
    TextView txtShare;
    @BindView(R.id.txt_download)
    TextView txtDownload;
    @BindView(R.id.ll_all_cover)
    LinearLayout llAllCover;
    @Nullable
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.txt_song_count)
    TextView txtSongCount;
    @BindView(R.id.rec_music_list)
    DisableScrollRecyclerView recMusicList;


    private SongMenuIntro specialBean;
    @Inject
    MusicListPresentImpl musicListPresent;
    @Inject
    GlobalPlayMusic globalPlayMusic;
    private MusicListModel musicListModel;
    private HashMap<String, Integer> paramsMap;
    private Integer page = 1;
    private LinearLayoutManager linearLayoutManager;
    private MusicListView musicListView;
    private List<Songs> songsList;
    @Override
    protected void initViews() {

        musicListView = getIntent().getParcelableExtra(SONG_MENU_VIEW);
        musicListModel = getIntent().getParcelableExtra(MUSIC_LIST_MODEL);
        specialBean = getIntent().getParcelableExtra(SONG_MENU);
        Bundle bundle = getIntent().getExtras();
        //paramsMap=getIntent()
        paramsMap = new HashMap<>();
        if (bundle.getInt("albumid") != 0) {
            paramsMap.put("albumid", bundle.getInt("albumid"));
        }
        if (bundle.getInt("ranktype") != 0) {
            paramsMap.put("ranktype", bundle.getInt("ranktype"));
        }
        if (bundle.getInt("rankid") != 0) {
            paramsMap.put("rankid", bundle.getInt("rankid"));
        }
        paramsMap.put("page", bundle.getInt("page"));
        paramsMap.put("pageSize", bundle.getInt("pageSize"));
        if (bundle.getInt("specialid") != 0) {
            paramsMap.put("specialid", bundle.getInt("specialid"));
        }


        musicListPresent.setModelImpl(musicListModel);


        musicListPresent.setMapParams(paramsMap);
        musicListView.initView(llCoverView, this);
        setTransparency(true);
        musicListPresent.attachView(this);
        musicListPresent.create();
        initRecycleView();
        initCoverInfo();


        musicListView.updateSongMenuInfo();
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float offset = Math.abs(verticalOffset * 1.0f) / appBarLayout.getTotalScrollRange();
                if (offset!=0f) {
                    if (offset > 0.4) {
                        toolbar.setTitle(specialBean.getSpecialname());
                    } else {
                        toolbar.setTitle("歌单");
                    }
                    toolbar.setBackgroundColor(changeAlpha(getResources().getColor(R.color.colorPrimary), Math.abs(verticalOffset * 1.0f) / appBarLayout.getTotalScrollRange()));

                }
            }
        });

    }

    /**
     * 根据百分比改变颜色透明度
     */
    private int changeAlpha(int color, float fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = (int) (Color.alpha(color) * fraction);
        return Color.argb(alpha, red, green, blue);
    }

    private void initCoverInfo() {
        toolbar.setTitle("歌单");
        toolbar.setSubtitle(specialBean.getIntro());


        int commentNum = specialBean.getSlid() == 0 ? 0 : specialBean.getSlid();
        int playCount = specialBean.getSongcount() == 0 ? 99 : specialBean.getSongcount();
        String favoriteNum = specialBean.getCollectcount() == 0 ? "暂无" : String.valueOf(specialBean.getCollectcount());
        //使用spannableStringBuilder时要注意setText时只有包含spannableString对象
        String allSongCount = "播放全部(共" + playCount + "首)";
        SpannableStringBuilder spannableString = new SpannableStringBuilder(allSongCount);

        ForegroundColorSpan colorSpan = new ForegroundColorSpan(App.getAppContext().getResources().getColor(R.color.alpha_35_black));
        spannableString.setSpan(new AbsoluteSizeSpan((int) DimenUtil.sp2px(12)), 4, allSongCount.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(colorSpan, 4, allSongCount.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        txtSongCount.setText(spannableString);
        txtComment.setText(String.valueOf(commentNum));
        txtCollect.setText(favoriteNum);
        Glide.with(this).load(specialBean.getImgurl().replace("{size}", "400")).bitmapTransform(new BlurTransformation(this, 40)).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                resource.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                appbar.setBackground(resource);
            }
        });
    }

    /*@Override
    public void updateSongMenuInfo(Object data) {

    }*/

    private void initRecycleView() {
        adapter = new MusicListRecyclerAdapter();
        adapter.setItemListener(this);
        linearLayoutManager = new LinearLayoutManager(this);
        recMusicList.setItemAnimator(new DefaultItemAnimator());
        recMusicList.setLayoutManager(new LinearLayoutManager(this));
        recMusicList.setAdapter(adapter);
        recMusicList.setOnScrollListener(new LoadMoreListener(linearLayoutManager) {
            @Override
            public void onLoadMore() {
                paramsMap.put("page", page++);
                musicListPresent.loadData(paramsMap, false);
            }
        });
    }

    @Override
    protected void initInjector() {
        getmActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_music_list;
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }


    @Override
    public void loadSuccess(List<Songs> data) {
        super.loadSuccess(data);
        adapter.setList(data);
        adapter.notifyDataSetChanged();
        songsList=data;


    }

    @Override
    protected View getSuccessView() {
        return recMusicList;
    }


    @OnClick({R.id.txt_collect, R.id.txt_comment, R.id.txt_share, R.id.txt_download})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_collect:
                Toast.makeText(this, "收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_comment:
                Toast.makeText(this, R.string.not_develop, Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_share:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_download:
                Toast.makeText(this, "下载", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    public void onClick(Songs data,int position) {
        globalPlayMusic.setCurrentPlaySongList(songsList);
        globalPlayMusic.setPlayPosition(position);
        globalPlayMusic.setIsPlay(true);
        startActivity(new Intent(MusicListActivity.this,PlayMusicActivity.class));
    }
}
