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
import com.qhn.bhne.baseproject.mvp.entity.SearchSongMenu;
import com.qhn.bhne.baseproject.mvp.ui.adapter.base.BaseRecyclerViewAdapter;
import com.qhn.bhne.baseproject.utils.MyUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */

public class SearchSongMenuAdapter extends BaseRecyclerViewAdapter<SearchSongMenu,SearchSongMenu> {

    @Inject
    public SearchSongMenuAdapter() {
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

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

        List<SearchSongMenu> searchMenuList = mList;

        if (searchMenuList.size() != 0) {
            SearchSongMenu searchMenu = mList.get(position);
            itemViewHolder.txtRankName.setText(searchMenu.getSpecialname());
            itemViewHolder.txtUpdateTime.setText(searchMenu.getNickname() + "\n" +
                    searchMenu.getSongcount() + ", 播放:" + MyUtils.dealBigNum(searchMenu.getPlaycount())
            );
        }
        Glide.with(context).load(mList.get(position).getImgurl().replace("{size}", "400"))
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
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemListener.onClick(getList().get(getAdapterPosition()));
                }
            });

        }
    }
}
