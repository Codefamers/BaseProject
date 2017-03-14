package com.qhn.bhne.xhmusic.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.qhn.bhne.xhmusic.listener.RequestCallBack;
import com.qhn.bhne.xhmusic.mvp.view.base.BaseView;
import com.qhn.bhne.xhmusic.utils.MyUtils;
import com.qhn.bhne.xhmusic.utils.RxBus;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by qhn
 * on 2016/10/28 0028.
 */

public abstract class BasePresenterImpl<T extends BaseView, E> implements BasePresenter, RequestCallBack<E> {
    protected T mView;

    public T getView() {
        return mView;
    }

    public void setView(T mView) {
        this.mView = mView;
    }

    protected Subscription mSubscription;
    @Inject
    public RxBus rxBus;

    @Override
    public void beforeRequest() {
        mView.loadBefore();
    }

    @Override
    public abstract void success(E data);

    @Override
    public void onFail(String errorMsg) {
        // mView.hideProgress();
        mView.loadFail(errorMsg);
    }

    @Override
    public abstract void create();

    //实例化view
    @Override
    public void attachView(@NonNull BaseView view) {
        mView = (T) view;
    }

    @Override
    public void onDestroy() {
        MyUtils.cancelSubscription(mSubscription);
    }
}
