package com.qhn.bhne.baseproject.mvp.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.common.MusicConstants;
import com.qhn.bhne.baseproject.mvp.entity.CurrentPlayMusic;
import com.qhn.bhne.baseproject.mvp.entity.Songs;
import com.qhn.bhne.baseproject.mvp.entity.SpecialSong;
import com.qhn.bhne.baseproject.mvp.ui.activities.PlayMusicActivity;
import com.qhn.bhne.baseproject.mvp.ui.adapter.base.BaseRecyclerViewAdapter;
import com.socks.library.KLog;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qhn
 * on 2017/2/14 0014.
 */

public class MusicListRecyclerAdapter extends BaseRecyclerViewAdapter<SpecialSong> {


    private CurrentPlayMusic currentPlayMusic;

    public CurrentPlayMusic getCurrentPlayMusic() {
        return currentPlayMusic;
    }

    public void setCurrentPlayMusic(CurrentPlayMusic currentPlayMusic) {
        this.currentPlayMusic = currentPlayMusic;
    }


    @Inject
    public MusicListRecyclerAdapter() {
        super(null);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getView(parent, R.layout.item_music_list);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        SpecialSong songs = getList().get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.txtMusicId.setText(String.valueOf(position + 1));
        //String songName = songs.getF;
        String songIntroduce = songs.getFilename();

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(songIntroduce);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#59FFFFFF"));
        spannableStringBuilder.setSpan(colorSpan, 0, songIntroduce.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(20);
        spannableStringBuilder.setSpan(absoluteSizeSpan, 0, songIntroduce.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        itemViewHolder.txtMusicName.setText(songs.getRemark() + "\n" + spannableStringBuilder.toString());
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        @Inject
        Activity activity;
        @BindView(R.id.txt_music_id)
        TextView txtMusicId;
        @BindView(R.id.txt_music_name)
        TextView txtMusicName;

        public ItemViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);
            final Context context = view.getContext();
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // myApp.setCurrentPlayMusicList(getList());
                    // intent.putExtra("position",getAdapterPosition());

                    Intent intent = new Intent(context, PlayMusicActivity.class);

                    currentPlayMusic.setPlayPosition(getAdapterPosition());
                    KLog.d("点击的位置"+getAdapterPosition());
                    currentPlayMusic.setMusicStatus(MusicConstants.MusicStatus.PLAY);
                    context.startActivity(intent);

                }
            });

        }
    }
}
