package com.qhn.bhne.baseproject.mvp.model;

import com.qhn.bhne.baseproject.listener.RequestCallBack;

import rx.Subscription;

/**
 * Created by qhn
 * on 2016/11/7 0007.
 */

public interface BroadcastInteractor<T> {
    Subscription loadBroadDetail(RequestCallBack<T> listener);

}
