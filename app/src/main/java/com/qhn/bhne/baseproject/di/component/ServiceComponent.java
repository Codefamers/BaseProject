package com.qhn.bhne.baseproject.di.component;

import com.qhn.bhne.baseproject.di.module.ServiceModule;
import com.qhn.bhne.baseproject.di.scope.PerService;
import com.qhn.bhne.baseproject.mvp.ui.service.MusicService;

import dagger.Component;

/**
 * Created by qhn
 * on 2017/2/23 0023.
 */

@PerService//如果component中依赖的有其他Component注入的时候也要将该component的module实例化
@Component(dependencies = ApplicationComponent.class,modules =ServiceModule.class )
public interface ServiceComponent {
    void inject(MusicService musicService);
}
