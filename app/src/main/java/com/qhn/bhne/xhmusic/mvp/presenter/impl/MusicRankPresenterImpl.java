package com.qhn.bhne.xhmusic.mvp.presenter.impl;

import com.qhn.bhne.xhmusic.mvp.entity.MusicRank;
import com.qhn.bhne.xhmusic.mvp.model.impl.MusicRankInteractorImpl;
import com.qhn.bhne.xhmusic.mvp.presenter.MusicRankPresenter;
import com.qhn.bhne.xhmusic.mvp.presenter.base.BasePresenterImpl;
import com.qhn.bhne.xhmusic.mvp.view.MusicRankView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by qhn
 * on 2016/11/9 0009.
 */

public class MusicRankPresenterImpl extends BasePresenterImpl<MusicRankView, List<MusicRank>> implements MusicRankPresenter {

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
    public void success(List<MusicRank> data) {
        data.remove(0);
        mView.loadSuccess(data);
    }


}
