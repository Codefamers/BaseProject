package com.qhn.bhne.baseproject.mvp.entity;

import java.util.List;

/**
 * Created by qhn
 * on 2016/11/7 0007.
 */
public class SongMenuData {


    /**
     * data : {"info":[{"collectcount":69193,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20141209/20141209181428218463.jpg","intro":"陪伴着一代人成长，同时也成为了一代人的青春记忆。它们传唱了一年又一年，有的被人不断重播，有的被人重编新唱，它们成为了时光河流里的珍珠，被时光打磨得更加动人。","playcount":67760098,"publishtime":"2016-07-14 00:00:00","singername":"","slid":67,"songcount":100,"songs":[],"specialid":22405,"specialname":"经典老歌：一个时代的留声","suid":373452707,"username":"陌人陌言","verified":0}],"timestamp":1488199697,"total":91083}
     * errcode : 0
     * error :
     * status : 1
     */

    private DataBean data;
    private int errcode;
    private String error;
    private int status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * info : [{"collectcount":69193,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20141209/20141209181428218463.jpg","intro":"陪伴着一代人成长，同时也成为了一代人的青春记忆。它们传唱了一年又一年，有的被人不断重播，有的被人重编新唱，它们成为了时光河流里的珍珠，被时光打磨得更加动人。","playcount":67760098,"publishtime":"2016-07-14 00:00:00","singername":"","slid":67,"songcount":100,"songs":[],"specialid":22405,"specialname":"经典老歌：一个时代的留声","suid":373452707,"username":"陌人陌言","verified":0}]
         * timestamp : 1488199697
         * total : 91083
         */

        private int timestamp;
        private int total;
        private List<SongMenu> info;

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<SongMenu> getInfo() {
            return info;
        }

        public void setInfo(List<SongMenu> info) {
            this.info = info;
        }

        public static class SongMenu {
            /**
             * collectcount : 69193
             * imgurl : http://imge.kugou.com/soft/collection/{size}/20141209/20141209181428218463.jpg
             * intro : 陪伴着一代人成长，同时也成为了一代人的青春记忆。它们传唱了一年又一年，有的被人不断重播，有的被人重编新唱，它们成为了时光河流里的珍珠，被时光打磨得更加动人。
             * playcount : 67760098
             * publishtime : 2016-07-14 00:00:00
             * singername :
             * slid : 67
             * songcount : 100
             * songs : []
             * specialid : 22405
             * specialname : 经典老歌：一个时代的留声
             * suid : 373452707
             * username : 陌人陌言
             * verified : 0
             */

            private int collectcount;
            private String imgurl;
            private String intro;
            private int playcount;
            private String publishtime;
            private String singername;
            private int slid;
            private int songcount;
            private int specialid;
            private String specialname;
            private int suid;
            private String username;
            private int verified;
            private List<Songs> songs;

            public int getCollectcount() {
                return collectcount;
            }

            public void setCollectcount(int collectcount) {
                this.collectcount = collectcount;
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

            public int getPlaycount() {
                return playcount;
            }

            public void setPlaycount(int playcount) {
                this.playcount = playcount;
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

            public int getSlid() {
                return slid;
            }

            public void setSlid(int slid) {
                this.slid = slid;
            }

            public int getSongcount() {
                return songcount;
            }

            public void setSongcount(int songcount) {
                this.songcount = songcount;
            }

            public int getSpecialid() {
                return specialid;
            }

            public void setSpecialid(int specialid) {
                this.specialid = specialid;
            }

            public String getSpecialname() {
                return specialname;
            }

            public void setSpecialname(String specialname) {
                this.specialname = specialname;
            }

            public int getSuid() {
                return suid;
            }

            public void setSuid(int suid) {
                this.suid = suid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public int getVerified() {
                return verified;
            }

            public void setVerified(int verified) {
                this.verified = verified;
            }

            public List<Songs> getSongs() {
                return songs;
            }

            public void setSongs(List<Songs> songs) {
                this.songs = songs;
            }
        }
    }
}
