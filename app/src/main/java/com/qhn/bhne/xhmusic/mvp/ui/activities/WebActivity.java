package com.qhn.bhne.xhmusic.mvp.ui.activities;

import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.mvp.ui.activities.base.BaseActivity;

import butterknife.BindView;

public class WebActivity extends BaseActivity {


    public static final String JUMP_URL = "JUMP_URL";
    public static final String TITLE = "title";
    @BindView(R.id.web_show_album)
    WebView webShowAlbum;

    @Override
    protected void initViews() {
        initWeb();
    }

    private void initWeb() {
        String jumpUrl = getIntent().getStringExtra(JUMP_URL);
        String keyWord = getIntent().getStringExtra(TITLE);
        toolbar.setTitle(keyWord);
        WebSettings settings = webShowAlbum.getSettings();
        webShowAlbum.getSettings().setJavaScriptEnabled(true);
        webShowAlbum.setWebViewClient(new WebViewClient());
        webShowAlbum.loadUrl(jumpUrl);
        // 设置可以支持缩放
        settings.setSupportZoom(true);
        // 设置出现缩放工具
        settings.setBuiltInZoomControls(true);
        //设置可在大视野范围内上下左右拖动，并且可以任意比例缩放
        settings.setUseWideViewPort(true);
        //设置默认加载的可视范围是大视野范围
        settings.setLoadWithOverviewMode(true);
        //自适应屏幕
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }


}
