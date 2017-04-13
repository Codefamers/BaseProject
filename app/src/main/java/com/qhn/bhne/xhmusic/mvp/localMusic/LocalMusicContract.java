package com.qhn.bhne.xhmusic.mvp.localMusic;

import com.qhn.bhne.xhmusic.mvp.BaseNewView;
import com.qhn.bhne.xhmusic.mvp.entity.SongMenu;
import com.qhn.bhne.xhmusic.mvp.entity.db.SongInfo;
import com.qhn.bhne.xhmusic.mvp.BasePresenter;


import java.util.List;

/**
 * Created by qhn
 * on 2017/4/12.
 */

public interface LocalMusicContract {
    interface View extends BaseNewView<Presenter> {
        void showLocalMusicCount(List<SongInfo> songInfoList);

        void showReccentPlayCount(List<SongInfo> songInfoList);

        void showDownLoadCount(List<SongInfo> songInfoList);

        void showMyCollectCount(int num);

        void updateBuildSongMenu(List<SongMenu> songMenuList);

        void updateCollectSongMenu(List<SongMenu> songMenuList);
    }

    interface Presenter extends BasePresenter {
        //查询本地音乐信息
        void queryLocalMusic();

        //查询最近播放
        void queryRecentPlay();

        //查询下载内容
        void queryDownLoad();

        //查询我收藏的歌手
        void queryMyCollectSinger();

        //查询创建的歌单
        void queryBuildSongMenu();

        //查询收藏的歌单
        void queryCollectSongMenu();

        //添加歌单
        void addBuildSongMenu();

        //删除创建歌单
        void deleteBuildSongMenu();

    }
}
