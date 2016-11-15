package com.qhn.bhne.baseproject.mvp.interactor;

import com.qhn.bhne.baseproject.listener.RequestCallBack;

import rx.Subscription;

/**
 * Created by qhn
 * on 2016/11/8 0008.
 */

public interface MVListInteractor<T> {
    Subscription loadMVList(int order, int page, int size, RequestCallBack<T> listener);

}
