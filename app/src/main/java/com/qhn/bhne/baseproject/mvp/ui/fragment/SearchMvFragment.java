package com.qhn.bhne.baseproject.mvp.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.common.HostType;
import com.qhn.bhne.baseproject.mvp.entity.SearchMV;
import com.qhn.bhne.baseproject.mvp.ui.activities.SearchActivity;
import com.qhn.bhne.baseproject.mvp.ui.adapter.SearchMVAdapter;
import com.qhn.bhne.baseproject.net.RetrofitManager;
import com.qhn.bhne.baseproject.utils.MyUtils;
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
public class SearchMVFragment extends BaseFragment {
    @BindView(R.id.rec_single_music)
    RecyclerView recSearchMV;
    @BindView(R.id.success_view)
    RelativeLayout successView;
    private String query;
    private int page = 1;
    private int pageSize = 20;
    @Inject
    SearchMVAdapter searchMVAdapter;

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
        query = ((SearchActivity) getContext()).getQuery();
        initRec();
        initData();
    }

    private void initData() {
        RetrofitManager.getInstance(HostType.HOT_TAG_SEARCH)
                .getSearchMVObservable(query, page, pageSize)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<SearchMV>>() {
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
                    public void onNext(List<SearchMV> searchMVList) {

                        searchMVAdapter.setList(searchMVList);
                        searchMVAdapter.notifyDataSetChanged();


                    }
                });
    }

    private void initRec() {
        MyUtils.setGridRecyclerStyle(getActivity(), recSearchMV, 2, searchMVAdapter);

    }

    @Override
    protected View getSuccessView() {
        return successView;
    }


}
