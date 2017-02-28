package com.qhn.bhne.baseproject.mvp.view;

import com.qhn.bhne.baseproject.mvp.entity.SongMenuData;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;

/**
* Created by Administrator on 2017/02/27
*/

public interface SongMenuView extends BaseView{
    void refreshData(SongMenuData songMenu);
    void loadMoreData(SongMenuData songMenu);
}