package com.qhn.bhne.baseproject.mvp.entity;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */
public class BannerContent {

    /**
     * data : {"info":[{"extra":{"innerurl":"http://zhuanji.kugou.com/html/mobile_commonchargeV2/index_69486.html?is_go=1&hreffrom=9"},"id":1,"imgurl":"http://g.kugou.com/v2/newhome/T1PkZcB_Wg1RCvBVdK.jpg","jump_type":0,"online":0,"rowid":23283,"title":"Ed Sheeran《÷》Divide","type":4,"url":""},{"extra":{"innerurl":"http://zhuanji.kugou.com/html/mobile_commonchargeV2/index_68909.html?is_go=1&hreffrom=9"},"id":2,"imgurl":"http://g.kugou.com/v2/newhome/T1syCcBQC_1RCvBVdK.jpg","jump_type":0,"online":0,"rowid":23149,"title":"鹿晗《Venture》","type":4,"url":""},{"extra":{"innerurl":"http://activity.mobile.kugou.com/activity/singer2017/static/index.html"},"id":5449,"imgurl":"http://imge.kugou.com/mobilebanner/20170225/20170225234928838618.jpg","online":1487953436,"title":"全新《歌手》之战残酷打响","type":4},{"extra":{"innerurl":"http://huodong.kugou.com/a2015/html/musicStory/index_69423.html"},"id":5505,"imgurl":"http://imge.kugou.com/mobilebanner/20170223/20170223191524526522.jpg","online":1487848515,"title":"酷狗音乐故事：你可不可以...爱我？","type":4},{"extra":{"collectcount":6140,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170215/20170215153934853543.jpg","intro":"不是你的菜，别去揭锅盖。不是你的爱，不要去依赖。人生，看你的人多，懂你的人少；说你的人多，帮你的人少；理解你的人，毕竟少而又少；相遇的人，很多；相依的人，很少。这个世界，有泪，自己流，<br>有苦，自己受。没人理解，自己努力，没人帮助，自己尽力。强者不是没有眼泪，只是可以含着眼泪向前跑 ！因为世界上最看不透的就是人心！","play_count":9926893,"publishtime":"2017-02-15","singername":"","slid":27,"songcount":82,"specialid":122138,"specialname":"用一首歌的时间忘记你","suid":509005901},"id":5503,"imgurl":"http://imge.kugou.com/mobilebanner/20170223/20170223180922995520.jpg","online":1487933187,"title":"用一首歌的时间忘记你","type":1},{"extra":{"innerurl":"http://m.www2.kugou.com/yueku/category/html/index.html?areaid=1"},"id":6,"imgurl":"http://g.kugou.com/v2/newhome/T1_CCcB7__1RCvBVdK.jpg","jump_type":0,"online":0,"rowid":23272,"title":"DJ专区","type":4,"url":""},{"extra":{"innerurl":"http://sdn.kugou.com/link.aspx?id=47218&dl=1"},"id":5451,"imgurl":"http://imge.kugou.com/mobilebanner/20170224/20170224150126391848.jpg","online":1488038400,"title":"酷狗潘多拉音响","type":4}],"timestamp":1488095772}
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
         * info : [{"extra":{"innerurl":"http://zhuanji.kugou.com/html/mobile_commonchargeV2/index_69486.html?is_go=1&hreffrom=9"},"id":1,"imgurl":"http://g.kugou.com/v2/newhome/T1PkZcB_Wg1RCvBVdK.jpg","jump_type":0,"online":0,"rowid":23283,"title":"Ed Sheeran《÷》Divide","type":4,"url":""},{"extra":{"innerurl":"http://zhuanji.kugou.com/html/mobile_commonchargeV2/index_68909.html?is_go=1&hreffrom=9"},"id":2,"imgurl":"http://g.kugou.com/v2/newhome/T1syCcBQC_1RCvBVdK.jpg","jump_type":0,"online":0,"rowid":23149,"title":"鹿晗《Venture》","type":4,"url":""},{"extra":{"innerurl":"http://activity.mobile.kugou.com/activity/singer2017/static/index.html"},"id":5449,"imgurl":"http://imge.kugou.com/mobilebanner/20170225/20170225234928838618.jpg","online":1487953436,"title":"全新《歌手》之战残酷打响","type":4},{"extra":{"innerurl":"http://huodong.kugou.com/a2015/html/musicStory/index_69423.html"},"id":5505,"imgurl":"http://imge.kugou.com/mobilebanner/20170223/20170223191524526522.jpg","online":1487848515,"title":"酷狗音乐故事：你可不可以...爱我？","type":4},{"extra":{"collectcount":6140,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170215/20170215153934853543.jpg","intro":"不是你的菜，别去揭锅盖。不是你的爱，不要去依赖。人生，看你的人多，懂你的人少；说你的人多，帮你的人少；理解你的人，毕竟少而又少；相遇的人，很多；相依的人，很少。这个世界，有泪，自己流，<br>有苦，自己受。没人理解，自己努力，没人帮助，自己尽力。强者不是没有眼泪，只是可以含着眼泪向前跑 ！因为世界上最看不透的就是人心！","play_count":9926893,"publishtime":"2017-02-15","singername":"","slid":27,"songcount":82,"specialid":122138,"specialname":"用一首歌的时间忘记你","suid":509005901},"id":5503,"imgurl":"http://imge.kugou.com/mobilebanner/20170223/20170223180922995520.jpg","online":1487933187,"title":"用一首歌的时间忘记你","type":1},{"extra":{"innerurl":"http://m.www2.kugou.com/yueku/category/html/index.html?areaid=1"},"id":6,"imgurl":"http://g.kugou.com/v2/newhome/T1_CCcB7__1RCvBVdK.jpg","jump_type":0,"online":0,"rowid":23272,"title":"DJ专区","type":4,"url":""},{"extra":{"innerurl":"http://sdn.kugou.com/link.aspx?id=47218&dl=1"},"id":5451,"imgurl":"http://imge.kugou.com/mobilebanner/20170224/20170224150126391848.jpg","online":1488038400,"title":"酷狗潘多拉音响","type":4}]
         * timestamp : 1488095772
         */

