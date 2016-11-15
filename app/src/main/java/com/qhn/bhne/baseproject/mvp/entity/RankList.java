package com.qhn.bhne.baseproject.mvp.entity;

import java.util.List;

/**
 * Created by qhn
 * on 2016/11/6 0006.
 */
public class RankList {

    /**
     * code : 1
     * msg : ok
     * data : []
     * pageCount : 0
     * totalCount : 0
     * version : null
     */

    private int code;
    private String msg;
    private int pageCount;
    private int totalCount;
    private String version;
    private List<Object> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
