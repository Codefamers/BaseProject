package com.qhn.bhne.baseproject.mvp.ui.activities;


import android.os.Bundle;
import android.view.MenuItem;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.ui.activities.base.BaseActivity;

public class PlayMusicActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    protected void initViews() {

    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_play_music;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
