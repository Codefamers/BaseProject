package com.qhn.bhne.baseproject.mvp.presenter;

import com.qhn.bhne.baseproject.mvp.entity.Songs;
import com.qhn.bhne.baseproject.mvp.model.MusicListModel;
import com.qhn.bhne.baseproject.mvp.presenter.base.BasePresenter;

import java.util.List;
import java.util.Map;

/**
 * Created by qhn
 * on 2017/2/14 0014.
 */

public interface MusicListPresenter extends BasePresenter{
    void loadData(Map<String, Integer> paramsMap,boolean isShowProgress);
    void setMapParams(Map<String, Integer> paramsMap);
    void setModelImpl(MusicListModel<List<Songs>> musicListModel);
}
