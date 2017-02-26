package com.qhn.bhne.baseproject.mvp.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.mvp.entity.SingleSong;
import com.qhn.bhne.baseproject.mvp.ui.activities.SearchActivity;
import com.qhn.bhne.baseproject.mvp.ui.adapter.SingleSongAdapter;
import com.qhn.bhne.baseproject.net.RetrofitManager;
import com.qhn.bhne.baseproject.utils.RxBus;
import com.socks.library.KLog;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by qhn
 * on 2017/2/25 0025.
 */

public class SingleSongFragment extends BaseFragment {
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
                .subscribe(new Subscriber<SingleSong>() {
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
                    public void onNext(SingleSong singleSong) {
                        //Toast.makeText(getContext(), "请求成功"+singleSong.getData().getInfo().size(), Toast.LENGTH_SHORT).show();
                        KLog.d("请求成功"+singleSong.getData().getSongs().size());
                        singleSongAdapter.setList(singleSong.getData().getSongs());
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
