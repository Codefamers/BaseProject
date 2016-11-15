package com.qhn.bhne.baseproject.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.application.App;
import com.qhn.bhne.baseproject.di.component.DaggerFragmentComponent;
import com.qhn.bhne.baseproject.di.component.FragmentComponent;
import com.qhn.bhne.baseproject.di.module.FragmentModule;
import com.qhn.bhne.baseproject.mvp.presenter.base.BasePresenter;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.socks.library.KLog;
import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by qhn
 * on 2016/10/27 0027.
 */

public abstract class BaseFragment<V extends BasePresenter> extends Fragment implements BaseView{
    protected FragmentComponent fragmentComponent;
    private View emptyView;//加载为空布局
    private View loadingView;//加载中布局
    private View failView;//加载失败布局
    private View successView;//加载成功布局


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
    private boolean isNeedLoadData;

    public boolean isNeedLoadData() {
        return isNeedLoadData;
    }

    public void setNeedLoadData(boolean needLoadData) {
        isNeedLoadData = needLoadData;
    }

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
    public void loadSuccess(Object data) {
        chooseShowView(SUCCESS_VIEW);
    }

    @Override
    public void loadFail(String message) {
        chooseShowView(FAIL_VIEW);
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
        if (loadingView == null) {
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
        KLog.d("实例化数据");
        successView = getSuccessView();
        loadingView = LayoutInflater.from(getActivity()).inflate(R.layout.item_loading_message, null);
        emptyView = LayoutInflater.from(getActivity()).inflate(R.layout.item_loading_empty, null);
        failView = LayoutInflater.from(getActivity()).inflate(R.layout.item_loading_fail, null);
        root.addView(loadingView);
        root.addView(emptyView);
        root.addView(failView);
    }
}
