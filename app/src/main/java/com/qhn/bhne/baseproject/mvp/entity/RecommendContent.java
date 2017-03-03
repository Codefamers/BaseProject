package com.qhn.bhne.baseproject.mvp.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */

public class RecommendContent {


    private List<RecommendBean> recommend;
    private List<?> operation;
    private List<SongBean> song;
    private List<VlistBean> vlist;
    private List<AlbumBean> album;
    private List<CustomSpecialBean> custom_special;
    private List<EntryBean> entry;
    private List<TopicBean> topic;

    public List<RecommendBean> getRecommend() {
        return recommend;
    }

    public void setRecommend(List<RecommendBean> recommend) {
        this.recommend = recommend;
    }

    public List<?> getOperation() {
        return operation;
    }

    public void setOperation(List<?> operation) {
        this.operation = operation;
    }

    public List<SongBean> getSong() {
        return song;
    }

    public void setSong(List<SongBean> song) {
        this.song = song;
    }

    public List<VlistBean> getVlist() {
        return vlist;
    }

    public void setVlist(List<VlistBean> vlist) {
        this.vlist = vlist;
    }

    public List<AlbumBean> getAlbum() {
        return album;
    }

    public void setAlbum(List<AlbumBean> album) {
        this.album = album;
    }

    public List<CustomSpecialBean> getCustom_special() {
        return custom_special;
    }

    public void setCustom_special(List<CustomSpecialBean> custom_special) {
        this.custom_special = custom_special;
    }

    public List<EntryBean> getEntry() {
        return entry;
    }

    public void setEntry(List<EntryBean> entry) {
        this.entry = entry;
    }

    public List<TopicBean> getTopic() {
        return topic;
    }

    public void setTopic(List<TopicBean> topic) {
        this.topic = topic;
    }

    public static class RecommendBean {
        /**
         * imgurl :
         * title : 歌手2017 合辑
         * id : 16095
         * type : 1
         * online : 1488038400
         * extra : {"play_count":13230392,"specialname":"歌手2017 合辑","publishtime":"2017-02-19","singername":"","verified":0,"songcount":47,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170225/20170225222421828181.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，每周六22：30锁定湖南卫视，《歌手》在等你！酷狗独家无损原声同步上线，与你共赴2017最强音乐盛宴！","suid":509004464,"specialid":121575,"collectcount":30042,"user_name":"战战战","slid":27}
         */

        private String imgurl;
        private String title;
        private int id;
        private int type;
        private int online;
        private ExtraBean extra;

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public ExtraBean getExtra() {
            return extra;
        }

        public void setExtra(ExtraBean extra) {
            this.extra = extra;
        }

        public static class ExtraBean {
            /**
             * play_count : 13230392
             * specialname : 歌手2017 合辑
             * publishtime : 2017-02-19
             * singername :
             * verified : 0
             * songcount : 47
             * imgurl : http://imge.kugou.com/soft/collection/{size}/20170225/20170225222421828181.jpg
             * intro : 乐过云巅，万念有心声，2017年1月21日起，每周六22：30锁定湖南卫视，《歌手》在等你！酷狗独家无损原声同步上线，与你共赴2017最强音乐盛宴！
             * suid : 509004464
             * specialid : 121575
             * collectcount : 30042
             * user_name : 战战战
             * slid : 27
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
        }
    }

    public static class SongBean {
        /**
         * filename : 张杰 - 哥哥
         * songname : 哥哥
         * sqhash : 547BEEB883FB32F3DC7DF14072D42BC4
         * hash : 67E7D056772F4FAE0747843D0A72375A
         * mvhash :
         * privilege : 0
         * filesize : 5736838
         * addtime : 2017-02-25 18:34:10
         * bitrate : 128
         * 320filesize : 14343360
         * Accompany : 1
         * isfirst : 1
         * singername : 张杰
         * sqfilesize : 36095650
         * 320privilege : 0
         * singerimgurl : http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20170111/20170111104600449.jpg
         * duration : 359
         * m4afilesize : 0
         * extname : mp3
         * 320hash : 96A181792E2E96F1BDC7A03F9415CB27
         * sqprivilege : 0
         * intro :
         * feetype : 0
         */

