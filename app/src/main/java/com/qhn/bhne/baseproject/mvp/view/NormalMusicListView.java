package com.qhn.bhne.baseproject.mvp.view;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.di.scope.ContextLife;
import com.qhn.bhne.baseproject.mvp.entity.SongMenuIntro;
import com.qhn.bhne.baseproject.utils.MyUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by qhn
 * on 2017/3/3 0003.
 */

public class NormalMusicListView implements MusicListView,Parcelable {
    @BindView(R.id.img_music_list_cover)
    ImageView imgMusicListCover;
    @BindView(R.id.txt_listen_count)
    TextView txtListenCount;
    @BindView(R.id.txt_list_title)
    TextView txtListTitle;
    @BindView(R.id.img_author_header)
    ImageView imgAuthorHeader;
    @BindView(R.id.txt_author_name)
    TextView txtAuthorName;

    private SongMenuIntro songMenuIntro;
    private Context context;
    @Inject
    public NormalMusicListView(SongMenuIntro songMenuIntro) {
        this.songMenuIntro=songMenuIntro;
    }





    @Override
    public void initView(ViewGroup rootView, Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_normal_music_list, rootView, true);
        ButterKnife.bind(this, view);
        this.context=context;
    }

    @Override
    public void updateSongMenuInfo() {


        String authorName = songMenuIntro.getUser_name() == null ? "暂无" : songMenuIntro.getUser_name();

        txtListenCount.setText(MyUtils.dealBigNum(songMenuIntro.getPlay_count()));
        txtAuthorName.setText(authorName);

        txtListTitle.setText(songMenuIntro.getSpecialname());
        Glide.with(context).load(songMenuIntro.getImgurl().replace("{size}", "400")).bitmapTransform(new CropCircleTransformation(context)).into(imgAuthorHeader);

        MyUtils.loadImageFormNet(songMenuIntro.getImgurl().replace("{size}", "400"), imgMusicListCover, context);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.songMenuIntro, flags);
    }

    protected NormalMusicListView(Parcel in) {
        this.songMenuIntro = in.readParcelable(SongMenuIntro.class.getClassLoader());
    }

    public static final Creator<NormalMusicListView> CREATOR = new Creator<NormalMusicListView>() {
        @Override
        public NormalMusicListView createFromParcel(Parcel source) {
            return new NormalMusicListView(source);
        }

        @Override
        public NormalMusicListView[] newArray(int size) {
            return new NormalMusicListView[size];
        }
    };
}
