package com.qhn.bhne.baseproject.common;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;



/**
 * Created by qhn
 * on 2017/2/23 0023.
 */

public class MusicConstants {

    /*音乐当前的状态：只有播放、暂停、停止三种*/
    public enum MusicStatus {
        PLAY, PAUSE, STOP
    }


    public static final int MUSIC_QUALITY_FLUENCY = 0;
    public static final int MUSIC_QUALITY_STANDARD = 1;
    public static final int MUSIC_QUALITY_SUPER = 2;
    @IntDef({MUSIC_QUALITY_FLUENCY,MUSIC_QUALITY_STANDARD,MUSIC_QUALITY_SUPER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MusicQuality {
    }



}
