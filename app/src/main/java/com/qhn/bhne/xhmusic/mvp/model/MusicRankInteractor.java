package com.qhn.bhne.xhmusic.mvp.model;

import com.qhn.bhne.xhmusic.listener.RequestCallBack;

import rx.Subscription;

/**
 * Created by qhn
 * on 2016/11/9 0009.
 */

public interface MusicRankInteractor<T> {
    Subscription loadMusicRankList( RequestCallBack<T> listener);
}
