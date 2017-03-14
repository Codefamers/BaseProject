package com.qhn.bhne.xhmusic.mvp.model;

import com.qhn.bhne.xhmusic.listener.RequestCallBack;

import rx.Subscription;

/**
 * Created by qhn
 * on 2016/11/7 0007.
 */

public interface BroadcastInteractor<T> {
    Subscription loadBroadDetail(RequestCallBack<T> listener);

}
