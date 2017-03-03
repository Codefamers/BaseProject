package com.qhn.bhne.baseproject.mvp.view;

import com.qhn.bhne.baseproject.mvp.entity.SongMenuType;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;

import java.util.List;

/**
* Created by Administrator on 2017/02/28
*/

public interface SongMenuTypeView<E> extends BaseView<E>{
   void  refreshData(List<SongMenuType> songMenuTypeList);
}