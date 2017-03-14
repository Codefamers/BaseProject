package com.qhn.bhne.xhmusic.mvp.entity;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */
public class SongListFM {

    /**
     * platform : android
     * pagesize : 20
     * clienttime : 1488115725
     * page : 1
     * clientver : 8493
     * appid : 1005
     * mid : 271163335621854377768999610192375722565
     * fmtype : 2
     * songcount : 1
     * key : 499c0814f73a68516c7b9135848e0a51
     * classid : 7
     */

    private String platform="android";
    private int pagesize=20;
    private String clienttime="1488115725";
    private int page=1;
    private String clientver="8493";
    private String appid="1005";
    private String mid="271163335621854377768999610192375722565";
    private int fmtype=2;
    private int songcount=1;
    private String key="499c0814f73a68516c7b9135848e0a51";
    private int classid=7;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public String getClienttime() {
        return clienttime;
    }

    public void setClienttime(String clienttime) {
        this.clienttime = clienttime;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getClientver() {
        return clientver;
    }

    public void setClientver(String clientver) {
        this.clientver = clientver;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public int getFmtype() {
        return fmtype;
    }

    public void setFmtype(int fmtype) {
        this.fmtype = fmtype;
    }

    public int getSongcount() {
        return songcount;
    }

    public void setSongcount(int songcount) {
        this.songcount = songcount;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }
}
