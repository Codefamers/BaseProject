package com.qhn.bhne.xhmusic.mvp.model;

import com.qhn.bhne.xhmusic.listener.RequestCallBack;

import java.util.Map;

import rx.Subscription;

/**
 * Created by qhn
 * on 2017/2/14 0014.
 */

public interface MusicListModel<T> {
    Subscription loadMusicList(Map<String, Integer> paramsMap, boolean isShowProgress,RequestCallBack<T> listener);

}
