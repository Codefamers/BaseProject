package com.qhn.bhne.xhmusic.mvp.localMusic;

import com.qhn.bhne.xhmusic.mvp.model.impl.LocalMusicInfoProvider;

import javax.inject.Inject;

/**
 * Created by qhn
 * on 2017/4/12.
 */

public class LocalMusicPresenter implements LocalMusicContract.Presenter {

    private LocalMusicInfoProvider mProvider;
    private LocalMusicContract.View mView;
    @Inject
    public LocalMusicPresenter(LocalMusicInfoProvider mProvider, LocalMusicContract.View mView) {
        this.mProvider = mProvider;
        this.mView = mView;
    }



    @Override
    public void start() {

    }

    @Override
    public void queryLocalMusic() {
        mProvider.queryAlbums();
    }

    @Override
    public void queryRecentPlay() {

    }

    @Override
    public void queryDownLoad() {

    }

    @Override
    public void queryMyCollectSinger() {

    }

    @Override
    public void queryBuildSongMenu() {

    }

    @Override
    public void queryCollectSongMenu() {

    }

    @Override
    public void addBuildSongMenu() {

    }

    @Override
    public void deleteBuildSongMenu() {

    }
}
