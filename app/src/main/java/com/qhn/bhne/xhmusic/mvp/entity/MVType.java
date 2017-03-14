package com.qhn.bhne.xhmusic.mvp.entity;

import java.util.List;

/**
 * Created by qhn
 * on 2016/11/8 0008.
 */

public class MVType {

    /**
     * code : 1
     * data : [{"id":3,"name":"类型","order":1,"parentId":0,"subType":[{"id":22,"name":"高热","order":1,"parentId":3},{"id":13,"name":"神曲","order":2,"parentId":3},{"id":14,"name":"性感","order":3,"parentId":3},{"id":15,"name":"舞曲","order":4,"parentId":3},{"id":17,"name":"中国风","order":6,"parentId":3},{"id":18,"name":"爱情","order":7,"parentId":3},{"id":19,"name":"经典","order":8,"parentId":3},{"id":20,"name":"演唱会","order":9,"parentId":3},{"id":11,"name":"影视","order":10,"parentId":3}]},{"id":1,"name":"地区","order":2,"parentId":0,"subType":[{"id":4,"name":"内地","order":1,"parentId":1},{"id":5,"name":"港台","order":2,"parentId":1},{"id":6,"name":"欧美","order":3,"parentId":1},{"id":7,"name":"韩国","order":4,"parentId":1},{"id":8,"name":"日本","order":5,"parentId":1}]},{"id":2,"name":"版本","order":3,"parentId":0,"subType":[{"id":10,"name":"官方版","order":1,"parentId":2},{"id":12,"name":"现场版","order":3,"parentId":2}]}]
     * msg : ok
     * page : 0
     * pageCount : 0
     * size : 0
     * totalCount : 0
     */

    private int code;
    private String msg;
    private int page;
    private int pageCount;
    private int size;
    private int totalCount;
    /**
     * id : 3
     * name : 类型
     * order : 1
     * parentId : 0
     * subType : [{"id":22,"name":"高热","order":1,"parentId":3},{"id":13,"name":"神曲","order":2,"parentId":3},{"id":14,"name":"性感","order":3,"parentId":3},{"id":15,"name":"舞曲","order":4,"parentId":3},{"id":17,"name":"中国风","order":6,"parentId":3},{"id":18,"name":"爱情","order":7,"parentId":3},{"id":19,"name":"经典","order":8,"parentId":3},{"id":20,"name":"演唱会","order":9,"parentId":3},{"id":11,"name":"影视","order":10,"parentId":3}]
     */

    private List<MVTypeBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<MVTypeBean> getData() {
        return data;
    }

    public void setData(List<MVTypeBean> data) {
        this.data = data;
    }

    public static class MVTypeBean {
        private int id;
        private String name;
        private int order;
        private int parentId;
        /**
         * id : 22
         * name : 高热
         * order : 1
         * parentId : 3
         */

        private List<MVSubTypeBean> subType;

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

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public List<MVSubTypeBean> getSubType() {
            return subType;
        }

        public void setSubType(List<MVSubTypeBean> subType) {
            this.subType = subType;
        }

        public static class MVSubTypeBean {
            private int id;
            private String name;
            private int order;
            private int parentId;

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

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }
        }
    }
}
