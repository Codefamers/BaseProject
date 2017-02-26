package com.qhn.bhne.baseproject.mvp.entity;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */
public class SearchMV {

    /**
     * status : 1
     * error :
     * data : {"timestamp":1488074760,"info":[{"filename":"《歌手2017<\/em>》宣传片","duration":50,"hash":"cd49ef56643ce9329fe781a311918a25","intro":"","imgurl":"http://imge.kugou.com/mvhdpic/{size}/20170112/20170112094426533400.jpg","album_id":"","publishdate":"2017-01-11 18:56:11","singername":"光良","topic":""},{"filename":"《歌手2017<\/em>》宣传片","duration":50,"hash":"2a19c4874b96fbf7f43120dfc4cdc6ce","intro":"","imgurl":"http://imge.kugou.com/mvhdpic/{size}/20170111/20170111141123815156.jpg","album_id":"","publishdate":"2017-01-11 11:55:06","singername":"袁娅维","topic":""},{"filename":"爱的就是你(2017福利秀 Free Show现场)","duration":466,"hash":"4fbb7269570f7af29a230488de5bff21","intro":"","imgurl":"http://imge.kugou.com/mvhdpic/{size}/20170205/20170205120337966656.jpg","album_id":"","publishdate":"2017-02-03 12:03:00","singername":"王力宏","topic":""},{"filename":"青春修炼手册(江苏卫视2017跨年演唱会现场)","duration":140,"hash":"75e9af1954f0c916411971e92d5b6d60","intro":"欢乐演绎TFBOYS金曲！超可爱","imgurl":"http://imge.kugou.com/mvhdpic/{size}/20170101/20170101160357867730.jpg","album_id":"","publishdate":"2017-01-01 10:30:38","singername":"蔡依林","topic":""},{"filename":"激流之战+正义之手(2017东方卫视梦圆东方跨年盛典现场)","duration":240,"hash":"7b89befa60bf0cb3af1d4546925ecf1a","intro":"","imgurl":"http://imge.kugou.com/mvhdpic/{size}/20170101/20170101030436836108.jpg","album_id":"","publishdate":"2017-01-01 02:49:11","singername":"SNH48","topic":""},{"filename":"We Will Rock You+真英雄+真真假假+身体健康+青春修炼手册+高高在下+你爱我像谁+一辈子一场梦(2017四川卫视花开天下跨年演唱会)","duration":275,"hash":"62824ee6f23ffae399f625f6ea3d4858","intro":"燃爆全场的经典串烧","imgurl":"http://imge.kugou.com/mvhdpic/{size}/20170101/20170101162607309680.jpg","album_id":"","publishdate":"2017-01-01 01:45:57","singername":"张卫健","topic":""},{"filename":"幸福拍手歌","duration":62,"hash":"9a04c7c6f3d15619d73edc6e234a8044","intro":"","imgurl":"http://imge.kugou.com/mvhdpic/{size}/20170101/20170101171714755826.jpg","album_id":"","publishdate":"2017-01-01 17:14:01","singername":"华语群星","topic":""}],"total":7}
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
         * timestamp : 1488074760
         * info : [{"filename":"《歌手2017<\/em>》宣传片","duration":50,"hash":"cd49ef56643ce9329fe781a311918a25","intro":"","imgurl":"http://imge.kugou.com/mvhdpic/{size}/20170112/20170112094426533400.jpg","album_id":"","publishdate":"2017-01-11 18:56:11","singername":"光良","topic":""},{"filename":"《歌手2017<\/em>》宣传片","duration":50,"hash":"2a19c4874b96fbf7f43120dfc4cdc6ce","intro":"","imgurl":"http://imge.kugou.com/mvhdpic/{size}/20170111/20170111141123815156.jpg","album_id":"","publishdate":"2017-01-11 11:55:06","singername":"袁娅维","topic":""},{"filename":"爱的就是你(2017福利秀 Free Show现场)","duration":466,"hash":"4fbb7269570f7af29a230488de5bff21","intro":"","imgurl":"http://imge.kugou.com/mvhdpic/{size}/20170205/20170205120337966656.jpg","album_id":"","publishdate":"2017-02-03 12:03:00","singername":"王力宏","topic":""},{"filename":"青春修炼手册(江苏卫视2017跨年演唱会现场)","duration":140,"hash":"75e9af1954f0c916411971e92d5b6d60","intro":"欢乐演绎TFBOYS金曲！超可爱","imgurl":"http://imge.kugou.com/mvhdpic/{size}/20170101/20170101160357867730.jpg","album_id":"","publishdate":"2017-01-01 10:30:38","singername":"蔡依林","topic":""},{"filename":"激流之战+正义之手(2017东方卫视梦圆东方跨年盛典现场)","duration":240,"hash":"7b89befa60bf0cb3af1d4546925ecf1a","intro":"","imgurl":"http://imge.kugou.com/mvhdpic/{size}/20170101/20170101030436836108.jpg","album_id":"","publishdate":"2017-01-01 02:49:11","singername":"SNH48","topic":""},{"filename":"We Will Rock You+真英雄+真真假假+身体健康+青春修炼手册+高高在下+你爱我像谁+一辈子一场梦(2017四川卫视花开天下跨年演唱会)","duration":275,"hash":"62824ee6f23ffae399f625f6ea3d4858","intro":"燃爆全场的经典串烧","imgurl":"http://imge.kugou.com/mvhdpic/{size}/20170101/20170101162607309680.jpg","album_id":"","publishdate":"2017-01-01 01:45:57","singername":"张卫健","topic":""},{"filename":"幸福拍手歌","duration":62,"hash":"9a04c7c6f3d15619d73edc6e234a8044","intro":"","imgurl":"http://imge.kugou.com/mvhdpic/{size}/20170101/20170101171714755826.jpg","album_id":"","publishdate":"2017-01-01 17:14:01","singername":"华语群星","topic":""}]
         * total : 7
         */

        private int timestamp;
        private int total;
        private List<SearchMVBean> info;

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

        public List<SearchMVBean> getInfo() {
            return info;
        }

        public void setInfo(List<SearchMVBean> info) {
            this.info = info;
        }

        public static class SearchMVBean {
            /**
             * filename : 《歌手2017</em>》宣传片
             * duration : 50
             * hash : cd49ef56643ce9329fe781a311918a25
             * intro :
             * imgurl : http://imge.kugou.com/mvhdpic/{size}/20170112/20170112094426533400.jpg
             * album_id :
             * publishdate : 2017-01-11 18:56:11
             * singername : 光良
             * topic :
             */

            private String filename;
            private int duration;
            private String hash;
            private String intro;
            private String imgurl;
            private String album_id;
            private String publishdate;
            private String singername;
            private String topic;

            public String getFilename() {
                return filename;
            }

            public void setFilename(String filename) {
                this.filename = filename;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public String getHash() {
                return hash;
            }

            public void setHash(String hash) {
                this.hash = hash;
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

            public String getAlbum_id() {
                return album_id;
            }

            public void setAlbum_id(String album_id) {
                this.album_id = album_id;
            }

            public String getPublishdate() {
                return publishdate;
            }

            public void setPublishdate(String publishdate) {
                this.publishdate = publishdate;
            }

            public String getSingername() {
                return singername;
            }

            public void setSingername(String singername) {
                this.singername = singername;
            }

            public String getTopic() {
                return topic;
            }

            public void setTopic(String topic) {
                this.topic = topic;
            }
        }
    }
}
