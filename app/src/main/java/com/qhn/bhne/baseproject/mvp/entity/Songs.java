package com.qhn.bhne.baseproject.mvp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qhn
 * on 2016/11/4 0004.
 */

public class Songs implements Parcelable {

    /**
     * albumId : 638762
     * albumName : 那爱
     * alias :
     * audit : 0
     * auditionList : [{"bitRate":32,"duration":194000,"size":805344,"suffix":"m4a","typeDescription":"流畅品质","url":"http://om32.alicdn.com/538/119538/782937818/1772288099_11046019_l.m4a?auth_key=dec3f81a040fa4aee2531ddf13c46d00-1478746800-0-null"},{"bitRate":128,"duration":194000,"size":3113732,"suffix":"mp3","typeDescription":"标准品质","url":"http://m5.file.xiami.com/538/119538/782937818/1772288099_11046019_l.mp3?auth_key=a9fb47fe764ec613fdcaa651a05c699d-1478746800-0-null"},{"bitRate":320,"duration":194000,"size":7781500,"suffix":"mp3","typeDescription":"超高品质","url":"http://m6.file.xiami.com/538/119538/782937818/1772288099_11046019_h.mp3?auth_key=d0aa71b139209ae4b81d744f5018c16d-1478746800-0-null"}]
     * commentCount : 0
     * composerId : 0
     * favorites : 5734
     * firstHit : false
     * isExclusive : 0
     * lang : 7
     * level : 2
     * librettistId : 0
     * listenCount : 0
     * mvBulletCount : 0
     * mvList : []
     * mvPickCount : 0
     * name : 爱
     * operType : 0
     * originalId : 6776635
     * outFlag : 0
     * outLinks : []
     * picUrl : http://img.xiami.net/images/album/img38/119538/7829378181420692341_4.jpg
     * producer : 0
     * publisher : 0
     * releaseYear : 0
     * remarks :
     * rightKey : {"albumPackage":[],"loginStatus":0,"musicPackage":[],"orderType":0,"paymentUnite":0,"price":0,"songRights":[{"auditionRightFlag":0,"bitRate":32,"downBuyFlag":false,"downFlag":true,"downloadRightFlag":0,"listenBuyFlag":false,"listenFlag":true},{"auditionRightFlag":0,"bitRate":320,"downBuyFlag":false,"downFlag":true,"downloadRightFlag":0,"listenBuyFlag":false,"listenFlag":true},{"auditionRightFlag":0,"bitRate":128,"downBuyFlag":false,"downFlag":true,"downloadRightFlag":0,"listenBuyFlag":false,"listenFlag":true}]}
     * riskRank : 11
     * singerId : 64211
     * singerName : Mi2
     * singerSFlag : 1
     * singers : [{"shopId":0,"singerId":64211,"singerName":"Mi2","singerSFlag":1}]
     * songId : 6776635
     * status : 1
     * type : 0
     * urlList : [{"bitRate":32,"duration":194000,"size":805344,"suffix":"m4a","typeDescription":"流畅品质","url":"http://om32.alicdn.com/538/119538/782937818/1772288099_11046019_l.m4a?auth_key=dec3f81a040fa4aee2531ddf13c46d00-1478746800-0-null"},{"bitRate":128,"duration":194000,"size":3113732,"suffix":"mp3","typeDescription":"标准品质","url":"http://m5.file.xiami.com/538/119538/782937818/1772288099_11046019_l.mp3?auth_key=a9fb47fe764ec613fdcaa651a05c699d-1478746800-0-null"},{"bitRate":320,"duration":194000,"size":7781500,"suffix":"mp3","typeDescription":"超高品质","url":"http://m6.file.xiami.com/538/119538/782937818/1772288099_11046019_h.mp3?auth_key=d0aa71b139209ae4b81d744f5018c16d-1478746800-0-null"}]
     */