        private String filename;
        private String songname;
        private String sqhash;
        private String hash;
        private String mvhash;
        private int privilege;
        private int filesize;
        private String addtime;
        private int bitrate;
        @SerializedName("320filesize")
        private int value320filesize;
        private int Accompany;
        private int isfirst;
        private String singername;
        private int sqfilesize;
        @SerializedName("320privilege")
        private int value320privilege;
        private String singerimgurl;
        private int duration;
        private int m4afilesize;
        private String extname;
        @SerializedName("320hash")
        private String value320hash;
        private int sqprivilege;
        private String intro;
        private int feetype;

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getSongname() {
            return songname;
        }

        public void setSongname(String songname) {
            this.songname = songname;
        }

        public String getSqhash() {
            return sqhash;
        }

        public void setSqhash(String sqhash) {
            this.sqhash = sqhash;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
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

        public int getFilesize() {
            return filesize;
        }

        public void setFilesize(int filesize) {
            this.filesize = filesize;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public int getBitrate() {
            return bitrate;
        }

        public void setBitrate(int bitrate) {
            this.bitrate = bitrate;
        }

        public int getValue320filesize() {
            return value320filesize;
        }

        public void setValue320filesize(int value320filesize) {
            this.value320filesize = value320filesize;
        }

        public int getAccompany() {
            return Accompany;
        }

        public void setAccompany(int Accompany) {
            this.Accompany = Accompany;
        }

        public int getIsfirst() {
            return isfirst;
        }

        public void setIsfirst(int isfirst) {
            this.isfirst = isfirst;
        }

        public String getSingername() {
            return singername;
        }

        public void setSingername(String singername) {
            this.singername = singername;
        }

        public int getSqfilesize() {
            return sqfilesize;
        }

        public void setSqfilesize(int sqfilesize) {
            this.sqfilesize = sqfilesize;
        }

        public int getValue320privilege() {
            return value320privilege;
        }

        public void setValue320privilege(int value320privilege) {
            this.value320privilege = value320privilege;
        }

        public String getSingerimgurl() {
            return singerimgurl;
        }

        public void setSingerimgurl(String singerimgurl) {
            this.singerimgurl = singerimgurl;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getM4afilesize() {
            return m4afilesize;
        }

        public void setM4afilesize(int m4afilesize) {
            this.m4afilesize = m4afilesize;
        }

        public String getExtname() {
            return extname;
        }

        public void setExtname(String extname) {
            this.extname = extname;
        }

        public String getValue320hash() {
            return value320hash;
        }

        public void setValue320hash(String value320hash) {
            this.value320hash = value320hash;
        }

        public int getSqprivilege() {
            return sqprivilege;
        }

        public void setSqprivilege(int sqprivilege) {
            this.sqprivilege = sqprivilege;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public int getFeetype() {
            return feetype;
        }

        public void setFeetype(int feetype) {
            this.feetype = feetype;
        }
    }

    public static class VlistBean {
        /**
         * des : 第89届奥斯卡将于2月27日隆重举行！《爱乐之城》《雄狮》《星际迷航3》等众多电影获提名入围，精彩的故事再配上触动灵魂的配乐，神切入的旋律与步步推进的剧情交错相连，让人沉醉，现在就让我们一起欣赏本届奥斯卡提名电影的精彩配乐。
         * public_time : 2017/02/24
         * title : 第89届奥斯卡提名电影配乐合集
         * cate : 影视原声
         * vid : 69567
         * mobile_banner : http://imge.kugou.com/commendpic/20170224/20170224184420299424.jpg
         * hot_num : 1034
         */

        private String des;
        private String public_time;
        private String title;
        private String cate;
        private int vid;
        private String mobile_banner;
        private int hot_num;

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getPublic_time() {
            return public_time;
        }

        public void setPublic_time(String public_time) {
            this.public_time = public_time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCate() {
            return cate;
        }

        public void setCate(String cate) {
            this.cate = cate;
        }

        public int getVid() {
            return vid;
        }

        public void setVid(int vid) {
            this.vid = vid;
        }

        public String getMobile_banner() {
            return mobile_banner;
        }

        public void setMobile_banner(String mobile_banner) {
            this.mobile_banner = mobile_banner;
        }

        public int getHot_num() {
            return hot_num;
        }

        public void setHot_num(int hot_num) {
            this.hot_num = hot_num;
        }
    }

    public static class AlbumBean {
        /**
         * albumname : 歌手2017 第六期
         * imgurl : http://imge.kugou.com/stdmusic/{size}/20170225/20170225183144852289.jpg
         * intro : 乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！
         * singerid : 637338
         * publishtime : 2017-02-25
         * singername : 歌手2017
         * albumid : 1974548
         * privilege : 0
         */

        private String albumname;
        private String imgurl;
        private String intro;
        private int singerid;
        private String publishtime;
        private String singername;
        private int albumid;
        private int privilege;

        public String getAlbumname() {
            return albumname;
        }

        public void setAlbumname(String albumname) {
            this.albumname = albumname;
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

        public int getSingerid() {
            return singerid;
        }

        public void setSingerid(int singerid) {
            this.singerid = singerid;
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

        public int getAlbumid() {
            return albumid;
        }

        public void setAlbumid(int albumid) {
            this.albumid = albumid;
        }

        public int getPrivilege() {
            return privilege;
        }

        public void setPrivilege(int privilege) {
            this.privilege = privilege;
        }
    }

    public static class CustomSpecialBean {

        private String title;
        private String icon;
        private int id;
        private List<SongMenuIntro> special;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<SongMenuIntro> getSpecial() {
            return special;
        }

        public void setSpecial(List<SongMenuIntro> special) {
            this.special = special;
        }

    }

    public static class EntryBean {
        /**
         * type : 4
         * imgurl : http://imge.kugou.com/quickentry/20160330/20160330114622814737.png
         * title : 专区
         * extra : {"innerurl":"http://m.www2.kugou.com/yueku/category/area/entry.html"}
         */

        private int type;
        private String imgurl;
        private String title;
        private ExtraBeanX extra;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public ExtraBeanX getExtra() {
            return extra;
        }

        public void setExtra(ExtraBeanX extra) {
            this.extra = extra;
        }

        public static class ExtraBeanX {
            /**
             * innerurl : http://m.www2.kugou.com/yueku/category/area/entry.html
             */

            private String innerurl;

            public String getInnerurl() {
                return innerurl;
            }

            public void setInnerurl(String innerurl) {
                this.innerurl = innerurl;
            }
        }
    }

    public static class TopicBean {
        /**
         * bannerhd : http://imge.kugou.com/v2/mobiletopic/T1IPhVBjAj1RCvBVdK.jpg
         * id : 1633
         * publishtime : 2017-01-24 11:45:00
         * imgurl : http://imge.kugou.com/mtopicbanner/{size}/20170120/20170120222523547522.jpg
         * title : 全新《歌手》之战残酷打响！
         * url : http://activity.mobile.kugou.com/activity/singer2017/static/index.html
         * type : 3
         * picurl : http://imge.kugou.com/mcommon/{size}/20170120/20170120222522529185.jpg
         * extra : null
         */

        private String bannerhd;
        private int id;
        private String publishtime;
        private String imgurl;
        private String title;
        private String url;
        private int type;
        private String picurl;
        private Object extra;

        public String getBannerhd() {
            return bannerhd;
        }

        public void setBannerhd(String bannerhd) {
            this.bannerhd = bannerhd;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPublishtime() {
            return publishtime;
        }

        public void setPublishtime(String publishtime) {
            this.publishtime = publishtime;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public Object getExtra() {
            return extra;
        }

        public void setExtra(Object extra) {
            this.extra = extra;
        }
    }
}
