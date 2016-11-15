package com.qhn.bhne.baseproject.mvp.interactor.impl;

import com.qhn.bhne.baseproject.listener.RequestCallBack;
import com.qhn.bhne.baseproject.mvp.entity.NewsChannelTableManager;
import com.qhn.bhne.baseproject.mvp.interactor.NewsInteractor;
import com.qhn.bhne.baseproject.utils.TransformUtils;
import com.qhn.greendao.NewsChannelTable;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by qhn
 * on 2016/10/28 0028.
 */

public class NewsInteractorImpl implements NewsInteractor<List<NewsChannelTable>> {


    @Inject
    public NewsInteractorImpl() {

    }

    /*
    * Subscription订阅集合
    *
    *
    * 是Subscription的一个实习类，用于管理一组订阅，当取消订阅时，会将这一组订阅全部取消，
    * 在Android中可以利用该类管理一个Activity中所有的异步任务，当Activity被销毁时，取消订阅，
    * 避免内存泄漏add — 将一个订阅加入到一个订阅组中
    * remove — 将一个订阅从该组中移除
    * clear — 清空订阅组
    * unsubscribe — 取消改组中正在进行的所有订阅
    * */
    @Override
    public Subscription lodeNewsChannels(final RequestCallBack<List<NewsChannelTable>> callBack) {
       return Observable.create(new Observable.OnSubscribe<List<NewsChannelTable>>() {
            @Override
            public void call(Subscriber<? super List<NewsChannelTable>> subscriber) {
                NewsChannelTableManager.initDB();
                subscriber.onNext(NewsChannelTableManager.loadNewsChannelsMine());
                subscriber.onCompleted();
            }
        }).compose(TransformUtils.<List<NewsChannelTable>>defaultSchedulers())//这一块是不是可以当作一个发射者发射出去
           .subscribe(new Subscriber<List<NewsChannelTable>>() {
               @Override
               public void onCompleted() {

               }

               @Override
               public void onError(Throwable e) {
                    callBack.onError("数据库出错了");
               }

               @Override
               public void onNext(List<NewsChannelTable> newsChannelTables) {
                   callBack.success(newsChannelTables);
               }
           });

    }
}
