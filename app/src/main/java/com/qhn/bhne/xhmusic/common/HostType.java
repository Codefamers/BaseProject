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
package com.qhn.bhne.xhmusic.common;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @author quhuainan
 * created on 2017/1/16 0016
 */
public class HostType {

 /*   *//**
     * 多少种Host类型
     *//*
    public static final int TYPE_COUNT = 3;


    /**
     * "api.songlist.ttpod.com/"
     *//*
    public static final int API_SONGLIST_TTPOD = 2;

    /**
     * "api.dongting.com/"
     */
    public static final int API_KU_GOUT_RECOMMEND = 3;
    /*
    * "fm.api.ttpod.com/"
    * */
    public static final int FM_API_TTPOD = 4;
    /*
    *
    * "http://mobilecdn.kugou.com/api/v3/"
    * */
    public static final int MOBILECDN_KUGOU = 5;

    public static final int SONG_LIST = 6;
    /*
    * http://mobilecdn.kugou.com/api/v3/search/
    * */
    public static final int HOT_TAG_SEARCH = 8;
    /*
    * http://ads.service.kugou.com/v1/
    * */
    public static final int KU_GOU_BANNER = 9;

    /*
    * http://fm.service.kugou.com/v1
    * */
    public static final int KU_GOU_FM_TYPE = 10;

    /*酷狗音乐详情
    * http://m.kugou.com/app/i/
    * */
    public static final int SONG_INFO = 11;
    public static final int TYPE_COUNT = 7;
    public static final int API_SONGLIST_TTPOD = 2;

    /**
     * 替代枚举的方案，使用IntDef保证类型安全
     */
    @IntDef({ API_KU_GOUT_RECOMMEND,FM_API_TTPOD,MOBILECDN_KUGOU,SONG_LIST,HOT_TAG_SEARCH,KU_GOU_BANNER
    ,KU_GOU_FM_TYPE,SONG_INFO})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HostTypeChecker {

    }

}
