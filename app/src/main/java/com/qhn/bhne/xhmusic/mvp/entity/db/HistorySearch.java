package com.qhn.bhne.xhmusic.mvp.entity.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by qhn
 * on 2017/2/24 0024.
 */
@Entity
public class HistorySearch {
    @Id(autoincrement = true)
    private Long id;

    @Index(unique = true)
    @NotNull
    private String name;//搜索名称

    @Generated(hash = 1580392407)
    public HistorySearch(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 38246671)
    public HistorySearch() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
