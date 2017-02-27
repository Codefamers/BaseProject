package com.qhn.bhne.baseproject.mvp.interactor;

import com.qhn.bhne.baseproject.listener.RequestCallBack;
import com.qhn.bhne.baseproject.mvp.entity.SongMenu;

import rx.Subscription;

/**
 * Created by qhn
 * on 2016/11/7 0007.
 */

public interface BroadcastInteractor<T> {
    Subscription loadBroadDetail( RequestCallBack<T> listener);

}
