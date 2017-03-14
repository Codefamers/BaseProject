package com.qhn.bhne.xhmusic.mvp.entity;

import java.util.List;

public class DataBean<T> {
    /**
     * info : [{"320filesize":11499711,"320hash":"A6F73E23C8F26E9D2703C0ACC1B5EB63","320privilege":0,"album_id":"0","bitrate":128,"duration":287,"extname":"mp3","fail_process":0,"fail_process_320":0,"fail_process_sq":0,"feetype":0,"filename":"薛之谦 - 意外","filesize":4607159,"has_accompany":1,"hash":"C726C14611F18C9410C5ED2BEF770DFD","inlist":1,"m4afilesize":0,"mvhash":"1D86AC853C39B4B450D502981E0CC1E1","pay_type":0,"pay_type_320":0,"pay_type_sq":0,"pkg_price":0,"pkg_price_320":0,"pkg_price_sq":0,"price":0,"price_320":0,"price_sq":0,"privilege":0,"remark":"《如果我爱你》电视剧插曲","sqfilesize":33990132,"sqhash":"F050CB310F30AA0C11115E8F9CCA7207","sqprivilege":0,"topic_url":"","topic_url_320":"","topic_url_sq":""}]
     * timestamp : 1488361941
     * total : 40
     */
    private List<T> info;
    private int timestamp;
   private int total;


  /*  public T getOtherData() {
        return otherData;
    }

    public void setOtherData(T otherData) {
        this.otherData = otherData;
    }*/

   // private T otherData;

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    /*public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
*/
    public List<T> getInfo() {
        return info;
    }

    public void setInfo(List<T> info) {
        this.info = info;
    }


}