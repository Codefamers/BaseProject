package com.qhn.bhne.baseproject.mvp.view;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.entity.SearchAlbum;
import com.qhn.bhne.baseproject.utils.MyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qhn
 * on 2017/3/3 0003.
 */

public class AlbumView implements MusicListView, Parcelable {

    @BindView(R.id.img_music_list_cover)
    ImageView imgMusicListCover;
    @BindView(R.id.txt_singer_name)
    TextView txtSingerName;
    @BindView(R.id.txt_album_name)
    TextView txtAlbumName;
    private SearchAlbum searchAlbum;
    private Context context;

    public AlbumView(SearchAlbum searchAlbum) {
        this.searchAlbum = searchAlbum;
    }

    @Override
    public void initView(ViewGroup rootView, Context context) {
        this.context = context;
        View view=LayoutInflater.from(context).inflate(R.layout.item_album_music_list, rootView, true);
        ButterKnife.bind(this, view);
    }

    @Override
    public void updateSongMenuInfo() {
        MyUtils.loadImageFormNet(searchAlbum.getImgurl().replace("{size}", "400"), imgMusicListCover, context);
        txtAlbumName.setText(searchAlbum.getAlbumname());
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("歌手:").append(searchAlbum.getSingername()).append("\n发行时间:").append(searchAlbum.getPublishtime().substring(5,10));
        txtSingerName.setText(stringBuilder.toString());

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.searchAlbum, flags);
    }



    protected AlbumView(Parcel in) {
        this.searchAlbum = in.readParcelable(SearchAlbum.class.getClassLoader());
    }

    public static final Parcelable.Creator<AlbumView> CREATOR = new Parcelable.Creator<AlbumView>() {
        @Override
        public AlbumView createFromParcel(Parcel source) {
            return new AlbumView(source);
        }

        @Override
        public AlbumView[] newArray(int size) {
            return new AlbumView[size];
        }
    };
}
