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
package com.qhn.bhne.xhmusic.net;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseArray;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.qhn.bhne.xhmusic.application.App;
import com.qhn.bhne.xhmusic.common.ApiConstants;
import com.qhn.bhne.xhmusic.common.HostType;
import com.qhn.bhne.xhmusic.mvp.entity.Banner;
import com.qhn.bhne.xhmusic.mvp.entity.BroadcastType;
import com.qhn.bhne.xhmusic.mvp.entity.BroadcastDetail;
import com.qhn.bhne.xhmusic.mvp.entity.ChannelList;
import com.qhn.bhne.xhmusic.mvp.entity.ClassListBody;
import com.qhn.bhne.xhmusic.mvp.entity.HotMusicTag;
import com.qhn.bhne.xhmusic.mvp.entity.MVList;
import com.qhn.bhne.xhmusic.mvp.entity.MVType;
import com.qhn.bhne.xhmusic.mvp.entity.MusicList;
import com.qhn.bhne.xhmusic.mvp.entity.MusicRank;
import com.qhn.bhne.xhmusic.mvp.entity.PostHttpResult;
import com.qhn.bhne.xhmusic.mvp.entity.RecommendContent;
import com.qhn.bhne.xhmusic.mvp.entity.GetHttpResult;
import com.qhn.bhne.xhmusic.mvp.entity.SearchAlbum;
import com.qhn.bhne.xhmusic.mvp.entity.SearchMV;
import com.qhn.bhne.xhmusic.mvp.entity.SearchSongMenu;
import com.qhn.bhne.xhmusic.mvp.entity.SongInfo;
import com.qhn.bhne.xhmusic.mvp.entity.SongListFM;
import com.qhn.bhne.xhmusic.mvp.entity.SongMenu;
import com.qhn.bhne.xhmusic.mvp.entity.SongMenuType;
import com.qhn.bhne.xhmusic.mvp.entity.Songs;
import com.qhn.bhne.xhmusic.utils.NetUtil;
import com.socks.library.KLog;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

/**
 *
 * @author quhuainan
 * created on 2017/3/1 0001
 */
public class RetrofitManager {

    private NewsService mNewsService;
    private static final String TAG = "RetrofitManager";
    /**
     * 设缓存有效期为两天
     */
    private static final long CACHE_STALE_SEC = 60 * 0 * 60 * 24;//
    /**
     * 查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
     * max-stale 指示客户机可以接收超出超时期间的响应消息。如果指定max-stale消息的值，那么客户机可接收超出超时期指定值之内的响应消息。
     */
    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;

    /**
     * 查询网络的Cache-Control设置，头部Cache-Control设为max-age=0
     * (假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)时则不会使用缓存而请求服务器
     */
    private static final String CACHE_CONTROL_AGE = "max-age=0";

    private static volatile OkHttpClient sOkHttpClient;

    private static SparseArray<RetrofitManager> sRetrofitManager = new SparseArray<>(HostType.TYPE_COUNT);

