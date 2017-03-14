package com.qhn.bhne.xhmusic.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.application.App;
import com.qhn.bhne.xhmusic.di.component.DaggerFragmentComponent;
import com.qhn.bhne.xhmusic.di.component.FragmentComponent;
import com.qhn.bhne.xhmusic.di.module.FragmentModule;
import com.qhn.bhne.xhmusic.event.RetryConnectNetEvent;
import com.qhn.bhne.xhmusic.mvp.presenter.base.BasePresenter;
import com.qhn.bhne.xhmusic.mvp.view.base.BaseView;
import com.qhn.bhne.xhmusic.utils.MyUtils;
import com.qhn.bhne.xhmusic.utils.RxBus;
import com.squareup.leakcanary.RefWatcher;

import javax.inject.Inject;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by qhn
 * on 2016/10/27 0027.
 */

public abstract class BaseFragment<V extends BasePresenter,E> extends Fragment implements BaseView<E> {
    protected FragmentComponent fragmentComponent;
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


    public FragmentComponent getFragmentComponent() {
        return fragmentComponent;
    }

    protected V mPresenter;

    public V getPresenter() {
        return mPresenter;
    }

    public void setPresenter(V mPresenter) {
        this.mPresenter = mPresenter;
    }

    private View mFragmentView;
    protected Subscription mSubscription;
    @Inject
    RxBus rxBus;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentComponent = DaggerFragmentComponent.builder()
                .applicationComponent(((App) getActivity().getApplication()).getApplicationComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
        initInjector();
    }

    protected abstract void initInjector();

    protected abstract int getLayoutId();

    protected abstract void initViews(View mFragmentView);

    protected abstract View getSuccessView();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mFragmentView == null) {
            mFragmentView = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this, mFragmentView);
            initViews(mFragmentView);
        }
        return mFragmentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = App.getRefWatcher(getActivity());
        refWatcher.watch(this);
        if (mPresenter != null)
            mPresenter.onDestroy();
        MyUtils.cancelSubscription(mSubscription);//取消订阅
    }


    @Override
    public void loadSuccess(E data) {
        chooseShowView(SUCCESS_VIEW);
    }

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

    private void initExtraView() {

        root = (FrameLayout) mFragmentView.findViewById(R.id.root);
        successView = getSuccessView();
        loadingView = LayoutInflater.from(getActivity()).inflate(R.layout.item_loading_message, null);
        emptyView = LayoutInflater.from(getActivity()).inflate(R.layout.item_loading_empty, null);
        failView = LayoutInflater.from(getActivity()).inflate(R.layout.item_loading_fail, null);
        btnRetry = (Button) failView.findViewById(R.id.btn_restart_load);
        root.addView(loadingView);
        root.addView(emptyView);
        root.addView(failView);
    }
}
