package com.qhn.bhne.baseproject.mvp.ui.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.entity.BroadcastDetail;
import com.qhn.bhne.baseproject.mvp.presenter.impl.BroadcastPresenterImpl;
import com.qhn.bhne.baseproject.mvp.ui.adapter.ContactsPersonAdapter;
import com.qhn.bhne.baseproject.mvp.view.BroadcastView;
import com.socks.library.KLog;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by qhn
 * on 2016/11/7 0007.
 */

public class BroadcastFragment extends BaseFragment implements BroadcastView {

    @BindView(R.id.rec_song_menu)
    RecyclerView recBroadcastAdapter;
    @Inject
    BroadcastPresenterImpl songMenuPresenter;
    private ContactsPersonAdapter adapter;


    @Override
    protected void initInjector() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected View getSuccessView() {
        return recBroadcastAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_broadcast;
    }

    @Override
    protected void initViews(View mFragmentView) {
        initRecyclerView();
        initPresenter();
    }

    private void initPresenter() {
        setPresenter(songMenuPresenter);
        songMenuPresenter.attachView(this);
        songMenuPresenter.create();
    }

    @Override
    public void loadSuccess(Object data) {
        super.loadSuccess(data);

        List<List<BroadcastDetail.DataBean>> broadcastDetails = (List<List<BroadcastDetail.DataBean>>) data;

        adapter.setContentData(broadcastDetails);
        adapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        KLog.d("执行次数");
        adapter = new ContactsPersonAdapter(getContext(), null);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getActivity(), 2);
        recBroadcastAdapter.setItemAnimator(new DefaultItemAnimator());
        recBroadcastAdapter.setLayoutManager(linearLayoutManager);

        recBroadcastAdapter.setAdapter(adapter);

    }


}
