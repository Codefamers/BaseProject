package com.qhn.bhne.baseproject.event;

import com.qhn.bhne.baseproject.mvp.entity.Banner;
import com.qhn.bhne.baseproject.mvp.entity.DataBean;
import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */
public class RecommendEvent {
    public RecommendEvent(List<Banner> bannerContent,RecommendContent recommendContent) {
        this.bannerContent = bannerContent;
        this.recommendContent = recommendContent;
    }

    private List<Banner> bannerContent;
    private RecommendContent recommendContent;

    public List<Banner> getBannerContent() {
        return bannerContent;
    }

    public void setBannerContent(List<Banner> bannerContent) {
        this.bannerContent = bannerContent;
    }

    public RecommendContent getRecommendContent() {
        return recommendContent;
    }

    public void setRecommendContent(RecommendContent recommendContent) {
        this.recommendContent = recommendContent;
    }
}
