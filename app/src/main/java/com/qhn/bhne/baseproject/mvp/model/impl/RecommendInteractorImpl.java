package com.qhn.bhne.baseproject.mvp.model.impl;

import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.event.RecommendEvent;
import com.qhn.bhne.baseproject.listener.RequestCallBack;
import com.qhn.bhne.baseproject.mvp.entity.BannerContent;
import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;
import com.qhn.bhne.baseproject.mvp.model.RecommendContentInteractor;
import com.qhn.bhne.baseproject.net.RetrofitManager;
import com.qhn.bhne.baseproject.utils.MyUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by qhn
 * on 2016/11/4 0004.
 */

public class RecommendInteractorImpl implements RecommendContentInteractor<RecommendEvent> {
    @Inject
    public RecommendInteractorImpl() {
    }


    @Override
    public Subscription loadRecommendContent(final RequestCallBack<RecommendEvent> listener) {
       Observable<BannerContent> bannerContentObservable=RetrofitManager.getInstance(HostType.KU_GOU_BANNER)
                .getBannerContent()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observable<RecommendContent> recommendContentObservable=RetrofitManager.getInstance(HostType.API_KU_GOUT_RECOMMEND)
                .getRecommendContent()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        //Observable<RecommendEvent>
        return Observable.zip(bannerContentObservable, recommendContentObservable, new Func2<BannerContent, RecommendContent, RecommendEvent>() {
            @Override
            public RecommendEvent call(BannerContent bannerContent, RecommendContent recommendContent) {
                return new RecommendEvent(recommendContent,bannerContent);
            }
        }).subscribe(new Subscriber<RecommendEvent>() {
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
            public void onNext(RecommendEvent recommendEvent) {
                listener.success(recommendEvent);
            }
        });
        /*RetrofitManager.getInstance(HostType.API_KU_GOUT_RECOMMEND)
                .getRecommendContent()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RecommendContent>() {
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
                    public void onNext(RecommendContent recommendContent) {
                        KLog.d("请求成功");
                        listener.success(recommendContent);
                    }
                });*/
    }


}
