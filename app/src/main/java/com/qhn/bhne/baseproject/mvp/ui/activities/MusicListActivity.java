package com.qhn.bhne.baseproject.mvp.ui.activities;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.entity.CurrentPlayMusic;
import com.qhn.bhne.baseproject.mvp.entity.KuGouSong;
import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;
import com.qhn.bhne.baseproject.mvp.presenter.impl.MusicListPresentImpl;
import com.qhn.bhne.baseproject.mvp.ui.adapter.MusicListRecyclerAdapter;
import com.qhn.bhne.baseproject.mvp.view.MusicListView;
import com.qhn.bhne.baseproject.utils.DimenUtil;
import com.qhn.bhne.baseproject.utils.MyUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

import static com.qhn.bhne.baseproject.common.Constants.SONG_MENU;


public class MusicListActivity extends BaseLoadDataActivity implements MusicListView {


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
    @BindView(R.id.txt_song_count)
    TextView txtSongCount;
    @Inject
    MusicListRecyclerAdapter adapter;
    @Inject
    MusicListPresentImpl musicListPresent;
    @Inject
    CurrentPlayMusic currentPlayMusic;
    @BindView(R.id.rel_music_list_cover)
    RelativeLayout relMusicListCover;
    @BindView(R.id.root)
    FrameLayout root;
    private RecommendContent.DataBean.InfoBean.CustomSpecialBean.SpecialBean specialBean;

    @Override
    protected void initViews() {
        setTransparency(true);
        specialBean = getIntent().getParcelableExtra(SONG_MENU);
        musicListPresent.attachView(this);
        musicListPresent.setSpecialid(specialBean.getSpecialid());
        musicListPresent.create();
        initRecycleView();
        updateSongMenuInfo(specialBean);
        toolbar.setBackgroundColor(getResources().getColor(R.color.alpha_00_white));

    }

    @Override
    public void updateSongMenuInfo(RecommendContent.DataBean.InfoBean.CustomSpecialBean.SpecialBean specialBean) {

        toolbar.setTitle("歌单");
        toolbar.setSubtitle(specialBean.getIntro());
        //使用spannableStringBuilder时要注意setText时只有包含spannableString对象
        String allSongCount = "播放全部(共" + specialBean.getSongcount() + "首)";
        SpannableStringBuilder spannableString = new SpannableStringBuilder(allSongCount);

        ForegroundColorSpan colorSpan = new ForegroundColorSpan(getResources().getColor(R.color.alpha_35_black));
        spannableString.setSpan(new AbsoluteSizeSpan((int) DimenUtil.sp2px(12)), 4, allSongCount.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(colorSpan, 4, allSongCount.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        txtSongCount.setText(spannableString);

        String authorName = specialBean.getUser_name() == null ? "暂无" : specialBean.getUser_name();
        int commentNum = specialBean.getSlid() == 0 ? 0 : specialBean.getSlid();
        String favoriteNum = specialBean.getCollectcount() == 0 ? "暂无" : String.valueOf(specialBean.getCollectcount());
        txtListenCount.setText(MyUtils.dealBigNum(specialBean.getPlay_count()));
        txtAuthorName.setText(authorName);
        txtComment.setText(String.valueOf(commentNum));
        txtCollect.setText(favoriteNum);
        txtListTitle.setText(specialBean.getSpecialname());
        Glide.with(this).load(specialBean.getImgurl().replace("{size}", "400")).bitmapTransform(new CropCircleTransformation(this)).into(imgAuthorHeader);
        Glide.with(this).load(specialBean.getImgurl().replace("{size}", "400")).bitmapTransform(new BlurTransformation(this, 20)).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                resource.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                relCover.setBackground(resource);
            }
        });
        MyUtils.loadImageFormNet(specialBean.getImgurl().replace("{size}", "400"), imgMusicListCover, this);
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
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }


    @Override
    public void loadSuccess(Object data) {
        adapter.setList(((KuGouSong) data).getData().getInfo());

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
