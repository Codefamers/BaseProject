package com.qhn.bhne.baseproject.mvp.entity;

public class Banner {
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