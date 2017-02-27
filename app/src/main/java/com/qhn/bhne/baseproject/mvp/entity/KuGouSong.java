package com.qhn.bhne.baseproject.mvp.entity;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */
public class KuGouSong {

    /**
     * data : {"info":[],"timestamp":1488109150,"total":26}
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
         * info : []
         * timestamp : 1488109150
         * total : 26
         */

        private int timestamp;
        private int total;
        private List<SpecialSong> info;

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

        public List<SpecialSong> getInfo() {
            return info;
        }

        public void setInfo(List<SpecialSong> info) {
            this.info = info;
        }
    }
}
