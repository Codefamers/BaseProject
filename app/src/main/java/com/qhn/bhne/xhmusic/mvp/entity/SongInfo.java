package com.qhn.bhne.xhmusic.mvp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by qhn
 * on 2017/3/4 0004.
 */

public class SongInfo implements Parcelable {

    /**
     * bitRate : 128
     * choricSinger : 好妹妹乐队
     * ctype : 1009
     * errcode : 0
     * error :
     * extName : mp3
     * extra : {"128filesize":4426649,"128hash":"382408962B6977D24585E55295B5C958","320filesize":11065468,"320hash":"CA4A1AC70FE150F6714683CCE7DD5CBD","sqfilesize":23638391,"sqhash":"E5BBF0B8977E6C3F0F49FA7669E1810F"}
     * fileHead : 100
     * fileName : 好妹妹乐队 - 清平调
     * fileSize : 4426649
     * hash : 382408962B6977D24585E55295B5C958
     * imgUrl : http://singerimg.kugou.com/uploadpic/softhead/{size}/20170101/20170101105221536.jpg
     * intro :
     * mvhash : 7F60B0B8D9F776677BB9A66D15508EA8
     * privilege : 0
     * q : 0
     * req_hash : 382408962B6977D24585E55295B5C958
     * singerHead :
     * singerId : 85021
     * singerName : 好妹妹乐队
     * songName : 清平调
     * status : 1
     * stype : 11323
     * timeLength : 277
     * topic_remark :
     * topic_url :
     * url : http://fs.open.kugou.com/6c7c7624d2f8ef3837232cd3a45e53c3/58ba91e9/G001/M05/0E/10/QQ0DAFSQDq-AJI0NAEOLmXallxM246.mp3
     */

    private float bitRate;
    private String choricSinger;
    private int ctype;
    private int errcode;
    private String error;
    private String extName;
    private ExtraBean extra;
    private int fileHead;
    private String fileName;
    private int fileSize;
    private String hash;
    private String imgUrl;
    private String intro;
    private String mvhash;
    private int privilege;
    private int q;
    private String req_hash;
    private String singerHead;
    private int singerId;
    private String singerName;
    private String songName;
    private int status;
    private int stype;
    private int timeLength;
    private String topic_remark;
    private String topic_url;
    private String url;

    public float getBitRate() {
        return bitRate;
    }

    public void setBitRate(float bitRate) {
        this.bitRate = bitRate;
    }

    public String getChoricSinger() {
        return choricSinger;
    }

    public void setChoricSinger(String choricSinger) {
        this.choricSinger = choricSinger;
    }

    public int getCtype() {
        return ctype;
    }

