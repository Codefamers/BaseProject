package com.qhn.bhne.xhmusic.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.qhn.bhne.xhmusic.mvp.view.base.BaseView;

/**
 * Created by qhn
 * on 2016/10/27 0027.
 */

public interface BasePresenter<T extends BaseView> {
    void create();
    void attachView(@NonNull T view);
    void onDestroy();
}
