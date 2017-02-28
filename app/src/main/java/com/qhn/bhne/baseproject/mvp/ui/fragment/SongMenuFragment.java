package com.qhn.bhne.baseproject.mvp.ui.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.listener.LoadMoreListener;
import com.qhn.bhne.baseproject.mvp.entity.SongMenuData;
import com.qhn.bhne.baseproject.mvp.presenter.impl.SongMenuPresenterImpl;
import com.qhn.bhne.baseproject.mvp.ui.adapter.SongMenuAdapter;
import com.qhn.bhne.baseproject.mvp.view.SongMenuView;
import com.qhn.bhne.baseproject.utils.MyUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
/**
 * Created by qhn
 * on 2017/2/27 0027.
 */
public class SongMenuFragment extends BaseFragment implements SongMenuView{
    @BindView(R.id.txt_song_menu_title)
    TextView txtSongMenuTitle;
    @BindView(R.id.rec_song_menu)
    RecyclerView recSongMenu;
    @BindView(R.id.ll_success_view)
    RelativeLayout llSuccessView;
    @Inject
    SongMenuAdapter songMenuAdapter;
    @Inject
    SongMenuPresenterImpl mPresenter;
    LoadMoreListener loadMoreListener;
    private int categoryID=0;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {

        if (this.categoryID!=categoryID) {
            mPresenter.loadData(1,pageSize,categoryID);
        }
        this.categoryID = categoryID;
    }

    private int page=0;
    private int pageSize=20;
    public interface  SongMenuFragmentListener{
        void chooseSongMenuType(int categoryID);
    }
    private SongMenuFragmentListener mListener;
    @Override
    protected void initInjector() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_song_menu;
    }

    @Override
    protected void initViews(View mFragmentView) {
        mListener= (SongMenuFragmentListener) getContext();
        initRec();
        mPresenter.attachView(this);
        mPresenter.create();
    }

    private void initRec() {
        songMenuAdapter.setList(new ArrayList<SongMenuData.DataBean.SongMenu>());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(), 2);
        recSongMenu.setItemAnimator(new DefaultItemAnimator());
        recSongMenu.setLayoutManager(gridLayoutManager);
        recSongMenu.setAdapter(songMenuAdapter);
        recSongMenu.setOnScrollListener(new LoadMoreListener(gridLayoutManager) {
            @Override
            public void onLoadMore() {
                mPresenter.loadData(page++,pageSize,categoryID);
            }
        });

    }

    @Override
    protected View getSuccessView() {
        return llSuccessView;
    }

    @OnClick(R.id.btn_choose_song_menu_type)
    public void onClick() {
        mListener.chooseSongMenuType(categoryID);
        Toast.makeText(getContext(), "选择分类", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loadSuccess(Object data) {
        super.loadSuccess(data);
        refreshData((SongMenuData) data);
    }

    @Override
    public void refreshData(SongMenuData songMenu) {
        songMenuAdapter.setList(songMenu.getData().getInfo());
        songMenuAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadMoreData(SongMenuData songMenu) {
        songMenuAdapter.addMore(songMenu.getData().getInfo());
        songMenuAdapter.notifyDataSetChanged();
    }




}
