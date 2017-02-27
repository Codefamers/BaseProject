package com.qhn.bhne.baseproject.mvp.entity;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */
public class ClassListBody {

    /**
     * platform : android
     * appid : 1005
     * mid : 271163335621854377768999610192375722565
     * clienttime : 1488112355
     * key : 216770e5216f9035d8e2dfbaec76ba89
     * clientver : 8493
     */

    private String platform="android";
    private String appid="1005";
    private String mid="271163335621854377768999610192375722565";
    private String clienttime="1488112355";
    private String key="216770e5216f9035d8e2dfbaec76ba89";
    private String clientver="8493";

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
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

    public String getClienttime() {
        return clienttime;
    }

    public void setClienttime(String clienttime) {
        this.clienttime = clienttime;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getClientver() {
        return clientver;
    }

    public void setClientver(String clientver) {
        this.clientver = clientver;
    }
}
