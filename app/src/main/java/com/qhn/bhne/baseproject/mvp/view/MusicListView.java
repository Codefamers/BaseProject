package com.qhn.bhne.baseproject.mvp.view;

import android.content.Context;
import android.view.ViewGroup;

import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;
import com.qhn.bhne.baseproject.mvp.entity.SongMenuIntro;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;

/**
 * Created by qhn
 * on 2017/2/14 0014.
 */

public interface MusicListView{
    void initView(ViewGroup rootView, Context context);
    void updateSongMenuInfo( );
}
