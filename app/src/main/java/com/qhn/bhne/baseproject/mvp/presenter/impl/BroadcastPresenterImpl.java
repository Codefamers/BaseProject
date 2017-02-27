package com.qhn.bhne.baseproject.mvp.presenter.impl;

import android.support.annotation.NonNull;

import com.qhn.bhne.baseproject.mvp.entity.BroadcastDetail;
import com.qhn.bhne.baseproject.mvp.interactor.impl.BroadcastInteractorImpl;
import com.qhn.bhne.baseproject.mvp.presenter.BroadcastPresenter;
import com.qhn.bhne.baseproject.mvp.presenter.base.BasePresenterImpl;
import com.qhn.bhne.baseproject.mvp.view.BroadcastView;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by qhn
 * on 2016/11/7 0007.
 */

public class BroadcastPresenterImpl extends BasePresenterImpl<BroadcastView,List<List<BroadcastDetail.DataBean>>> implements BroadcastPresenter {
    @Inject
    BroadcastInteractorImpl songMenuInteractor;

    @Inject
    public BroadcastPresenterImpl() {

    }


    @Override
    public void create() {
        loadData();
    }

    private void loadData() {
        songMenuInteractor.loadBroadDetail(this);
    }

    @Override
    public void success(List<List<BroadcastDetail.DataBean>> data) {
        if (data == null || data.size() == 0) {
            mView.loadDataEmpty();
        } /*else if (currentPage != 0) {
            mView.loadMore(data.getData());
        } */ else
            mView.loadSuccess(data);

    }

    @Override
    public void attachView(@NonNull BaseView view) {
        setView((BroadcastView) view);
    }


    @Override
    public void loadMore() {
        //currentPage++;
        //songMenuInteractor.loadBroadDetail(defaultTag,currentPage,size,this);

    }
}
