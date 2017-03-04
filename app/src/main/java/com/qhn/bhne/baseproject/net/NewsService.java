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
package com.qhn.bhne.baseproject.net;


import com.qhn.bhne.baseproject.mvp.entity.Banner;
import com.qhn.bhne.baseproject.mvp.entity.BroadcastDetail;
import com.qhn.bhne.baseproject.mvp.entity.BroadcastType;
import com.qhn.bhne.baseproject.mvp.entity.ChannelList;
import com.qhn.bhne.baseproject.mvp.entity.ClassListBody;
import com.qhn.bhne.baseproject.mvp.entity.GetHttpResult;
import com.qhn.bhne.baseproject.mvp.entity.HotMusicTag;
import com.qhn.bhne.baseproject.mvp.entity.MVList;
import com.qhn.bhne.baseproject.mvp.entity.MVType;
import com.qhn.bhne.baseproject.mvp.entity.MusicList;
import com.qhn.bhne.baseproject.mvp.entity.MusicRank;
import com.qhn.bhne.baseproject.mvp.entity.PostHttpResult;
import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;
import com.qhn.bhne.baseproject.mvp.entity.SearchAlbum;
import com.qhn.bhne.baseproject.mvp.entity.SearchMV;
import com.qhn.bhne.baseproject.mvp.entity.SearchSongMenu;
import com.qhn.bhne.baseproject.mvp.entity.SongListFM;
import com.qhn.bhne.baseproject.mvp.entity.SongMenu;
import com.qhn.bhne.baseproject.mvp.entity.SongMenuType;
import com.qhn.bhne.baseproject.mvp.entity.Songs;

import java.util.List;
import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;


public interface NewsService {
    //获取推荐
    @GET("recommend?plat=0&type=8&operator=3&version=8493")
    Observable<GetHttpResult<RecommendContent>> getRecommendContent();

    //获取推荐页轮播图
    @GET("mobile_fmbanner?isvip=0&mid=271163335621854377768999610192375722565&clienttime=1488095989605&appid=1100&plat=0&userid=0&networktype=1&phonebrand=vivo&operator=3&ismonthly=0&clientver=8" +
            "493&key=024ba790ab865019f1790679f860bb48&version=8493&type=4")
    Observable<GetHttpResult<List<Banner>>> getRecommendBanner();

    //获取电台类型
    @POST("class_list")
    Observable<PostHttpResult<List<BroadcastType>>> getBroadcastType(
            @Body ClassListBody classListBody
    );

    //获取电台详情
    @POST("song_list_fmclass")
    Observable<PostHttpResult<List<BroadcastDetail>>> getBroadcastDetail(
            @Body SongListFM classListBody
    );

    //获取歌曲排行榜
    @GET("rank/list?apiver=4&withsong=1&showtype=2&plat=0&parentid=0&version=8493")
    Observable<GetHttpResult<List<MusicRank>>> getMusicRank();

    //排行榜详情
    @GET("rank/song?")
    Observable<GetHttpResult<List<Songs>>> getMusicRankDetails(
            @QueryMap Map<String, Integer> paramsMap

    );


    //获取歌单类型
    @GET("category/allList?plat=0")
    Observable<GetHttpResult<List<SongMenuType>>> getSongMenuType();

    //根据歌单类型获取歌单列表
    @GET("category/special?")
    Observable<GetHttpResult<List<SongMenu>>> getSongMenu(@Query("withsong") int withsong,
                                                          @Query("sort") int sort,
                                                          @Query("plat") int plat,
                                                          @Query("ugc") int ugc,
                                                          @Query("page") int page,
                                                          @Query("categoryid") int categoryid,
                                                          @Query("size") int size);


    //获取热门搜索
    @GET("hot?")
    Observable<GetHttpResult<List<HotMusicTag>>> getHotMusicTag(@Query("count") int count);


    //获取搜索单曲
    @GET("song?")
    Observable<GetHttpResult<List<Songs>>> getSearchSong(
            @Query("tagtype") String tagtype,
            @Query("keyword") String keyword,
            @Query("page") int page,
            @Query("pagesize") int pagesize
    );

    //获取搜索歌单
    @GET("special?")
    Observable<GetHttpResult<List<SearchSongMenu>>> getSearchSongMenu(
            @Query("keyword") String keyword,
            @Query("page") int page,
            @Query("pagesize") int pagesize
    );

    //获取搜索专辑
    @GET("album?")
    Observable<GetHttpResult<List<SearchAlbum>>> getSearchAlbum(
            @Query("keyword") String keyword,
            @Query("page") int page,
            @Query("pagesize") int pagesize
    );
    //获取搜索专辑内所有歌曲
    @GET("album/song?")
    Observable<GetHttpResult<List<Songs>>> getSearchAlbumSongs(
            @QueryMap Map<String,Integer> paramsMap
    );

    //获取搜索MV
    @GET("mv?")
    Observable<GetHttpResult<List<SearchMV>>> getSearchMV(
            @Query("keyword") String keyword,
            @Query("page") int page,
            @Query("pagesize") int pagesize
    );

    @GET("channellist?")
    Observable<ChannelList> getChannelList();

    @GET("song/video/type/{id}?")
    Observable<MVList> getMVList(@Path("id") int id,
                                 @Query("order") int order,
                                 @Query("page") int page,
                                 @Query("size") int size);

    @GET("song/video/type?")
    Observable<MVType> getVideoType();


    @GET("songlists/{id}?")
    Observable<MusicList> getMusicList(@Path("id") int id);


    //歌单内所有歌曲
    @GET("special/song?")
    Observable<GetHttpResult<List<Songs>>> getSpecialSong(
            @QueryMap Map<String, Integer> paramsMap

    );

    /*@Query("specialid") int specialid,
    @Query("page") int page,
    @Query("pagesize") int pagesize*/

}

/*
* "platform": "android",
	"appid": "1005",
	"mid": "271163335621854377768999610192375722565",
	"clienttime": "1488112355",
	"key": "216770e5216f9035d8e2dfbaec76ba89",
	"clientver": "8493"*/