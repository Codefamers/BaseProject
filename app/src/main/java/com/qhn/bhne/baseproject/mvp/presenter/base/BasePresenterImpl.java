package com.qhn.bhne.baseproject.mvp.presenter.base;

import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;

import com.qhn.bhne.baseproject.listener.RequestCallBack;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;
import com.qhn.bhne.baseproject.utils.MyUtils;

import rx.Subscription;

/**
 * Created by qhn
 * on 2016/10/28 0028.
 */

public class BasePresenterImpl<T extends BaseView,E>implements BasePresenter,RequestCallBack<E> {
    protected  T mView;

    public T getView() {
        return mView;
    }

    public void setView(T mView) {
        this.mView = mView;
    }

    protected Subscription mSubscription;
    @Override
    public void beforeRequest() {
        mView.loadBefore();
    }

    @Override
    public void success(E data) {
        //mView.hideProgress();
//        mView.loadSuccess(data);

    }

    @Override
    public void onError(String errorMsg) {
       // mView.hideProgress();
        mView.loadFail(errorMsg);
    }

    @Override
    public void create() {

    }

    //实例化view
    @Override
    public void attachView(@NonNull BaseView view) {
        mView=(T)view;
    }

    @Override
    public void onDestroy() {
        MyUtils.cancelSubscription(mSubscription);
    }
}
