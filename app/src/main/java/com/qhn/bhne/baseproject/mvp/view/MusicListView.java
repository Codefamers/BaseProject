package com.qhn.bhne.baseproject.mvp.view;

import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;
import com.qhn.bhne.baseproject.mvp.entity.SongMenuIntro;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;

/**
 * Created by qhn
 * on 2017/2/14 0014.
 */

public interface MusicListView<E> extends BaseView<E>{
    void updateSongMenuInfo(SongMenuIntro specialBean);
}
