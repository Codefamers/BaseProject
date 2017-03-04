package com.qhn.bhne.baseproject.mvp.model;

import com.qhn.bhne.baseproject.listener.RequestCallBack;

import java.util.Map;

import rx.Subscription;

/**
 * Created by qhn
 * on 2017/2/14 0014.
 */

public interface MusicListModel<T> {
    Subscription loadMusicList(Map<String, Integer> paramsMap, boolean isShowProgress,RequestCallBack<T> listener);

}
