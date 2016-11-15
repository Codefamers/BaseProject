package com.qhn.bhne.baseproject.mvp.interactor;

import com.qhn.bhne.baseproject.listener.RequestCallBack;

import rx.Subscription;

/**
 * Created by qhn
 * on 2016/10/28 0028.
 */

public interface NewsInteractor<T> {
    Subscription lodeNewsChannels(RequestCallBack<T> callBack);
}
