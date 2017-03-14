package com.qhn.bhne.xhmusic.mvp.view;

import com.qhn.bhne.xhmusic.mvp.entity.SongMenu;
import com.qhn.bhne.xhmusic.mvp.view.base.BaseView;

import java.util.List;

/**
* Created by Administrator on 2017/02/27
*/

public interface SongMenuView<E> extends BaseView<E>{
    void refreshData(List<SongMenu> songMenu);
    void loadMoreData(List<SongMenu> songMenu);
}