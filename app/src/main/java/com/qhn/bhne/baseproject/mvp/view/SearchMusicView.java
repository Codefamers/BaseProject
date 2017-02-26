package com.qhn.bhne.baseproject.mvp.view;

import com.qhn.bhne.baseproject.mvp.entity.HistorySearch;
import com.qhn.bhne.baseproject.mvp.entity.HotMusicTag;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/24 0024.
 */

public interface SearchMusicView extends BaseView {
    void refreshSearchHistory(List<HistorySearch> hisSearchList);
    void showTag(List<HotMusicTag.DataBean.HotTagInfo> hotTagList);

    void startResultFrg(String query);
}
