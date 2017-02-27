package com.qhn.bhne.baseproject.mvp.interactor.impl;

import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.listener.RequestCallBack;
import com.qhn.bhne.baseproject.mvp.entity.BroadcastDetail;
import com.qhn.bhne.baseproject.mvp.entity.BroadcastType;
import com.qhn.bhne.baseproject.mvp.entity.ClassListBody;
import com.qhn.bhne.baseproject.mvp.entity.SongListFM;
import com.qhn.bhne.baseproject.mvp.interactor.BroadcastInteractor;
import com.qhn.bhne.baseproject.net.RetrofitManager;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by qhn
 * on 2016/11/7 0007.
 */

public class BroadcastInteractorImpl implements BroadcastInteractor<List<List<BroadcastDetail.DataBean>>> {
    @Inject
    public BroadcastInteractorImpl() {
    }

    @Override
    public Subscription loadBroadDetail(final RequestCallBack<List<List<BroadcastDetail.DataBean>>> listener) {

        return RetrofitManager.getInstance(HostType.KU_GOU_FM_TYPE)
                .getBroadcastTypeObservable(new ClassListBody())
                .map(new Func1<BroadcastType, List<BroadcastType.BroadcastBean>>() {
                    @Override
                    public List<BroadcastType.BroadcastBean> call(BroadcastType broadcastType) {
                        return broadcastType.getData();
                    }
                }).flatMap(new Func1<List<BroadcastType.BroadcastBean>, Observable<BroadcastType.BroadcastBean>>() {
                    @Override
                    public Observable<BroadcastType.BroadcastBean> call(List<BroadcastType.BroadcastBean> broadcastBeen) {
                        return Observable.from(broadcastBeen);
                    }
                })
                .flatMap(new Func1<BroadcastType.BroadcastBean, Observable<BroadcastDetail>>() {
                    @Override
                    public Observable<BroadcastDetail> call(BroadcastType.BroadcastBean broadcastBean) {
                        SongListFM songListFM = new SongListFM();
                        songListFM.setClassid(broadcastBean.getClassId());
                        return RetrofitManager.getInstance(HostType.KU_GOU_FM_TYPE).getBroadcastDetailObservable(songListFM);
                    }
                }).toList().map(new Func1<List<BroadcastDetail>, List<List<BroadcastDetail.DataBean>>>() {
                    @Override
                    public List<List<BroadcastDetail.DataBean>> call(List<BroadcastDetail> broadcastDetailList) {
                        List<List<BroadcastDetail.DataBean>> broadcastBeanList = new ArrayList<>();
                        for (BroadcastDetail broadcastDetail : broadcastDetailList) {
                            broadcastBeanList.add(broadcastDetail.getData());
                        }
                        return broadcastBeanList;
                    }
                })
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<List<BroadcastDetail.DataBean>>>() {
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
                        listener.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<List<BroadcastDetail.DataBean>> broadcastDetailList) {
                        KLog.d("请求成功777" + broadcastDetailList.size());
                        listener.success(broadcastDetailList);
                    }
                });

    }
}
