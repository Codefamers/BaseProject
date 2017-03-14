package com.qhn.bhne.xhmusic.mvp.presenter;

import com.qhn.bhne.xhmusic.mvp.entity.HistorySearch;
import com.qhn.bhne.xhmusic.mvp.presenter.base.BasePresenter;

/**
 * Created by qhn
 * on 2017/2/25 0025.
 */

public interface SearchRecommendPresenter extends BasePresenter {
    void deleteHistoryRecord(HistorySearch historySearch);
    void doSearch(String query);
    void saveHistoryRecord(HistorySearch historySearch);
}
