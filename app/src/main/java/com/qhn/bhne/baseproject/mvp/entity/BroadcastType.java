package com.qhn.bhne.baseproject.mvp.entity;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */
public class BroadcastType {


    /**
     * status : 1
     * error_code : 0
     * data : [{"sort":4,"className":"主题","sort_app":1,"display_app":1,"display_pc":1,"img":"20120413101532394961.jpg","classId":7},{"sort":1,"className":"场景","sort_app":2,"display_app":1,"display_pc":1,"img":"20120413101527273434.jpg","classId":6},{"sort":3,"className":"心情","sort_app":3,"display_app":1,"display_pc":1,"img":"20120413101514300868.jpg","classId":4},{"sort":6,"className":"风格","sort_app":4,"display_app":1,"display_pc":1,"img":"20120413101502420746.jpg","classId":2},{"sort":5,"className":"人群","sort_app":5,"display_app":1,"display_pc":1,"img":"20120413101518220921.jpg","classId":5},{"sort":7,"className":"语言","sort_app":6,"display_app":1,"display_pc":1,"img":"20120413101508353680.jpg","classId":3},{"sort":12,"className":"运动","sort_app":7,"display_app":1,"display_pc":1,"img":"","classId":23},{"sort":8,"className":"乐器","sort_app":8,"display_app":1,"display_pc":1,"img":"","classId":24},{"sort":2,"className":"DJ","sort_app":9,"display_app":1,"display_pc":1,"img":"","classId":22},{"sort":10,"className":"儿童","sort_app":10,"display_app":1,"display_pc":1,"img":"","classId":21},{"sort":11,"className":"综艺","sort_app":11,"display_app":1,"display_pc":1,"img":"","classId":25}]
     */

    private int status;
    private int error_code;
    private List<BroadcastBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<BroadcastBean> getData() {
        return data;
    }

    public void setData(List<BroadcastBean> data) {
        this.data = data;
    }

    public static class BroadcastBean {
        /**
         * sort : 4
         * className : 主题
         * sort_app : 1
         * display_app : 1
         * display_pc : 1
         * img : 20120413101532394961.jpg
         * classId : 7
         */

        private int sort;
        private String className;
        private int sort_app;
        private int display_app;
        private int display_pc;
        private String img;
        private int classId;

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public int getSort_app() {
            return sort_app;
        }

        public void setSort_app(int sort_app) {
            this.sort_app = sort_app;
        }

        public int getDisplay_app() {
            return display_app;
        }

        public void setDisplay_app(int display_app) {
            this.display_app = display_app;
        }

        public int getDisplay_pc() {
            return display_pc;
        }

        public void setDisplay_pc(int display_pc) {
            this.display_pc = display_pc;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getClassId() {
            return classId;
        }

        public void setClassId(int classId) {
            this.classId = classId;
        }
    }
}
