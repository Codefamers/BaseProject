package com.qhn.bhne.baseproject.mvp.view;

import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;

/**
 * Created by qhn
 * on 2017/2/14 0014.
 */

public interface MusicListView extends BaseView{
    void updateSongMenuInfo(RecommendContent.DataBean.InfoBean.CustomSpecialBean.SpecialBean specialBean);
}
