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

/**
 *
 * @author quhuainan
 * created on 2017/3/4 0004
 */
public class ApiConstants {
    //推荐
    public static final String KU_GOU_RECOMMEND = "http://service.mobile.kugou.com/v1/yueku/";
    //轮播图
    public static final String KU_GOU_BAANER = "http://ads.service.kugou.com/v1/";
    //酷狗热门搜索标签//酷狗歌曲搜索
    private static final String SEARCH_HOT="http://mobilecdn.kugou.com/api/v3/search/";
    //酷狗电台类别
    public static final String KU_GOU_FM_TYPE = "http://fm.service.kugou.com/v1/";
    //酷狗
    private static final String KUGOU_MOBILECDN = "http://mobilecdn.kugou.com/api/v3/";

    //酷狗音乐详情
    public static final String SONG_INFO = "http://m.kugou.com/app/i/";


   // public static final String DONG_TING_SEARCH = "http://search.dongting.com/";

    //排行榜
   // public static final String DONG_TING = "http://api.dongting.com/";
    //电台列表
    //public static final String FM_API_TTPOD = "http://fm.api.ttpod.com/";

    //音乐列表
   // public static final String SONG_LIST_TTPOD = "http://api.songlist.ttpod.com/";



    /**
     * 获取对应的host
     *
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
           /* case HostType.SEARCH_DONG_TING:
                host = DONG_TING_SEARCH;
                break;*/
            case HostType.API_SONGLIST_TTPOD:
                host = KU_GOU_RECOMMEND;
                break;
            case HostType.API_KU_GOUT_RECOMMEND:
                host = KU_GOU_RECOMMEND;
                break;
           /* case HostType.FM_API_TTPOD:
                host = FM_API_TTPOD;
                break;*/
            case HostType.MOBILECDN_KUGOU:
                host = KUGOU_MOBILECDN;
                break;
            /*case HostType.SONG_LIST:
                host=SONG_LIST_TTPOD;
                break;*/
            case HostType.HOT_TAG_SEARCH:
                host=SEARCH_HOT;
                break;
            case HostType.KU_GOU_BANNER:
                host=KU_GOU_BAANER;
                break;
            case HostType.KU_GOU_FM_TYPE:
                host=KU_GOU_FM_TYPE;
                break;
            case HostType.SONG_INFO:
                host=SONG_INFO;
                break;
            default:
                host = "";
                break;
        }
        return host;
    }
}
