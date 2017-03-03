package com.qhn.bhne.baseproject.mvp.view.base;


import com.qhn.bhne.baseproject.mvp.entity.DataBean;

/**
 * Created by qhn
 * on 2016/10/27 0027.
 */

public interface BaseView<E> {
    void loadSuccess(E data);

    void loadFail(String message);

    void loadBefore();

    void loadDataEmpty();
}
