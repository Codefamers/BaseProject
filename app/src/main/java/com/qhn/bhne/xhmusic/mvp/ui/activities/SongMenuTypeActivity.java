package com.qhn.bhne.xhmusic.mvp.ui.activities;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.listener.ClickAdapterItemListener;
import com.qhn.bhne.xhmusic.mvp.entity.SongMenuType;
import com.qhn.bhne.xhmusic.mvp.presenter.impl.SongMenuTypePresenterImpl;
import com.qhn.bhne.xhmusic.mvp.ui.adapter.SongMenuTypeAdapter;
import com.qhn.bhne.xhmusic.mvp.view.SongMenuTypeView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class SongMenuTypeActivity extends BaseLoadDataActivity<SongMenuTypePresenterImpl,List<SongMenuType>>implements SongMenuTypeView<List<SongMenuType>>, ClickAdapterItemListener<SongMenuType.ChildBean> {
    public static final int REQUEST_CODE = 563;
    int currentCategoryID = 0;
    @Inject
    SongMenuTypePresenterImpl mPresenter;
    @Inject
    SongMenuTypeAdapter mAdapter;
    @BindView(R.id.rec_song_menu)
    RecyclerView recSongMenu;

    @Override
    protected void initViews() {
        currentCategoryID = getIntent().getIntExtra(MainActivity.CHOOSE_SONG_MENU_TYPE, 0);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initRec();
        mPresenter.attachView(this);
        mPresenter.create();
    }

    private void initRec() {

        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 5);
        mAdapter.setItemListener(this);
        recSongMenu.setLayoutManager(linearLayoutManager);
        recSongMenu.setAdapter(mAdapter);

    }

    @Override
    protected void initInjector() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_song_menu_type;

    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }


    @Override
    protected View getSuccessView() {
        return recSongMenu;
    }

    @Override
    public void loadSuccess(List<SongMenuType> data) {
        super.loadSuccess(data);

        refreshData(data);
    }

    @Override
    public void refreshData(List<SongMenuType> songMenuTypeList) {
        mAdapter.setList(songMenuTypeList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(SongMenuType.ChildBean childBean,int position) {
        Intent in = new Intent(this, MainActivity.class);
        in.putExtra(MainActivity.CHOOSE_SONG_MENU_TYPE, Integer.parseInt(childBean.getCategoryid()));
        setResult(REQUEST_CODE, in);
        finish();
    }
}
