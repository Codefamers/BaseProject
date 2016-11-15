package com.qhn.bhne.baseproject.mvp.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.entity.MusicRank;
import com.qhn.bhne.baseproject.mvp.presenter.MusicRankPresenter;
import com.qhn.bhne.baseproject.mvp.presenter.impl.MusicRankPresenterImpl;
import com.qhn.bhne.baseproject.mvp.ui.adapter.MusicRankAdapter;
import com.qhn.bhne.baseproject.mvp.view.MusicRankView;
import com.qhn.bhne.baseproject.utils.MyUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by qhn
 * on 2016/11/7 0007.
 */

public class RankFragment extends BaseFragment implements MusicRankView {
    @Inject
    MusicRankPresenterImpl musicRankPresenter;
    @BindView(R.id.rec_music_rank)
    RecyclerView recMusicRank;
    @BindView(R.id.success_view)
    RelativeLayout successView;
    @Inject
    MusicRankAdapter musicRankAdapter;

    @Override
    protected void initInjector() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_music_rank;
    }

    @Override
    protected void initViews(View mFragmentView) {
        initPresenter();
    }

    private void initPresenter() {
        mPresenter = musicRankPresenter;
        musicRankPresenter.attachView(this);
        musicRankPresenter.create();
    }

    @Override
    protected View getSuccessView() {

        return successView;
    }

    @Override
    public void loadSuccess(Object data) {
        super.loadSuccess(data);
        musicRankAdapter.setList((List<MusicRank.DataBean.InfoBean>) data);

        MyUtils.setGridRecyclerStyle(getActivity(), recMusicRank, 1, musicRankAdapter);
    }
}
