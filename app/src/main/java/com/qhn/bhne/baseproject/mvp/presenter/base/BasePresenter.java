package com.qhn.bhne.baseproject.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.qhn.bhne.baseproject.mvp.view.base.BaseView;

/**
 * Created by qhn
 * on 2016/10/27 0027.
 */

public interface BasePresenter {
    void create();
    void attachView(@NonNull BaseView view);
    void onDestroy();
}
