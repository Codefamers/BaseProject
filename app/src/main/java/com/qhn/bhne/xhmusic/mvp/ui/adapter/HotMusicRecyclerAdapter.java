package com.qhn.bhne.xhmusic.mvp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.di.scope.ContextLife;
import com.qhn.bhne.xhmusic.mvp.entity.RecommendContent;
import com.qhn.bhne.xhmusic.mvp.entity.db.SongMenuIntro;
import com.qhn.bhne.xhmusic.mvp.model.impl.MusicListModelImpl;
import com.qhn.bhne.xhmusic.mvp.ui.activities.MusicListActivity;
import com.qhn.bhne.xhmusic.mvp.ui.adapter.base.BaseRecyclerViewAdapter;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.RecommendMusicFragment;
import com.qhn.bhne.xhmusic.mvp.view.NormalMusicListView;
import com.qhn.bhne.xhmusic.utils.MyUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.qhn.bhne.xhmusic.common.Constants.SONG_MENU;
import static com.qhn.bhne.xhmusic.mvp.ui.activities.MusicListActivity.MUSIC_LIST_MODEL;
import static com.qhn.bhne.xhmusic.mvp.ui.activities.MusicListActivity.SONG_MENU_VIEW;

/**
 * Created by qhn
 * on 2016/11/3 0003.
 */

public class HotMusicRecyclerAdapter extends BaseRecyclerViewAdapter {


    @Inject
    public HotMusicRecyclerAdapter() {
        super(null);
        category = getCategory();
    }

    @ContextLife("Fragment")
    @Inject
    Context context;

    private int category;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getView(parent, R.layout.item_hot_music);
        return new ItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

        switch (category) {
            case RecommendMusicFragment.HOT_ADAPTER:
                final RecommendContent.RecommendBean rb =
                        (RecommendContent.RecommendBean) getList().get(position);
                final RecommendContent.RecommendBean.ExtraBean eb = rb.getExtra();
                itemViewHolder.txtMusicAlbumName.setText(eb.getSpecialname());
                itemViewHolder.txtListen.setText(MyUtils.dealBigNum(eb.getPlay_count()));
                MyUtils.loadImageFormNet(eb.getImgurl().replace("{size}", "400"), itemViewHolder.imgPic, context);
                itemViewHolder.imgPic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startMusicListActivity(eb);
                    }
                });
                break;
            case RecommendMusicFragment.NEW_ADAPTER:
                RecommendContent.AlbumBean albumBean =
                        (RecommendContent.AlbumBean) getList().get(position);
                itemViewHolder.txtListen.setVisibility(View.GONE);
                itemViewHolder.txtMusicAlbumName.setText(albumBean.getAlbumname());
                itemViewHolder.txtAlbumAuthor.setVisibility(View.VISIBLE);
                itemViewHolder.txtAlbumAuthor.setText(albumBean.getSingername());
                MyUtils.loadImageFormNet(albumBean.getImgurl().replace("{size}", "400"), itemViewHolder.imgPic, context);

                break;
            case RecommendMusicFragment.REPORT_ADAPTER:
                itemViewHolder.txtListen.setVisibility(View.GONE);
                break;
            case RecommendMusicFragment.GOOD_MV_ADAPTER:

                RecommendContent.VlistBean vlistBean =
                        (RecommendContent.VlistBean) getList().get(position);
                itemViewHolder.txtMusicAlbumName.setText(vlistBean.getTitle());
                MyUtils.loadImageFormNet(vlistBean.getMobile_banner(), itemViewHolder.imgPic, context);
                break;
        }

    }

    private void startMusicListActivity(RecommendContent.RecommendBean.ExtraBean eb) {
        Intent intent=new Intent(context, MusicListActivity.class);
        SongMenuIntro songMenuIntro=new SongMenuIntro(eb.getSpecialid(),eb.getCollectcount(),eb.getIntro()
                ,eb.getSongcount(),eb.getPlay_count(),eb.getUser_name(),eb.getImgurl(),eb.getSpecialname(),eb.getSlid());
        intent.putExtra(SONG_MENU_VIEW,new NormalMusicListView(songMenuIntro));
        intent.putExtra(MUSIC_LIST_MODEL,new MusicListModelImpl());
        intent.putExtra(SONG_MENU,songMenuIntro);
        Bundle bundle=new Bundle();

        bundle.putInt("page", 1);
        bundle.putInt("pageSize", 100);
        bundle.putInt("specialid", songMenuIntro.getSpecialid());
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_music_album_name)
        public TextView txtMusicAlbumName;
        @BindView(R.id.txt_album_author)
        public TextView txtAlbumAuthor;
        @BindView(R.id.txt_listen)
        public TextView txtListen;
        @BindView(R.id.img_pic)
        public ImageView imgPic;

        public ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (category) {
                        case RecommendMusicFragment.HOT_ADAPTER:


                            break;
                        case RecommendMusicFragment.NEW_ADAPTER:


                            break;
                        case RecommendMusicFragment.REPORT_ADAPTER:

                            break;
                        case RecommendMusicFragment.GOOD_MV_ADAPTER:


                            break;
                    }
                }
            });
        }
    }

}
