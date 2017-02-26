package com.qhn.bhne.baseproject.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Util;
import com.qhn.bhne.baseproject.BuildConfig;
import com.qhn.bhne.baseproject.db.DaoMaster;
import com.qhn.bhne.baseproject.db.DaoSession;
import com.qhn.bhne.baseproject.di.component.ApplicationComponent;
import com.qhn.bhne.baseproject.di.component.DaggerApplicationComponent;
import com.qhn.bhne.baseproject.di.module.ApplicationModule;
import com.socks.library.KLog;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import org.greenrobot.greendao.database.Database;


/**
 * Created by qhn
 * on 2016/10/26 0026.
 */

public class App extends Application {
    private RefWatcher refWatcher;//内存泄漏工具

    private DaoSession daoSession;

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public void setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
    }

    private static Context sAppContext;

    public ApplicationComponent mApplicationComponent;
    private String userAgent;

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }


    public static Context getAppContext() {
        return sAppContext;
    }

    //private static DaoSe
    public static RefWatcher getRefWatcher(Context context) {
        App application = (App) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = this;
        //初始化内存泄漏工具版本
        initLeakCanary();
        //初始化log随着activity生命周期的打印语句
        initActivityLifecycleLogs();
        //开启内存泄漏详细模式
        initStrictMode();
        initDayNightMode();
        KLog.init(BuildConfig.LOG_DEBUG);
        // 官方推荐将获取 DaoMaster 对象的方法放到 Application 层，这样将避免多次创建生成 Session 对象
        initDatabase();//配置数据库
        initApplicationComponent();
        userAgent = Util.getUserAgent(this, "ExoPlayerDemo");

    }

    private void initDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,
                "xh-music-db");
        Database db = helper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        setDaoSession(daoSession);
        KLog.d("App" + daoMaster.getDatabase());
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
        mApplicationComponent = DaggerApplicationComponent.builder()
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
            refWatcher = LeakCanary.install(this);//如果是debug版就在app上安装内存检测工具
        else
            refWatcher = installLeakCanary();
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
