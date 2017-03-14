package com.qhn.bhne.xhmusic.mvp.view;

import com.qhn.bhne.xhmusic.mvp.entity.SongMenuType;
import com.qhn.bhne.xhmusic.mvp.view.base.BaseView;

import java.util.List;

/**
* Created by Administrator on 2017/02/28
*/

public interface SongMenuTypeView<E> extends BaseView<E>{
   void  refreshData(List<SongMenuType> songMenuTypeList);
}