package com.qhn.bhne.xhmusic.mvp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qhn
 * on 2017/2/14 0014.
 */

public class MusicList implements Parcelable {

    /**
     * created_time : 1477534605074
     * desc : 独立民谣又是一种特别的音乐色彩，它能更个人化地表达歌者的情绪。
     * favorite : false
     * favorite_count : 19
     * image : {"pic":"http://pic.xiami.net/images/trade/music_cover/180/581163b4d0660_9036805_1477534644.jpg","source":1}
     * last_updated : 1477551804471
     * listen_count : 0
     * owner : {"cover_pic":"http://pic.xiami.net/images/common/default_cover.jpg","identity":3,"nick_name":"陈楚生工作室","portrait_pic":"http://pic.xiami.net/images/avatar_new/2524/1262197141458713460.jpg","user_id":404868622}
     * share_count : 0
     * song_count : 15
     * songlist_id : 309712909
     * status : 1
     * tags : [{"tag_id":610,"tag_name":"独立"},{"tag_id":431669,"tag_name":"民谣"},{"tag_id":514,"tag_name":"放松"}]
     * title : 清新的独立民谣
     * version : 18
     */
    private String comment_count;

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }

    private long created_time;
    private String desc;
    private boolean favorite;
    private int favorite_count;
    private ImageBean image;
    private long last_updated;
    private int listen_count;
    private OwnerBean owner;
    private int share_count;
    private int song_count;
    private int songlist_id;
    private int status;
    private String title;
    private int version;
    private List<TagsBean> tags;
    private List<Songs> songs;

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }

    public long getCreated_time() {
        return created_time;
    }

    public void setCreated_time(long created_time) {
        this.created_time = created_time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }

    public ImageBean getImage() {
        return image;
    }

    public void setImage(ImageBean image) {
        this.image = image;
    }

    public long getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(long last_updated) {
        this.last_updated = last_updated;
    }

    public int getListen_count() {
        return listen_count;
    }

    public void setListen_count(int listen_count) {
        this.listen_count = listen_count;
    }

    public OwnerBean getOwner() {
        return owner;
    }

    public void setOwner(OwnerBean owner) {
        this.owner = owner;
    }

    public int getShare_count() {
        return share_count;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    public int getSong_count() {
        return song_count;
    }

    public void setSong_count(int song_count) {
        this.song_count = song_count;
    }

    public int getSonglist_id() {
        return songlist_id;
    }

    public void setSonglist_id(int songlist_id) {
        this.songlist_id = songlist_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class ImageBean implements Parcelable {
        /**
         * pic : http://pic.xiami.net/images/trade/music_cover/180/581163b4d0660_9036805_1477534644.jpg
         * source : 1
         */

        private String pic;
        private int source;

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.pic);
            dest.writeInt(this.source);
        }

        public ImageBean() {
        }

        protected ImageBean(Parcel in) {
            this.pic = in.readString();
            this.source = in.readInt();
        }

        public static final Creator<ImageBean> CREATOR = new Creator<ImageBean>() {
            @Override
            public ImageBean createFromParcel(Parcel source) {
                return new ImageBean(source);
            }

            @Override
            public ImageBean[] newArray(int size) {
                return new ImageBean[size];
            }
        };
    }

    public static class OwnerBean implements Parcelable {
        /**
         * cover_pic : http://pic.xiami.net/images/common/default_cover.jpg
         * identity : 3
         * nick_name : 陈楚生工作室
         * portrait_pic : http://pic.xiami.net/images/avatar_new/2524/1262197141458713460.jpg
         * user_id : 404868622
         */

        private String cover_pic;
        private int identity;
        private String nick_name;
        private String portrait_pic;
        private int user_id;

        public String getCover_pic() {
            return cover_pic;
        }

        public void setCover_pic(String cover_pic) {
            this.cover_pic = cover_pic;
        }

        public int getIdentity() {
            return identity;
        }

        public void setIdentity(int identity) {
            this.identity = identity;
        }

        public String getNick_name() {
            return nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getPortrait_pic() {
            return portrait_pic;
        }

        public void setPortrait_pic(String portrait_pic) {
            this.portrait_pic = portrait_pic;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.cover_pic);
            dest.writeInt(this.identity);
            dest.writeString(this.nick_name);
            dest.writeString(this.portrait_pic);
            dest.writeInt(this.user_id);
        }

        public OwnerBean() {
        }

        protected OwnerBean(Parcel in) {
            this.cover_pic = in.readString();
            this.identity = in.readInt();
            this.nick_name = in.readString();
            this.portrait_pic = in.readString();
            this.user_id = in.readInt();
        }

        public static final Creator<OwnerBean> CREATOR = new Creator<OwnerBean>() {
            @Override
            public OwnerBean createFromParcel(Parcel source) {
                return new OwnerBean(source);
            }

            @Override
            public OwnerBean[] newArray(int size) {
                return new OwnerBean[size];
            }
        };
    }

    public static class TagsBean {
        /**
         * tag_id : 610
         * tag_name : 独立
         */

        private int tag_id;
        private String tag_name;

        public int getTag_id() {
            return tag_id;
        }

        public void setTag_id(int tag_id) {
            this.tag_id = tag_id;
        }

        public String getTag_name() {
            return tag_name;
        }

        public void setTag_name(String tag_name) {
            this.tag_name = tag_name;
        }
    }


    public MusicList() {
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.comment_count);
        dest.writeLong(this.created_time);
        dest.writeString(this.desc);
        dest.writeByte(this.favorite ? (byte) 1 : (byte) 0);
        dest.writeInt(this.favorite_count);
        dest.writeParcelable(this.image, flags);
        dest.writeLong(this.last_updated);
        dest.writeInt(this.listen_count);
        dest.writeParcelable(this.owner, flags);
        dest.writeInt(this.share_count);
        dest.writeInt(this.song_count);
        dest.writeInt(this.songlist_id);
        dest.writeInt(this.status);
        dest.writeString(this.title);
        dest.writeInt(this.version);
        dest.writeList(this.tags);
        dest.writeTypedList(this.songs);
    }

    protected MusicList(Parcel in) {
        this.comment_count = in.readString();
        this.created_time = in.readLong();
        this.desc = in.readString();
        this.favorite = in.readByte() != 0;
        this.favorite_count = in.readInt();
        this.image = in.readParcelable(ImageBean.class.getClassLoader());
        this.last_updated = in.readLong();
        this.listen_count = in.readInt();
        this.owner = in.readParcelable(OwnerBean.class.getClassLoader());
        this.share_count = in.readInt();
        this.song_count = in.readInt();
        this.songlist_id = in.readInt();
        this.status = in.readInt();
        this.title = in.readString();
        this.version = in.readInt();
        this.tags = new ArrayList<TagsBean>();
        in.readList(this.tags, TagsBean.class.getClassLoader());
        this.songs = in.createTypedArrayList(Songs.CREATOR);
    }

    public static final Parcelable.Creator<MusicList> CREATOR = new Parcelable.Creator<MusicList>() {
        @Override
        public MusicList createFromParcel(Parcel source) {
            return new MusicList(source);
        }

        @Override
        public MusicList[] newArray(int size) {
            return new MusicList[size];
        }
    };
}
