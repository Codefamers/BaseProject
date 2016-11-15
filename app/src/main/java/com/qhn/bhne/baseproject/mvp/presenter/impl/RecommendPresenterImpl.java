package com.qhn.bhne.baseproject.mvp.presenter.impl;

import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;
import com.qhn.bhne.baseproject.mvp.interactor.RecommendContentInteractor;
import com.qhn.bhne.baseproject.mvp.interactor.impl.RecommendInteractorImpl;
import com.qhn.bhne.baseproject.mvp.presenter.RecommendPresenter;
import com.qhn.bhne.baseproject.mvp.presenter.base.BasePresenterImpl;
import com.qhn.bhne.baseproject.mvp.view.RecommendView;
import com.socks.library.KLog;

import javax.inject.Inject;

/**
 * Created by qhn
 * on 2016/11/4 0004.
 */

public class RecommendPresenterImpl extends BasePresenterImpl<RecommendView,RecommendContent> implements RecommendPresenter {
    private RecommendContentInteractor<RecommendContent> mInteractor;
    @Inject
    public RecommendPresenterImpl(RecommendInteractorImpl recommendInteractor) {
        this.mInteractor=recommendInteractor;
    }

    @Override
    public void create() {
        KLog.d("加载数据");
        loadData(true);

    }
    //activity退出时执行的操作
    @Override
    public void onDestroy() {
        KLog.d("fragment结束");
    }

    @Override
    public void success(RecommendContent data) {
        super.success(data);
        if (data==null) {
            mView.loadDataEmpty();
        }else {
            mView.loadSuccess(data.getData());
        }
    }

    @Override
    public void refreshData() {
        loadData(false);
    }


    //加载数据
    private void loadData(Boolean isShowProgress) {
        mInteractor.loadRecommendContent(this,isShowProgress);
    }

}
