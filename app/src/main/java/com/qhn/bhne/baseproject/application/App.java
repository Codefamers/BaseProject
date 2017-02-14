package com.qhn.bhne.baseproject.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Util;
import com.qhn.bhne.baseproject.BuildConfig;
import com.qhn.bhne.baseproject.common.Constants;
import com.qhn.bhne.baseproject.di.component.ApplicationComponent;

import com.qhn.bhne.baseproject.di.component.DaggerApplicationComponent;
import com.qhn.bhne.baseproject.di.module.ApplicationModule;
import com.qhn.bhne.baseproject.mvp.entity.Songs;
import com.qhn.greendao.DaoMaster;
import com.qhn.greendao.DaoSession;
import com.qhn.greendao.NewsChannelTableDao;
import com.socks.library.KLog;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
/**
 * Created by qhn
 * on 2016/10/26 0026.
 */

public class App extends Application {
    private RefWatcher refWatcher;//内存泄漏工具
    private List<Songs> currentPlayMusicList;



    private static Context sAppContext;
    private static DaoSession mDaoSession;
    public ApplicationComponent mApplicationComponent;
    private String userAgent;

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }


    public static Context getAppContext() {
        return sAppContext;
    }

    //private static DaoSe
    public  static  RefWatcher getRefWatcher(Context context){
        App application= (App) context.getApplicationContext();
        return  application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext=this;
        //初始化内存泄漏工具版本
        initLeakCanary();
        //初始化log随着activity生命周期的打印语句
        initActivityLifecycleLogs();
        //开启内存泄漏详细模式
        initStrictMode();
        initDayNightMode();
        KLog.init(BuildConfig.LOG_DEBUG);
        // 官方推荐将获取 DaoMaster 对象的方法放到 Application 层，这样将避免多次创建生成 Session 对象
        setupDatabase();//配置数据库
        initApplicationComponent();

        userAgent = Util.getUserAgent(this, "ExoPlayerDemo");

    }
    public List<Songs> getCurrentPlayMusicList() {
        return currentPlayMusicList;
    }

    public void setCurrentPlayMusicList(List<Songs> currentPlayMusicList) {
        this.currentPlayMusicList = currentPlayMusicList;
    }
    private void setupDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, Constants.DB_NAME, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
        // 在 QueryBuilder 类中内置两个 Flag 用于方便输出执行的 SQL 语句与传递参数的值
        QueryBuilder.LOG_SQL = BuildConfig.DEBUG;
        QueryBuilder.LOG_VALUES = BuildConfig.DEBUG;
    }
    //激活rxjavaStrictMode将在主线程执行的耗时操作打印出来
    private void initStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                    new StrictMode
                            .ThreadPolicy.Builder()
                            .detectAll()
                            //.penaltyDialog()//弹出违规对话框
                            .penaltyLog()//打印违规信息
                            .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }

    }

    private void initDayNightMode() {

    }

    private void initApplicationComponent() {
        mApplicationComponent= DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    private void initActivityLifecycleLogs() {
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                KLog.v("=========", activity + "  onActivityCreated");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                KLog.v("=========", activity + "  onActivityStarted");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                KLog.v("=========", activity + "  onActivityResumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                KLog.v("=========", activity + "  onActivityPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                KLog.v("=========", activity + "  onActivityStopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                KLog.v("=========", activity + "  onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                KLog.v("=========", activity + "  onActivityDestroyed");
            }
        });
    }

    private void initLeakCanary() {
        if (BuildConfig.DEBUG)
            refWatcher= LeakCanary.install(this);//如果是debug版就在app上安装内存检测工具
        else
            refWatcher=installLeakCanary();
    }
    public static NewsChannelTableDao getNewsChannelTableDao() {
        return mDaoSession.getNewsChannelTableDao();
    }
    private RefWatcher installLeakCanary() {
        return RefWatcher.DISABLED;
    }


    public DataSource.Factory buildDataSourceFactory(DefaultBandwidthMeter bandwidthMeter) {
        return new DefaultDataSourceFactory(this, bandwidthMeter,
                buildHttpDataSourceFactory(bandwidthMeter));
    }

    public HttpDataSource.Factory buildHttpDataSourceFactory(DefaultBandwidthMeter bandwidthMeter) {
        return new DefaultHttpDataSourceFactory(userAgent, bandwidthMeter);
    }

    public boolean useExtensionRenderers() {
        return BuildConfig.FLAVOR.equals("withExtensions");
    }
}
