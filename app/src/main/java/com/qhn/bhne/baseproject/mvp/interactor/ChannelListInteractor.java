package com.qhn.bhne.baseproject.mvp.interactor;

import com.qhn.bhne.baseproject.listener.RequestCallBack;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by qhn
 * on 2016/11/8 0008.
 */

public interface ChannelListInteractor<T> {
    Subscription loadChannelList(RequestCallBack<T> listener);
}
