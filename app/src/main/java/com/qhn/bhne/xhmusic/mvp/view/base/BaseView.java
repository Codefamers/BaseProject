package com.qhn.bhne.xhmusic.mvp.view.base;


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
