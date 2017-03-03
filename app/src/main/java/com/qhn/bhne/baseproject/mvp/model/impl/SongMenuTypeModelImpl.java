package com.qhn.bhne.baseproject.mvp.model.impl;


import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.listener.RequestCallBack;
import com.qhn.bhne.baseproject.mvp.entity.SongMenuType;
import com.qhn.bhne.baseproject.mvp.model.SongMenuTypeModel;
import com.qhn.bhne.baseproject.net.RetrofitManager;
import com.qhn.bhne.baseproject.utils.MyUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/02/28
 */

public class SongMenuTypeModelImpl implements SongMenuTypeModel<List<SongMenuType>> {
    @Inject
    public SongMenuTypeModelImpl() {
    }

    @Override
    public Subscription loadSongMenuType(final RequestCallBack<List<SongMenuType>> listener) {
        return RetrofitManager.getInstance(HostType.MOBILECDN_KUGOU)
                .getSongMenuTypeObservable()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<SongMenuType>>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        listener.beforeRequest();

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
                    public void onNext(List<SongMenuType> songMenuList) {

                        listener.success(songMenuList);

                    }
                });
    }
}