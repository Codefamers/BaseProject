package com.qhn.bhne.xhmusic.mvp.view;

import com.qhn.bhne.xhmusic.mvp.entity.HistorySearch;
import com.qhn.bhne.xhmusic.mvp.view.base.BaseView;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/24 0024.
 */

public interface SearchMusicView<E> extends BaseView<E> {
    void refreshSearchHistory(List<HistorySearch> hisSearchList);
    void showTag(E hotTagList);

    void startResultFrg(String query);
}