    //根据hotsType来创建不同的service
    public RetrofitManager(@HostType.HostTypeChecker int hostType) {
        Retrofit retrofit;
        Log.d(TAG, "RetrofitManager: " + ApiConstants.getHost(hostType));

        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.getHost(hostType))
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        mNewsService = retrofit.create(NewsService.class);
    }

    //使用单利模式获取okHttp对象并对okHttp进行设置
    private OkHttpClient getOkHttpClient() {
        if (sOkHttpClient == null) {
            synchronized (RetrofitManager.class) {
                Cache cache = new Cache(new File(App.getAppContext().getCacheDir(), "HttpCache"),
                        1024 * 1024 * 100);//给缓存设置文件夹，文件夹的名称为httpCache,缓存大小为100M
                if (sOkHttpClient == null) {
                    sOkHttpClient = new OkHttpClient
                            .Builder()
                            .cache(cache)
                            .connectTimeout(6, TimeUnit.SECONDS)//设置连接超时时间6s，设置客户端和服务器建立连接的超时时间，从2.5版本开始默认我10s
                            .readTimeout(6, TimeUnit.SECONDS)//设置读取超时时间6s，客服端从服务器下载响应数据的超时时间
                            .writeTimeout(6, TimeUnit.SECONDS)//设置写入超时6s，客服端上传数据到服务器的超时时间
                            .addInterceptor(mRewriteCacheControlInterceptor)//增加应用拦截器和网络拦截器
                            .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                            .addInterceptor(mLoggingInterceptor).build();
                }
            }
        }
        return sOkHttpClient;
    }

    /**
     * 云端响应头拦截器，用来配置缓存策略
     * Retrofit是根据请求服务器的URL去创建缓存文件，请求的URL不同，所创建的缓存文件也不同,在发起访问服务器请求时，
     * Retrofit根据URL去找对应的缓存，然后返回缓存的数据
     * Dangerous interceptor that rewrites the server's cache-control header.
     */
    private final Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();//获取请求
            if (!NetUtil.isNetworkAvailable()) {//如果网络不可用
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();//拦截该请求走缓存
            }

            Response originalResponse = chain.proceed(request);//获取响应
            if (NetUtil.isNetworkAvailable()) {//如果有网
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)//覆盖服务器响应头的Cache-Control,用我们自己的,因为服务器响应回来的可能不支持缓存
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_SEC)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };

    private final Interceptor mLoggingInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long t1 = System.nanoTime();
            KLog.i(String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));
            Response response = chain.proceed(request);
            long t2 = System.nanoTime();
            KLog.i(String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));
            return response;
        }
    };

    public static RetrofitManager getInstance(int hostType) {
        RetrofitManager retrofitManager = sRetrofitManager.get(hostType);
        if (retrofitManager == null) {
            retrofitManager = new RetrofitManager(hostType);
            sRetrofitManager.put(hostType, retrofitManager);
            return retrofitManager;
        }
        return retrofitManager;
    }


    /**
     * 根据网络状况获取缓存的策略
     */
    @NonNull
    private String getCacheControl() {
        return NetUtil.isNetworkAvailable() ? CACHE_CONTROL_AGE : CACHE_CONTROL_CACHE;
    }
    private  class GetResultFilter<T> implements Func1<GetHttpResult<T>, T> {


        @Override
        public T call(GetHttpResult<T> httpResultBean) {
            int errCode=httpResultBean.getErrcode();
            if (errCode==0) {
                return httpResultBean.getData().getInfo();
            }
            return null;
        }
    }
    private  class PostResultFilter<T> implements Func1<PostHttpResult<T>, T> {


        @Override
        public T call(PostHttpResult<T> postHttpResult) {
            int errCode=postHttpResult.getError_code();
            if (errCode==0) {
                return postHttpResult.getData();
            }
            return null;
        }
    }

    //首页推荐
    public Observable<RecommendContent> getRecommendContent() {
        return mNewsService.getRecommendContent().map(new GetResultFilter<RecommendContent>());
    }

    //首页轮播图
    public Observable<List<Banner>> getBannerContent() {
        return mNewsService.getRecommendBanner().map(new GetResultFilter<List<Banner>>());
    }
    //电台类别
    public Observable<List<BroadcastType>> getBroadcastTypeObservable(ClassListBody classListBody) {
        return mNewsService.getBroadcastType(classListBody).map(new PostResultFilter<List<BroadcastType>>());
    }

    //电台内容
    public Observable<List<BroadcastDetail>> getBroadcastDetailObservable(SongListFM songListFM) {
        return mNewsService.getBroadcastDetail(songListFM).map(new PostResultFilter<List<BroadcastDetail>>());
    }


    //音乐排行榜
    public Observable<List<MusicRank>> getMusicRankObservable() {
        return mNewsService.getMusicRank().map(new GetResultFilter<List<MusicRank>>());
    }
    //音乐排行榜详情
    public Observable<List<Songs>> getMusicRankDetailsObservable(Map<String,Integer> paramsMap) {
        return mNewsService.getMusicRankDetails(paramsMap).map(new GetResultFilter<List<Songs>>());
    }
    //所有歌单
    public Observable<List<SongMenu>> getSongMenuObservable(int categoryid, int page, int size) {
        return mNewsService.getSongMenu(1, 3, 0, 1, page, categoryid, size).map(new GetResultFilter<List<SongMenu>>());
    }

    public Observable<List<SongMenuType>> getSongMenuTypeObservable() {
        return mNewsService.getSongMenuType().map(new GetResultFilter<List<SongMenuType>>());
    }

    public Observable<ChannelList> getChannelListObservable() {
        return mNewsService.getChannelList();
    }

    public Observable<MVList> getMVListObservable(int id, int order, int page, int size) {
        return mNewsService.getMVList(id, order, page, size);
    }

    public Observable<MusicList> getMusicListObservable(int id) {
        return mNewsService.getMusicList(id);
    }

    public Observable<MVType> getMVTypeObservable() {
        return mNewsService.getVideoType();
    }

    public Observable<List<HotMusicTag>> getHotMusicTagObservable(int count) {
        return mNewsService.getHotMusicTag(count).map(new GetResultFilter<List<HotMusicTag>>());
    }

    //搜索单曲
    public Observable<List<Songs>> getSingleSongObservable(String tagType, String keyword, int page, int pageSize) {
        return mNewsService.getSearchSong(tagType, keyword, page, pageSize).map(new GetResultFilter<List<Songs>>());
    }

    //搜索歌单
    public Observable<List<SearchSongMenu>> getSearchSongMenuObservable(String keyword, int page, int pageSize) {
        return mNewsService.getSearchSongMenu(keyword, page, pageSize).map(new GetResultFilter<List<SearchSongMenu>>());
    }

    //搜索专辑
    public Observable<List<SearchAlbum>> getSearchAlbumObservable(String keyword, int page, int pageSize) {
        return mNewsService.getSearchAlbum(keyword, page, pageSize).map(new GetResultFilter<List<SearchAlbum>>());
    }
    //搜索专辑内所有歌曲
    public Observable<List<Songs>> getSearchAlbumSongsObservable(Map<String,Integer> paramsMap) {
        return mNewsService.getSearchAlbumSongs(paramsMap).map(new GetResultFilter<List<Songs>>());
    }

    public Observable<SongInfo> getSongInfoObservable(String songHash) {
        return mNewsService.getSearchAlbumSongs(songHash,"playInfo");
    }
    //搜索MV
    public Observable<List<SearchMV>> getSearchMVObservable(String keyword, int page, int pageSize) {
        return mNewsService.getSearchMV(keyword, page, pageSize).map(new GetResultFilter<List<SearchMV>>());
    }

    //搜索歌单内的所有歌曲
    public Observable<List<Songs>> getKugouSongObservable(Map<String, Integer> paramsMap) {
        return mNewsService.getSpecialSong(paramsMap).map(new GetResultFilter<List<Songs>>());
    }





    public static class GsonLenientConverterFactory extends Converter.Factory {
        public static GsonLenientConverterFactory create() {
            return create(new Gson());
        }

        public static GsonLenientConverterFactory create(Gson gson) {
            return new GsonLenientConverterFactory(gson);
        }

        private final Gson gson;

        private GsonLenientConverterFactory(Gson gson) {
            if (gson == null) throw new NullPointerException("gson == null");
            this.gson = gson;
        }

        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
            return new DecodeResponseBodyConverter<>(adapter, gson);
        }


    }


    public static class DecodeResponseBodyConverter<T> implements Converter<ResponseBody, T> {
        private final TypeAdapter<T> adapter;
        private final Gson gson;
        private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
        private static final Charset UTF_8 = Charset.forName("UTF-8");

        DecodeResponseBodyConverter(TypeAdapter<T> adapter, Gson gson) {
            this.adapter = adapter;
            this.gson = gson;
        }

        @Override
        public T convert(ResponseBody value) throws IOException {
            //解密字符串
            String result3 = value.string();
            JsonReader jsonReader = gson.newJsonReader(new StringReader(result3));
            jsonReader.setLenient(true);
            Log.d("返回的字符串", result3);
            return adapter.read(jsonReader);
        }
    }

}
