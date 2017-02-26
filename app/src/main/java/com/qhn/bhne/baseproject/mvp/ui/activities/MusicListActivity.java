package com.qhn.bhne.baseproject.mvp.ui.activities;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.application.App;
import com.qhn.bhne.baseproject.mvp.entity.CurrentPlayMusic;
import com.qhn.bhne.baseproject.mvp.entity.MusicList;
import com.qhn.bhne.baseproject.mvp.presenter.impl.MusicListPresentImpl;
import com.qhn.bhne.baseproject.mvp.ui.activities.base.BaseActivity;
import com.qhn.bhne.baseproject.mvp.ui.adapter.MusicListRecyclerAdapter;
import com.qhn.bhne.baseproject.mvp.view.MusicListView;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.socks.library.KLog;

import javax.inject.Inject;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;


public class MusicListActivity extends BaseActivity implements MusicListView {


    @BindView(R.id.txt_list_title)
    TextView txtListTitle;
    @BindView(R.id.rel_cover)
    RelativeLayout relCover;
    @BindView(R.id.rec_music_list)
    RecyclerView recMusicList;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txt_listen_count)
    TextView txtListenCount;
    @BindView(R.id.img_music_list_cover)
    ImageView imgMusicListCover;
    @BindView(R.id.fra_music_list_cover)
    FrameLayout fraMusicListCover;
    @BindView(R.id.img_author_header)
    ImageView imgAuthorHeader;
    @BindView(R.id.txt_author_name)
    TextView txtAuthorName;
    @BindView(R.id.txt_collect)
    TextView txtCollect;
    @BindView(R.id.txt_comment)
    TextView txtComment;
    @BindView(R.id.txt_share)
    TextView txtShare;
    @BindView(R.id.txt_download)
    TextView txtDownload;
    @BindView(R.id.activity_music_list)
    ScrollView activityMusicList;

    @Inject
    MusicListRecyclerAdapter adapter;
    @Inject
    MusicListPresentImpl musicListPresent;
    @Inject
    CurrentPlayMusic currentPlayMusic;

    @Override
    protected void initViews() {
        musicListPresent.attachView(this);
        musicListPresent.create();
        toolbar.setTitle("歌单");
        toolbar.setSubtitle("编辑推荐:那些一专成绝响却给我们留下难忘记的回忆");
        initRecycleView();
        //KLog.d("currentPlayMusic"+currentPlayMusic+"\ncurrentPlayMusic2"+currentPlayMusic2);
    }

    private void initRecycleView() {
        adapter = new MusicListRecyclerAdapter();
        recMusicList.setItemAnimator(new DefaultItemAnimator());
        recMusicList.setLayoutManager(new LinearLayoutManager(this));
        recMusicList.setAdapter(adapter);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_play_music, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }


    @Override
    public void loadSuccess(Object data) {
        adapter.setList(((MusicList) data).getSongs());
        currentPlayMusic.setCurrentPlaySongList(((MusicList) data).getSongs());
        adapter.setCurrentPlayMusic(currentPlayMusic);
        adapter.notifyDataSetChanged();
        updateToolBar((MusicList) data);
        updateCoverInfo((MusicList) data);
    }

    //更新封面信息
    private void updateCoverInfo(MusicList data) {
        String authorName=data.getOwner().getNick_name()==null?"暂无":data.getOwner().getNick_name();
        String commentNum=data.getComment_count()==null?"暂无":data.getComment_count();
        String shareNum=data.getShare_count()==0?"暂无":String.valueOf(data.getShare_count());
        String favoriteNum=data.getFavorite_count()==0?"暂无":String.valueOf(data.getFavorite_count());

        txtListenCount.setText(MyUtils.dealBigNum(data.getListen_count()));
        txtAuthorName.setText(authorName);
        txtComment.setText(commentNum);
        txtShare.setText(shareNum);
        txtCollect.setText(favoriteNum);
        txtListTitle.setText(data.getTitle());
       // Glide.with(this).load(data.getImage().getPic()).bitmapTransform(new BlurTransformation(this,20)).into(imgMusicListCover);
        Glide.with(this).load(data.getOwner().getPortrait_pic()).bitmapTransform(new CropCircleTransformation(this)).into(imgAuthorHeader);
        Glide.with(this).load(data.getImage().getPic()).bitmapTransform(new BlurTransformation(this,20)).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                resource.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                relCover.setBackground(resource);
            }
        });
         MyUtils.loadImageFormNet(data.getImage().getPic(),imgMusicListCover,this);
        //MyUtils.loadImageFormNet(data.getOwner().getPortrait_pic(),imgAuthorHeader,this);


    }

    //更新toolBar上信息
    private void updateToolBar(MusicList data) {
        toolbar.setSubtitle(data.getDesc());
    }

    @Override
    public void loadFail(String message) {

    }

    @Override
    public void loadBefore() {

    }

    @Override
    public void loadDataEmpty() {

    }

}
