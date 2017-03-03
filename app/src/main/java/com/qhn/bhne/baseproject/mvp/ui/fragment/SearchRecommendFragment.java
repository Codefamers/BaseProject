package com.qhn.bhne.baseproject.mvp.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ScrollView;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.entity.HistorySearch;
import com.qhn.bhne.baseproject.mvp.entity.HotMusicTag;
import com.qhn.bhne.baseproject.mvp.presenter.impl.SearchRecImpl;
import com.qhn.bhne.baseproject.mvp.ui.activities.WebActivity;
import com.qhn.bhne.baseproject.mvp.ui.adapter.HisSearchRecyclerViewAdapter;
import com.qhn.bhne.baseproject.mvp.view.SearchMusicView;
import com.qhn.bhne.baseproject.wight.FlowLayout;
import com.qhn.bhne.baseproject.wight.TagAdapter;
import com.qhn.bhne.baseproject.wight.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by qhn
 * on 2017/2/25 0025.
 */

public class SearchRecommendFragment extends BaseFragment<SearchRecImpl,List<HotMusicTag>> implements SearchMusicView<List<HotMusicTag>> {

    @BindView(R.id.tfl_hot_search)
    TagFlowLayout tflHotSearch;
    @BindView(R.id.rec_search_history)
    RecyclerView recSearchHistory;
    @BindView(R.id.ll_success_view)
    ScrollView scrSuccessView;
    Button txtHotTag;

    private List<HistorySearch> hisSearchList;
    private List<HotMusicTag> hotTagList;
    private SrfListener mListener;
    @Inject
    HisSearchRecyclerViewAdapter hisRecAdapter;
    @Inject
    SearchRecImpl mPresenter;


    private TagAdapter<HotMusicTag> tagAdapter;

    public SearchRecImpl getPresenter() {
        return mPresenter;
    }

    public interface SrfListener {
        void returnResultFrg(String query);
    }

    @Override
    protected void initInjector() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_recommend;
    }

    @Override
    protected void initViews(View mFragmentView) {

        mListener = (SrfListener) getContext();
        initSearchHistory();
        initHotTag();
        mPresenter.attachView(this);
        mPresenter.create();
    }

    private void initHotTag() {
        hotTagList = new ArrayList<>();
        final LayoutInflater mInflater = LayoutInflater.from(getContext());
        tagAdapter = new TagAdapter<HotMusicTag>(SearchRecommendFragment.this.hotTagList) {
            @Override
            public View getView(FlowLayout parent, int position, final HotMusicTag hotTag) {
                txtHotTag = (Button) mInflater.inflate(R.layout.tv,
                        tflHotSearch, false);
                txtHotTag.setText(hotTag.getKeyword());
                txtHotTag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HistorySearch historySearch = new HistorySearch(null, hotTag.getKeyword());
                        mPresenter.saveHistoryRecord(historySearch);
                        if (hotTag.getJumpurl().isEmpty()) {
                            mPresenter.doSearch(historySearch.getName());
                        } else {
                            startWeb(hotTag);
                        }
                    }

                });
                return txtHotTag;
            }
        };
        tflHotSearch.setAdapter(tagAdapter);
    }

    private void startWeb(HotMusicTag hotTagInfo) {
        Intent intent = new Intent(getContext(), WebActivity.class);
        intent.putExtra(WebActivity.JUMP_URL, hotTagInfo.getJumpurl());
        intent.putExtra(WebActivity.TITLE, hotTagInfo.getKeyword());
        startActivity(intent);
    }

    private void initSearchHistory() {
        hisSearchList = new ArrayList<>();
        hisRecAdapter.setList(hisSearchList);
        recSearchHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        recSearchHistory.setAdapter(hisRecAdapter);
        hisRecAdapter.setSearchRecommendFragment(this);

    }

    @Override
    protected View getSuccessView() {
        return scrSuccessView;
    }

    @Override
    public void loadSuccess(List<HotMusicTag> data) {
        super.loadSuccess(data);
        showTag(data);
    }

    @Override
    public void showTag(List<HotMusicTag> hotTagList) {
        this.hotTagList = hotTagList;
        //tflHotSearch.
        tagAdapter.setmTagDatas(hotTagList);
        tagAdapter.notifyDataChanged();
    }

    @Override
    public void startResultFrg(String query) {
        mListener.returnResultFrg(query);
    }


    @Override
    public void refreshSearchHistory(List<HistorySearch> hisSearchList) {
        hisRecAdapter.setList(hisSearchList);
        hisRecAdapter.notifyDataSetChanged();
    }
}
