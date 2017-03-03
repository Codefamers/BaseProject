package com.qhn.bhne.baseproject.mvp.view;

import com.qhn.bhne.baseproject.mvp.entity.Banner;
import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;
import com.qhn.bhne.baseproject.mvp.view.base.BaseView;

import java.util.List;

/**
 * Created by qhn
 * on 2016/11/4 0004.
 */

public interface RecommendView<E> extends BaseView<E> {
    void refreshBanner(List<Banner> bannerList);

    void refreshRec(RecommendContent recommendContent);

}
