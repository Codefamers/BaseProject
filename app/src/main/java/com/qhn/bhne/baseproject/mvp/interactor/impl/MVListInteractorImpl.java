package com.qhn.bhne.baseproject.mvp.interactor.impl;

import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.listener.RequestCallBack;
import com.qhn.bhne.baseproject.mvp.entity.MVList;
import com.qhn.bhne.baseproject.mvp.entity.MVType;
import com.qhn.bhne.baseproject.mvp.interactor.MVListInteractor;
import com.qhn.bhne.baseproject.net.RetrofitManager;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by qhn
 * on 2016/11/8 0008.
 */

public class MVListInteractorImpl implements MVListInteractor<Map<String,List<MVList.MVBean>>> {
    private int i;

    public boolean isShowProgress() {
        return isShowProgress;
    }

    public void setShowProgress(boolean showProgress) {
        isShowProgress = showProgress;
    }

    private boolean isShowProgress=true;

    @Inject
    public MVListInteractorImpl() {
    }

    @Override
    public Subscription loadMVList( final int order, final int page, final int size, final RequestCallBack listener) {
        return RetrofitManager.getInstance(HostType.API_DONG_TING)
                .getMVTypeObservable()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MVType>() {
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
                    public void onNext(MVType mvType) {
                        KLog.d("父类执行次数" + i++);
                        final List<MVType.MVTypeBean.MVSubTypeBean> subTypeList=mvType.getData().get(order - 1).getSubType();
                        final Map<String, List<MVList.MVBean>> mvLists=new HashMap<String, List<MVList.MVBean>>();
                        final List<String> titleList=new ArrayList<String>();
                        final List<List<MVList.MVBean>> itemList=new ArrayList<List<MVList.MVBean>>();
                        Observable.from(subTypeList)
                                .concatMap(new Func1<MVType.MVTypeBean.MVSubTypeBean, Observable<MVList>>() {//返回observable集合
                                    @Override
                                    public Observable<MVList> call(MVType.MVTypeBean.MVSubTypeBean mvSubTypeBean) {
                                        KLog.d(mvSubTypeBean.getName());
                                        titleList.add(mvSubTypeBean.getName());

                                        return RetrofitManager.getInstance(HostType.API_DONG_TING)
                                                .getMVListObservable(mvSubTypeBean.getId(), order, page, getSize(mvSubTypeBean.getOrder()));
                                    }

                                })
                                .subscribeOn(Schedulers.io())
                                .unsubscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<MVList>() {
                                    @Override
                                    public void onCompleted() {
                                        if (itemList.size()==titleList.size()) {
                                            for (int i = 0; i < titleList.size(); i++) {
                                                mvLists.put(titleList.get(i),itemList.get(i));
                                            }
                                            listener.success(mvLists);
                                        }
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        e.printStackTrace();
                                        listener.onError(MyUtils.analyzeNetworkError(e));
                                    }

                                    @Override
                                    public void onNext(MVList mvList) {
                                        itemList.add(mvList.getData());


                                    }
                                });

                    }
                });
    }

    private int getSize(int order) {
        int size=0;
        switch (order) {
            case 1://高热
                size=6;
                break;
            case 2://神曲 后台bug size比所要求的少三个
                size=7;
                break;
            case 3://性感
                size=2;
                break;
            case 4://舞曲 后台bug size比所要求的少一个
                size=3;
                break;

            case 6://中国风
                size=4;
                break;
            case 7://爱情
                size=2;
                break;
            case 8://经典
                size=3;
                break;
            case 9://演唱会，后台bug size比所要求的少一个
                size=3;
                break;
            case 10://影视
                size=2;
                break;

        }
        return size;
    }
}
