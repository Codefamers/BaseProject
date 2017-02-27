package com.qhn.bhne.baseproject.mvp.view;

import com.qhn.bhne.baseproject.mvp.entity.BannerContent;
import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;

import java.util.List;

/**
 * Created by qhn
 * on 2016/11/4 0004.
 */

public interface RecommendView<RecommendContent> extends BaseView {
   //void setSuccessData(List<RecommendContent.DataBean> data);//返回adapter数据
    void refreshBanner(BannerContent bannerContents);
    void refreshRec(com.qhn.bhne.baseproject.mvp.entity.RecommendContent.DataBean.InfoBean infoBean);

}
