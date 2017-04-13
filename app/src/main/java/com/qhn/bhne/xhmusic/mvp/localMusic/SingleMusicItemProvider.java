package com.qhn.bhne.xhmusic.mvp.localMusic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.mvp.entity.db.SongInfo;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by qhn
 * on 2017/4/12.
 */

public class SingleMusicItemProvider extends ItemViewProvider<SongInfo, SingleMusicItemProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_single_music, parent, false);

        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull SongInfo songInfo) {
        holder.tvSongName.setText(songInfo.getSongName());
        holder.tvSinger.setText(songInfo.getIntro());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_is_play_music)
        ImageView ivIsPlayMusic;
        @BindView(R.id.tv_song_name)
        TextView tvSongName;
        @BindView(R.id.iv_is_download_local)
        ImageView ivIsDownloadLocal;
        @BindView(R.id.tv_singer)
        TextView tvSinger;
        @BindView(R.id.iv_more_operation)
        ImageView ivMoreOperation;

        ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "点击位置" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
            ivMoreOperation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "更多操作", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
