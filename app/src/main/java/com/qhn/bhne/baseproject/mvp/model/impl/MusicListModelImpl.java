package com.qhn.bhne.baseproject.mvp.model.impl;

import android.os.Parcel;
import android.os.Parcelable;

import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.listener.RequestCallBack;
import com.qhn.bhne.baseproject.mvp.entity.Songs;
import com.qhn.bhne.baseproject.mvp.model.MusicListModel;
import com.qhn.bhne.baseproject.net.RetrofitManager;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by qhn
 * on 2017/2/14 0014.
 */

public class MusicListModelImpl implements MusicListModel<List<Songs>>,Parcelable {

    @Inject
    public MusicListModelImpl() {
    }

    @Override
    public Subscription loadMusicList(Map<String, Integer> paramsMap, final boolean isShowProgress, final RequestCallBack<List<Songs>> listener) {
        return RetrofitManager.getInstance(HostType.MOBILECDN_KUGOU)
                .getKugouSongObservable(paramsMap)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Songs>>() {
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
                        listener.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Songs> dataBean) {
                        listener.success(dataBean);
                    }
                });
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    protected MusicListModelImpl(Parcel in) {
    }

    public static final Parcelable.Creator<MusicListModelImpl> CREATOR = new Parcelable.Creator<MusicListModelImpl>() {
        @Override
        public MusicListModelImpl createFromParcel(Parcel source) {
            return new MusicListModelImpl(source);
        }

        @Override
        public MusicListModelImpl[] newArray(int size) {
            return new MusicListModelImpl[size];
        }
    };
}
