package com.qhn.bhne.baseproject.mvp.presenter;

import com.qhn.bhne.baseproject.mvp.entity.HistorySearch;
import com.qhn.bhne.baseproject.mvp.presenter.base.BasePresenter;

/**
 * Created by qhn
 * on 2017/2/25 0025.
 */

public interface SearchRecommendPresenter extends BasePresenter {
    void deleteHistoryRecord(HistorySearch historySearch);
    void doSearch(String query);
    void saveHistoryRecord(HistorySearch historySearch);
}
