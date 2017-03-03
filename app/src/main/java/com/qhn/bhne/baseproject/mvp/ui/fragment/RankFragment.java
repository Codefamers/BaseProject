package com.qhn.bhne.baseproject.mvp.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.di.scope.ContextLife;
import com.qhn.bhne.baseproject.listener.ClickAdapterItemListener;
import com.qhn.bhne.baseproject.mvp.entity.MusicRank;
import com.qhn.bhne.baseproject.mvp.entity.SongMenuIntro;
import com.qhn.bhne.baseproject.mvp.presenter.impl.MusicRankPresenterImpl;
import com.qhn.bhne.baseproject.mvp.ui.activities.MusicListActivity;
import com.qhn.bhne.baseproject.mvp.ui.adapter.MusicRankAdapter;
import com.qhn.bhne.baseproject.mvp.view.MusicRankView;
import com.qhn.bhne.baseproject.utils.MyUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

import static com.qhn.bhne.baseproject.common.Constants.SONG_MENU;

/**
 * Created by qhn
 * on 2016/11/7 0007.
 */

public class RankFragment extends BaseFragment<MusicRankPresenterImpl,List<MusicRank>> implements MusicRankView<List<MusicRank>>,ClickAdapterItemListener<MusicRank> {

    @BindView(R.id.rec_music_rank)
    RecyclerView recMusicRank;
    @BindView(R.id.success_view)
    RelativeLayout successView;
    @Inject
    MusicRankAdapter musicRankAdapter;
    @Inject
    MusicRankPresenterImpl musicRankPresenter;

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
        musicRankPresenter.attachView(this);
        musicRankPresenter.create();
    }

    @Override
    protected View getSuccessView() {

        return successView;
    }

    @Override
    public void loadSuccess(List<MusicRank> data) {
        super.loadSuccess(data);
        musicRankAdapter.setList(data);
        MyUtils.setGridRecyclerStyle(getActivity(), recMusicRank, 1, musicRankAdapter);
    }

    @Override
    public void onClick(MusicRank data) {
        Intent intent=new Intent(getActivity(), MusicListActivity.class);
        SongMenuIntro songMenuIntro=new SongMenuIntro(999,data.getIntro(),99,0,null,data.getBannerurl(),data.getRankname(),999);
        intent.putExtra(SONG_MENU,songMenuIntro);
        startActivity(intent);
    }
}
