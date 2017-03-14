package com.qhn.bhne.xhmusic.mvp.presenter;

import android.view.View;
import android.widget.AdapterView;

import com.qhn.bhne.xhmusic.mvp.presenter.base.BasePresenter;

/**
 * Created by qhn
 * on 2016/11/8 0008.
 */

public interface MVListPresenter extends BasePresenter {
    void chooseMVCategory(AdapterView<?> adapterView, View view, int i, long l);
}
