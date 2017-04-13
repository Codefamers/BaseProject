package com.qhn.bhne.xhmusic.mvp.localMusic;

import android.animation.Animator;
import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.db.DaoSession;
import com.qhn.bhne.xhmusic.mvp.entity.db.SongInfo;
import com.qhn.bhne.xhmusic.mvp.model.impl.LocalMusicInfoProvider;
import com.qhn.bhne.xhmusic.mvp.ui.activities.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class ScanMusicActivity extends BaseActivity {

    @BindView(R.id.img_scan_icon)
    ImageView imgScanIcon;
    @BindView(R.id.img_scan_effect)
    ImageView imgScanEffect;
    @BindView(R.id.txt_show_result)
    TextView txtShowResult;
    private ValueAnimator animator;
    @Inject
    DaoSession daoSession;

    @Override
    protected void initViews() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_scan_music;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    public void startScanAnim() {
        animator = ValueAnimator.ofFloat(360, 0);
        animator.setDuration(50000);
        animator.setEvaluator(new FloatEvaluator());
        animator.setRepeatCount(-1);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatMode(ValueAnimator.REVERSE);
        final int radius = 30;
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float angle = (float) animation.getAnimatedValue();
                float translateX = (float) (radius * Math.cos(angle));
                float translateY = (float) (radius * Math.sin(angle));
                imgScanIcon.setTranslationX(translateX);
                imgScanIcon.setTranslationY(translateY);
            }
        });

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                imgScanIcon.setSelected(true);
                imgScanIcon.setTranslationX(0);
                imgScanIcon.setTranslationY(0);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
        //扫描效果添加
        TranslateAnimation translateAnimation = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_PARENT, 0f, TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f, TranslateAnimation.RELATIVE_TO_PARENT, 0.7f);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setDuration(2000);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(TranslateAnimation.REVERSE);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imgScanEffect.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgScanEffect.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imgScanEffect.clearAnimation();
        imgScanEffect.startAnimation(translateAnimation);
    }


    public void stopScanAnim() {
        imgScanEffect.clearAnimation();
        imgScanEffect.setVisibility(View.GONE);
        if (null != animator && animator.isRunning()) {
            animator.end();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopScanAnim();
    }

    @OnClick({R.id.txt_return_local_music, R.id.txt_get_lrc})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_return_local_music:
                scanLocalMusic();
                startScanAnim();
                break;
            case R.id.txt_get_lrc:
                stopScanAnim();
                break;
        }
    }

    //扫描本地音乐
    private void scanLocalMusic() {
        List<SongInfo> songInfoList = new LocalMusicInfoProvider().queryMusic(LocalMusicInfoProvider.START_FROM_LOCAL);
        for (SongInfo songInfo : songInfoList) {
            daoSession.getSongInfoDao().insert(songInfo);
        }
    }
}
