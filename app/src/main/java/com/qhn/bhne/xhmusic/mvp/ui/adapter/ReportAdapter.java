package com.qhn.bhne.xhmusic.mvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.di.scope.ContextLife;
import com.qhn.bhne.xhmusic.mvp.entity.RecommendContent;
import com.qhn.bhne.xhmusic.mvp.ui.adapter.base.BaseRecyclerViewAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */
public class ReportAdapter extends BaseRecyclerViewAdapter<RecommendContent.TopicBean,RecommendContent.TopicBean> {
    @Inject
    public ReportAdapter() {
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
        RecommendContent.TopicBean topicBean=mList.get(position);
        itemViewHolder.txtRankName.setText(topicBean.getTitle());
        itemViewHolder.txtUpdateTime.setText(topicBean.getPublishtime());
        Glide.with(context).load(topicBean.getPicurl().replace("{size}", "400"))
                .placeholder(R.drawable.ic_placeholder).into(itemViewHolder.imgRankPic);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_rank_pic)
        ImageView imgRankPic;
        @BindView(R.id.txt_rank_name)
        TextView txtRankName;
        @BindView(R.id.txt_update_time)
        TextView txtUpdateTime;

        public ItemViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
