package com.qhn.bhne.baseproject.mvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fasterxml.jackson.databind.node.POJONode;
import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.di.scope.ContextLife;
import com.qhn.bhne.baseproject.mvp.entity.SearchMV;
import com.qhn.bhne.baseproject.mvp.ui.adapter.base.BaseRecyclerViewAdapter;
import com.qhn.bhne.baseproject.wight.ShapedImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */
public class SearchMVAdapter extends BaseRecyclerViewAdapter<SearchMV.DataBean.SearchMVBean> {


    @Inject
    public SearchMVAdapter() {
        super(null);
    }

    @ContextLife("Fragment")
    @Inject
    Context context;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getView(parent, R.layout.item_mv_list);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        SearchMV.DataBean.SearchMVBean searchMVBean=getList().get(position);
        itemViewHolder.txtMusicAlbumName.setText(searchMVBean.getFilename());
        itemViewHolder.txtMusicVideoAuthor.setText(searchMVBean.getSingername());
        Glide.with(context).load(mList.get(position).getImgurl().replace("{size}", "400"))
                .placeholder(R.drawable.ic_placeholder).into(itemViewHolder.imgPic);


    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_pic)
        ShapedImageView imgPic;
        @BindView(R.id.txt_listen)
        TextView txtListen;
        @BindView(R.id.txt_music_album_name)
        TextView txtMusicAlbumName;
        @BindView(R.id.txt_music_video_author)
        TextView txtMusicVideoAuthor;

        public ItemViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
