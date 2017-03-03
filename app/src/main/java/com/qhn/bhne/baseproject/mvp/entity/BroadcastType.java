package com.qhn.bhne.baseproject.mvp.entity;

public  class BroadcastType {
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