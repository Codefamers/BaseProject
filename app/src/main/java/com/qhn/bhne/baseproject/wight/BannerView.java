package com.qhn.bhne.baseproject.wight;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;
import com.qhn.bhne.baseproject.utils.DimenUtil;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/8/3 0003.
 */
public class BannerView extends FrameLayout {
    //轮播图图片数量
    private final static int IMAGE_COUNT = 5;
    //自动轮播的时间间隔
    private final static int TIME_INTERVAL = 10;
    //自动轮播启用开关
    private final static boolean isAutoPlay = true;
    //小圆点半径
    private static final int DOT_VIEW_RADIUS = 5;
    //小圆点之间的距离
    private static final int DOT_VIEW_DISTANCE = 5;
    //默认的的资源ID
    private int[] imagesResIds;



    //从网络加载的资源url
    private List<String> imageUrlList;

    //放轮播图片的ImageView的list
    private List<ImageView> imageViewsList;
    //放圆点的View的list
    private List<View> dotViewsList;
    private ViewPager viewPager;
    //当前轮播页
    private int currentItem = 0;
    //定时任务
    private ScheduledExecutorService scheduledExecutorService;
    //Handler
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            viewPager.setCurrentItem(currentItem);
        }
    };
    public List<String> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(List<String> imageUrlList,Context context) {
        this.imageUrlList = imageUrlList;
        initUI(context);
        invalidate();

    }
    //Code中实例化一个View会调用
    public BannerView(Context context) {
        this(context, null);

    }

    //xml中定义会调用第二个构造函数
    public BannerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public BannerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initData();
        initUI(context);
        if (isAutoPlay) {
            startPlay();
        }
    }

    /**
     * <p/>
     * 开始轮播图切换
     * 085.
     */
    private void startPlay() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new SlideShowTask(), 1, 5,
                TimeUnit.SECONDS);
    }

    /**
     * <p/>
     * 停止轮播图切换
     */

    private void stopPlay() {
        scheduledExecutorService.shutdown();
    }

    /**
     * 097.
     * <p/>
     * 初始化相关Data
     * 098.
     */
    public void initData() {
        imagesResIds = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
        imageViewsList = new ArrayList();
        dotViewsList = new ArrayList();

    }

    /**
     * <p/>
     * 初始化Views等UI
     * 114.
     */
    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_slideshow, this, true);
        LinearLayout llDot = (LinearLayout) findViewById(R.id.ll_dot);
        imageUrlList=getImageUrlList();
        imageViewsList.clear();
        dotViewsList.clear();
        llDot.removeAllViews();
        if (imageUrlList==null) {
            for (int imageID : imagesResIds) {
                ImageView view = new ImageView(context);
                view.setImageResource(imageID);
                view.setScaleType(ImageView.ScaleType.FIT_XY);
                imageViewsList.add(view);
                ImageView dotView = new ImageView(context);
                dotView.setImageDrawable(context.getResources().getDrawable(R.drawable.dot_black));
                dotView.setScaleType(ImageView.ScaleType.FIT_XY);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        DimenUtil.dp2px(DOT_VIEW_RADIUS), DimenUtil.dp2px(
                        DOT_VIEW_RADIUS));
                if (dotViewsList.size() > 0) {
                    params.leftMargin = DimenUtil.dp2px(DOT_VIEW_DISTANCE);
                }
                dotView.setLayoutParams(params);
                dotViewsList.add(dotView);
                llDot.addView(dotView);
            }
        }else {
            for (String imageUrl : imageUrlList) {
                ImageView view = new ImageView(context);
                MyUtils.loadImageFormNet(imageUrl,view, (Activity) context);
                view.setScaleType(ImageView.ScaleType.FIT_XY);
                imageViewsList.add(view);
                ImageView dotView = new ImageView(context);
                dotView.setImageDrawable(context.getResources().getDrawable(R.drawable.dot_black));
                dotView.setScaleType(ImageView.ScaleType.FIT_XY);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        DimenUtil.dp2px(DOT_VIEW_RADIUS), DimenUtil.dp2px(
                        DOT_VIEW_RADIUS));
                if (dotViewsList.size() > 0) {
                    params.leftMargin = DimenUtil.dp2px(DOT_VIEW_DISTANCE);
                }
                dotView.setLayoutParams(params);
                dotViewsList.add(dotView);
                llDot.addView(dotView);
            }
        }



        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setFocusable(true);
        viewPager.setAdapter(new MyPagerAdapter());
        viewPager.setOnPageChangeListener(new MyPageChangeListener());
    }

    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViewsList.get(position));
        }

        @Override
        public int getCount() {
            return imageViewsList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViewsList.get(position));
            return imageViewsList.get(position);

        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }


    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        boolean isAutoPlay = false;

        @Override
        public void onPageScrollStateChanged(int arg0) {
            switch (arg0) {
                case 1://手势滑动，空闲中
                    isAutoPlay = false;
                    break;
                case 2://界面切换中
                    isAutoPlay = true;
                    break;
                case 0:
                    //滑动结束，即切换完毕或者加载完毕
                    //当前为最后一张，此时从右向左滑，则切换到第一张
                    if (viewPager.getCurrentItem() == viewPager.getAdapter().getCount() - 1 && !isAutoPlay) {
                        viewPager.setCurrentItem(0);
                    }
                    //当前为第一张，此时从左向右滑，则切换到最后一张
                    else if (viewPager.getCurrentItem() == 0 && !isAutoPlay) {
                        viewPager.setCurrentItem(viewPager.getAdapter().getCount() - 1);
                    }
                    break;

            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int pos) {
            currentItem = pos;
            for (int i = 0; i < dotViewsList.size(); i++) {
                if (i == pos) {
                    (dotViewsList.get(pos)).setBackgroundResource(R.drawable.dot_black);
                } else {
                    (dotViewsList.get(i)).setBackgroundResource(R.drawable.dot_white);
                }
            }
        }

        /**
         * 263.
         * <p/>
         * 销毁ImageView资源，回收内存
         */
        private void destoryBitmaps() {
            for (int i = 0; i < IMAGE_COUNT; i++) {
                ImageView imageView = imageViewsList.get(i);
                Drawable drawable = imageView.getDrawable();
                if (drawable != null) {
                    //解除drawable对view的引用
                    drawable.setCallback(null);
                }
            }
        }


    }

    /**
     * 执行轮播图切换任务
     *
     * @author caizhiming
     */
    private class SlideShowTask implements Runnable {
        @Override
        public void run() {
            synchronized (viewPager) {
                currentItem = (currentItem + 1) % imageViewsList.size();
                handler.obtainMessage().sendToTarget();
            }
        }
    }

}