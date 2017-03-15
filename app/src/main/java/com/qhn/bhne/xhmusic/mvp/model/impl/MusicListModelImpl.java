package com.qhn.bhne.xhmusic.mvp.model.impl;

import android.os.Parcel;
import android.os.Parcelable;

import com.qhn.bhne.xhmusic.common.HostType;
import com.qhn.bhne.xhmusic.listener.RequestCallBack;
import com.qhn.bhne.xhmusic.mvp.entity.db.SongInfo;
import com.qhn.bhne.xhmusic.mvp.entity.Songs;
import com.qhn.bhne.xhmusic.mvp.model.MusicListModel;
import com.qhn.bhne.xhmusic.net.RetrofitManager;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by qhn
 * on 2017/2/14 0014.
 */

public class MusicListModelImpl implements MusicListModel<List<Songs>>, Parcelable {

    @Inject
    public MusicListModelImpl() {
    }

    @Override
    public Subscription loadMusicList(Map<String, Integer> paramsMap, final boolean isShowProgress, final RequestCallBack<List<Songs>> listener) {
        Observable<List<Songs>> songsObservable = RetrofitManager.getInstance(HostType.MOBILECDN_KUGOU)
                .getKugouSongObservable(paramsMap);
        Observable<List<SongInfo>> songInfoObservable = songsObservable.flatMap(new Func1<List<Songs>, Observable<Songs>>() {
            @Override
            public Observable<Songs> call(List<Songs> songs) {
                return Observable.from(songs);
            }
        }).flatMap(new Func1<Songs, Observable<SongInfo>>() {
            @Override
            public Observable<SongInfo> call(final Songs songs) {
                return RetrofitManager.getInstance(HostType.SONG_INFO).getSongInfoObservable(songs.getHash());

            }
        }).toList();
        return Observable.zip(songsObservable, songInfoObservable, new Func2<List<Songs>, List<SongInfo>, List<Songs>>() {
            @Override
            public List<Songs> call(List<Songs> songs, List<SongInfo> songInfos) {
                for (int i = 0; i < songs.size(); i++) {
                    songs.get(i).setSongInfo(songInfos.get(i));
                }
                return songs;
            }
        }).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<List<Songs>>() {
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
        /*mergeWith(songsObservable)
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
                        });*/
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
