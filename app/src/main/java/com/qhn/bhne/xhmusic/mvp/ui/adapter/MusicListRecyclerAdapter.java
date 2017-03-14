package com.qhn.bhne.xhmusic.mvp.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.mvp.entity.Songs;
import com.qhn.bhne.xhmusic.mvp.ui.adapter.base.BaseRecyclerViewAdapter;
import com.qhn.bhne.xhmusic.utils.DimenUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qhn
 * on 2017/2/14 0014.
 */

public class MusicListRecyclerAdapter extends BaseRecyclerViewAdapter<Songs, Songs> {


    private Context context;

    @Inject
    public MusicListRecyclerAdapter() {
        super(null);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getView(parent, R.layout.item_music_list);
        if (context == null) {
            context = parent.getContext();
        }
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Songs songs = getList().get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.txtMusicId.setText(String.valueOf(position + 1));
        String songIntroduce = songs.getFilename();
        String songName = songs.getRemark();

        if (TextUtils.isEmpty(songName)) {
            songName = songs.getSongname();
            if (TextUtils.isEmpty(songName)) {
                songName = songs.getOthername();
            }
        }
        //使用spannableStringBuilder时要注意setText时只有包含spannableString对象
        if (!TextUtils.isEmpty(songName)) {
            SpannableStringBuilder spannableString = new SpannableStringBuilder(songName);
            spannableString.append("\n" + songIntroduce);
            ForegroundColorSpan colorSpan = new ForegroundColorSpan(context.getResources().getColor(R.color.alpha_85_black));
            spannableString.setSpan(new AbsoluteSizeSpan((int) DimenUtil.sp2px(16)), 0, songName.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(colorSpan, 0, songName.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            itemViewHolder.txtMusicName.setText(spannableString);
        } else {

            SpannableStringBuilder spannableString = new SpannableStringBuilder(songIntroduce);
            ForegroundColorSpan colorSpan = new ForegroundColorSpan(context.getResources().getColor(R.color.alpha_85_black));
            spannableString.setSpan(new AbsoluteSizeSpan((int) DimenUtil.sp2px(16)), 0, songIntroduce.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(colorSpan, 0, songIntroduce.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            itemViewHolder.txtMusicName.setText(spannableString);

        }


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
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    itemListener.onClick(getList().get(getAdapterPosition()),getAdapterPosition());
                }
            });

        }
    }
}
