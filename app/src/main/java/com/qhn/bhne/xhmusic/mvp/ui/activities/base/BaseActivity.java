package com.qhn.bhne.xhmusic.mvp.ui.activities.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.application.App;
import com.qhn.bhne.xhmusic.di.component.ActivityComponent;
import com.qhn.bhne.xhmusic.di.component.DaggerActivityComponent;
import com.qhn.bhne.xhmusic.di.module.ActivityModule;
import com.qhn.bhne.xhmusic.mvp.presenter.base.BasePresenter;
import com.qhn.bhne.xhmusic.utils.NetUtil;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.socks.library.KLog;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;

/**
 * Created by qhn
 * on 2016/10/27 0027.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
    protected ActivityComponent mActivityComponent;
    protected T mPresenter;
    public Unbinder mUnbinder;

    public ActivityComponent getmActivityComponent() {
        return mActivityComponent;
    }

    private WindowManager mWindowManager = null;
    private View mNightView = null;
    private boolean mIsAddedView;

    protected boolean mIsHasNavigationView;
    private DrawerLayout mDrawerLayout;
    protected Subscription mSubscription;
    protected NavigationView mBaseNavView;
    private Class mClass;
    protected Toolbar toolbar;
    //toolbar染色或者透明 false代表染色
    private Boolean isTransparency = false;

    public Boolean getTransparency() {
        return isTransparency;
    }

    public void setTransparency(Boolean transparency) {
        isTransparency = transparency;
    }

    protected abstract void initViews();

    protected abstract void initInjector();

    protected abstract int getLayoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KLog.i(getClass().getSimpleName());
        NetUtil.isNetworkErrThenShowMsg();//网络错误时显示错误信息
        initActivityComponent();
        setNightOrDayMode();
        int layoutId = getLayoutId();
        setContentView(layoutId);
        initInjector();
        mUnbinder = ButterKnife.bind(this);
        initToolBar();
        initViews();
        if (mIsHasNavigationView)
            initDrawerLayout();
        if (mPresenter != null) {
            mPresenter.create();
        }
        initNightModeSwitch();
        if (isTransparency) {
            makeStatusBarTransparent();
        } else
            setStatusBarTranslucent();
    }

    private void initNightModeSwitch() {

    }

    /*设置透明状态栏*/
    private void makeStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.alpha_00_white);
        }

    }

    private void initDrawerLayout() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (navView != null) {
            navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_news:
                            // mClass= NewsActivity.class;
                            break;
                        case R.id.nav_photo:
                            Toast.makeText(BaseActivity.this, "照片", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.nav_video:
                            Toast.makeText(BaseActivity.this, "照片", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.nav_night_mode:
                            break;
                    }
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                    return false;
                }
            });
        }
    }


    private void initToolBar() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(this);


    }


    private void setNightOrDayMode() {

    }


    // TODO:适配4.4
    @TargetApi(Build.VERSION_CODES.KITKAT)
    protected void setStatusBarTranslucent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorPrimaryDark);
        }
    }

    private void initActivityComponent() {
        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((App) getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();

    }


}
