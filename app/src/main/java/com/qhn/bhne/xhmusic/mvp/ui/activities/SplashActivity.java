package com.qhn.bhne.xhmusic.mvp.ui.activities;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.qhn.bhne.xhmusic.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.logo_outer_iv)
    ImageView logoOuterIv;
    @BindView(R.id.logo_inner_iv)
    ImageView logoInnerIv;
    @BindView(R.id.app_name_tv)
    TextView appNameTv;
    boolean isShowingRubberEffect = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.zoomin, 0);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initAnimation();
    }

    private void initAnimation() {
        startLogoInner1();
        startLogoOuterAndAppName();
    }
    private void startLogoInner1() {
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.anim_top_in);
        logoInnerIv.startAnimation(animation);
    }
    private void startLogoOuterAndAppName() {
        ValueAnimator valueAnimator=ValueAnimator.ofFloat(0,1);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fraction=valueAnimator.getAnimatedFraction();//获取动画进行的部分
                if (fraction>=0.8&&!isShowingRubberEffect) {
                    isShowingRubberEffect=true;
                    startLogoOuter();
                    startShowAppName();
                    finishActivity();
                }else if(fraction>=0.95){
                    valueAnimator.cancel();
                    startLogoInner2();
                }
            }
        });
        valueAnimator.start();
    }

    private void startLogoInner2() {
        YoYo.with(Techniques.Bounce).duration(1000).playOn(logoInnerIv);
    }

    private void startLogoOuter() {
        YoYo.with(Techniques.RubberBand).duration(1000).playOn(logoOuterIv);
    }

    private void startShowAppName() {
        YoYo.with(Techniques.FadeIn).duration(1000).playOn(appNameTv);
    }

    private void finishActivity() {
        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        overridePendingTransition(0, android.R.anim.fade_out);
                        finish();
                    }
                });
    }
}
