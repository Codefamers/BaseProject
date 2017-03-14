package com.qhn.bhne.xhmusic.mvp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by qhn
 * on 2016/11/9 0009.
 */
public class MusicRank implements Parcelable {

    /**
     * id : 56
     * rankid : 22993
     * rankname : 酷音乐流行榜
     * ranktype : 0
     * intro : 酷音乐流行风向标是酷狗、酷我联合推出的权威性榜单。以酷狗及酷我用户真实的搜索播放数据为基础，客观、精准的反映亿万网友对音乐收听和喜爱的情况。
     * imgurl : http://imge.kugou.com/mcommon/{size}/20150408/20150408200744668027.png
     * bannerurl : http://imge.kugou.com/mcommonbanner/{size}/20150408/20150408200750668725.png
     * banner7url : http://imge.kugou.com/mcommon/{size}/20150408/20150408200746678454.png
     * isvol : 0
     * update_frequency :
     * custom_type : 0
     * songinfo : []
     * haschildren : 1
     * children : [{"rankname":"酷音乐流行风向标"},{"rankname":"酷音乐华语榜"},{"rankname":"酷音乐粤语榜"},{"rankname":"酷音乐韩国榜"},{"rankname":"酷音乐日本榜"},{"rankname":"酷音乐欧美榜"}]
     */


    private int id;
    private int rankid;
    private String rankname;
    private int ranktype;
    private String intro;
    private String imgurl;
    private String bannerurl;
    private String banner7url;
    private int isvol;
    private String update_frequency;
    private int custom_type;
    private int haschildren;
    private List<SongInfoBean> songinfo;
    /**
     * rankname : 酷音乐流行风向标
     */

    private List<ChildrenBean> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRankid() {
        return rankid;
    }

    public void setRankid(int rankid) {
        this.rankid = rankid;
    }

    public String getRankname() {
        return rankname;
    }

    public void setRankname(String rankname) {
        this.rankname = rankname;
    }

    public int getRanktype() {
        return ranktype;
    }

    public void setRanktype(int ranktype) {
        this.ranktype = ranktype;
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

    public String getBannerurl() {
        return bannerurl;
    }

    public void setBannerurl(String bannerurl) {
        this.bannerurl = bannerurl;
    }

    public String getBanner7url() {
        return banner7url;
    }

    public void setBanner7url(String banner7url) {
        this.banner7url = banner7url;
    }

    public int getIsvol() {
        return isvol;
    }

    public void setIsvol(int isvol) {
        this.isvol = isvol;
    }

    public String getUpdate_frequency() {
        return update_frequency;
    }

    public void setUpdate_frequency(String update_frequency) {
        this.update_frequency = update_frequency;
    }

    public int getCustom_type() {
        return custom_type;
    }

    public void setCustom_type(int custom_type) {
        this.custom_type = custom_type;
    }

    public int getHaschildren() {
        return haschildren;
    }

    public void setHaschildren(int haschildren) {
        this.haschildren = haschildren;
    }

    public List<SongInfoBean> getSonginfo() {
        return songinfo;
    }

    public void setSonginfo(List<SongInfoBean> songinfo) {
        this.songinfo = songinfo;
    }

    public List<ChildrenBean> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenBean> children) {
        this.children = children;
    }

    public class ChildrenBean {
        private String rankname;

        public String getRankname() {
            return rankname;
        }

        public void setRankname(String rankname) {
            this.rankname = rankname;
        }
    }

    public class SongInfoBean {
        private String songname;

        public String getSongname() {
            return songname;
        }

        public void setSongname(String songname) {
            this.songname = songname;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.rankid);
        dest.writeString(this.rankname);
        dest.writeInt(this.ranktype);
        dest.writeString(this.intro);
        dest.writeString(this.imgurl);
        dest.writeString(this.bannerurl);
        dest.writeString(this.banner7url);
        dest.writeInt(this.isvol);
        dest.writeString(this.update_frequency);
        dest.writeInt(this.custom_type);
        dest.writeInt(this.haschildren);
    }

    public MusicRank() {
    }

    protected MusicRank(Parcel in) {
        this.id = in.readInt();
        this.rankid = in.readInt();
        this.rankname = in.readString();
        this.ranktype = in.readInt();
        this.intro = in.readString();
        this.imgurl = in.readString();
        this.bannerurl = in.readString();
        this.banner7url = in.readString();
        this.isvol = in.readInt();
        this.update_frequency = in.readString();
        this.custom_type = in.readInt();
        this.haschildren = in.readInt();
    }

    public static final Parcelable.Creator<MusicRank> CREATOR = new Parcelable.Creator<MusicRank>() {
        @Override
        public MusicRank createFromParcel(Parcel source) {
            return new MusicRank(source);
        }

        @Override
        public MusicRank[] newArray(int size) {
            return new MusicRank[size];
        }
    };
}
