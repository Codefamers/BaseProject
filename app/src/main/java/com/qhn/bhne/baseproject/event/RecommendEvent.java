package com.qhn.bhne.baseproject.event;

import com.qhn.bhne.baseproject.mvp.entity.BannerContent;
import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */
public class RecommendEvent {
    private BannerContent bannerContent;
    private RecommendContent recommendContent;

    public RecommendEvent(RecommendContent recommendContent, BannerContent bannerContent) {
        this.recommendContent = recommendContent;
        this.bannerContent = bannerContent;
    }

    public BannerContent getBannerContent() {
        return bannerContent;
    }

    public void setBannerContent(BannerContent bannerContent) {
        this.bannerContent = bannerContent;
    }

    public RecommendContent getRecommendContent() {
        return recommendContent;
    }

    public void setRecommendContent(RecommendContent recommendContent) {
        this.recommendContent = recommendContent;
    }


}
