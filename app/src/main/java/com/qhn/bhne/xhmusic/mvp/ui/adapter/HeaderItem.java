package com.qhn.bhne.xhmusic.mvp.ui.adapter;

import android.view.View;

import com.qhn.bhne.xhmusic.R;

import butterknife.ButterKnife;
import kale.adapter.item.AdapterItem;

/**
 * Created by qhn
 * on 2016/11/8 0008.
 */
public class HeaderItem implements AdapterItem {
    @Override
    public int getLayoutResId() {
        return R.layout.item_song_menu_header;
    }

    @Override
    public void bindViews(View view) {
        ButterKnife.bind(this,view);
    }

    @Override
    public void setViews() {

    }

    @Override
    public void handleData(Object o, int i) {

    }
}
