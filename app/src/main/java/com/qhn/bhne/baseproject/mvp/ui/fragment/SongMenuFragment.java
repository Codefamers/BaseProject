package com.qhn.bhne.baseproject.mvp.ui.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.entity.ChannelList;
import com.qhn.bhne.baseproject.mvp.entity.SongMenu;
import com.qhn.bhne.baseproject.mvp.presenter.impl.SongMenuPresenterImpl;
import com.qhn.bhne.baseproject.mvp.ui.adapter.ContactsPersonAdapter;
import com.qhn.bhne.baseproject.mvp.ui.adapter.SongMenuRecyclerAdapter;
import com.qhn.bhne.baseproject.mvp.view.SongMenuView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by qhn
 * on 2016/11/7 0007.
 */

public class SongMenuFragment extends BaseFragment implements SongMenuView {

    @BindView(R.id.rec_song_menu)
    RecyclerView recSongMenu;
    @Inject
    SongMenuPresenterImpl songMenuPresenter;
    @Inject
    SongMenuRecyclerAdapter songMenuAdapter;

    @Override
    protected void initInjector() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected View getSuccessView() {
        return recSongMenu;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_song_menu;
    }

    @Override
    protected void initViews(View mFragmentView) {
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
        initRecyclerView(data);


    }

    private void initRecyclerView(Object data) {
        ContactsPersonAdapter adapter = new ContactsPersonAdapter(getActivity(), (List<ChannelList.ChannelBean>) data);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getActivity(), 2);
        recSongMenu.setItemAnimator(new DefaultItemAnimator());
        recSongMenu.setLayoutManager(linearLayoutManager);
        recSongMenu.setAdapter(adapter);

    }


    @Override
    public void loadMore(Object data) {
        songMenuAdapter.addMore((List<SongMenu.SongMenuData>) data);
        songMenuAdapter.notifyDataSetChanged();
    }


}
