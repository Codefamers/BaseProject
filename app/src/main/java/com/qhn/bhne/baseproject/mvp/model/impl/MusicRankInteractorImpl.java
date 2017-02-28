package com.qhn.bhne.baseproject.mvp.model.impl;

import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.listener.RequestCallBack;
import com.qhn.bhne.baseproject.mvp.entity.MusicRank;
import com.qhn.bhne.baseproject.mvp.model.MusicRankInteractor;
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
 * on 2016/11/9 0009.
 */

public class MusicRankInteractorImpl implements MusicRankInteractor<MusicRank> {
    public boolean isShowProgress() {
        return isShowProgress;
    }

    public void setShowProgress(boolean showProgress) {
        isShowProgress = showProgress;
    }

    private boolean isShowProgress=true;

    @Inject
    public MusicRankInteractorImpl() {
    }

    @Override
    public Subscription loadMusicRankList( final RequestCallBack listener) {
        return RetrofitManager.getInstance(HostType.MOBILECDN_KUGOU)
                .getMusicRankObservable()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MusicRank>() {
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
                        listener.onFail(MyUtils.analyzeNetworkError(e));
                    }

                    @Override
                    public void onNext(MusicRank musicRank) {
                        KLog.d("请求成功");
                        listener.success(musicRank);

                    }
                });
    }
}
