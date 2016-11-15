package com.qhn.bhne.baseproject.mvp.entity;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.application.App;
import com.qhn.bhne.baseproject.common.ApiConstants;
import com.qhn.bhne.baseproject.common.Constants;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.qhn.greendao.NewsChannelTable;
import com.qhn.greendao.NewsChannelTableDao;

import java.util.Arrays;
import java.util.List;

import de.greenrobot.dao.query.Query;


/**
 * Created by qhn
 * on 2016/10/27 0027.
 * 让GrenDao根据实体类来创建数据库
 */

public class NewsChannelTableManager {
    /*
    * 首次打开程序初始化db
    * */
    public static void initDB(){
        if (!MyUtils.getSharedPreferences().getBoolean(Constants.INIT_DB,false)) {
            NewsChannelTableDao dao= App.getNewsChannelTableDao();
            List<String> channelName= Arrays.asList(App.getAppContext().getResources().getStringArray(R.array.mv_category));
            List<String> channelId=Arrays.asList(App.getAppContext().getResources().getStringArray(R.array.mv_category));
            for (int i = 0; i < channelName.size(); i++) {
                NewsChannelTable entity=new NewsChannelTable(channelName.get(i),channelId.get(i),
                        ApiConstants.getType(channelId.get(i)),i<=5,i,i==0);
                dao.insert(entity);
            }
            MyUtils.getSharedPreferences().edit().putBoolean(Constants.INIT_DB,true).apply();

        }
    }
    public static List<NewsChannelTable> loadNewsChannelsMine(){
        Query<NewsChannelTable> newsChannelTableQuery=App.getNewsChannelTableDao()
                .queryBuilder()
                .where(NewsChannelTableDao.Properties.NewsChannelSelect.eq(true))
                .orderAsc(NewsChannelTableDao.Properties.NewsChannelIndex)
                .build();
        return newsChannelTableQuery.list();
    }
    public static List<NewsChannelTable> loadNewsChannelsMore() {
        Query<NewsChannelTable> newsChannelTableQuery = App.getNewsChannelTableDao().queryBuilder()
                .where(NewsChannelTableDao.Properties.NewsChannelSelect.eq(false))
                .orderAsc(NewsChannelTableDao.Properties.NewsChannelIndex).build();
        return newsChannelTableQuery.list();
    }

    public static NewsChannelTable loadNewsChannel(int position) {
        return App.getNewsChannelTableDao().queryBuilder()
                .where(NewsChannelTableDao.Properties.NewsChannelIndex.eq(position)).build().unique();
    }

    public static void update(NewsChannelTable newsChannelTable) {
        App.getNewsChannelTableDao().update(newsChannelTable);
    }

    public static List<NewsChannelTable> loadNewsChannelsWithin(int from, int to) {
        Query<NewsChannelTable> newsChannelTableQuery = App.getNewsChannelTableDao().queryBuilder()
                .where(NewsChannelTableDao.Properties.NewsChannelIndex
                        .between(from, to)).build();
        return newsChannelTableQuery.list();
    }

    public static List<NewsChannelTable> loadNewsChannelsIndexGt(int channelIndex) {
        Query<NewsChannelTable> newsChannelTableQuery = App.getNewsChannelTableDao().queryBuilder()
                .where(NewsChannelTableDao.Properties.NewsChannelIndex
                        .gt(channelIndex)).build();
        return newsChannelTableQuery.list();
    }

    public static List<NewsChannelTable> loadNewsChannelsIndexLtAndIsUnselect(int channelIndex) {
        Query<NewsChannelTable> newsChannelTableQuery = App.getNewsChannelTableDao().queryBuilder()
                .where(NewsChannelTableDao.Properties.NewsChannelIndex.lt(channelIndex),
                        NewsChannelTableDao.Properties.NewsChannelSelect.eq(false)).build();
        return newsChannelTableQuery.list();
    }

    public static int getAllSize() {
        return App.getNewsChannelTableDao().loadAll().size();
    }

    public static int getNewsChannelSelectSize() {
        return (int) App.getNewsChannelTableDao().queryBuilder()
                .where(NewsChannelTableDao.Properties.NewsChannelSelect.eq(true))
                .buildCount().count();
    }
}
