package com.qhn.bhne.baseproject.mvp.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.event.PlayMusicEvent;
import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;
import com.qhn.bhne.baseproject.mvp.presenter.impl.RecommendPresenterImpl;
import com.qhn.bhne.baseproject.mvp.ui.activities.PlayMusicActivity;
import com.qhn.bhne.baseproject.mvp.ui.adapter.HotMusicRecyclerAdapter;
import com.qhn.bhne.baseproject.playmusicDemo.SampleChooserActivity;
import com.qhn.bhne.baseproject.utils.RxBus;
import com.qhn.bhne.baseproject.wight.BannerView;
import com.qhn.bhne.baseproject.mvp.view.RecommendView;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.qhn.bhne.baseproject.wight.DisableScrollRecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by qhn
 * on 2016/11/2 0002.
 */

public class RecommendMusicFragment extends BaseFragment
        implements  OnRefreshListener,RecommendView {
    @BindView(R.id.rec_hot_music)
    DisableScrollRecyclerView recHotMusic;
    @BindView(R.id.rec_new_music)
    DisableScrollRecyclerView recNewMusic;
    @BindView(R.id.rec_good_mv)
    DisableScrollRecyclerView recGoodMV;
    @BindView(R.id.rec_exclusive_report)
    DisableScrollRecyclerView recEXCReport;
    @BindView(R.id.success_view)
    NestedScrollView successView;
    @Inject
    HotMusicRecyclerAdapter hotAdapter;
    public static final int HOT_ADAPTER = 1;
    @Inject
    HotMusicRecyclerAdapter newAdapter;
    public static final int NEW_ADAPTER = 2;
    @Inject
    HotMusicRecyclerAdapter goodMvAdapter;
    public static final int GOOD_MV_ADAPTER = 3;
    @Inject
    HotMusicRecyclerAdapter reportAdapter;
    public static final int REPORT_ADAPTER = 4;
    @Inject
    Activity activity;

    @Inject
    RecommendPresenterImpl recommendPresenter;
    @BindView(R.id.itn_all_listening)
    ImageButton itnAllListening;
    @BindView(R.id.img_banner)
    BannerView imgBanner;
    @BindView(R.id.itn_everyday_recommend_music)
    ImageButton itnEverydayRecommendMusic;
    @BindView(R.id.itn_new_music_rank)
    ImageButton itnNewMusicRank;
    @BindView(R.id.btn_hot_music)
    Button btnHotMusic;
    @BindView(R.id.btn_exclusive_report)
    Button btnExclusiveReport;
    @BindView(R.id.btn_new_music)
    Button btnNewMusic;
    @BindView(R.id.btn_good_mv)
    Button btnGoodMv;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View getSuccessView() {
        return successView;
    }

    @Override
    protected void initInjector() {
        fragmentComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend_music;
    }

    @Override
    protected void initViews(View mFragmentView) {
        setNeedLoadData(true);
        initPresenter();
        initSwipeRefreshLayout();
    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(getActivity().getResources().getIntArray(R.array.gplus_colors));
    }

    private void initPresenter() {
        mPresenter = recommendPresenter;
        mPresenter.attachView(this);//将view注入到Presenter中去
        mPresenter.create();

    }



    @Override
    public void loadSuccess(Object object) {
        super.loadSuccess(object);
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
        List<RecommendContent.DataBean> data = (List<RecommendContent.DataBean>) object;
        initRecyclerView(data);
       // RxBus.getInstance().post(new PlayMusicEvent(data.get(2).getData().get(1).));
        refreshBanner();
    }

    private void refreshBanner() {
        ArrayList<String> imageUrlList=new ArrayList<>();
        imageUrlList.add("http://pic.xiami.net/images/trade/ams_homepage/195/58370f164f6dc_9754208_1480003350.jpg");
        imageUrlList.add("http://pic.xiami.net/images/trade/ams_homepage/73/583515985d039_3695825_1479873944.jpg");
        imageUrlList.add("http://pic.xiami.net/images/trade/ams_homepage/160/58325730a150a_8038592_1479694128.jpg");
        imageUrlList.add("http://pic.xiami.net/images/trade/ams_homepage/191/58233bde52e46_9583561_1478704094.jpg");
        imageUrlList.add("http://pic.xiami.net/images/trade/ams_homepage/80/581995338de95_4026804_1478071603.jpg");
        imgBanner.setImageUrlList(imageUrlList,getActivity());

    }

    private void initRecyclerView(List<RecommendContent.DataBean> data) {
        hotAdapter.setList(data.get(3).getData());
        hotAdapter.setCategory(HOT_ADAPTER);
        MyUtils.setGridRecyclerStyle(getActivity(), recHotMusic, 3,hotAdapter);

        newAdapter.setList(data.get(5).getData());
        newAdapter.setCategory(NEW_ADAPTER);
        MyUtils.setGridRecyclerStyle(getActivity(), recNewMusic, 3,newAdapter);


        reportAdapter.setList(data.get(7).getData());
        reportAdapter.setCategory(REPORT_ADAPTER);
        MyUtils.setGridRecyclerStyle(getActivity(), recEXCReport, 3,reportAdapter);

        goodMvAdapter.setList(data.get(6).getData());
        goodMvAdapter.setCategory(GOOD_MV_ADAPTER);
        MyUtils.setGridRecyclerStyle(getActivity(), recGoodMV, 3,goodMvAdapter);
    }

    @Override
    public void onRefresh() {
        recommendPresenter.refreshData();
    }

    @OnClick({R.id.itn_all_listening, R.id.itn_everyday_recommend_music, R.id.itn_new_music_rank, R.id.btn_hot_music, R.id.btn_exclusive_report, R.id.btn_new_music, R.id.btn_good_mv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.itn_all_listening:
                Toast.makeText(activity, "所有人都在听", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), SampleChooserActivity.class));
                break;
            case R.id.itn_everyday_recommend_music:
                Toast.makeText(activity, "推荐音乐", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itn_new_music_rank:
                Toast.makeText(activity, "新歌排行", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_hot_music:
                Toast.makeText(activity, "热门音乐", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_exclusive_report:
                Toast.makeText(activity, "独家报道", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_new_music:
                Toast.makeText(activity, "新歌排行", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_good_mv:
                Toast.makeText(activity, "推荐MV", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