        private int timestamp;
        private List<Banner> info;

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public List<Banner> getInfo() {
            return info;
        }

        public void setInfo(List<Banner> info) {
            this.info = info;
        }

        public static class Banner {
            /**
             * extra : {"innerurl":"http://zhuanji.kugou.com/html/mobile_commonchargeV2/index_69486.html?is_go=1&hreffrom=9"}
             * id : 1
             * imgurl : http://g.kugou.com/v2/newhome/T1PkZcB_Wg1RCvBVdK.jpg
             * jump_type : 0
             * online : 0
             * rowid : 23283
             * title : Ed Sheeran《÷》Divide
             * type : 4
             * url :
             */

            private ExtraBean extra;
            private int id;
            private String imgurl;
            private int jump_type;
            private int online;
            private int rowid;
            private String title;
            private int type;
            private String url;

            public ExtraBean getExtra() {
                return extra;
            }

            public void setExtra(ExtraBean extra) {
                this.extra = extra;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImgurl() {
                return imgurl;
            }

            public void setImgurl(String imgurl) {
                this.imgurl = imgurl;
            }

            public int getJump_type() {
                return jump_type;
            }

            public void setJump_type(int jump_type) {
                this.jump_type = jump_type;
            }

            public int getOnline() {
                return online;
            }

            public void setOnline(int online) {
                this.online = online;
            }

            public int getRowid() {
                return rowid;
            }

            public void setRowid(int rowid) {
                this.rowid = rowid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public static class ExtraBean {
                /**
                 * innerurl : http://zhuanji.kugou.com/html/mobile_commonchargeV2/index_69486.html?is_go=1&hreffrom=9
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
    }
}
