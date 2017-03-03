package com.qhn.bhne.baseproject.mvp.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.mvp.entity.SearchSong;
import com.qhn.bhne.baseproject.mvp.entity.Songs;
import com.qhn.bhne.baseproject.mvp.ui.activities.SearchActivity;
import com.qhn.bhne.baseproject.mvp.ui.adapter.SingleSongAdapter;
import com.qhn.bhne.baseproject.net.RetrofitManager;
import com.socks.library.KLog;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by qhn
 * on 2017/2/25 0025.
 */

public class SearchSongFragment extends BaseFragment {
    @BindView(R.id.rec_single_music)
    RecyclerView recSingleMusic;
    @BindView(R.id.success_view)
    RelativeLayout successView;
    @Inject
    SingleSongAdapter singleSongAdapter;

    private String query;
    private int page=1;
    private int pageSize=20;

    @Override
    protected void initInjector() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_single_song;
    }

    @Override
    protected void initViews(View mFragmentView) {
        initRecyclerView();
        query=((SearchActivity)getContext()).getQuery();
        initData();
    }

    private void initData() {
        RetrofitManager.getInstance(HostType.HOT_TAG_SEARCH)
                .getSingleSongObservable("全部",query,page,pageSize)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Songs>>() {
                    @Override
                    public void onStart() {
                        super.onStart();

                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();

                        KLog.d("2222请求失败");

                    }

                    @Override
                    public void onNext(List<Songs> songs) {
                        singleSongAdapter.setList(songs);
                        singleSongAdapter.notifyDataSetChanged();


                    }
                });
    }

    private void initRecyclerView() {
        recSingleMusic.setLayoutManager(new LinearLayoutManager(getContext()));
        recSingleMusic.setAdapter(singleSongAdapter);
    }

    @Override
    protected View getSuccessView() {
        return successView;
    }


}
