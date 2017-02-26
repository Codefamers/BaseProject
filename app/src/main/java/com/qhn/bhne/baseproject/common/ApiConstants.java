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
package com.qhn.bhne.baseproject.common;

/**
 * @author 咖枯
 * @version 1.0 2016/5/25
 */
public class ApiConstants {
    //推荐
    public static final String DONG_TING_API = "http://api.dongting.com/";


    public static final String DONG_TING_SEARCH = "http://search.dongting.com/";

    //排行榜
    public static final String DONG_TING = "http://api.dongting.com/";
    //电台列表
    public static final String FM_API_TTPOD = "http://fm.api.ttpod.com/";
    //酷狗
    private static final String KUGOU_MOBILECDN = "http://mobilecdn.kugou.com/api/v3/";
    //音乐列表
    public static final String SONG_LIST_TTPOD = "http://api.songlist.ttpod.com/";


    //酷狗热门搜索标签//酷狗歌曲搜索
    private static final String SEARCH_HOT="http://mobilecdn.kugou.com/api/v3/search/";


    public static final String NETEAST_HOST = "http://c.m.163.com/";
    // 头条TYPE
    public static final String HEADLINE_TYPE = "headline";
    // 房产TYPE
    public static final String HOUSE_TYPE = "house";
    // 其他TYPE
    public static final String OTHER_TYPE = "list";

    //    // 北京
    //    public static final String LOCAL_TYPE = "local";
    //    // 北京的Id
    //    public static final String BEIJING_ID = "5YyX5Lqs";

    // 头条id
    public static final String HEADLINE_ID = "T1348647909107";
    // 房产id
    public static final String HOUSE_ID = "5YyX5Lqs";


    /**
     * 新闻id获取类型
     *
     * @param id 新闻id
     * @return 新闻类型
     */
    public static String getType(String id) {
        switch (id) {
            case HEADLINE_ID:
                return HEADLINE_TYPE;
            case HOUSE_ID:
                return HOUSE_TYPE;
            default:
                break;
        }
        return OTHER_TYPE;
    }

    /**
     * 获取对应的host
     *
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case HostType.SEARCH_DONG_TING:
                host = DONG_TING_SEARCH;
                break;
            case HostType.API_SONGLIST_TTPOD:
                host = DONG_TING_API;
                break;
            case HostType.API_DONG_TING:
                host = DONG_TING_API;
                break;
            case HostType.FM_API_TTPOD:
                host = FM_API_TTPOD;
                break;
            case HostType.MOBILECDN_KUGOU:
                host = KUGOU_MOBILECDN;
                break;
            case HostType.SONG_LIST:
                host=SONG_LIST_TTPOD;
                break;
            case HostType.HOT_TAG_SEARCH:
                host=SEARCH_HOT;
                break;
            default:
                host = "";
                break;
        }
        return host;
    }
}
