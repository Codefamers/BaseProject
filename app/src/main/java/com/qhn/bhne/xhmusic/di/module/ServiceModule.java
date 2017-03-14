package com.qhn.bhne.xhmusic.di.module;

import android.app.Service;

import dagger.Module;

/**
 * Created by qhn
 * on 2017/2/23 0023.
 */
@Module
public class ServiceModule {
    private Service service;

    public ServiceModule(Service service) {
        this.service = service;
    }
}
