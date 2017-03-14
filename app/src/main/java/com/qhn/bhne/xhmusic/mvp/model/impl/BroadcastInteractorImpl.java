package com.qhn.bhne.xhmusic.mvp.model.impl;

import com.qhn.bhne.xhmusic.common.HostType;
import com.qhn.bhne.xhmusic.listener.RequestCallBack;
import com.qhn.bhne.xhmusic.mvp.entity.BroadcastDetail;
import com.qhn.bhne.xhmusic.mvp.entity.BroadcastType;
import com.qhn.bhne.xhmusic.mvp.entity.ClassListBody;
import com.qhn.bhne.xhmusic.mvp.entity.SongListFM;
import com.qhn.bhne.xhmusic.mvp.model.BroadcastInteractor;
import com.qhn.bhne.xhmusic.net.RetrofitManager;
import com.socks.library.KLog;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class BroadcastInteractorImpl implements BroadcastInteractor<List<List<BroadcastDetail>>> {
    @Inject
    public BroadcastInteractorImpl() {
    }

    @Override
    public Subscription loadBroadDetail(final RequestCallBack<List<List<BroadcastDetail>>> listener) {

        return RetrofitManager.getInstance(HostType.KU_GOU_FM_TYPE)
                .getBroadcastTypeObservable(new ClassListBody())
                .flatMap(new Func1<List<BroadcastType>, Observable<BroadcastType>>() {
                    @Override
                    public Observable<BroadcastType> call(List<BroadcastType> broadcastBeen) {
                        return Observable.from(broadcastBeen);
                    }
                })
                .flatMap(new Func1<BroadcastType, Observable<List<BroadcastDetail>>>() {
                    @Override
                    public Observable<List<BroadcastDetail>> call(BroadcastType broadcastType) {
                        SongListFM songListFM = new SongListFM();
                        songListFM.setClassid(broadcastType.getClassId());
                        return RetrofitManager.getInstance(HostType.KU_GOU_FM_TYPE).getBroadcastDetailObservable(songListFM);
                    }
                }).toList()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<List<BroadcastDetail>>>() {
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
                    public void onNext(List<List<BroadcastDetail>> broadcastDetailList) {
                        KLog.d("请求成功777" + broadcastDetailList.size());
                        listener.success(broadcastDetailList);
                    }
                });

    }
}
