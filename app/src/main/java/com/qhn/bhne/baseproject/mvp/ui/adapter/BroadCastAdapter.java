/*
package com.qhn.bhne.baseproject.mvp.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.entity.SongMenu;
import com.qhn.bhne.baseproject.mvp.ui.adapter.base.BaseRecyclerViewAdapter;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.qhn.bhne.baseproject.wight.ShapedImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

*
 * Created by qhn
 * on 2016/11/7 0007.



public class BroadCastAdapter extends BaseRecyclerViewAdapter<SongMenuData.SongMenuData> {
    @Inject
    public BroadCastAdapter() {
        super(null);
    }

    @Inject
    Activity activity;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_FOOTER:
                view = getView(parent, R.layout.item_foot_loading_message);
                return new BroadCastAdapter.FooterViewHolder(view);

            case TYPE_ITEM:
                view = getView(parent, R.layout.item_song_menu);
                return new BroadCastAdapter.ItemViewHolder(view);
            default:
                return null;
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (holder instanceof BroadCastAdapter.ItemViewHolder) {
            SongMenuData.SongMenuData dataContent = mList.get(position);
            BroadCastAdapter.ItemViewHolder itemViewHolder = (BroadCastAdapter.ItemViewHolder) holder;
            itemViewHolder.txtMusicAlbumName.setText(dataContent.getTitle());
            if (dataContent.getListen_count() != 0) {
                itemViewHolder.txtListen.setText(MyUtils.dealBigNum(dataContent.getListen_count()));
                itemViewHolder.txtListen.setVisibility(View.VISIBLE);
            }

            itemViewHolder.txtAuthor.setText(dataContent.getAuthor());
            MyUtils.loadImageFormNet(dataContent.getPic_url(), itemViewHolder.imgPic, activity);
        }


    }

    @Override
    public int getItemViewType(int position) {
        if (mIsShowFooter && isFooterPosition(position)) {
            return TYPE_FOOTER;
        } else
            return TYPE_ITEM;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_music_album_name)
        public TextView txtMusicAlbumName;
        @BindView(R.id.txt_listen)
        public TextView txtListen;
        @BindView(R.id.txt_author)
        TextView txtAuthor;
        @BindView(R.id.img_pic)
        public ShapedImageView imgPic;

        public ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
*/
