package com.qhn.bhne.baseproject.mvp.presenter.impl;

import android.support.annotation.NonNull;

import com.qhn.bhne.baseproject.mvp.entity.ChannelList;
import com.qhn.bhne.baseproject.mvp.entity.SongMenu;
import com.qhn.bhne.baseproject.mvp.interactor.ChannelListInteractor;
import com.qhn.bhne.baseproject.mvp.interactor.SongMenuInteractor;
import com.qhn.bhne.baseproject.mvp.interactor.impl.ChannelListInteractorImpl;
import com.qhn.bhne.baseproject.mvp.presenter.SongMenuPresenter;
import com.qhn.bhne.baseproject.mvp.presenter.base.BasePresenterImpl;
import com.qhn.bhne.baseproject.mvp.view.SongMenuView;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;

import javax.inject.Inject;

/**
 * Created by qhn
 * on 2016/11/7 0007.
 */

public class SongMenuPresenterImpl extends BasePresenterImpl<SongMenuView, ChannelList> implements SongMenuPresenter {
    private SongMenuInteractor<SongMenu> songMenuInteractor;
    private ChannelListInteractor<ChannelList> channelListInteractor;
    private String defaultTag = "运动";
    private int currentPage = 0;


    @Inject
    public SongMenuPresenterImpl(ChannelListInteractorImpl channelListInteractor) {
        this.channelListInteractor = channelListInteractor;
    }


    @Override
    public void create() {
        loadData(defaultTag);
    }

    private void loadData(String tag) {
        channelListInteractor.loadChannelList(this);
    }

    @Override
    public void success(ChannelList data) {
        if (data == null || data.getData().size() == 0) {
            mView.loadDataEmpty();
        } else if (currentPage != 0) {
            mView.loadMore(data.getData());
        } else
            mView.loadSuccess(data.getData());

    }

    @Override
    public void attachView(@NonNull BaseView view) {
        setView((SongMenuView) view);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void loadMore() {
        currentPage++;
        //songMenuInteractor.loadSongMenu(defaultTag,currentPage,size,this);

    }
}
