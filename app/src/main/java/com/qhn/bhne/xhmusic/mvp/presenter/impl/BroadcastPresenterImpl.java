package com.qhn.bhne.xhmusic.mvp.presenter.impl;

import android.support.annotation.NonNull;

import com.qhn.bhne.xhmusic.mvp.entity.BroadcastDetail;
import com.qhn.bhne.xhmusic.mvp.model.impl.BroadcastInteractorImpl;
import com.qhn.bhne.xhmusic.mvp.presenter.BroadcastPresenter;
import com.qhn.bhne.xhmusic.mvp.presenter.base.BasePresenterImpl;
import com.qhn.bhne.xhmusic.mvp.view.BroadcastView;
import com.qhn.bhne.xhmusic.mvp.view.base.BaseView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by qhn
 * on 2016/11/7 0007.
 */

public class BroadcastPresenterImpl extends BasePresenterImpl<BroadcastView,List<List<BroadcastDetail>>> implements BroadcastPresenter {
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
    public void success(List<List<BroadcastDetail>> data) {
        if (data == null || data.size() == 0) {
            mView.loadDataEmpty();
        } else
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
