package com.qhn.bhne.baseproject.di.component;

import android.content.Context;

import com.qhn.bhne.baseproject.di.module.ApplicationModule;
import com.qhn.bhne.baseproject.di.scope.ContextLife;
import com.qhn.bhne.baseproject.di.scope.PerApp;

import dagger.Component;

/**
 * Created by qhn
 * on 2016/10/27 0027.
 */
@PerApp
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ContextLife("Application")
    Context getApplication();
}
