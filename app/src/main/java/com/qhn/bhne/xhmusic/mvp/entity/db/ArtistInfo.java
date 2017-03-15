/**
 * Copyright (lrc_arrow) www.longdw.com
 */
package com.qhn.bhne.xhmusic.mvp.entity.db;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ArtistInfo implements Parcelable {

    public static final String KEY_ARTIST_NAME = "artist_name";
    public static final String KEY_NUMBER_OF_TRACKS = "number_of_tracks";
    public static final String KEY_ARTIST_ID = "artist_id";
    public static final String KEY_ARTIST_SORT = "artist_sort";

    @NotNull
    public String artist_name;
    public int number_of_tracks;
    @NotNull
    public long artist_id;
    public String artist_sort;
    public static final Creator<ArtistInfo> CREATOR = new Creator<ArtistInfo>() {

        @Override
        public ArtistInfo createFromParcel(Parcel source) {
            Bundle bundle = source.readBundle();
            ArtistInfo info = new ArtistInfo();
            info.artist_name = bundle.getString(KEY_ARTIST_NAME);
            info.number_of_tracks = bundle.getInt(KEY_NUMBER_OF_TRACKS);
            info.artist_id = bundle.getLong(KEY_ARTIST_ID);
            info.artist_sort = bundle.getString(KEY_ARTIST_SORT);
            return info;
        }

        @Override
        public ArtistInfo[] newArray(int size) {
            return new ArtistInfo[size];
        }
    };

    @Generated(hash = 682898117)
    public ArtistInfo(@NotNull String artist_name, int number_of_tracks,
            long artist_id, String artist_sort) {
        this.artist_name = artist_name;
        this.number_of_tracks = number_of_tracks;
        this.artist_id = artist_id;
        this.artist_sort = artist_sort;
    }

    @Generated(hash = 83519337)
    public ArtistInfo() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_ARTIST_NAME, artist_name);
        bundle.putInt(KEY_NUMBER_OF_TRACKS, number_of_tracks);
        bundle.putLong(KEY_ARTIST_ID, artist_id);
        bundle.putString(KEY_ARTIST_SORT, artist_sort);
        dest.writeBundle(bundle);
    }

    public String getArtist_name() {
        return this.artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public int getNumber_of_tracks() {
        return this.number_of_tracks;
    }

    public void setNumber_of_tracks(int number_of_tracks) {
        this.number_of_tracks = number_of_tracks;
    }

    public long getArtist_id() {
        return this.artist_id;
    }

    public void setArtist_id(long artist_id) {
        this.artist_id = artist_id;
    }

    public String getArtist_sort() {
        return this.artist_sort;
    }

    public void setArtist_sort(String artist_sort) {
        this.artist_sort = artist_sort;
    }

}
