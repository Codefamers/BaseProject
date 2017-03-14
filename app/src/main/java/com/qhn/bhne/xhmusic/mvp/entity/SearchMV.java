package com.qhn.bhne.xhmusic.mvp.entity;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */
public class SearchMV {


    /**
     * filename : 《歌手2017</em>》宣传片
     * duration : 50
     * hash : cd49ef56643ce9329fe781a311918a25
     * intro :
     * imgurl : http://imge.kugou.com/mvhdpic/{size}/20170112/20170112094426533400.jpg
     * album_id :
     * publishdate : 2017-01-11 18:56:11
     * singername : 光良
     * topic :
     */

    private String filename;
    private int duration;
    private String hash;
    private String intro;
    private String imgurl;
    private String album_id;
    private String publishdate;
    private String singername;
    private String topic;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}

