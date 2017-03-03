package com.qhn.bhne.baseproject.mvp.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.event.RecommendEvent;
import com.qhn.bhne.baseproject.mvp.entity.Banner;
import com.qhn.bhne.baseproject.mvp.entity.DataBean;
import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;
import com.qhn.bhne.baseproject.mvp.entity.SongMenuIntro;
import com.qhn.bhne.baseproject.mvp.presenter.impl.RecommendPresenterImpl;
import com.qhn.bhne.baseproject.mvp.ui.activities.MusicListActivity;
import com.qhn.bhne.baseproject.mvp.ui.activities.WebActivity;
import com.qhn.bhne.baseproject.mvp.ui.adapter.HotMusicRecyclerAdapter;
import com.qhn.bhne.baseproject.mvp.ui.adapter.ReportAdapter;
import com.qhn.bhne.baseproject.mvp.view.RecommendView;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.qhn.bhne.baseproject.wight.BannerView;
import com.qhn.bhne.baseproject.wight.DisableScrollRecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static com.qhn.bhne.baseproject.common.Constants.SONG_MENU;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */

public class KuGouRecommendMusicFragment extends BaseFragment<RecommendPresenterImpl,RecommendEvent> implements RecommendView<RecommendEvent>, BannerView.BannerViewOnclickListener, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.img_banner)
    BannerView imgBanner;
    @BindView(R.id.itn_all_listening)
    ImageButton itnAllListening;
    @BindView(R.id.itn_everyday_recommend_music)
    ImageButton itnEverydayRecommendMusic;
    @BindView(R.id.itn_new_music_rank)
    ImageButton itnNewMusicRank;
    @BindView(R.id.btn_hot_music)
    Button btnHotMusic;
    @BindView(R.id.rec_hot_music)
    DisableScrollRecyclerView recHotMusic;
    @BindView(R.id.btn_exclusive_report)
    Button btnExclusiveReport;
    @BindView(R.id.rec_exclusive_report)
    DisableScrollRecyclerView recExclusiveReport;
    @BindView(R.id.btn_new_music)
    Button btnNewMusic;
    @BindView(R.id.rec_new_music)
    DisableScrollRecyclerView recNewMusic;
    @BindView(R.id.btn_good_mv)
    Button btnGoodMv;
    @BindView(R.id.rec_good_mv)
    DisableScrollRecyclerView recGoodMv;
    @BindView(R.id.success_view)
    NestedScrollView successView;
    @BindView(R.id.txt_test)
    TextView textView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
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
    ReportAdapter reportAdapter;
    public static final int REPORT_ADAPTER = 4;
    @Inject
    RecommendPresenterImpl recommendPresenter;
    private List<Banner> imageUrlList;
    @Inject
    Activity activity;

    //每日推荐歌单
    private SongMenuIntro specialBean;
    private SongMenuIntro privateFM;

    @Override
    protected void initInjector() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend_music;
    }

    @Override
    protected void initViews(View mFragmentView) {
        initRec();
        imgBanner.setBannerViewOnclickListener(this);
        initSwipeRefreshLayout();
        recommendPresenter.attachView(this);
        recommendPresenter.create();
    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(getActivity().getResources().getIntArray(R.array.gplus_colors));
    }

    private void initRec() {

        hotAdapter.setCategory(HOT_ADAPTER);
        MyUtils.setGridRecyclerStyle(getActivity(), recHotMusic, 3, hotAdapter);


        newAdapter.setCategory(NEW_ADAPTER);
        MyUtils.setGridRecyclerStyle(getActivity(), recNewMusic, 3, newAdapter);


        MyUtils.setGridRecyclerStyle(getActivity(), recExclusiveReport, 1, reportAdapter);

        goodMvAdapter.setCategory(GOOD_MV_ADAPTER);
        MyUtils.setGridRecyclerStyle(getActivity(), recGoodMv, 2, goodMvAdapter);
    }


    @Override
    protected View getSuccessView() {
        return successView;
    }

    @Override
    public void loadSuccess(RecommendEvent data) {
        super.loadSuccess(data);
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
        RecommendContent recommendContent=data.getRecommendContent();
        List<Banner> bc=data.getBannerContent();
        refreshRec(recommendContent);


        refreshBanner(bc);
        specialBean = recommendContent.getCustom_special().get(0).getSpecial().get(1);
        privateFM = recommendContent.getCustom_special().get(0).getSpecial().get(0);

    }

    @Override
    public void refreshRec(RecommendContent recommendContent) {

        List<RecommendContent.AlbumBean>
                albumBeanList = recommendContent.getAlbum();
        newAdapter.setList(albumBeanList);
        newAdapter.notifyDataSetChanged();
        List<RecommendContent.RecommendBean>
                recommendBeenList = recommendContent.getRecommend();
        hotAdapter.setList(recommendBeenList.subList(0, 6));
        hotAdapter.notifyDataSetChanged();

        List<RecommendContent.VlistBean> vlistBeanList = recommendContent.getVlist();
        goodMvAdapter.setList(vlistBeanList);
        goodMvAdapter.notifyDataSetChanged();

        List<RecommendContent.TopicBean> topicBeanList = recommendContent.getTopic();
        reportAdapter.setList(topicBeanList);
        reportAdapter.notifyDataSetChanged();
    }


    @Override
    public void refreshBanner(List<Banner> bannerList) {


        imgBanner.setImageUrlList(bannerList, getActivity());
    }

    @Override
    public void onClickBanner(View v, int currentItem) {
        if (!imageUrlList.isEmpty()) {
            Intent in = new Intent(getContext(), WebActivity.class);
            in.putExtra(WebActivity.JUMP_URL, imageUrlList.get(currentItem).getExtra().getInnerurl());
            in.putExtra(WebActivity.TITLE, imageUrlList.get(currentItem).getTitle());
            startActivity(in);

        }

    }

    @OnClick({R.id.itn_all_listening, R.id.itn_everyday_recommend_music, R.id.itn_new_music_rank, R.id.btn_hot_music, R.id.btn_exclusive_report, R.id.btn_new_music, R.id.btn_good_mv})
    public void onClick(View view) {
        Intent in = new Intent(activity, MusicListActivity.class);
        switch (view.getId()) {

            case R.id.itn_all_listening:
                in.putExtra(SONG_MENU, privateFM);
                startActivity(in);

                break;
            case R.id.itn_everyday_recommend_music:
                in.putExtra(SONG_MENU, specialBean);
                startActivity(in);
                //Toast.makeText(activity, "推荐音乐", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itn_new_music_rank:
                in.putExtra(SONG_MENU, specialBean);
                startActivity(in);
                Toast.makeText(activity, "新歌排行", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_hot_music:
                testData();
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

    private void testData() {


       /* RetrofitManager.getInstance(HostType.KU_GOU_FM_TYPE)
                .getBroadcastTypeObservable(new ClassListBody())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BroadcastType>() {
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

                    }

                    @Override
                    public void onNext(BroadcastType songMenu) {
                        KLog.d("请求成功777"+songMenu.getData().size());

                    }
                });
        RetrofitManager.getInstance(HostType.KU_GOU_FM_TYPE)
                .getBroadcastDetailObservable(new SongListFM())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BroadcastDetail>() {
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

                    }

                    @Override
                    public void onNext(BroadcastDetail songMenu) {
                        KLog.d("请求成功666"+songMenu.getData().size());

                    }
                });*/
    }

    @Override
    public void onRefresh() {
        recommendPresenter.create();
    }
}
