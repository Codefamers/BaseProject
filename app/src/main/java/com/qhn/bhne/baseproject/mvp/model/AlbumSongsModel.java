package com.qhn.bhne.baseproject.mvp.model;

import com.qhn.bhne.baseproject.listener.RequestCallBack;

import java.util.Map;

import rx.Subscription;

/**
 * Created by qhn
 * on 2017/3/3 0003.
 */

public interface AlbumSongsModel<T> {
    Subscription loadAlbumSongs(Map<String, Integer> paramsMap, boolean isShowProgress, RequestCallBack<T> listener);

}
