package com.qhn.bhne.baseproject.mvp.presenter.impl;

import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.event.RetryConnectNetEvent;
import com.qhn.bhne.baseproject.mvp.entity.DataBean;
import com.qhn.bhne.baseproject.mvp.entity.MusicList;
import com.qhn.bhne.baseproject.mvp.entity.Songs;
import com.qhn.bhne.baseproject.mvp.entity.SpecialSong;
import com.qhn.bhne.baseproject.mvp.model.MusicListInteractor;
import com.qhn.bhne.baseproject.mvp.model.impl.MusicListInteractorImpl;
import com.qhn.bhne.baseproject.mvp.presenter.base.BasePresenterImpl;
import com.qhn.bhne.baseproject.mvp.view.MusicListView;
import com.qhn.bhne.baseproject.net.RetrofitManager;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class MusicListPresentImpl extends BasePresenterImpl<MusicListView,List<Songs>> {
    //private MusicRankInteractorImpl musicRankInteractor;
    private MusicListInteractor<MusicList> musicListInteractor;
    private int specialid;
    private int pageSize = 30;
    private int page = 1;

    public int getSpecialid() {
        return specialid;
    }

    public void setSpecialid(int specialid) {
        this.specialid = specialid;
    }

    @Inject
    public MusicListPresentImpl(MusicListInteractorImpl musicRankInteractor) {
        this.musicListInteractor = musicRankInteractor;
    }

    @Override
    public void success(List<Songs> data) {
        mView.loadSuccess(data);
    }


    @Override
    public void create() {
        mSubscription = rxBus.toObservable(RetryConnectNetEvent.class).subscribe(new Action1<RetryConnectNetEvent>() {
            @Override
            public void call(RetryConnectNetEvent retryConnectNetEvent) {
                loadData(specialid);
            }
        });
        loadData(specialid);
    }

    private void loadData(int specialid) {
        RetrofitManager.getInstance(HostType.MOBILECDN_KUGOU)
                .getKugouSongObservable(specialid, page, pageSize)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Songs>>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        beforeRequest();

                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Songs> dataBean) {
                        success(dataBean);
                    }
                });
    }


}
