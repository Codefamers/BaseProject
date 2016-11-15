package com.qhn.bhne.baseproject.listener;



/**
 * Created by qhn
 * on 2016/10/28 0028.
 */

public interface RequestCallBack<T> {
    void beforeRequest();
    void success(T data);
    void onError(String errorMsg);

}
