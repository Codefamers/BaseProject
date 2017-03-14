package com.qhn.bhne.xhmusic.mvp.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.mvp.entity.SongMenu;
import com.qhn.bhne.xhmusic.mvp.ui.adapter.base.BaseRecyclerViewAdapter;
import com.qhn.bhne.xhmusic.utils.MyUtils;
import com.qhn.bhne.xhmusic.wight.ShapedImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qhn
 * on 2017/2/27 0027.
 */
public class SongMenuAdapter extends BaseRecyclerViewAdapter<SongMenu,SongMenu> {
    @Inject
    public SongMenuAdapter() {
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
                return new SongMenuAdapter.FooterViewHolder(view);

            case TYPE_ITEM:
                view = getView(parent, R.layout.item_song_menu);
                return new SongMenuAdapter.ItemViewHolder(view);
            default:
                return null;
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (holder instanceof ItemViewHolder) {

            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            SongMenu songMenu=getList().get(position);
            itemViewHolder.txtMusicAlbumName.setText(songMenu.getIntro());
            itemViewHolder.txtListen.setText(MyUtils.dealBigNum(songMenu.getPlaycount()));
            itemViewHolder.txtListen.setVisibility(View.VISIBLE);

            itemViewHolder.txtAuthor.setVisibility(View.VISIBLE);
            itemViewHolder.txtAuthor.setText(songMenu.getUsername());
            MyUtils.loadImageFormNet(songMenu.getImgurl().replace("{size}","400"), itemViewHolder.imgPic, activity);
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
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemListener.onClick(getList().get(getAdapterPosition()),getAdapterPosition());
                }
            });
        }
    }
}
