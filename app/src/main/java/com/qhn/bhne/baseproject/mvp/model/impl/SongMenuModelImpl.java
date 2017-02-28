package com.qhn.bhne.baseproject.mvp.model.impl;


import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.listener.RequestCallBack;
import com.qhn.bhne.baseproject.mvp.entity.SongMenuData;
import com.qhn.bhne.baseproject.mvp.model.SongMenuModel;
import com.qhn.bhne.baseproject.net.RetrofitManager;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.socks.library.KLog;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/02/27
 */

public class SongMenuModelImpl implements SongMenuModel<SongMenuData> {
    @Inject
    public SongMenuModelImpl() {
    }


    @Override
    public Subscription loadSongMenu(int categoryID,int page, int pageSize,  final RequestCallBack<SongMenuData> listener) {
        return RetrofitManager.getInstance(HostType.MOBILECDN_KUGOU)
                .getSongMenuObservable(categoryID,page,pageSize)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SongMenuData>() {
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
                    public void onNext(SongMenuData songMenu) {
                        KLog.d("请求成功");
                        listener.success(songMenu);

                    }
                });
    }
}