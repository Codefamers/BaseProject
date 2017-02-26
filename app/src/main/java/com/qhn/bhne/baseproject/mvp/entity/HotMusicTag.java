package com.qhn.bhne.baseproject.mvp.entity;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/24 0024.
 */

public class HotMusicTag {

    /**
     * data : {"info":[{"jumpurl":"","keyword":"歌手2017","sort":0},{"jumpurl":"http://huodong.kugou.com/a2015/html/musicStory/index_69423.html","keyword":"音乐故事","sort":1},{"jumpurl":"","keyword":"张靓颖 思美人","sort":2},{"jumpurl":"","keyword":"鹿晗 Venture","sort":2},{"jumpurl":"","keyword":"侧田","sort":4},{"jumpurl":"","keyword":"欢乐好声音","sort":5},{"jumpurl":"","keyword":"成都","sort":5},{"jumpurl":"","keyword":"IF YOU","sort":5},{"jumpurl":"","keyword":"Seve","sort":6},{"jumpurl":"","keyword":"这个年纪","sort":7},{"jumpurl":"","keyword":"Faded","sort":8},{"jumpurl":"","keyword":"TFBOYS","sort":9},{"jumpurl":"","keyword":"多幸运","sort":9},{"jumpurl":"","keyword":"三生三世","sort":10},{"jumpurl":"","keyword":"X玖少年团","sort":11},{"jumpurl":"","keyword":"当你","sort":14}],"timestamp":1487916354}
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
         * info : [{"jumpurl":"","keyword":"歌手2017","sort":0},{"jumpurl":"http://huodong.kugou.com/a2015/html/musicStory/index_69423.html","keyword":"音乐故事","sort":1},{"jumpurl":"","keyword":"张靓颖 思美人","sort":2},{"jumpurl":"","keyword":"鹿晗 Venture","sort":2},{"jumpurl":"","keyword":"侧田","sort":4},{"jumpurl":"","keyword":"欢乐好声音","sort":5},{"jumpurl":"","keyword":"成都","sort":5},{"jumpurl":"","keyword":"IF YOU","sort":5},{"jumpurl":"","keyword":"Seve","sort":6},{"jumpurl":"","keyword":"这个年纪","sort":7},{"jumpurl":"","keyword":"Faded","sort":8},{"jumpurl":"","keyword":"TFBOYS","sort":9},{"jumpurl":"","keyword":"多幸运","sort":9},{"jumpurl":"","keyword":"三生三世","sort":10},{"jumpurl":"","keyword":"X玖少年团","sort":11},{"jumpurl":"","keyword":"当你","sort":14}]
         * timestamp : 1487916354
         */

        private int timestamp;
        private List<HotTagInfo> info;

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public List<HotTagInfo> getInfo() {
            return info;
        }

        public void setInfo(List<HotTagInfo> info) {
            this.info = info;
        }

        public static class HotTagInfo {
            /**
             * jumpurl :
             * keyword : 歌手2017
             * sort : 0
             */

            private String jumpurl;
            private String keyword;
            private int sort;

            public String getJumpurl() {
                return jumpurl;
            }

            public void setJumpurl(String jumpurl) {
                this.jumpurl = jumpurl;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }
        }
    }
}
