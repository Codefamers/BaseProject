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


import com.qhn.bhne.baseproject.mvp.entity.ChannelList;
import com.qhn.bhne.baseproject.mvp.entity.HotMusicTag;
import com.qhn.bhne.baseproject.mvp.entity.MVList;
import com.qhn.bhne.baseproject.mvp.entity.MVType;
import com.qhn.bhne.baseproject.mvp.entity.MusicList;
import com.qhn.bhne.baseproject.mvp.entity.MusicRank;
import com.qhn.bhne.baseproject.mvp.entity.NewsDetail;
import com.qhn.bhne.baseproject.mvp.entity.RankList;
import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;
import com.qhn.bhne.baseproject.mvp.entity.SearchAlbum;
import com.qhn.bhne.baseproject.mvp.entity.SearchMV;
import com.qhn.bhne.baseproject.mvp.entity.SearchSongMenu;
import com.qhn.bhne.baseproject.mvp.entity.SingleSong;
import com.qhn.bhne.baseproject.mvp.entity.SongMenu;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * @author 咖枯
 * @version 1.0 2016/5/24
 */
public interface NewsService {


    @GET("nc/article/{postId}/full.html")
    Observable<Map<String, NewsDetail>> getNewDetail(
            @Header("Cache-Control") String cacheControl,
            @Path("postId") String postId);

    @GET
    Observable<ResponseBody> getNewsBodyHtmlPhoto(
            @Url String photoPath);
    //@Url，它允许我们直接传入一个请求的URL。这样以来我们可以将上一个请求的获得的url直接传入进来，baseUrl将被无视
    // baseUrl 需要符合标准，为空、""、或不合法将会报错


    @GET("frontpage/frontpage?v=v8.1.5.2016110613&s=s310")
    Observable<RecommendContent> getRecommendContent();

    @GET("channel/ranklist/{rankId}/songs?2")
    Observable<RankList> getRankList(@Path("rankId") int rankId);

    @GET("songlist/search?")
    Observable<SongMenu> getSongMenu(@Query("q") String tag,
                                     @Query("page") int page,
                                     @Query("size") int size);

    @GET("channellist?")
    Observable<ChannelList> getChannelList();

    @GET("song/video/type/{id}?")
    Observable<MVList> getMVList(@Path("id") int id,
                                 @Query("order") int order,
                                 @Query("page") int page,
                                 @Query("size") int size);

    @GET("song/video/type?")
    Observable<MVType> getVideoType();

    @GET("rank/list?apiver=4&withsong=1&showtype=2&plat=0&parentid=0&version=8493")
    Observable<MusicRank> getMusicRank();

    @GET("songlists/{id}?")
    Observable<MusicList> getMusicList(@Path("id") int id);

    @GET("hot?")
    Observable<HotMusicTag> getHotMusicTag(@Query("count") int count);

    @GET("song?")
    Observable<SingleSong> getSingleSong(
            @Query("tagtype") String tagtype,
            @Query("keyword") String keyword,
            @Query("page") int page,
            @Query("pagesize") int pagesize
    );
    @GET("special?")
    Observable<SearchSongMenu> getSearchSongMenu(
            @Query("keyword") String keyword,
            @Query("page") int page,
            @Query("pagesize") int pagesize
    );
    @GET("album?")
    Observable<SearchAlbum> getSearchAlbum(
            @Query("keyword") String keyword,
            @Query("page") int page,
            @Query("pagesize") int pagesize
    );
    @GET("mv?")
    Observable<SearchMV> getSearchMV(
            @Query("keyword") String keyword,
            @Query("page") int page,
            @Query("pagesize") int pagesize
    );
}

