package com.qhn.bhne.xhmusic.mvp.model;

import com.qhn.bhne.xhmusic.listener.RequestCallBack;

import rx.Subscription;

/**
 * Created by qhn
 * on 2016/11/4 0004.
 */

public interface RecommendContentInteractor<T> {
    Subscription loadRecommendContent(RequestCallBack<T> listener);

}
