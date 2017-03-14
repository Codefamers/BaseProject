package com.qhn.bhne.xhmusic.mvp.model.impl;

import com.qhn.bhne.xhmusic.common.HostType;
import com.qhn.bhne.xhmusic.listener.RequestCallBack;
import com.qhn.bhne.xhmusic.mvp.entity.MusicRank;
import com.qhn.bhne.xhmusic.mvp.model.MusicRankInteractor;
import com.qhn.bhne.xhmusic.net.RetrofitManager;
import com.qhn.bhne.xhmusic.utils.MyUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by qhn
 * on 2016/11/9 0009.
 */

public class MusicRankInteractorImpl implements MusicRankInteractor<List<MusicRank>> {
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
    public Subscription loadMusicRankList( final RequestCallBack<List<MusicRank>> listener) {
        return RetrofitManager.getInstance(HostType.MOBILECDN_KUGOU)
                .getMusicRankObservable()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<MusicRank>>() {
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
                    public void onNext(List<MusicRank> musicRankList) {

                        listener.success(musicRankList);

                    }
                });
    }
}
