package com.qhn.bhne.xhmusic.mvp.localMusic;


import dagger.Module;
import dagger.Provides;

/**
 * Created by qhn
 * on 2017/4/12.
 */
@Module
public class LocalMusicPresenterModule {
    private final LocalMusicContract.View mView;

    public LocalMusicPresenterModule(LocalMusicContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public LocalMusicContract.View providerLocalMusicContractView() {
        return mView;
    }
}
