package com.qhn.bhne.baseproject.mvp.model;

import com.qhn.bhne.baseproject.listener.RequestCallBack;

import rx.Subscription;

/**
 * Created by qhn
 * on 2017/2/14 0014.
 */

public interface MusicListInteractor<T> {
    Subscription loadMusicList(int musicListID, RequestCallBack<T> listener);

}
