/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.qhn.bhne.baseproject.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.design.widget.TabLayout;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.application.App;
import com.qhn.bhne.baseproject.common.Constants;
import com.socks.library.KLog;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscription;

/**
 * @author 咖枯
 * @version 1.0 2016/5/31
 */
public class MyUtils {

    public static boolean isNightMode() {
        SharedPreferences preferences = App.getAppContext().getSharedPreferences(
                Constants.SHARES_COLOURFUL_NEWS, Activity.MODE_PRIVATE);
        return preferences.getBoolean(Constants.NIGHT_THEME_MODE, false);
    }

    public static void saveTheme(boolean isNight) {
        SharedPreferences preferences = App.getAppContext().getSharedPreferences(
                Constants.SHARES_COLOURFUL_NEWS, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(Constants.NIGHT_THEME_MODE, isNight);
        editor.apply();
    }

    public static SharedPreferences getSharedPreferences() {
        return App.getAppContext()
                .getSharedPreferences(Constants.SHARES_COLOURFUL_NEWS, Context.MODE_PRIVATE);
    }

    /**
     * from yyyy-MM-dd HH:mm:ss to MM-dd HH:mm
     */
    public static String formatDate(String before) {
        String after;
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    .parse(before);
            after = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault()).format(date);
        } catch (ParseException e) {
            KLog.e("转换新闻日期格式异常：" + e.toString());
            return before;
        }
        return after;
    }

    public static int getStatusBarHeight(Activity activity) {
        int height = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            height = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return height;
    }

    public static void dynamicSetTabLayoutMode(TabLayout tabLayout) {
        int tabWidth = calculateTabWidth(tabLayout);
        int screenWidth = getScreenWith();

        if (tabWidth <= screenWidth) {
            tabLayout.setTabMode(TabLayout.MODE_FIXED);
        } else {
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
    }

    private static int calculateTabWidth(TabLayout tabLayout) {
        int tabWidth = 0;
        for (int i = 0; i < tabLayout.getChildCount(); i++) {
            final View view = tabLayout.getChildAt(i);
            view.measure(0, 0); // 通知父view测量，以便于能够保证获取到宽高
            tabWidth += view.getMeasuredWidth();
        }
        return tabWidth;
    }

    public static int getScreenWith() {
        return App.getAppContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int getColor(int nightColor, int dayColor) {
        int color;
        if (!MyUtils.isNightMode()) {
            color = nightColor;
        } else {
            color = dayColor;
        }
        return color;
    }

    public static String analyzeNetworkError(Throwable e) {
        String errMsg = App.getAppContext().getString(R.string.load_error);
        if (e instanceof HttpException) {
            int state = ((HttpException) e).code();
            if (state == 403) {
                errMsg = App.getAppContext().getString(R.string.retry_after);
            }
        }
        return errMsg;
    }

    public static void cancelSubscription(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    /**
     * 解决InputMethodManager内存泄露现象
     */
    public static void fixInputMethodManagerLeak(Context destContext) {
        if (destContext == null) {
            return;
        }

        InputMethodManager imm = (InputMethodManager) destContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }

        String[] arr = new String[]{"mCurRootView", "mServedView", "mNextServedView"};
        Field f;
        Object obj_get;
        for (String param : arr) {
            try {
                f = imm.getClass().getDeclaredField(param);
                if (!f.isAccessible()) {
                    f.setAccessible(true);
                } // author: sodino mail:sodino@qq.com
                obj_get = f.get(imm);
                if (obj_get != null && obj_get instanceof View) {
                    View v_get = (View) obj_get;
                    if (v_get
                            .getContext() == destContext) { // 被InputMethodManager持有引用的context是想要目标销毁的
                        f.set(imm, null); // 置空，破坏掉path to gc节点
                    } else {
                        // 不是想要目标销毁的，即为又进了另一层界面了，不要处理，避免影响原逻辑,也就不用继续for循环了
                        /*if (QLog.isColorLevel()) {
                            QLog.d(ReflecterHelper.class.getSimpleName(), QLog.CLR, "fixInputMethodManagerLeak break, context is not suitable, get_context=" + v_get.getContext()+" dest_context=" + destContext);
                        }*/
                        break;
                    }
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    public static View getRootView(Activity context) {
        return ((ViewGroup) context.findViewById(android.R.id.content)).getChildAt(0);
    }

    //从Url中加载图片
    public static void loadImageFormNet(String url, ImageView imageView, Activity activity) {
        Glide.with(activity).load(url).placeholder(R.drawable.ic_placeholder).into(imageView);
        //Glide.with(activity).load(url).bitmapTransform(new RoundedCornersTransformation(activity, 200, 0, RoundedCornersTransformation.CornerType.TOP)).crossFade().into(imageView);
    }

    public static void setGridRecyclerStyle(Activity activity, RecyclerView recyclerView, int span, RecyclerView.Adapter adapter) {
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new GridLayoutManager(activity, span));
        recyclerView.setAdapter(adapter);
    }

    /*
       * 设置圆角图片 activity:上下文环境 resImageId 图片资源Url或者Id userPhoto 图片控件
       * */
    public static void setCircleIMG(final Activity activity, Object resImageId, final ImageView userPhoto) {
        if (resImageId instanceof String && TextUtils.isEmpty((String) resImageId)) {
            Toast.makeText(activity, "无效图片资源", Toast.LENGTH_SHORT).show();
            return;
        }
        if (resImageId instanceof Integer && (Integer) resImageId == 0) {
            Toast.makeText(activity, "无效图片资源", Toast.LENGTH_SHORT).show();
            return;
        }
        if (userPhoto == null) {
            Toast.makeText(activity, "无效图片控件", Toast.LENGTH_SHORT).show();
            return;
        }
        Glide.with(activity).load(resImageId).asBitmap().placeholder(R.drawable.ic_placeholder).centerCrop().into(new BitmapImageViewTarget(userPhoto) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(activity.getResources(), resource);
                //circularBitmapDrawable.setCircular(true);
                circularBitmapDrawable.setCornerRadius(2);
                userPhoto.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    //将大数字转换为小数字eg 51000-5.1万
    public static String dealBigNum(int listenCount) {
        if (listenCount > 9999) {
            int wan = listenCount / 10000;
            int small = listenCount % 10000 / 1000;
            if (small < 1)
                small = 0;
            return String.valueOf(wan) + "." + String.valueOf(small) + "万";
        }
        return String.valueOf(listenCount);
    }

    public static byte[] getImage(String address) {
        //通过代码 模拟器浏览器访问图片的流程
        URL url = null;
        try {
            url = new URL(address);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            //获取服务器返回回来的流
            InputStream is = conn.getInputStream();


            return getBytes(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] getBytes(InputStream is) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        is.close();
        bos.flush();
        byte[] result = bos.toByteArray();
        System.out.println(new String(result));
        return result;
    }
}