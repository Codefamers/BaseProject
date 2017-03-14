package com.qhn.bhne.xhmusic.mvp.presenter.impl;

import com.qhn.bhne.xhmusic.event.RecommendEvent;
import com.qhn.bhne.xhmusic.event.RetryConnectNetEvent;
import com.qhn.bhne.xhmusic.mvp.model.RecommendContentInteractor;
import com.qhn.bhne.xhmusic.mvp.model.impl.RecommendInteractorImpl;
import com.qhn.bhne.xhmusic.mvp.presenter.RecommendPresenter;
import com.qhn.bhne.xhmusic.mvp.presenter.base.BasePresenterImpl;
import com.qhn.bhne.xhmusic.mvp.view.RecommendView;
import com.socks.library.KLog;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by qhn
 * on 2016/11/4 0004.
 */

public class RecommendPresenterImpl extends BasePresenterImpl<RecommendView, RecommendEvent> implements RecommendPresenter {
    private RecommendContentInteractor<RecommendEvent> mInteractor;

    @Inject
    public RecommendPresenterImpl(RecommendInteractorImpl recommendInteractor) {
        this.mInteractor = recommendInteractor;
    }

    @Override
    public void create() {
        //订阅重试
        mSubscription = rxBus.toObservable(RetryConnectNetEvent.class).subscribe(new Action1<RetryConnectNetEvent>() {
            @Override
            public void call(RetryConnectNetEvent retryConnectNetEvent) {
                loadData();
            }
        });
        loadData();

    }


    //activity退出时执行的操作
    @Override
    public void onDestroy() {
        KLog.d("fragment结束");
    }

    @Override
    public void success(RecommendEvent data) {

        if (data == null) {
            mView.loadDataEmpty();
        } else {
            mView.loadSuccess(data);
        }
    }

    @Override
    public void refreshData() {
        loadData();
    }


    //加载数据
    private void loadData() {
        mInteractor.loadRecommendContent(this);
    }

}
