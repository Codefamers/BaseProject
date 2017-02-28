package com.qhn.bhne.baseproject.mvp.presenter.impl;


import com.qhn.bhne.baseproject.mvp.entity.SongMenuData;
import com.qhn.bhne.baseproject.mvp.model.impl.SongMenuModelImpl;
import com.qhn.bhne.baseproject.mvp.presenter.SongMenuPresenter;
import com.qhn.bhne.baseproject.mvp.presenter.base.BasePresenterImpl;
import com.qhn.bhne.baseproject.mvp.view.SongMenuView;

import javax.inject.Inject;

/**
* Created by Administrator on 2017/02/27
*/

public class SongMenuPresenterImpl extends BasePresenterImpl<SongMenuView,SongMenuData> implements SongMenuPresenter {

    @Inject
    SongMenuModelImpl songMenuModel;
    private int categoryID=0;
    private int page=0;
    private int pageSize=20;
    @Inject
    public SongMenuPresenterImpl(SongMenuModelImpl songMenuModel) {
        this.songMenuModel = songMenuModel;
    }

    @Override
    public void create() {
        loadData(categoryID,page,pageSize);
    }
    @Override
    public void success(SongMenuData data) {
        mView.loadSuccess(data);
    }
    @Override
    public void loadData(int page, int size, int categoryid) {
        songMenuModel.loadSongMenu(categoryid,page,size,this);
    }

}