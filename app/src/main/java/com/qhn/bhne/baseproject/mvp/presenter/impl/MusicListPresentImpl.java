package com.qhn.bhne.baseproject.mvp.presenter.impl;

import com.qhn.bhne.baseproject.mvp.entity.MusicList;
import com.qhn.bhne.baseproject.mvp.interactor.MusicListInteractor;
import com.qhn.bhne.baseproject.mvp.interactor.impl.MusicListInteractorImpl;
import com.qhn.bhne.baseproject.mvp.presenter.base.BasePresenterImpl;
import com.qhn.bhne.baseproject.mvp.view.MusicListView;

import javax.inject.Inject;


public class MusicListPresentImpl extends BasePresenterImpl<MusicListView, MusicList> {
    //private MusicRankInteractorImpl musicRankInteractor;
    private MusicListInteractor<MusicList> musicListInteractor;

    @Inject
    public MusicListPresentImpl(MusicListInteractorImpl musicRankInteractor) {
        this.musicListInteractor = musicRankInteractor;
    }

    @Override
    public void create() {
        musicListInteractor.loadMusicList(306952426, this);
    }

    @Override
    public void success(MusicList data) {
        mView.loadSuccess(data);
    }

    @Override
    public void onDestroy() {

    }
}
