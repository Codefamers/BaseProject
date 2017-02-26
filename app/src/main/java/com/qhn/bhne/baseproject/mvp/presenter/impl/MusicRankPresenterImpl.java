package com.qhn.bhne.baseproject.mvp.presenter.impl;

import android.support.annotation.NonNull;

import com.qhn.bhne.baseproject.mvp.entity.MusicRank;
import com.qhn.bhne.baseproject.mvp.interactor.impl.MusicRankInteractorImpl;
import com.qhn.bhne.baseproject.mvp.presenter.MusicRankPresenter;
import com.qhn.bhne.baseproject.mvp.presenter.base.BasePresenterImpl;
import com.qhn.bhne.baseproject.mvp.view.MusicRankView;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by qhn
 * on 2016/11/9 0009.
 */

public class MusicRankPresenterImpl extends BasePresenterImpl<MusicRankView,MusicRank>   {

    private MusicRankInteractorImpl musicRankInteractor;

    @Inject
    public MusicRankPresenterImpl(MusicRankInteractorImpl musicRankInteractor) {
        this.musicRankInteractor = musicRankInteractor;
    }

    @Override
    public void create() {
        musicRankInteractor.loadMusicRankList(this);
    }

    @Override
    public void success(MusicRank data) {
        List<MusicRank.DataBean.InfoBean> infoBeanList=data.getData().getInfo();
        infoBeanList.remove(0);
        mView.loadSuccess(infoBeanList);
    }

    @Override
    public void onDestroy() {

    }
}
