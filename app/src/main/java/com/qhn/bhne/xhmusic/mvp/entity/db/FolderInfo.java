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
public class FolderInfo implements Parcelable {

    private static String KEY_FOLDER_NAME = "folder_name";
    private static String KEY_FOLDER_PATH = "folder_path";
    private static final String KEY_FOLDER_SORT = "folder_sort";
    private static final String KEY_FOLDER_FILE_COUNT = "file_count";
    @NotNull
    public String folder_name;
    @NotNull
    public String folder_path;
    private String folder_sort;
    private int folder_count;
    // 用来创建自定义的Parcelable的对象
    public static Creator<FolderInfo> CREATOR = new Creator<FolderInfo>() {

        @Override
        public FolderInfo createFromParcel(Parcel source) {
            FolderInfo info = new FolderInfo();
            Bundle bundle = source.readBundle();
            info.folder_name = bundle.getString(KEY_FOLDER_NAME);
            info.folder_path = bundle.getString(KEY_FOLDER_PATH);
            info.folder_sort = bundle.getString(KEY_FOLDER_SORT);
            info.folder_count = bundle.getInt(KEY_FOLDER_FILE_COUNT);
            return info;
        }

        @Override
        public FolderInfo[] newArray(int size) {
            return new FolderInfo[size];
        }
    };

    @Generated(hash = 607780581)
    public FolderInfo(@NotNull String folder_name, @NotNull String folder_path,
            String folder_sort, int folder_count) {
        this.folder_name = folder_name;
        this.folder_path = folder_path;
        this.folder_sort = folder_sort;
        this.folder_count = folder_count;
    }

    @Generated(hash = 1950667150)
    public FolderInfo() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_FOLDER_NAME, folder_name);
        bundle.putString(KEY_FOLDER_PATH, folder_path);
        bundle.putString(KEY_FOLDER_SORT, folder_sort);
        bundle.putInt(KEY_FOLDER_FILE_COUNT, folder_count);
        dest.writeBundle(bundle);
    }

    public String getFolder_name() {
        return this.folder_name;
    }

    public void setFolder_name(String folder_name) {
        this.folder_name = folder_name;
    }

    public String getFolder_path() {
        return this.folder_path;
    }

    public void setFolder_path(String folder_path) {
        this.folder_path = folder_path;
    }

    public String getFolder_sort() {
        return this.folder_sort;
    }

    public void setFolder_sort(String folder_sort) {
        this.folder_sort = folder_sort;
    }

    public int getFolder_count() {
        return this.folder_count;
    }

    public void setFolder_count(int folder_count) {
        this.folder_count = folder_count;
    }

}
