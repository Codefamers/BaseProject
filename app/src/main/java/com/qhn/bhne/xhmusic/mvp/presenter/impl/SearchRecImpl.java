package com.qhn.bhne.xhmusic.mvp.presenter.impl;

import android.database.sqlite.SQLiteConstraintException;

import com.qhn.bhne.xhmusic.common.HostType;
import com.qhn.bhne.xhmusic.db.DaoSession;
import com.qhn.bhne.xhmusic.db.HistorySearchDao;
import com.qhn.bhne.xhmusic.event.RetryConnectNetEvent;
import com.qhn.bhne.xhmusic.mvp.entity.db.HistorySearch;
import com.qhn.bhne.xhmusic.mvp.entity.HotMusicTag;
import com.qhn.bhne.xhmusic.mvp.presenter.SearchRecommendPresenter;
import com.qhn.bhne.xhmusic.mvp.presenter.base.BasePresenterImpl;
import com.qhn.bhne.xhmusic.mvp.view.SearchMusicView;
import com.qhn.bhne.xhmusic.net.RetrofitManager;
import com.socks.library.KLog;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by qhn
 * on 2017/2/25 0025.
 */

public class SearchRecImpl extends BasePresenterImpl<SearchMusicView, List<HotMusicTag>> implements SearchRecommendPresenter {
    @Inject
    public SearchRecImpl() {
    }
    @Inject
    DaoSession daoSession;
    private HistorySearchDao historySearchDao;

    @Override
    public void success(List<HotMusicTag> data) {
        mView.loadSuccess(data);
    }



    @Override
    public void create() {
        initData();
        querySearchHis();
        mSubscription=rxBus.toObservable(RetryConnectNetEvent.class).subscribe(new Action1<RetryConnectNetEvent>() {
            @Override
            public void call(RetryConnectNetEvent retryConnectNetEvent) {
                initData();
                KLog.d("订阅成功");
            }
        });
    }

    private void querySearchHis() {
        historySearchDao = daoSession.getHistorySearchDao();
        daoSession.clear();
        mView.refreshSearchHistory(historySearchDao.loadAll());

    }

    private void initData() {
        RetrofitManager.getInstance(HostType.HOT_TAG_SEARCH)
                .getHotMusicTagObservable(10)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<HotMusicTag>>() {
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
                        KLog.d("1111请求失败");
                        e.printStackTrace();
                        onFail(e.getMessage());

                    }

                    @Override
                    public void onNext(List<HotMusicTag> hotMusicTagList) {
                        success(hotMusicTagList);
                    }
                });
    }


    @Override
    public void deleteHistoryRecord(HistorySearch historySearch) {
        daoSession.getHistorySearchDao().delete(historySearch);

    }

    @Override
    public void doSearch(String query) {
        mView.startResultFrg(query);
    }

    @Override
    public void saveHistoryRecord(HistorySearch historySearch) {
        try {
            historySearchDao.insert(historySearch);
        } catch (SQLiteConstraintException e) {
            e.printStackTrace();
        } finally {
            daoSession.clear();
            mView.refreshSearchHistory(historySearchDao.loadAll());

        }
    }


}
