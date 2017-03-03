package com.qhn.bhne.baseproject.mvp.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/28 0028.
 */
public class SongMenuType {

    private String categoryid;
    private String categoryname;
    @SerializedName("child")
    private List<ChildBean> SongMenuTypeChild;

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public List<ChildBean> getSongMenuTypeChild() {
        return SongMenuTypeChild;
    }

    public void setSongMenuTypeChild(List<ChildBean> SongMenuTypeChild) {
        this.SongMenuTypeChild = SongMenuTypeChild;
    }

    public static class ChildBean {
        /**
         * categoryid : 12
         * categoryname : 经典
         */

        private String categoryid;
        private String categoryname;

        public String getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(String categoryid) {
            this.categoryid = categoryid;
        }

        public String getCategoryname() {
            return categoryname;
        }

        public void setCategoryname(String categoryname) {
            this.categoryname = categoryname;
        }
    }
}


