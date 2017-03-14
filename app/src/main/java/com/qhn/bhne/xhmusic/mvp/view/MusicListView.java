package com.qhn.bhne.xhmusic.mvp.view;

import android.content.Context;
import android.view.ViewGroup;

/**
 * Created by qhn
 * on 2017/2/14 0014.
 */

public interface MusicListView{
    void initView(ViewGroup rootView, Context context);
    void updateSongMenuInfo( );
}
