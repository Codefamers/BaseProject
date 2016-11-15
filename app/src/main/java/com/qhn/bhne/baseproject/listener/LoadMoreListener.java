package com.qhn.bhne.baseproject.listener;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.socks.library.KLog;

/**
 * Created by qhn
 * on 2016/11/7 0007.
 */

public abstract class LoadMoreListener extends RecyclerView.OnScrollListener {
    //声明一个LinearLayoutManager
    private GridLayoutManager linearLayoutManager;
    //当前页，从0开始
    private int currentPage = 0;
    //已经加载出来的Item的数量
    private int totalItemCount;

    //主要用来存储上一个totalItemCount
    private int previousTotal = 0;

    //在屏幕上可见的item数量
    private int visibleItemCount;

    //在屏幕可见的Item中的第一个
    private int firstVisibleItem;

    //是否正在上拉数据
    private boolean loading = true;

   /* public LoadMoreListener(LinearLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }*/

    public LoadMoreListener(GridLayoutManager gridLayoutManager) {
        this.linearLayoutManager = gridLayoutManager;
    }

    /*scroll_state_idle=0//闲置状态
      scroll_state_dragging=1//控制滚动
      scroll_state_settling=2//自己滚动
    * */
    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        int totalItemNum = linearLayoutManager.getItemCount();//获取adapter中item的个数
        int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        int visibleItemNum = linearLayoutManager.getChildCount();//出现在当前窗口的item的数量
        KLog.d("所有数量" + totalItemNum + "\n最后一个item的位置" + lastVisibleItemPosition + "\n可见数目" + visibleItemNum);
        if (visibleItemNum > 0 && newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition >= totalItemNum - 1) {
            onLoadMore();
        }
    }


    /**
     * 提供一个抽闲方法，在Activity中监听到这个EndLessOnScrollListener
     * 并且实现这个方法
     */
    public abstract void onLoadMore();
}
