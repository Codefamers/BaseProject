package com.qhn.bhne.baseproject.mvp.entity;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */
public class SearchAlbum {

    /**
     * status : 1
     * error :
     * data : {"timestamp":1488073953,"correctionforce":0,"total":7,"correctiontip":"","info":[{"albumname":"歌手2017<\/em> 第六期","publishtime":"2017-02-25 00:00:00","isfirst":2,"albumid":1974548,"songcount":7,"imgurl":"http://imge.kugou.com/stdmusic/{size}/20170225/20170225183144852289.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！","buycount":0,"singerid":0,"cd_url":"","privilege":0,"singername":"歌手2017<\/em>"},{"albumname":"歌手2017<\/em> 第五期","publishtime":"2017-02-18 00:00:00","isfirst":2,"albumid":1971719,"songcount":8,"imgurl":"http://imge.kugou.com/stdmusic/{size}/20170218/20170218200528532389.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！","buycount":0,"singerid":0,"cd_url":"","privilege":0,"singername":"歌手2017<\/em>"},{"albumname":"歌手2017<\/em> 第四期","publishtime":"2017-02-11 00:00:00","isfirst":2,"albumid":1969071,"songcount":7,"imgurl":"http://imge.kugou.com/stdmusic/{size}/20170211/20170211173228567793.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！","buycount":0,"singerid":0,"cd_url":"","privilege":0,"singername":"歌手2017<\/em>"},{"albumname":"歌手2017<\/em> 第三期","publishtime":"2017-02-04 00:00:00","isfirst":2,"albumid":1967080,"songcount":8,"imgurl":"http://imge.kugou.com/stdmusic/{size}/20170204/20170204154537680771.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！","buycount":0,"singerid":0,"cd_url":"","privilege":0,"singername":"歌手2017<\/em>"},{"albumname":"歌手2017<\/em> 第二期","publishtime":"2017-01-28 00:00:00","isfirst":2,"albumid":1966682,"songcount":6,"imgurl":"http://imge.kugou.com/stdmusic/{size}/20170128/20170128141532860247.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！","buycount":0,"singerid":0,"cd_url":"","privilege":0,"singername":"歌手2017<\/em>"},{"albumname":"歌手2017<\/em> 第一期","publishtime":"2017-01-21 00:00:00","isfirst":2,"albumid":1965431,"songcount":6,"imgurl":"http://imge.kugou.com/stdmusic/{size}/20170121/20170121164913611446.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！","buycount":0,"singerid":0,"cd_url":"","privilege":0,"singername":"歌手2017<\/em>"},{"albumname":"社会摇2017","publishtime":"2017-01-23 00:00:00","isfirst":0,"albumid":1967280,"songcount":5,"imgurl":"http://imge.kugou.com/stdmusic/{size}/20170123/20170123221113361059.jpg","intro":"2017社会摇摆","buycount":0,"singerid":0,"cd_url":"","privilege":0,"singername":"Along"}],"correctiontype":0}
     * errcode : 0
     */

    private int status;
    private String error;
    private DataBean data;
    private int errcode;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

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

    public static class DataBean {
        /**
         * timestamp : 1488073953
         * correctionforce : 0
         * total : 7
         * correctiontip :
         * info : [{"albumname":"歌手2017<\/em> 第六期","publishtime":"2017-02-25 00:00:00","isfirst":2,"albumid":1974548,"songcount":7,"imgurl":"http://imge.kugou.com/stdmusic/{size}/20170225/20170225183144852289.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！","buycount":0,"singerid":0,"cd_url":"","privilege":0,"singername":"歌手2017<\/em>"},{"albumname":"歌手2017<\/em> 第五期","publishtime":"2017-02-18 00:00:00","isfirst":2,"albumid":1971719,"songcount":8,"imgurl":"http://imge.kugou.com/stdmusic/{size}/20170218/20170218200528532389.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！","buycount":0,"singerid":0,"cd_url":"","privilege":0,"singername":"歌手2017<\/em>"},{"albumname":"歌手2017<\/em> 第四期","publishtime":"2017-02-11 00:00:00","isfirst":2,"albumid":1969071,"songcount":7,"imgurl":"http://imge.kugou.com/stdmusic/{size}/20170211/20170211173228567793.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！","buycount":0,"singerid":0,"cd_url":"","privilege":0,"singername":"歌手2017<\/em>"},{"albumname":"歌手2017<\/em> 第三期","publishtime":"2017-02-04 00:00:00","isfirst":2,"albumid":1967080,"songcount":8,"imgurl":"http://imge.kugou.com/stdmusic/{size}/20170204/20170204154537680771.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！","buycount":0,"singerid":0,"cd_url":"","privilege":0,"singername":"歌手2017<\/em>"},{"albumname":"歌手2017<\/em> 第二期","publishtime":"2017-01-28 00:00:00","isfirst":2,"albumid":1966682,"songcount":6,"imgurl":"http://imge.kugou.com/stdmusic/{size}/20170128/20170128141532860247.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！","buycount":0,"singerid":0,"cd_url":"","privilege":0,"singername":"歌手2017<\/em>"},{"albumname":"歌手2017<\/em> 第一期","publishtime":"2017-01-21 00:00:00","isfirst":2,"albumid":1965431,"songcount":6,"imgurl":"http://imge.kugou.com/stdmusic/{size}/20170121/20170121164913611446.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！","buycount":0,"singerid":0,"cd_url":"","privilege":0,"singername":"歌手2017<\/em>"},{"albumname":"社会摇2017","publishtime":"2017-01-23 00:00:00","isfirst":0,"albumid":1967280,"songcount":5,"imgurl":"http://imge.kugou.com/stdmusic/{size}/20170123/20170123221113361059.jpg","intro":"2017社会摇摆","buycount":0,"singerid":0,"cd_url":"","privilege":0,"singername":"Along"}]
         * correctiontype : 0
         */

        private int timestamp;
        private int correctionforce;
        private int total;
        private String correctiontip;
        private int correctiontype;
        private List<Album> info;

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public int getCorrectionforce() {
            return correctionforce;
        }

        public void setCorrectionforce(int correctionforce) {
            this.correctionforce = correctionforce;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getCorrectiontip() {
            return correctiontip;
        }

        public void setCorrectiontip(String correctiontip) {
            this.correctiontip = correctiontip;
        }

        public int getCorrectiontype() {
            return correctiontype;
        }

        public void setCorrectiontype(int correctiontype) {
            this.correctiontype = correctiontype;
        }

        public List<Album> getInfo() {
            return info;
        }

        public void setInfo(List<Album> info) {
            this.info = info;
        }

        public static class Album {
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
        }
    }
}
