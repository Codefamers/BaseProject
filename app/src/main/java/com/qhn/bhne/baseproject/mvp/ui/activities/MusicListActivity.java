package com.qhn.bhne.baseproject.mvp.ui.activities;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.application.App;
import com.qhn.bhne.baseproject.listener.LoadMoreListener;
import com.qhn.bhne.baseproject.mvp.entity.CurrentPlayMusic;
import com.qhn.bhne.baseproject.mvp.entity.SongMenuIntro;
import com.qhn.bhne.baseproject.mvp.entity.Songs;
import com.qhn.bhne.baseproject.mvp.model.MusicListModel;
import com.qhn.bhne.baseproject.mvp.presenter.impl.MusicListPresentImpl;
import com.qhn.bhne.baseproject.mvp.ui.adapter.MusicListRecyclerAdapter;
import com.qhn.bhne.baseproject.mvp.view.MusicListView;
import com.qhn.bhne.baseproject.utils.DimenUtil;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.qhn.bhne.baseproject.common.Constants.SONG_MENU;


public class MusicListActivity extends BaseLoadDataActivity<MusicListPresentImpl, List<Songs>> {


    public static final String SONG_MENU_VIEW = "songMenuView";
    public static final String MUSIC_LIST_MODEL = "musicListModel";
    @Inject
    MusicListRecyclerAdapter adapter;


    @Inject
    CurrentPlayMusic currentPlayMusic;

    @BindView(R.id.txt_collect)
    TextView txtCollect;
    @BindView(R.id.txt_comment)
    TextView txtComment;
    @BindView(R.id.txt_share)
    TextView txtShare;
    @BindView(R.id.txt_download)
    TextView txtDownload;
    @BindView(R.id.ll_cover_view)
    LinearLayout llCoverView;
    @BindView(R.id.txt_song_count)
    TextView txtSongCount;
    @BindView(R.id.rec_music_list)
    RecyclerView recMusicList;
    @BindView(R.id.root)
    FrameLayout root;

    @BindView(R.id.ll_all_cover)
    LinearLayout llAllCover;
    @BindView(R.id.activity_music_list)
    NestedScrollView activityMusicList;



    private SongMenuIntro specialBean;
    @Inject
    MusicListPresentImpl musicListPresent;

    private MusicListModel musicListModel;
    private HashMap<String, Integer> paramsMap;
    private Integer page = 1;
    private LinearLayoutManager linearLayoutManager;
    private MusicListView musicListView;

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


    }

    private void initCoverInfo() {
        toolbar.setBackgroundColor(getResources().getColor(R.color.alpha_00_white));
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
                llAllCover.setBackground(resource);
            }
        });
    }

    /*@Override
    public void updateSongMenuInfo(Object data) {

    }*/

    private void initRecycleView() {
        adapter = new MusicListRecyclerAdapter();
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



}
