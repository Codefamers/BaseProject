package com.qhn.bhne.xhmusic.mvp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.wight.ShapedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qhn
 * on 2016/11/5 0005.
 */

public class HotMusicItemViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.txt_music_album_name)
    TextView txtMusicAlbumName;

    @BindView(R.id.txt_listen)
    TextView txtListen;

    @BindView(R.id.img_pic)
    ShapedImageView imgPic;

    public HotMusicItemViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
