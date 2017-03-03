package com.qhn.bhne.baseproject.mvp.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */
public class BroadcastDetail {
    private String heat;
    private String isnew;
    private String fmname;
    private String fmid;
    private String imgurl;
    private int fmtype;
    private String classid;
    private String imgurl_size;
    private String banner;
    private int offset;
    private String addtime;
    private String classname;
    private String banner_size;
    private String parentId;
    private String description;
    private List<SonglistBean> songlist;

    public String getHeat() {
        return heat;
    }

    public void setHeat(String heat) {
        this.heat = heat;
    }

    public String getIsnew() {
        return isnew;
    }

    public void setIsnew(String isnew) {
        this.isnew = isnew;
    }

    public String getFmname() {
        return fmname;
    }

    public void setFmname(String fmname) {
        this.fmname = fmname;
    }

    public String getFmid() {
        return fmid;
    }

    public void setFmid(String fmid) {
        this.fmid = fmid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public int getFmtype() {
        return fmtype;
    }

    public void setFmtype(int fmtype) {
        this.fmtype = fmtype;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getImgurl_size() {
        return imgurl_size;
    }

    public void setImgurl_size(String imgurl_size) {
        this.imgurl_size = imgurl_size;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getBanner_size() {
        return banner_size;
    }

    public void setBanner_size(String banner_size) {
        this.banner_size = banner_size;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SonglistBean> getSonglist() {
        return songlist;
    }

    public void setSonglist(List<SonglistBean> songlist) {
        this.songlist = songlist;
    }

    public static class SonglistBean {
        /**
         * price_320 : 200
         * pay_type_320 : 3
         * privilege_320 : 10
         * hash : 18A8B9C8153D6213A0CA261A56273091
         * size_ape : 0
         * sid : 609034
         * pay_type_128 : 0
         * m4asize : 0
         * pkg_price_320 : 1
         * privilege_128 : 8
         * vip : 0
         * mvhash :
         * price_128 : 0
         * fail_process_320 : 12
         * topic_url :
         * size : 3480763
         * hash_ape :
         * 320size : 8699820
         * 320hash : 1FC0B40C1F625DC48EF7121395F7B09E
         * time : 217000
         * bitrate : 128
         * 320isfilehead : 100
         * 320time : 217000
         * fail_process_128 : 0
         * ext : mp3
         * album_id :
         * m4ahash :
         * name : Jason Derulo - Trumpets
         * pkg_price_128 : 0
         */

        private int price_320;
        private int pay_type_320;
        private int privilege_320;
        private String hash;
        private int size_ape;
        private int sid;
        private int pay_type_128;
        private int m4asize;
        private int pkg_price_320;
        private int privilege_128;
        private int vip;
        private String mvhash;
        private int price_128;
        private int fail_process_320;
        private String topic_url;
        private int size;
        private String hash_ape;
        @SerializedName("320size")
        private int value320size;
        @SerializedName("320hash")
        private String value320hash;
        private int time;
        private int bitrate;
        @SerializedName("320isfilehead")
        private int value320isfilehead;
        @SerializedName("320time")
        private int value320time;
        private int fail_process_128;
        private String ext;
        private String album_id;
        private String m4ahash;
        private String name;
        private int pkg_price_128;

        public int getPrice_320() {
            return price_320;
        }

        public void setPrice_320(int price_320) {
            this.price_320 = price_320;
        }

        public int getPay_type_320() {
            return pay_type_320;
        }

        public void setPay_type_320(int pay_type_320) {
            this.pay_type_320 = pay_type_320;
        }

        public int getPrivilege_320() {
            return privilege_320;
        }

        public void setPrivilege_320(int privilege_320) {
            this.privilege_320 = privilege_320;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public int getSize_ape() {
            return size_ape;
        }

        public void setSize_ape(int size_ape) {
            this.size_ape = size_ape;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public int getPay_type_128() {
            return pay_type_128;
        }

        public void setPay_type_128(int pay_type_128) {
            this.pay_type_128 = pay_type_128;
        }

        public int getM4asize() {
            return m4asize;
        }

        public void setM4asize(int m4asize) {
            this.m4asize = m4asize;
        }

        public int getPkg_price_320() {
            return pkg_price_320;
        }

        public void setPkg_price_320(int pkg_price_320) {
            this.pkg_price_320 = pkg_price_320;
        }

        public int getPrivilege_128() {
            return privilege_128;
        }

        public void setPrivilege_128(int privilege_128) {
            this.privilege_128 = privilege_128;
        }

        public int getVip() {
            return vip;
        }

        public void setVip(int vip) {
            this.vip = vip;
        }

        public String getMvhash() {
            return mvhash;
        }

        public void setMvhash(String mvhash) {
            this.mvhash = mvhash;
        }

        public int getPrice_128() {
            return price_128;
        }

        public void setPrice_128(int price_128) {
            this.price_128 = price_128;
        }

        public int getFail_process_320() {
            return fail_process_320;
        }

        public void setFail_process_320(int fail_process_320) {
            this.fail_process_320 = fail_process_320;
        }

        public String getTopic_url() {
            return topic_url;
        }

        public void setTopic_url(String topic_url) {
            this.topic_url = topic_url;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getHash_ape() {
            return hash_ape;
        }

        public void setHash_ape(String hash_ape) {
            this.hash_ape = hash_ape;
        }

        public int getValue320size() {
            return value320size;
        }

        public void setValue320size(int value320size) {
            this.value320size = value320size;
        }

        public String getValue320hash() {
            return value320hash;
        }

        public void setValue320hash(String value320hash) {
            this.value320hash = value320hash;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getBitrate() {
            return bitrate;
        }

        public void setBitrate(int bitrate) {
            this.bitrate = bitrate;
        }

        public int getValue320isfilehead() {
            return value320isfilehead;
        }

        public void setValue320isfilehead(int value320isfilehead) {
            this.value320isfilehead = value320isfilehead;
        }

        public int getValue320time() {
            return value320time;
        }

        public void setValue320time(int value320time) {
            this.value320time = value320time;
        }

        public int getFail_process_128() {
            return fail_process_128;
        }

        public void setFail_process_128(int fail_process_128) {
            this.fail_process_128 = fail_process_128;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public String getAlbum_id() {
            return album_id;
        }

        public void setAlbum_id(String album_id) {
            this.album_id = album_id;
        }

        public String getM4ahash() {
            return m4ahash;
        }

        public void setM4ahash(String m4ahash) {
            this.m4ahash = m4ahash;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPkg_price_128() {
            return pkg_price_128;
        }

        public void setPkg_price_128(int pkg_price_128) {
            this.pkg_price_128 = pkg_price_128;
        }
    }
}

