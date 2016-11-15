package com.qhn.bhne.baseproject.mvp.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.listener.BindViewCallBack;
import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;
import com.qhn.bhne.baseproject.mvp.ui.adapter.base.BaseRecyclerViewAdapter;
import com.qhn.bhne.baseproject.mvp.ui.fragment.RecommendMusicFragment;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.qhn.bhne.baseproject.wight.ShapedImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qhn
 * on 2016/11/3 0003.
 */

public class HotMusicRecyclerAdapter extends BaseRecyclerViewAdapter<RecommendContent.DataBean.DataContent> {


    @Inject
    public HotMusicRecyclerAdapter() {
        super(null);
        category=getCategory();
    }

    @Inject
    Activity activity;
    private BindViewCallBack<RecommendContent.DataBean.DataContent> bindViewCallBack;
    private int category;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public BindViewCallBack getBindViewCallBack() {
        return bindViewCallBack;
    }

    public void setBindViewCallBack(BindViewCallBack<RecommendContent.DataBean.DataContent> bindViewCallBack) {
        this.bindViewCallBack = bindViewCallBack;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getView(parent, R.layout.item_hot_music);
        return new ItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        RecommendContent.DataBean.DataContent dataContent = mList.get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.txtMusicAlbumName.setText(dataContent.getName());
        itemViewHolder.txtListen.setText(MyUtils.dealBigNum(dataContent.getListenCount()));
        MyUtils.loadImageFormNet(dataContent.getPicUrl(),itemViewHolder.imgPic,activity);
        switch (category) {
            case RecommendMusicFragment.HOT_ADAPTER:
                break;
            case RecommendMusicFragment.NEW_ADAPTER:
                itemViewHolder.txtListen.setVisibility(View.GONE);
                break;
            case RecommendMusicFragment.REPORT_ADAPTER:
                itemViewHolder.txtListen.setVisibility(View.GONE);
                itemViewHolder.txtMusicAlbumName.setText(dataContent.getDesc());
                break;
            case RecommendMusicFragment.GOOD_MV_ADAPTER:
                break;
        }

    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_music_album_name)
        public TextView txtMusicAlbumName;
        /* @BindView(R.id.txt_album_author)
         TextView txtAlbumAuthor;*/
        @BindView(R.id.txt_listen)
        public TextView txtListen;
        /* @BindView(R.id.txt_comment)
         TextView txtComment;*/
        @BindView(R.id.img_pic)
        public ImageView imgPic;

        public ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
