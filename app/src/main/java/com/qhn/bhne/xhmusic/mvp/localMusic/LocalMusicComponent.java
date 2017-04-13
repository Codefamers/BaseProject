package com.qhn.bhne.xhmusic.mvp.localMusic;

import com.qhn.bhne.xhmusic.di.component.ApplicationComponent;
import com.qhn.bhne.xhmusic.di.scope.PerActivity;
import com.qhn.bhne.xhmusic.di.scope.PerFragment;


import dagger.Component;

/**
 * Created by qhn
 * on 2017/4/12.
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = LocalMusicPresenterModule.class)
public interface LocalMusicComponent {

    void inject(LocalMusicFragment fragment);
}
