package com.qhn.bhne.xhmusic.mvp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qhn
 * on 2016/11/4 0004.
 */

public class Songs extends SpecialSong implements Parcelable {



    private int fail_process;
    private int fail_process_320;
    private int fail_process_sq;

    private int has_accompany;

    private int inlist;
    private int pay_type;
    private int pay_type_320;
    private int pay_type_sq;
    private int pkg_price;
    private int pkg_price_320;
    private int pkg_price_sq;
    private int price;
    private int price_320;
    private int price_sq;

    private String remark;
    private String topic_url;
    private String topic_url_320;
    private String topic_url_sq;
    private SongInfo songInfo;

    public SongInfo getSongInfo() {
        return songInfo;
    }

    public void setSongInfo(SongInfo songInfo) {
        this.songInfo = songInfo;
    }

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



    public int getFail_process() {
        return fail_process;
    }

    public void setFail_process(int fail_process) {
        this.fail_process = fail_process;
    }

    public int getFail_process_320() {
        return fail_process_320;
    }

    public void setFail_process_320(int fail_process_320) {
        this.fail_process_320 = fail_process_320;
    }

    public int getFail_process_sq() {
        return fail_process_sq;
    }

    public void setFail_process_sq(int fail_process_sq) {
        this.fail_process_sq = fail_process_sq;
    }



    public int getHas_accompany() {
        return has_accompany;
    }

    public void setHas_accompany(int has_accompany) {
        this.has_accompany = has_accompany;
    }



    public int getInlist() {
        return inlist;
    }

    public void setInlist(int inlist) {
        this.inlist = inlist;
    }



    public int getPay_type() {
        return pay_type;
    }

    public void setPay_type(int pay_type) {
        this.pay_type = pay_type;
    }

    public int getPay_type_320() {
        return pay_type_320;
    }

    public void setPay_type_320(int pay_type_320) {
        this.pay_type_320 = pay_type_320;
    }

    public int getPay_type_sq() {
        return pay_type_sq;
    }

    public void setPay_type_sq(int pay_type_sq) {
        this.pay_type_sq = pay_type_sq;
    }

    public int getPkg_price() {
        return pkg_price;
    }

    public void setPkg_price(int pkg_price) {
        this.pkg_price = pkg_price;
    }

    public int getPkg_price_320() {
        return pkg_price_320;
    }

    public void setPkg_price_320(int pkg_price_320) {
        this.pkg_price_320 = pkg_price_320;
    }

    public int getPkg_price_sq() {
        return pkg_price_sq;
    }

    public void setPkg_price_sq(int pkg_price_sq) {
        this.pkg_price_sq = pkg_price_sq;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice_320() {
        return price_320;
    }

    public void setPrice_320(int price_320) {
        this.price_320 = price_320;
    }

    public int getPrice_sq() {
        return price_sq;
    }

    public void setPrice_sq(int price_sq) {
        this.price_sq = price_sq;
    }



    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }



    public String getTopic_url() {
        return topic_url;
    }

    public void setTopic_url(String topic_url) {
        this.topic_url = topic_url;
    }

    public String getTopic_url_320() {
        return topic_url_320;
    }

    public void setTopic_url_320(String topic_url_320) {
        this.topic_url_320 = topic_url_320;
    }

    public String getTopic_url_sq() {
        return topic_url_sq;
    }

    public void setTopic_url_sq(String topic_url_sq) {
        this.topic_url_sq = topic_url_sq;
    }

    public Songs() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.fail_process);
        dest.writeInt(this.fail_process_320);
        dest.writeInt(this.fail_process_sq);
        dest.writeInt(this.has_accompany);
        dest.writeInt(this.inlist);
        dest.writeInt(this.pay_type);
        dest.writeInt(this.pay_type_320);
        dest.writeInt(this.pay_type_sq);
        dest.writeInt(this.pkg_price);
        dest.writeInt(this.pkg_price_320);
        dest.writeInt(this.pkg_price_sq);
        dest.writeInt(this.price);
        dest.writeInt(this.price_320);
        dest.writeInt(this.price_sq);
        dest.writeString(this.remark);
        dest.writeString(this.topic_url);
        dest.writeString(this.topic_url_320);
        dest.writeString(this.topic_url_sq);
        dest.writeParcelable(this.songInfo, flags);
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

    protected Songs(Parcel in) {
        this.fail_process = in.readInt();
        this.fail_process_320 = in.readInt();
        this.fail_process_sq = in.readInt();
        this.has_accompany = in.readInt();
        this.inlist = in.readInt();
        this.pay_type = in.readInt();
        this.pay_type_320 = in.readInt();
        this.pay_type_sq = in.readInt();
        this.pkg_price = in.readInt();
        this.pkg_price_320 = in.readInt();
        this.pkg_price_sq = in.readInt();
        this.price = in.readInt();
        this.price_320 = in.readInt();
        this.price_sq = in.readInt();
        this.remark = in.readString();
        this.topic_url = in.readString();
        this.topic_url_320 = in.readString();
        this.topic_url_sq = in.readString();
        this.songInfo = in.readParcelable(SongInfo.class.getClassLoader());
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
