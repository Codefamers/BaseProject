package com.qhn.bhne.xhmusic.listener;



/**
 * Created by qhn
 * on 2016/10/28 0028.
 */

public interface RequestCallBack<T> {
    void beforeRequest();
    void success(T data);
    void onFail(String errorMsg);

}
