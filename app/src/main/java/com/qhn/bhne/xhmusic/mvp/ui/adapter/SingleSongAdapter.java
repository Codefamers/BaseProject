package com.qhn.bhne.xhmusic.mvp.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.di.scope.ContextLife;
import com.qhn.bhne.xhmusic.mvp.entity.GlobalPlayMusic;
import com.qhn.bhne.xhmusic.mvp.entity.Songs;
import com.qhn.bhne.xhmusic.mvp.ui.adapter.base.BaseRecyclerViewAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qhn
 * on 2017/2/25 0025.
 */

public class SingleSongAdapter extends BaseRecyclerViewAdapter<Songs,Songs> {


    @Inject
    public SingleSongAdapter() {
        super(null);
    }

    @ContextLife("Fragment")
    @Inject
    Context context;

    @Inject
    GlobalPlayMusic currentPlayMusic;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getView(parent, R.layout.item_single_song);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Songs songs = getList().get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

        String songName = songs.getSongname();
        String songIntroduce = songs.getSingername() + "-" + songs.getAlbum_name();

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(songIntroduce);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#59FFFFFF"));
        spannableStringBuilder.setSpan(colorSpan, 0, songIntroduce.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(20);
        spannableStringBuilder.setSpan(absoluteSizeSpan, 0, songIntroduce.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        itemViewHolder.txtContent.setText(songName + "\n" + spannableStringBuilder.toString());

    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_content)
        TextView txtContent;
        @BindView(R.id.img_more_operation)
        ImageView imgMoreOperation;

        public ItemViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);
            imgMoreOperation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "更多操作", Toast.LENGTH_SHORT).show();
                }
            });
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentPlayMusic.setCurrentPlaySongList(getList());
                    //activity.startActivity(new Intent(activity, PlayMusicActivity.class));
                }
            });

        }
    }
}
/*
*
*
* @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getView(parent, R.layout.item_history_search);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);


    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {


        public ItemViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }*/