    private int albumId;
    private String albumName;
    private String alias;
    private int audit;
    private int commentCount;
    private int composerId;
    private int favorites;
    private boolean firstHit;
    private int isExclusive;
    private int lang;
    private String level;
    private int librettistId;
    private int listenCount;
    private int mvBulletCount;
    private int mvPickCount;
    private String name;
    private int operType;
    private int originalId;
    private int outFlag;
    private String picUrl;
    private int producer;
    private int publisher;
    private int releaseYear;
    private String remarks;
    /**
     * albumPackage : []
     * loginStatus : 0
     * musicPackage : []
     * orderType : 0
     * paymentUnite : 0
     * price : 0
     * songRights : [{"auditionRightFlag":0,"bitRate":32,"downBuyFlag":false,"downFlag":true,"downloadRightFlag":0,"listenBuyFlag":false,"listenFlag":true},{"auditionRightFlag":0,"bitRate":320,"downBuyFlag":false,"downFlag":true,"downloadRightFlag":0,"listenBuyFlag":false,"listenFlag":true},{"auditionRightFlag":0,"bitRate":128,"downBuyFlag":false,"downFlag":true,"downloadRightFlag":0,"listenBuyFlag":false,"listenFlag":true}]
     */

    private RightKeyBean rightKey;
    private int riskRank;
    private int singerId;
    private String singerName;
    private int singerSFlag;
    private int songId;
    private int status;
    private int type;
    /**
     * bitRate : 32
     * duration : 194000
     * size : 805344
     * suffix : m4a
     * typeDescription : 流畅品质
     * url : http://om32.alicdn.com/538/119538/782937818/1772288099_11046019_l.m4a?auth_key=dec3f81a040fa4aee2531ddf13c46d00-1478746800-0-null
     */

    private List<AuditionListBean> auditionList;
    private List<?> mvList;
    private List<?> outLinks;
    /**
     * shopId : 0
     * singerId : 64211
     * singerName : Mi2
     * singerSFlag : 1
     */

    private List<SingersBean> singers;
    /**
     * bitRate : 32
     * duration : 194000
     * size : 805344
     * suffix : m4a
     * typeDescription : 流畅品质
     * url : http://om32.alicdn.com/538/119538/782937818/1772288099_11046019_l.m4a?auth_key=dec3f81a040fa4aee2531ddf13c46d00-1478746800-0-null
     */

    private List<UrlListBean> urlList;

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getAudit() {
        return audit;
    }

