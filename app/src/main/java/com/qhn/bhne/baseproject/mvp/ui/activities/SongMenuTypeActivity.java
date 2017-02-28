package com.qhn.bhne.baseproject.mvp.ui.activities;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.ui.activities.base.BaseActivity;

public class SongMenuTypeActivity extends BaseActivity {
    public static final int REQUEST_CODE = 563;
    int currentCategoryID=0;
    @Override
    protected void initViews() {
         final Intent in=new Intent(this,MainActivity.class);
        currentCategoryID=getIntent().getIntExtra(MainActivity.CHOOSE_SONG_MENU_TYPE,0);
        in.putExtra(MainActivity.CHOOSE_SONG_MENU_TYPE,23);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(REQUEST_CODE,in);
                finish();
            }
        });
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_song_menu_type;

    }

    public void startMainActivity(View view) {
        final Intent in=new Intent(this,MainActivity.class);
        in.putExtra(MainActivity.CHOOSE_SONG_MENU_TYPE,23);

        setResult(REQUEST_CODE,in);
        finish();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
