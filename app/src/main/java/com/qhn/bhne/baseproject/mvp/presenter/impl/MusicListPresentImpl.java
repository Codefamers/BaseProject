package com.qhn.bhne.baseproject.mvp.presenter.impl;

import com.qhn.bhne.baseproject.event.RetryConnectNetEvent;
import com.qhn.bhne.baseproject.mvp.entity.Songs;
import com.qhn.bhne.baseproject.mvp.model.MusicListModel;
import com.qhn.bhne.baseproject.mvp.presenter.MusicListPresenter;
import com.qhn.bhne.baseproject.mvp.presenter.base.BasePresenterImpl;
import com.qhn.bhne.baseproject.mvp.view.MusicListView;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.functions.Action1;


public class MusicListPresentImpl extends BasePresenterImpl implements MusicListPresenter {
    @Inject
    public MusicListPresentImpl() {
    }

    private MusicListModel<List<Songs>> mMusicModel;
    private int specialID;
    private int pageSize = 30;
    private int page = 1;
    private Map<String, Integer> paramsMap;

    @Override
    public void success(Object data) {
        mView.loadSuccess(data);
    }


    @Override
    public void create() {
        mSubscription = rxBus.toObservable(RetryConnectNetEvent.class).subscribe(new Action1<RetryConnectNetEvent>() {
            @Override
            public void call(RetryConnectNetEvent retryConnectNetEvent) {
                loadData(paramsMap,true);
            }
        });
        loadData(paramsMap,true);
    }


    @Override
    public void loadData(Map<String, Integer> paramsMap,boolean isShowProgress) {
        mMusicModel.loadMusicList(paramsMap,isShowProgress, this);
    }




    @Override
    public void setMapParams(Map<String, Integer> paramsMap) {
        this.paramsMap=paramsMap;
    }

    @Override
    public void setModelImpl(MusicListModel<List<Songs>> musicListModel) {
        this.mMusicModel = musicListModel;
    }


}
