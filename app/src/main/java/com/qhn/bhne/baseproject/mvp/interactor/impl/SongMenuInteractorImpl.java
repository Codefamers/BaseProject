package com.qhn.bhne.baseproject.mvp.interactor.impl;

import com.qhn.bhne.baseproject.common.ApiConstants;
import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.listener.RequestCallBack;
import com.qhn.bhne.baseproject.mvp.entity.SongMenu;
import com.qhn.bhne.baseproject.mvp.interactor.SongMenuInteractor;
import com.qhn.bhne.baseproject.net.RetrofitManager;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.socks.library.KLog;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by qhn
 * on 2016/11/7 0007.
 */

public class SongMenuInteractorImpl implements SongMenuInteractor<SongMenu> {
    @Inject
    public SongMenuInteractorImpl() {
    }


    public boolean isShowProgress() {
        return isShowProgress;
    }

    public void setShowProgress(boolean showProgress) {
        isShowProgress = showProgress;
    }

    private boolean isShowProgress=true;

    @Override
    public Subscription loadSongMenu(String tag, int page, int size, final RequestCallBack<SongMenu> listener) {
        return RetrofitManager.getInstance(HostType.SEARCH_DONG_TING)
                .getSongMenuObservable("tag:" + tag, page, size)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SongMenu>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        if (isShowProgress) {
                            listener.beforeRequest();
                        }

                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        listener.onError(MyUtils.analyzeNetworkError(e));
                    }

                    @Override
                    public void onNext(SongMenu songMenu) {
                        KLog.d("请求成功");
                        listener.success(songMenu);
                    }
                });
    }
}
