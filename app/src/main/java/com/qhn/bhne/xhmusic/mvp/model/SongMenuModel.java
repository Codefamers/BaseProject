package com.qhn.bhne.xhmusic.mvp.model;

import com.qhn.bhne.xhmusic.listener.RequestCallBack;

import rx.Subscription;

/**
 * Created by Administrator on 2017/02/27
 */

public interface SongMenuModel<T> {
    Subscription loadSongMenu(int page, int pageSize, int categoryID,boolean isShowProgress, RequestCallBack<T> requestCallBack);
}