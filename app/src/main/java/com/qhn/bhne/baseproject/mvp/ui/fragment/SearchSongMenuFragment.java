package com.qhn.bhne.baseproject.mvp.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.mvp.entity.SearchSongMenu;
import com.qhn.bhne.baseproject.mvp.ui.activities.SearchActivity;
import com.qhn.bhne.baseproject.mvp.ui.adapter.SearchSongMenuAdapter;
import com.qhn.bhne.baseproject.net.RetrofitManager;
import com.qhn.bhne.baseproject.utils.RxBus;
import com.socks.library.KLog;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */

public class SearchSongMenuFragment extends BaseFragment {
    @BindView(R.id.rec_single_music)
    RecyclerView recSongMenuMusic;
    @BindView(R.id.success_view)
    RelativeLayout successView;
    @Inject
    SearchSongMenuAdapter searchSongMenuAdapter;

    private String query;
    private int page = 1;
    private int pageSize = 20;

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
        initRec();
        query = ((SearchActivity) getContext()).getQuery();
        initData();
    }

    private void initData() {
        RetrofitManager.getInstance(HostType.HOT_TAG_SEARCH)
                .getSearchSongMenuObservable(query, page, pageSize)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<SearchSongMenu>>() {
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
                    public void onNext(List<SearchSongMenu> searchSongMenuList) {
                        searchSongMenuAdapter.setList(searchSongMenuList);
                        searchSongMenuAdapter.notifyDataSetChanged();


                    }
                });
    }

    private void initRec() {

        recSongMenuMusic.setLayoutManager(new LinearLayoutManager(getContext()));
        recSongMenuMusic.setAdapter(searchSongMenuAdapter);
    }

    @Override
    protected View getSuccessView() {
        return successView;
    }


}
