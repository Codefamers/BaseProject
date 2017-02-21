package com.qhn.bhne.baseproject.mvp.interactor.impl;

import android.util.Log;

import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.listener.RequestCallBack;
import com.qhn.bhne.baseproject.mvp.entity.MVType;
import com.qhn.bhne.baseproject.mvp.entity.MusicList;
import com.qhn.bhne.baseproject.mvp.interactor.MusicListInteractor;
import com.qhn.bhne.baseproject.net.RetrofitManager;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.socks.library.KLog;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uk.co.senab.photoview.log.LoggerDefault;

/**
 * Created by qhn
 * on 2017/2/14 0014.
 */

public class MusicListInteractorImpl implements MusicListInteractor<MusicList> {
    @Inject
    public MusicListInteractorImpl() {
    }

    private static final String TAG = "MusicListInteractorImpl";

    @Override
    public Subscription loadMusicList(int musicListID, final RequestCallBack<MusicList> listener) {
        return RetrofitManager.getInstance(HostType.SONG_LIST)
                .getMusicListObservable(musicListID)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MusicList>() {
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
                        listener.onError(MyUtils.analyzeNetworkError(e));
                    }

                    @Override
                    public void onNext(MusicList musicList) {
                        KLog.d("请求成功");
                        listener.success(musicList);
                    }


                });
    }
}
