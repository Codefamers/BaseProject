package com.qhn.bhne.baseproject.mvp.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */
public class SearchAlbum implements Parcelable {


    /**
     * albumname : 歌手2017</em> 第六期
     * publishtime : 2017-02-25 00:00:00
     * isfirst : 2
     * albumid : 1974548
     * songcount : 7
     * imgurl : http://imge.kugou.com/stdmusic/{size}/20170225/20170225183144852289.jpg
     * intro : 乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！
     * buycount : 0
     * singerid : 0
     * cd_url :
     * privilege : 0
     * singername : 歌手2017</em>
     */

    private String albumname;
    private String publishtime;
    private int isfirst;
    private int albumid;
    private int songcount;
    private String imgurl;
    private String intro;
    private int buycount;
    private int singerid;
    private String cd_url;
    private int privilege;
    private String singername;

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public int getIsfirst() {
        return isfirst;
    }

    public void setIsfirst(int isfirst) {
        this.isfirst = isfirst;
    }

    public int getAlbumid() {
        return albumid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
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

    public int getBuycount() {
        return buycount;
    }

    public void setBuycount(int buycount) {
        this.buycount = buycount;
    }

    public int getSingerid() {
        return singerid;
    }

    public void setSingerid(int singerid) {
        this.singerid = singerid;
    }

    public String getCd_url() {
        return cd_url;
    }

    public void setCd_url(String cd_url) {
        this.cd_url = cd_url;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.albumname);
        dest.writeString(this.publishtime);
        dest.writeInt(this.isfirst);
        dest.writeInt(this.albumid);
        dest.writeInt(this.songcount);
        dest.writeString(this.imgurl);
        dest.writeString(this.intro);
        dest.writeInt(this.buycount);
        dest.writeInt(this.singerid);
        dest.writeString(this.cd_url);
        dest.writeInt(this.privilege);
        dest.writeString(this.singername);
    }

    public SearchAlbum() {
    }

    protected SearchAlbum(Parcel in) {
        this.albumname = in.readString();
        this.publishtime = in.readString();
        this.isfirst = in.readInt();
        this.albumid = in.readInt();
        this.songcount = in.readInt();
        this.imgurl = in.readString();
        this.intro = in.readString();
        this.buycount = in.readInt();
        this.singerid = in.readInt();
        this.cd_url = in.readString();
        this.privilege = in.readInt();
        this.singername = in.readString();
    }

    public static final Parcelable.Creator<SearchAlbum> CREATOR = new Parcelable.Creator<SearchAlbum>() {
        @Override
        public SearchAlbum createFromParcel(Parcel source) {
            return new SearchAlbum(source);
        }

        @Override
        public SearchAlbum[] newArray(int size) {
            return new SearchAlbum[size];
        }
    };
}


