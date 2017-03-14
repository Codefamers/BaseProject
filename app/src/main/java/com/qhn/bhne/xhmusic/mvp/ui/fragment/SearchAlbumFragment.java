package com.qhn.bhne.xhmusic.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.common.HostType;
import com.qhn.bhne.xhmusic.listener.ClickAdapterItemListener;
import com.qhn.bhne.xhmusic.mvp.entity.SearchAlbum;
import com.qhn.bhne.xhmusic.mvp.entity.SongMenuIntro;
import com.qhn.bhne.xhmusic.mvp.model.impl.AlbumSongsModelImpl;
import com.qhn.bhne.xhmusic.mvp.ui.activities.MusicListActivity;
import com.qhn.bhne.xhmusic.mvp.ui.activities.SearchActivity;
import com.qhn.bhne.xhmusic.mvp.ui.adapter.SearchAlbumAdapter;
import com.qhn.bhne.xhmusic.mvp.view.AlbumView;
import com.qhn.bhne.xhmusic.net.RetrofitManager;
import com.qhn.bhne.xhmusic.utils.RxBus;
import com.socks.library.KLog;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.qhn.bhne.xhmusic.common.Constants.SONG_MENU;
import static com.qhn.bhne.xhmusic.mvp.ui.activities.MusicListActivity.MUSIC_LIST_MODEL;
import static com.qhn.bhne.xhmusic.mvp.ui.activities.MusicListActivity.SONG_MENU_VIEW;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */

public class SearchAlbumFragment extends BaseFragment implements ClickAdapterItemListener<SearchAlbum>{
    @BindView(R.id.rec_single_music)
    RecyclerView recSearchAlbum;
    @BindView(R.id.success_view)
    RelativeLayout successView;
    @Inject
    RxBus rxBus;
    private String query;
    private int page = 1;
    private int pageSize = 20;
    @Inject
    SearchAlbumAdapter searchAlbumAdapter;
    @Override
    protected void initInjector() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_single_song;
    }

    @Override
    protected void initViews(View mFragmentView) {
        query=((SearchActivity)getContext()).getQuery();
        searchAlbumAdapter.setItemListener(this);
        initRec();
        initData();
    }

    private void initData() {
        RetrofitManager.getInstance(HostType.HOT_TAG_SEARCH)
                .getSearchAlbumObservable(query, page, pageSize)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<SearchAlbum>>() {
                    @Override
                    public void onStart() {
                        super.onStart();

                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();

                        KLog.d("2222请求失败");

                    }

                    @Override
                    public void onNext(List<SearchAlbum> searchAlbumList) {

                        searchAlbumAdapter.setList(searchAlbumList);
                        searchAlbumAdapter.notifyDataSetChanged();


                    }
                });
    }

    private void initRec() {
        recSearchAlbum.setLayoutManager(new LinearLayoutManager(getContext()));
        recSearchAlbum.setAdapter(searchAlbumAdapter);
    }

    @Override
    protected View getSuccessView() {
        return successView;
    }


    @Override
    public void onClick(SearchAlbum eb,int position) {
        Intent intent = new Intent(getContext(), MusicListActivity.class);
        SongMenuIntro songMenuIntro=new SongMenuIntro();
        songMenuIntro.setIntro(eb.getIntro());
        songMenuIntro.setImgurl(eb.getImgurl());
        songMenuIntro.setSongcount(eb.getSongcount());
        intent.putExtra(SONG_MENU_VIEW, new AlbumView(eb));
        intent.putExtra(MUSIC_LIST_MODEL, new AlbumSongsModelImpl());
        intent.putExtra(SONG_MENU, songMenuIntro);
        Bundle bundle = new Bundle();

        bundle.putInt("page", 1);
        bundle.putInt("pageSize", 100);
        bundle.putInt("albumid", eb.getAlbumid());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
