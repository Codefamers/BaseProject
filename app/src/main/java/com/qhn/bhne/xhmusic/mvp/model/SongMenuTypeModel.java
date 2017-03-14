package com.qhn.bhne.xhmusic.mvp.model;

import com.qhn.bhne.xhmusic.listener.RequestCallBack;

import rx.Subscription;

/**
 * Created by Administrator on 2017/02/28
 */

public interface SongMenuTypeModel<T> {
    Subscription loadSongMenuType(RequestCallBack<T> requestCallBack);

}