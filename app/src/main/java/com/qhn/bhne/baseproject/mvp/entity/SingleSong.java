package com.qhn.bhne.baseproject.mvp.entity;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/25 0025.
 */

public class SingleSong {

    /**
     * black : {"isblock":1,"type":0}
     * data : {"aggregation":[{"count":1,"key":"DJ"},{"count":43,"key":"现场"},{"count":0,"key":"广场舞"},{"count":15,"key":"伴奏"},{"count":0,"key":"铃声"}],"correctiontip":"","correctiontype":0,"errcode":0,"error":"","forcecorrection":0,"relative":{"priortype":1,"singer":[{"albumcount":6,"imgurl":"http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20170117/20170117165037167750.jpg","mvcount":0,"singerid":637338,"singername":"歌手2017","songcount":42}]},"status":1}
     */

    private BlackBean black;
    private DataBean data;
    public BlackBean getBlack() {
        return black;
    }

    public void setBlack(BlackBean black) {
        this.black = black;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class BlackBean {
        /**
         * isblock : 1
         * type : 0
         */

        private int isblock;
        private int type;

        public int getIsblock() {
            return isblock;
        }

        public void setIsblock(int isblock) {
            this.isblock = isblock;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    public static class DataBean {
        /**
         * aggregation : [{"count":1,"key":"DJ"},{"count":43,"key":"现场"},{"count":0,"key":"广场舞"},{"count":15,"key":"伴奏"},{"count":0,"key":"铃声"}]
         * correctiontip :
         * correctiontype : 0
         * errcode : 0
         * error :
         * forcecorrection : 0
         * relative : {"priortype":1,"singer":[{"albumcount":6,"imgurl":"http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20170117/20170117165037167750.jpg","mvcount":0,"singerid":637338,"singername":"歌手2017","songcount":42}]}
         * status : 1
         */

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
}
