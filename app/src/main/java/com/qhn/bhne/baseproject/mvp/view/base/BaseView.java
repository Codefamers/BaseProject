package com.qhn.bhne.baseproject.mvp.view.base;



/**
 * Created by qhn
 * on 2016/10/27 0027.
 */

public interface BaseView {
    void loadSuccess(Object data);
    void loadFail(String message);
    void loadBefore();
    void loadDataEmpty();
}
