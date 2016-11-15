package com.qhn.bhne.baseproject.mvp.interactor.impl;

import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.listener.RequestCallBack;
import com.qhn.bhne.baseproject.mvp.entity.ChannelList;
import com.qhn.bhne.baseproject.mvp.interactor.ChannelListInteractor;
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
 * on 2016/11/8 0008.
 */

public class ChannelListInteractorImpl implements ChannelListInteractor<ChannelList> {
    private boolean isShowProgress=true;
    public boolean isShowProgress() {
        return isShowProgress;
    }

    public void setShowProgress(boolean showProgress) {
        isShowProgress = showProgress;
    }

    @Inject
    public ChannelListInteractorImpl() {
    }
    @Override
    public Subscription loadChannelList(final RequestCallBack listener) {
        return RetrofitManager.getInstance(HostType.FM_API_TTPOD)
                .getChannelListObservable()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ChannelList>() {
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
                    public void onNext(ChannelList channelList) {
                        KLog.d("请求成功");
                        listener.success(channelList);
                    }
                });
    }
}
