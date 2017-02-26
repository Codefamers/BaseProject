package com.qhn.bhne.baseproject.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.qhn.bhne.baseproject.listener.RequestCallBack;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.qhn.bhne.baseproject.utils.RxBus;

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
