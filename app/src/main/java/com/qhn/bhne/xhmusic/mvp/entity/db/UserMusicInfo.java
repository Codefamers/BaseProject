package com.qhn.bhne.xhmusic.mvp.entity.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by qhn
 * on 2017/3/15 0015.
 */
@Entity
public class UserMusicInfo {
    @Id(autoincrement = true)
    private Long id;

    private int localMusicCount;//本地歌曲数量

    private int recentPlayCount;//最近播放数量
    private int loadDownCount;//歌曲下载数量
    private int loveSingerCount;//喜欢的歌手数量
    private int loveMVCount;//喜欢的MV数量
    private int buildSongMenuCount;//自己创建的歌单数量
    private int collectSongMenuCount;//收藏的歌单数量
    private boolean isScanLocalMusic;
    @Generated(hash = 100558710)
    public UserMusicInfo(Long id, int localMusicCount, int recentPlayCount,
            int loadDownCount, int loveSingerCount, int loveMVCount,
            int buildSongMenuCount, int collectSongMenuCount,
            boolean isScanLocalMusic) {
        this.id = id;
        this.localMusicCount = localMusicCount;
        this.recentPlayCount = recentPlayCount;
        this.loadDownCount = loadDownCount;
        this.loveSingerCount = loveSingerCount;
        this.loveMVCount = loveMVCount;
        this.buildSongMenuCount = buildSongMenuCount;
        this.collectSongMenuCount = collectSongMenuCount;
        this.isScanLocalMusic = isScanLocalMusic;
    }
    @Generated(hash = 1748195004)
    public UserMusicInfo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getLocalMusicCount() {
        return this.localMusicCount;
    }
    public void setLocalMusicCount(int localMusicCount) {
        this.localMusicCount = localMusicCount;
    }
    public int getRecentPlayCount() {
        return this.recentPlayCount;
    }
    public void setRecentPlayCount(int recentPlayCount) {
        this.recentPlayCount = recentPlayCount;
    }
    public int getLoadDownCount() {
        return this.loadDownCount;
    }
    public void setLoadDownCount(int loadDownCount) {
        this.loadDownCount = loadDownCount;
    }
    public int getLoveSingerCount() {
        return this.loveSingerCount;
    }
    public void setLoveSingerCount(int loveSingerCount) {
        this.loveSingerCount = loveSingerCount;
    }
    public int getLoveMVCount() {
        return this.loveMVCount;
    }
    public void setLoveMVCount(int loveMVCount) {
        this.loveMVCount = loveMVCount;
    }
    public int getBuildSongMenuCount() {
        return this.buildSongMenuCount;
    }
    public void setBuildSongMenuCount(int buildSongMenuCount) {
        this.buildSongMenuCount = buildSongMenuCount;
    }
    public int getCollectSongMenuCount() {
        return this.collectSongMenuCount;
    }
    public void setCollectSongMenuCount(int collectSongMenuCount) {
        this.collectSongMenuCount = collectSongMenuCount;
    }
    public boolean getIsScanLocalMusic() {
        return this.isScanLocalMusic;
    }
    public void setIsScanLocalMusic(boolean isScanLocalMusic) {
        this.isScanLocalMusic = isScanLocalMusic;
    }
    
}
