package com.qhn.bhne.baseproject.mvp.ui.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.event.RetryConnectNetEvent;
import com.qhn.bhne.baseproject.mvp.ui.activities.base.BaseActivity;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;
import com.qhn.bhne.baseproject.utils.RxBus;

import javax.inject.Inject;

/**
 * Created by qhn
 * on 2017/2/27 0027.
 */

public abstract class BaseLoadDataActivity extends BaseActivity implements BaseView {

    private View emptyView;//加载为空布局
    private View loadingView;//加载中布局
    private View failView;//加载失败布局
    private View successView;//加载成功布局

    private Button btnRetry;
    private static int LOADING_VIEW = 1;
    private static int SUCCESS_VIEW = 2;
    private static int EMPTY_VIEW = 3;
    private static int FAIL_VIEW = 4;
    private FrameLayout root;
    @Inject
    RxBus rxBus;
    @Override
    public void loadFail(String message) {
        chooseShowView(FAIL_VIEW);
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rxBus.post(new RetryConnectNetEvent());
            }
        });

    }

    @Override
    public void loadBefore() {
        chooseShowView(LOADING_VIEW);
    }

    @Override
    public void loadDataEmpty() {
        chooseShowView(EMPTY_VIEW);
    }

    private void chooseShowView(int whichOne) {
        if (loadingView == null) {//判断视图是否已经初始化过
            initExtraView();
        }
        if (loadingView.getVisibility() != View.GONE)
            loadingView.setVisibility(View.GONE);
        if (failView.getVisibility() != View.GONE)
            failView.setVisibility(View.GONE);
        if (emptyView.getVisibility() != View.GONE)
            emptyView.setVisibility(View.GONE);
        if (successView.getVisibility() != View.GONE)
            successView.setVisibility(View.GONE);
        if (whichOne == LOADING_VIEW) {
            loadingView.setVisibility(View.VISIBLE);
        }
        if (whichOne == FAIL_VIEW) {
            failView.setVisibility(View.VISIBLE);
        }
        if (whichOne == EMPTY_VIEW) {
            emptyView.setVisibility(View.VISIBLE);
        }
        if (whichOne == SUCCESS_VIEW) {
            successView.setVisibility(View.VISIBLE);
        }
    }
    protected abstract View getSuccessView();
    private void initExtraView() {
        root = (FrameLayout) findViewById(R.id.root);
        successView = getSuccessView();
        loadingView = LayoutInflater.from(this).inflate(R.layout.item_loading_message, null);
        emptyView = LayoutInflater.from(this).inflate(R.layout.item_loading_empty, null);
        failView = LayoutInflater.from(this).inflate(R.layout.item_loading_fail, null);
        btnRetry = (Button) failView.findViewById(R.id.btn_restart_load);
        root.addView(loadingView);
        root.addView(emptyView);
        root.addView(failView);
    }
}
