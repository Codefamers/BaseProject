package com.qhn.bhne.baseproject.mvp.entity;

import java.util.List;

/**
 * Created by qhn
 * on 2016/11/4 0004.
 */
public class RecommendContent {


    private long version;
    /**
     * action : {"type":0}
     * data : [{"action":{"type":1,"value":"http://h.xiami.com/music/create-key.html"},"id":3810,"name":"虾米导流","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/4/58170e6a2328e_210956_1477906026.jpg"}]
     * id : 2971
     * isNameDisplay : 0
     * name : 海报（天天动听）
     * style : 8
     */

    private List<DataBean> data;


    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }



    //第一个Data
    public static class DataBean {
        /**
         * type : 0
         */

        private ActionBean action;//第一个action
        private int id;
        private int isNameDisplay;
        private String name;
        private int style;
        private List<DataContent> data;//第二个Data,真正想要的内容
        /**
         * action : {"type":1,"value":"http://h.xiami.com/music/create-key.html"}
         * id : 3810
         * name : 虾米导流
         * picUrl : http://pic.xiami.net/images/trade/ams_homepage/4/58170e6a2328e_210956_1477906026.jpg
         */



        public ActionBean getAction() {
            return action;
        }

        public void setAction(ActionBean action) {
            this.action = action;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsNameDisplay() {
            return isNameDisplay;
        }

        public void setIsNameDisplay(int isNameDisplay) {
            this.isNameDisplay = isNameDisplay;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }

        public List<DataContent> getData() {
            return data;
        }

        public void setData(List<DataContent> data) {
            this.data = data;
        }

        public static class ActionBean {
            private int type;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class DataContent {
            /**
             * type : 1
             * value : http://h.xiami.com/music/create-key.html
             */

            private ActionContent action;
            private int id;
            private String name;//封面名称
            private String picUrl;//封面图片
            private String author;//封面作者
            private String desc;//封面描述
            private int listenCount;//下载量
            private int bulletCount;//点赞量
            private int comments;//评论量

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getComments() {
                return comments;
            }

            public void setComments(int comments) {
                this.comments = comments;
            }

            public int getBulletCount() {
                return bulletCount;
            }

            public void setBulletCount(int bulletCount) {
                this.bulletCount = bulletCount;
            }

            public int getListenCount() {
                return listenCount;
            }

            public void setListenCount(int listenCount) {
                this.listenCount = listenCount;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public ActionContent getAction() {
                return action;
            }

            public void setAction(ActionContent action) {
                this.action = action;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public static class ActionContent {
                private int type;
                private String value;

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }
    }
}
