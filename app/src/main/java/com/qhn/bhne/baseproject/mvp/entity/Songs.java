package com.qhn.bhne.baseproject.mvp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qhn
 * on 2016/11/4 0004.
 */

public class Songs implements Parcelable {

    /**
     * 320filesize : 8926080
     * 320hash : 7d7826ab507f3d1cf50c97bc669dc8cc
     * 320privilege : 0
     * Accompany : 1
     * album_id : 1974548
     * album_name : 歌手2017</em> 第六期
     * bitrate : 128
     * duration : 223
     * extname : mp3
     * feetype : 0
     * filename : 林忆莲 - 盛夏光年 - 歌手2017</em>第一季第六期现场
     * filesize : 3569927
     * group : []
     * hash : 5d17f645d11c9a96be7d1412869b0fa9
     * isnew : 1
     * m4afilesize : 918733
     * mvhash :
     * othername : 歌手2017</em>第一季第六期现场
     * ownercount : 0
     * privilege : 0
     * singername : 林忆莲
     * songname : 盛夏光年
     * source :
     * sourceid : 0
     * sqfilesize : 28336832
     * sqhash : c251e77645fefbbe3fcf71d8af194f36
     * sqprivilege : 0
     * srctype : 1
     * topic :
     */


    @SerializedName("320filesize")
    private int value320filesize;
    @SerializedName("320hash")
    private String value320hash;
    @SerializedName("320privilege")
    private int value320privilege;
    private int Accompany;
    private String album_id;
    private String album_name;
    private int bitrate;
    private int duration;
    private String extname;
    private int feetype;
    private String filename;
    private int filesize;
    private String hash;
    private int isnew;
    private int m4afilesize;
    private String mvhash;
    private String othername;
    private int ownercount;
    private int privilege;
    private String singername;
    private String songname;
    private String source;
    private int sourceid;
    private int sqfilesize;
    private String sqhash;
    private int sqprivilege;
    private int srctype;
    private String topic;
    private List<Object> group;

    public int getValue320filesize() {
        return value320filesize;
    }

    public void setValue320filesize(int value320filesize) {
        this.value320filesize = value320filesize;
    }

    public String getValue320hash() {
        return value320hash;
    }

    public void setValue320hash(String value320hash) {
        this.value320hash = value320hash;
    }

    public int getValue320privilege() {
        return value320privilege;
    }

    public void setValue320privilege(int value320privilege) {
        this.value320privilege = value320privilege;
    }

    public int getAccompany() {
        return Accompany;
    }

    public void setAccompany(int Accompany) {
        this.Accompany = Accompany;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getExtname() {
        return extname;
    }

    public void setExtname(String extname) {
        this.extname = extname;
    }

    public int getFeetype() {
        return feetype;
    }

    public void setFeetype(int feetype) {
        this.feetype = feetype;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getFilesize() {
        return filesize;
    }

    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getIsnew() {
        return isnew;
    }

    public void setIsnew(int isnew) {
        this.isnew = isnew;
    }

    public int getM4afilesize() {
        return m4afilesize;
    }

    public void setM4afilesize(int m4afilesize) {
        this.m4afilesize = m4afilesize;
    }

    public String getMvhash() {
        return mvhash;
    }

    public void setMvhash(String mvhash) {
        this.mvhash = mvhash;
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername;
    }

    public int getOwnercount() {
        return ownercount;
    }

    public void setOwnercount(int ownercount) {
        this.ownercount = ownercount;
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

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getSourceid() {
        return sourceid;
    }

    public void setSourceid(int sourceid) {
        this.sourceid = sourceid;
    }

    public int getSqfilesize() {
        return sqfilesize;
    }

    public void setSqfilesize(int sqfilesize) {
        this.sqfilesize = sqfilesize;
    }

    public String getSqhash() {
        return sqhash;
    }

    public void setSqhash(String sqhash) {
        this.sqhash = sqhash;
    }

    public int getSqprivilege() {
        return sqprivilege;
    }

    public void setSqprivilege(int sqprivilege) {
        this.sqprivilege = sqprivilege;
    }

    public int getSrctype() {
        return srctype;
    }

    public void setSrctype(int srctype) {
        this.srctype = srctype;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<?> getGroup() {
        return group;
    }

    public void setGroup(List<Object> group) {
        this.group = group;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.value320filesize);
        dest.writeString(this.value320hash);
        dest.writeInt(this.value320privilege);
        dest.writeInt(this.Accompany);
        dest.writeString(this.album_id);
        dest.writeString(this.album_name);
        dest.writeInt(this.bitrate);
        dest.writeInt(this.duration);
        dest.writeString(this.extname);
        dest.writeInt(this.feetype);
        dest.writeString(this.filename);
        dest.writeInt(this.filesize);
        dest.writeString(this.hash);
        dest.writeInt(this.isnew);
        dest.writeInt(this.m4afilesize);
        dest.writeString(this.mvhash);
        dest.writeString(this.othername);
        dest.writeInt(this.ownercount);
        dest.writeInt(this.privilege);
        dest.writeString(this.singername);
        dest.writeString(this.songname);
        dest.writeString(this.source);
        dest.writeInt(this.sourceid);
        dest.writeInt(this.sqfilesize);
        dest.writeString(this.sqhash);
        dest.writeInt(this.sqprivilege);
        dest.writeInt(this.srctype);
        dest.writeString(this.topic);
        dest.writeList(this.group);
    }

    public Songs() {
    }

    protected Songs(Parcel in) {
        this.value320filesize = in.readInt();
        this.value320hash = in.readString();
        this.value320privilege = in.readInt();
        this.Accompany = in.readInt();
        this.album_id = in.readString();
        this.album_name = in.readString();
        this.bitrate = in.readInt();
        this.duration = in.readInt();
        this.extname = in.readString();
        this.feetype = in.readInt();
        this.filename = in.readString();
        this.filesize = in.readInt();
        this.hash = in.readString();
        this.isnew = in.readInt();
        this.m4afilesize = in.readInt();
        this.mvhash = in.readString();
        this.othername = in.readString();
        this.ownercount = in.readInt();
        this.privilege = in.readInt();
        this.singername = in.readString();
        this.songname = in.readString();
        this.source = in.readString();
        this.sourceid = in.readInt();
        this.sqfilesize = in.readInt();
        this.sqhash = in.readString();
        this.sqprivilege = in.readInt();
        this.srctype = in.readInt();
        this.topic = in.readString();
        this.group = new ArrayList<Object>();
        in.readList(this.group, Object.class.getClassLoader());
    }

    public static final Parcelable.Creator<Songs> CREATOR = new Parcelable.Creator<Songs>() {
        @Override
        public Songs createFromParcel(Parcel source) {
            return new Songs(source);
        }

        @Override
        public Songs[] newArray(int size) {
            return new Songs[size];
        }
    };
}