    public void setAudit(int audit) {
        this.audit = audit;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getComposerId() {
        return composerId;
    }

    public void setComposerId(int composerId) {
        this.composerId = composerId;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public boolean isFirstHit() {
        return firstHit;
    }

    public void setFirstHit(boolean firstHit) {
        this.firstHit = firstHit;
    }

    public int getIsExclusive() {
        return isExclusive;
    }

    public void setIsExclusive(int isExclusive) {
        this.isExclusive = isExclusive;
    }

    public int getLang() {
        return lang;
    }

    public void setLang(int lang) {
        this.lang = lang;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getLibrettistId() {
        return librettistId;
    }

    public void setLibrettistId(int librettistId) {
        this.librettistId = librettistId;
    }

    public int getListenCount() {
        return listenCount;
    }

    public void setListenCount(int listenCount) {
        this.listenCount = listenCount;
    }

    public int getMvBulletCount() {
        return mvBulletCount;
    }

    public void setMvBulletCount(int mvBulletCount) {
        this.mvBulletCount = mvBulletCount;
    }

    public int getMvPickCount() {
        return mvPickCount;
    }

    public void setMvPickCount(int mvPickCount) {
        this.mvPickCount = mvPickCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOperType() {
        return operType;
    }

    public void setOperType(int operType) {
        this.operType = operType;
    }

    public int getOriginalId() {
        return originalId;
    }

    public void setOriginalId(int originalId) {
        this.originalId = originalId;
    }

    public int getOutFlag() {
        return outFlag;
    }

    public void setOutFlag(int outFlag) {
        this.outFlag = outFlag;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getProducer() {
        return producer;
    }

    public void setProducer(int producer) {
        this.producer = producer;
    }

    public int getPublisher() {
        return publisher;
    }

    public void setPublisher(int publisher) {
        this.publisher = publisher;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public RightKeyBean getRightKey() {
        return rightKey;
    }

    public void setRightKey(RightKeyBean rightKey) {
        this.rightKey = rightKey;
    }

    public int getRiskRank() {
        return riskRank;
    }

    public void setRiskRank(int riskRank) {
        this.riskRank = riskRank;
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

    public int getSingerSFlag() {
        return singerSFlag;
    }

    public void setSingerSFlag(int singerSFlag) {
        this.singerSFlag = singerSFlag;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<AuditionListBean> getAuditionList() {
        return auditionList;
    }

    public void setAuditionList(List<AuditionListBean> auditionList) {
        this.auditionList = auditionList;
    }

    public List<?> getMvList() {
        return mvList;
    }

    public void setMvList(List<?> mvList) {
        this.mvList = mvList;
    }

    public List<?> getOutLinks() {
        return outLinks;
    }

    public void setOutLinks(List<?> outLinks) {
        this.outLinks = outLinks;
    }

    public List<SingersBean> getSingers() {
        return singers;
    }

    public void setSingers(List<SingersBean> singers) {
        this.singers = singers;
    }

    public List<UrlListBean> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<UrlListBean> urlList) {
        this.urlList = urlList;
    }

    public static class RightKeyBean {
        private int loginStatus;
        private int orderType;
        private int paymentUnite;
        private int price;
        private List<?> albumPackage;
        private List<?> musicPackage;
        /**
         * auditionRightFlag : 0
         * bitRate : 32
         * downBuyFlag : false
         * downFlag : true
         * downloadRightFlag : 0
         * listenBuyFlag : false
         * listenFlag : true
         */

        private List<SongRightsBean> songRights;

        public int getLoginStatus() {
            return loginStatus;
        }

        public void setLoginStatus(int loginStatus) {
            this.loginStatus = loginStatus;
        }

        public int getOrderType() {
            return orderType;
        }

        public void setOrderType(int orderType) {
            this.orderType = orderType;
        }

        public int getPaymentUnite() {
            return paymentUnite;
        }

        public void setPaymentUnite(int paymentUnite) {
            this.paymentUnite = paymentUnite;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public List<?> getAlbumPackage() {
            return albumPackage;
        }

        public void setAlbumPackage(List<?> albumPackage) {
            this.albumPackage = albumPackage;
        }

        public List<?> getMusicPackage() {
            return musicPackage;
        }

        public void setMusicPackage(List<?> musicPackage) {
            this.musicPackage = musicPackage;
        }

        public List<SongRightsBean> getSongRights() {
            return songRights;
        }

        public void setSongRights(List<SongRightsBean> songRights) {
            this.songRights = songRights;
        }

        public static class SongRightsBean {
            private int auditionRightFlag;
            private int bitRate;
            private boolean downBuyFlag;
            private boolean downFlag;
            private int downloadRightFlag;
            private boolean listenBuyFlag;
            private boolean listenFlag;

            public int getAuditionRightFlag() {
                return auditionRightFlag;
            }

            public void setAuditionRightFlag(int auditionRightFlag) {
                this.auditionRightFlag = auditionRightFlag;
            }

            public int getBitRate() {
                return bitRate;
            }

            public void setBitRate(int bitRate) {
                this.bitRate = bitRate;
            }

            public boolean isDownBuyFlag() {
                return downBuyFlag;
            }

            public void setDownBuyFlag(boolean downBuyFlag) {
                this.downBuyFlag = downBuyFlag;
            }

            public boolean isDownFlag() {
                return downFlag;
            }

            public void setDownFlag(boolean downFlag) {
                this.downFlag = downFlag;
            }

            public int getDownloadRightFlag() {
                return downloadRightFlag;
            }

            public void setDownloadRightFlag(int downloadRightFlag) {
                this.downloadRightFlag = downloadRightFlag;
            }

            public boolean isListenBuyFlag() {
                return listenBuyFlag;
            }

            public void setListenBuyFlag(boolean listenBuyFlag) {
                this.listenBuyFlag = listenBuyFlag;
            }

            public boolean isListenFlag() {
                return listenFlag;
            }

            public void setListenFlag(boolean listenFlag) {
                this.listenFlag = listenFlag;
            }
        }
    }

    public static class AuditionListBean {
        private int bitRate;
        private int duration;
        private int size;
        private String suffix;
        private String typeDescription;
        private String url;

        public int getBitRate() {
            return bitRate;
        }

        public void setBitRate(int bitRate) {
            this.bitRate = bitRate;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getSuffix() {
            return suffix;
        }

        public void setSuffix(String suffix) {
            this.suffix = suffix;
        }

        public String getTypeDescription() {
            return typeDescription;
        }

        public void setTypeDescription(String typeDescription) {
            this.typeDescription = typeDescription;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class SingersBean {
        private int shopId;
        private int singerId;
        private String singerName;
        private int singerSFlag;

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
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

        public int getSingerSFlag() {
            return singerSFlag;
        }

        public void setSingerSFlag(int singerSFlag) {
            this.singerSFlag = singerSFlag;
        }
    }

    public static class UrlListBean {
        private int bitRate;
        private int duration;
        private int size;
        private String suffix;
        private String typeDescription;
        private String url;

        public int getBitRate() {
            return bitRate;
        }

        public void setBitRate(int bitRate) {
            this.bitRate = bitRate;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getSuffix() {
            return suffix;
        }

        public void setSuffix(String suffix) {
            this.suffix = suffix;
        }

        public String getTypeDescription() {
            return typeDescription;
        }

        public void setTypeDescription(String typeDescription) {
            this.typeDescription = typeDescription;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.albumId);
        dest.writeString(this.albumName);
        dest.writeString(this.alias);
        dest.writeInt(this.audit);
        dest.writeInt(this.commentCount);
        dest.writeInt(this.composerId);
        dest.writeInt(this.favorites);
        dest.writeByte(this.firstHit ? (byte) 1 : (byte) 0);
        dest.writeInt(this.isExclusive);
        dest.writeInt(this.lang);
        dest.writeString(this.level);
        dest.writeInt(this.librettistId);
        dest.writeInt(this.listenCount);
        dest.writeInt(this.mvBulletCount);
        dest.writeInt(this.mvPickCount);
        dest.writeString(this.name);
        dest.writeInt(this.operType);
        dest.writeInt(this.originalId);
        dest.writeInt(this.outFlag);
        dest.writeString(this.picUrl);
        dest.writeInt(this.producer);
        dest.writeInt(this.publisher);
        dest.writeInt(this.releaseYear);
        dest.writeString(this.remarks);
        dest.writeInt(this.riskRank);
        dest.writeInt(this.singerId);
        dest.writeString(this.singerName);
        dest.writeInt(this.singerSFlag);
        dest.writeInt(this.songId);
        dest.writeInt(this.status);
        dest.writeInt(this.type);
        dest.writeList(this.auditionList);
        dest.writeList(this.mvList);
        dest.writeList(this.outLinks);
        dest.writeList(this.singers);
        dest.writeList(this.urlList);
    }

    public Songs() {
    }

    protected Songs(Parcel in) {
        this.albumId = in.readInt();
        this.albumName = in.readString();
        this.alias = in.readString();
        this.audit = in.readInt();
        this.commentCount = in.readInt();
        this.composerId = in.readInt();
        this.favorites = in.readInt();
        this.firstHit = in.readByte() != 0;
        this.isExclusive = in.readInt();
        this.lang = in.readInt();
        this.level = in.readString();
        this.librettistId = in.readInt();
        this.listenCount = in.readInt();
        this.mvBulletCount = in.readInt();
        this.mvPickCount = in.readInt();
        this.name = in.readString();
        this.operType = in.readInt();
        this.originalId = in.readInt();
        this.outFlag = in.readInt();
        this.picUrl = in.readString();
        this.producer = in.readInt();
        this.publisher = in.readInt();
        this.releaseYear = in.readInt();
        this.remarks = in.readString();
        this.rightKey = in.readParcelable(RightKeyBean.class.getClassLoader());
        this.riskRank = in.readInt();
        this.singerId = in.readInt();
        this.singerName = in.readString();
        this.singerSFlag = in.readInt();
        this.songId = in.readInt();
        this.status = in.readInt();
        this.type = in.readInt();
        this.auditionList = new ArrayList<AuditionListBean>();
        in.readList(this.auditionList, AuditionListBean.class.getClassLoader());


        this.singers = new ArrayList<SingersBean>();
        in.readList(this.singers, SingersBean.class.getClassLoader());
        this.urlList = new ArrayList<UrlListBean>();
        in.readList(this.urlList, UrlListBean.class.getClassLoader());
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
