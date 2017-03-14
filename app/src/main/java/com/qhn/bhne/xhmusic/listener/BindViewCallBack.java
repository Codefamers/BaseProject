package com.qhn.bhne.xhmusic.listener;

import android.support.v7.widget.RecyclerView;

/**
 * Created by qhn
 * on 2016/11/5 0005.
 */

public interface BindViewCallBack<T> {
   void bindView(RecyclerView.ViewHolder holder,T data, int position);
}
