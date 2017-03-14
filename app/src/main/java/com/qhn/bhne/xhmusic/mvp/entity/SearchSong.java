package com.qhn.bhne.xhmusic.mvp.entity;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/25 0025.
 */

public class SearchSong {
    private String correctiontip;
    private int correctiontype;
    private int errcode;
    private String error;
    private int forcecorrection;
    private RelativeBean relative;
    private int status;
    private List<AggregationBean> aggregation;

    public List<Songs> getSongs() {
        return info;
    }

    public void setSongs(List<Songs> info) {
        this.info = info;
    }

    private List<Songs> info;

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

    public int getForcecorrection() {
        return forcecorrection;
    }

    public void setForcecorrection(int forcecorrection) {
        this.forcecorrection = forcecorrection;
    }

    public RelativeBean getRelative() {
        return relative;
    }

    public void setRelative(RelativeBean relative) {
        this.relative = relative;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<AggregationBean> getAggregation() {
        return aggregation;
    }

    public void setAggregation(List<AggregationBean> aggregation) {
        this.aggregation = aggregation;
    }

    public static class RelativeBean {
        /**
         * priortype : 1
         * singer : [{"albumcount":6,"imgurl":"http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20170117/20170117165037167750.jpg","mvcount":0,"singerid":637338,"singername":"歌手2017","songcount":42}]
         */

        private int priortype;
        private List<SingerBean> singer;

        public int getPriortype() {
            return priortype;
        }

        public void setPriortype(int priortype) {
            this.priortype = priortype;
        }

        public List<SingerBean> getSinger() {
            return singer;
        }

        public void setSinger(List<SingerBean> singer) {
            this.singer = singer;
        }

        public static class SingerBean {
            /**
             * albumcount : 6
             * imgurl : http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20170117/20170117165037167750.jpg
             * mvcount : 0
             * singerid : 637338
             * singername : 歌手2017
             * songcount : 42
             */

            private int albumcount;
            private String imgurl;
            private int mvcount;
            private int singerid;
            private String singername;
            private int songcount;

            public int getAlbumcount() {
                return albumcount;
            }

            public void setAlbumcount(int albumcount) {
                this.albumcount = albumcount;
            }

            public String getImgurl() {
                return imgurl;
            }

            public void setImgurl(String imgurl) {
                this.imgurl = imgurl;
            }

            public int getMvcount() {
                return mvcount;
            }

            public void setMvcount(int mvcount) {
                this.mvcount = mvcount;
            }

            public int getSingerid() {
                return singerid;
            }

            public void setSingerid(int singerid) {
                this.singerid = singerid;
            }

            public String getSingername() {
                return singername;
            }

            public void setSingername(String singername) {
                this.singername = singername;
            }

            public int getSongcount() {
                return songcount;
            }

            public void setSongcount(int songcount) {
                this.songcount = songcount;
            }
        }
    }

    public static class AggregationBean {
        /**
         * count : 1
         * key : DJ
         */

        private int count;
        private String key;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}