    public void setCtype(int ctype) {
        this.ctype = ctype;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public ExtraBean getExtra() {
        return extra;
    }

    public void setExtra(ExtraBean extra) {
        this.extra = extra;
    }

    public int getFileHead() {
        return fileHead;
    }

    public void setFileHead(int fileHead) {
        this.fileHead = fileHead;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getMvhash() {
        return mvhash;
    }

    public void setMvhash(String mvhash) {
        this.mvhash = mvhash;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public String getReq_hash() {
        return req_hash;
    }

    public void setReq_hash(String req_hash) {
        this.req_hash = req_hash;
    }

    public String getSingerHead() {
        return singerHead;
    }

    public void setSingerHead(String singerHead) {
        this.singerHead = singerHead;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStype() {
        return stype;
    }

    public void setStype(int stype) {
        this.stype = stype;
    }

    public int getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(int timeLength) {
        this.timeLength = timeLength;
    }

    public String getTopic_remark() {
        return topic_remark;
    }

    public void setTopic_remark(String topic_remark) {
        this.topic_remark = topic_remark;
    }

    public String getTopic_url() {
        return topic_url;
    }

    public void setTopic_url(String topic_url) {
        this.topic_url = topic_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static class ExtraBean implements Parcelable {
        /**
         * 128filesize : 4426649
         * 128hash : 382408962B6977D24585E55295B5C958
         * 320filesize : 11065468
         * 320hash : CA4A1AC70FE150F6714683CCE7DD5CBD
         * sqfilesize : 23638391
         * sqhash : E5BBF0B8977E6C3F0F49FA7669E1810F
         */

        @SerializedName("128filesize")
        private int _$128filesize;
        @SerializedName("128hash")
        private String _$128hash;
        @SerializedName("320filesize")
        private int _$320filesize;
        @SerializedName("320hash")
        private String _$320hash;
        private int sqfilesize;
        private String sqhash;

        public int get_$128filesize() {
            return _$128filesize;
        }

        public void set_$128filesize(int _$128filesize) {
            this._$128filesize = _$128filesize;
        }

        public String get_$128hash() {
            return _$128hash;
        }

        public void set_$128hash(String _$128hash) {
            this._$128hash = _$128hash;
        }

        public int get_$320filesize() {
            return _$320filesize;
        }

        public void set_$320filesize(int _$320filesize) {
            this._$320filesize = _$320filesize;
        }

        public String get_$320hash() {
            return _$320hash;
        }

        public void set_$320hash(String _$320hash) {
            this._$320hash = _$320hash;
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this._$128filesize);
            dest.writeString(this._$128hash);
            dest.writeInt(this._$320filesize);
            dest.writeString(this._$320hash);
            dest.writeInt(this.sqfilesize);
            dest.writeString(this.sqhash);
        }

        public ExtraBean() {
        }

        protected ExtraBean(Parcel in) {
            this._$128filesize = in.readInt();
            this._$128hash = in.readString();
            this._$320filesize = in.readInt();
            this._$320hash = in.readString();
            this.sqfilesize = in.readInt();
            this.sqhash = in.readString();
        }

        public static final Creator<ExtraBean> CREATOR = new Creator<ExtraBean>() {
            @Override
            public ExtraBean createFromParcel(Parcel source) {
                return new ExtraBean(source);
            }

            @Override
            public ExtraBean[] newArray(int size) {
                return new ExtraBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(this.bitRate);
        dest.writeString(this.choricSinger);
        dest.writeInt(this.ctype);
        dest.writeInt(this.errcode);
        dest.writeString(this.error);
        dest.writeString(this.extName);
        dest.writeParcelable(this.extra, flags);
        dest.writeInt(this.fileHead);
        dest.writeString(this.fileName);
        dest.writeInt(this.fileSize);
        dest.writeString(this.hash);
        dest.writeString(this.imgUrl);
        dest.writeString(this.intro);
        dest.writeString(this.mvhash);
        dest.writeInt(this.privilege);
        dest.writeInt(this.q);
        dest.writeString(this.req_hash);
        dest.writeString(this.singerHead);
        dest.writeInt(this.singerId);
        dest.writeString(this.singerName);
        dest.writeString(this.songName);
        dest.writeInt(this.status);
        dest.writeInt(this.stype);
        dest.writeInt(this.timeLength);
        dest.writeString(this.topic_remark);
        dest.writeString(this.topic_url);
        dest.writeString(this.url);
    }

    public SongInfo() {
    }

    protected SongInfo(Parcel in) {
        this.bitRate = in.readInt();
        this.choricSinger = in.readString();
        this.ctype = in.readInt();
        this.errcode = in.readInt();
        this.error = in.readString();
        this.extName = in.readString();
        this.extra = in.readParcelable(ExtraBean.class.getClassLoader());
        this.fileHead = in.readInt();
        this.fileName = in.readString();
        this.fileSize = in.readInt();
        this.hash = in.readString();
        this.imgUrl = in.readString();
        this.intro = in.readString();
        this.mvhash = in.readString();
        this.privilege = in.readInt();
        this.q = in.readInt();
        this.req_hash = in.readString();
        this.singerHead = in.readString();
        this.singerId = in.readInt();
        this.singerName = in.readString();
        this.songName = in.readString();
        this.status = in.readInt();
        this.stype = in.readInt();
        this.timeLength = in.readInt();
        this.topic_remark = in.readString();
        this.topic_url = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<SongInfo> CREATOR = new Parcelable.Creator<SongInfo>() {
        @Override
        public SongInfo createFromParcel(Parcel source) {
            return new SongInfo(source);
        }

        @Override
        public SongInfo[] newArray(int size) {
            return new SongInfo[size];
        }
    };
}
