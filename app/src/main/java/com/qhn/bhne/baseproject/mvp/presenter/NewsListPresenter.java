package com.qhn.bhne.baseproject.mvp.presenter;

import com.qhn.bhne.baseproject.mvp.presenter.base.BasePresenter;

/**
 * Created by qhn
 * on 2016/10/31 0031.
 */

public interface NewsListPresenter extends BasePresenter{
    void setNewsTypeAndId(String newsTypeAndId,String newsId);
    void refreshData();
    void loadMore();
}
