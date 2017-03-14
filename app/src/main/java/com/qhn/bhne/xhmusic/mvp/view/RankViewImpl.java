package com.qhn.bhne.xhmusic.mvp.view;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.mvp.entity.MusicRank;
import com.qhn.bhne.xhmusic.utils.MyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qhn
 * on 2017/3/3 0003.
 */

public class RankViewImpl implements MusicListView, Parcelable {

    @BindView(R.id.img_music_list_cover)
    ImageView imgMusicListCover;
    @BindView(R.id.txt_listen_count)
    TextView txtListenCount;
    @BindView(R.id.fra_music_list_cover)
    FrameLayout fraMusicListCover;
    private MusicRank musicRank;
    private Context context;

    public RankViewImpl(MusicRank musicRank) {
        this.musicRank = musicRank;
    }


    @Override
    public void initView(ViewGroup rootView, Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rank_music_list, rootView, true);
        ButterKnife.bind(this, view);
        this.context = context;
    }

    @Override
    public void updateSongMenuInfo() {
        txtListenCount.setText(musicRank.getUpdate_frequency());
        MyUtils.loadImageFormNet(musicRank.getBanner7url().replace("{size}", "400"), imgMusicListCover, context);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.musicRank, flags);
    }

    protected RankViewImpl(Parcel in) {
        this.musicRank = in.readParcelable(MusicRank.class.getClassLoader());
    }

    public static final Parcelable.Creator<RankViewImpl> CREATOR = new Parcelable.Creator<RankViewImpl>() {
        @Override
        public RankViewImpl createFromParcel(Parcel source) {
            return new RankViewImpl(source);
        }

        @Override
        public RankViewImpl[] newArray(int size) {
            return new RankViewImpl[size];
        }
    };
}
