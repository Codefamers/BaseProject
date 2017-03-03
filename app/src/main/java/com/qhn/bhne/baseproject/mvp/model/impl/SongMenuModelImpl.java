package com.qhn.bhne.baseproject.mvp.model.impl;


import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.listener.RequestCallBack;
import com.qhn.bhne.baseproject.mvp.entity.SongMenu;
import com.qhn.bhne.baseproject.mvp.model.SongMenuModel;
import com.qhn.bhne.baseproject.net.RetrofitManager;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.socks.library.KLog;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/02/27
 */

public class SongMenuModelImpl implements SongMenuModel<List<SongMenu>> {
    @Inject
    public SongMenuModelImpl() {
    }


    @Override
    public Subscription loadSongMenu(int categoryID, int page, int pageSize, final boolean isShowProgress, final RequestCallBack<List<SongMenu>> listener) {
        return RetrofitManager.getInstance(HostType.MOBILECDN_KUGOU)
                .getSongMenuObservable(categoryID,page,pageSize)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<SongMenu>>() {
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
                    public void onNext(List<SongMenu> songMenuList) {
                        KLog.d("请求成功");
                        listener.success(songMenuList);

                    }
                });
    }
}