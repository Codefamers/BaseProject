package com.qhn.bhne.baseproject.mvp.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class SongMenuIntro implements Parcelable {
    public SongMenuIntro(int specialid,int collectcount, String intro, int songcount, int play_count, String user_name, String imgurl, String specialname, int slid) {
        this.collectcount = collectcount;
        this.intro = intro;
        this.songcount = songcount;
        this.play_count = play_count;
        this.user_name = user_name;
        this.imgurl = imgurl;
        this.specialname = specialname;
        this.slid = slid;
        this.specialid=specialid;
    }

    /**
     * play_count : 5156028
     * specialname : 粤语好歌 值得反复聆听
     * publishtime : 2016-11-30
     * singername :
     * verified : 0
     * songcount : 47
     * imgurl : http://imge.kugou.com/soft/collection/{size}/20161130/20161130175801678009.jpg
     * intro : 始终觉得删了可惜的歌哦！
     * suid : 509005376
     * specialid : 120724
     * collectcount : 5684
     * user_name : 天使的守护
     * slid : 29
     */

    private int play_count;
    private String specialname;
    private String publishtime;
    private String singername;
    private int verified;
    private int songcount;
    private String imgurl;
    private String intro;
    private int suid;
    private int specialid;
    private int collectcount;
    private String user_name;
    private int slid;

    public int getPlay_count() {
        return play_count;
    }

    public void setPlay_count(int play_count) {
        this.play_count = play_count;
    }

    public String getSpecialname() {
        return specialname;
    }

    public void setSpecialname(String specialname) {
        this.specialname = specialname;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public int getSongcount() {
        return songcount;
    }

    public void setSongcount(int songcount) {
        this.songcount = songcount;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getSuid() {
        return suid;
    }

    public void setSuid(int suid) {
        this.suid = suid;
    }

    public int getSpecialid() {
        return specialid;
    }

    public void setSpecialid(int specialid) {
        this.specialid = specialid;
    }

    public int getCollectcount() {
        return collectcount;
    }

    public void setCollectcount(int collectcount) {
        this.collectcount = collectcount;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getSlid() {
        return slid;
    }

    public void setSlid(int slid) {
        this.slid = slid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.play_count);
        dest.writeString(this.specialname);
        dest.writeString(this.publishtime);
        dest.writeString(this.singername);
        dest.writeInt(this.verified);
        dest.writeInt(this.songcount);
        dest.writeString(this.imgurl);
        dest.writeString(this.intro);
        dest.writeInt(this.suid);
        dest.writeInt(this.specialid);
        dest.writeInt(this.collectcount);
        dest.writeString(this.user_name);
        dest.writeInt(this.slid);
    }

    public SongMenuIntro() {
    }

    protected SongMenuIntro(Parcel in) {
        this.play_count = in.readInt();
        this.specialname = in.readString();
        this.publishtime = in.readString();
        this.singername = in.readString();
        this.verified = in.readInt();
        this.songcount = in.readInt();
        this.imgurl = in.readString();
        this.intro = in.readString();
        this.suid = in.readInt();
        this.specialid = in.readInt();
        this.collectcount = in.readInt();
        this.user_name = in.readString();
        this.slid = in.readInt();
    }

    public static final Parcelable.Creator<SongMenuIntro> CREATOR = new Parcelable.Creator<SongMenuIntro>() {
        @Override
        public SongMenuIntro createFromParcel(Parcel source) {
            return new SongMenuIntro(source);
        }

        @Override
        public SongMenuIntro[] newArray(int size) {
            return new SongMenuIntro[size];
        }
    };
}
