package com.qhn.bhne.xhmusic.mvp.ui.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.mvp.entity.BroadcastDetail;
import com.qhn.bhne.xhmusic.mvp.presenter.impl.BroadcastPresenterImpl;
import com.qhn.bhne.xhmusic.mvp.ui.adapter.ContactsPersonAdapter;
import com.qhn.bhne.xhmusic.mvp.view.BroadcastView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by qhn
 * on 2016/11/7 0007.
 */

public class BroadcastFragment extends BaseFragment<BroadcastPresenterImpl,List<List<BroadcastDetail>>> implements BroadcastView<List<List<BroadcastDetail>>> {

    @BindView(R.id.rec_song_menu)
    RecyclerView recBroadcastAdapter;
    @Inject
    BroadcastPresenterImpl songMenuPresenter;
    @Inject
    ContactsPersonAdapter adapter;


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
    public void loadSuccess(List<List<BroadcastDetail>> data) {
        super.loadSuccess(data);


        adapter.setList(data);

        adapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getActivity(), 2);
        recBroadcastAdapter.setItemAnimator(new DefaultItemAnimator());
        recBroadcastAdapter.setLayoutManager(linearLayoutManager);
        recBroadcastAdapter.setAdapter(adapter);

    }


}
