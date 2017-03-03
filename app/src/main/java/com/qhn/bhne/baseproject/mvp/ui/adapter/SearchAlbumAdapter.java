package com.qhn.bhne.baseproject.mvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.di.scope.ContextLife;
import com.qhn.bhne.baseproject.mvp.entity.SearchAlbum;
import com.qhn.bhne.baseproject.mvp.ui.adapter.base.BaseRecyclerViewAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */

public class SearchAlbumAdapter extends BaseRecyclerViewAdapter<SearchAlbum,SearchAlbum> {


    @Inject
    public SearchAlbumAdapter() {
        super(null);
    }

    @ContextLife("Fragment")
    @Inject
    Context context;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getView(parent, R.layout.item_rank_music);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        SearchAlbum album = mList.get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        if (album != null) {

            itemViewHolder.txtRankName.setText(album.getAlbumname());
            itemViewHolder.txtUpdateTime.setText(album.getSingername() + "\n" +
                    album.getPublishtime()
            );
        }
        Glide.with(context).load(album != null ? album.getImgurl().replace("{size}", "400") : R.drawable.ic_load_fail)
                .placeholder(R.drawable.ic_placeholder).into(itemViewHolder.imgRankPic);

    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_rank_pic)
        ImageView imgRankPic;
        @BindView(R.id.txt_rank_name)
        TextView txtRankName;
        @BindView(R.id.txt_update_time)
        TextView txtUpdateTime;
        @BindView(R.id.ll_rank_music_name)
        LinearLayout llRankMusicName;

        public ItemViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
