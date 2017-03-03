package com.qhn.bhne.baseproject.mvp.presenter.impl;

import android.view.View;
import android.widget.AdapterView;

import com.qhn.bhne.baseproject.mvp.entity.MVList;
import com.qhn.bhne.baseproject.mvp.model.MVListInteractor;
import com.qhn.bhne.baseproject.mvp.model.impl.MVListInteractorImpl;
import com.qhn.bhne.baseproject.mvp.presenter.MVListPresenter;
import com.qhn.bhne.baseproject.mvp.presenter.base.BasePresenterImpl;
import com.qhn.bhne.baseproject.mvp.view.MVListView;
import com.socks.library.KLog;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by qhn
 * on 2016/11/8 0008.
 */

public class MVListPresenterImpl extends BasePresenterImpl<MVListView,Map<String,List<MVList.MVBean>>> implements MVListPresenter {
    MVListInteractor<Map<String,List<MVList.MVBean>>> mvListMVListInteractor;
    private int currentPage = 1;
    private int size = 2;
    private int id = 22;
    private int order = 1;


    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Inject
    public MVListPresenterImpl(MVListInteractorImpl mvListMVListInteractor) {
        this.mvListMVListInteractor = mvListMVListInteractor;
        KLog.d();
    }

    @Override
    public void create() {
        loadData();
    }

    private void loadData() {
        mvListMVListInteractor.loadMVList(order, currentPage, size, this);
    }



    @Override
    public void success(Map<String, List<MVList.MVBean>> data) {
       // mView.loadSuccess(data);
    }

    @Override
    public void chooseMVCategory(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                setOrder(1);

                break;
            case 1:
                setOrder(2);
                break;
            case 2:
                setOrder(3);
                break;
        }
        loadData();
    }


}
