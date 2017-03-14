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
import com.qhn.bhne.xhmusic.mvp.entity.SearchSongMenu;
import com.qhn.bhne.xhmusic.mvp.entity.SongMenuIntro;
import com.qhn.bhne.xhmusic.mvp.model.impl.MusicListModelImpl;
import com.qhn.bhne.xhmusic.mvp.ui.activities.MusicListActivity;
import com.qhn.bhne.xhmusic.mvp.ui.activities.SearchActivity;
import com.qhn.bhne.xhmusic.mvp.ui.adapter.SearchSongMenuAdapter;
import com.qhn.bhne.xhmusic.mvp.view.NormalMusicListView;
import com.qhn.bhne.xhmusic.net.RetrofitManager;
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

public class SearchSongMenuFragment extends BaseFragment implements ClickAdapterItemListener<SearchSongMenu> {
    @BindView(R.id.rec_single_music)
    RecyclerView recSongMenuMusic;
    @BindView(R.id.success_view)
    RelativeLayout successView;
    @Inject
    SearchSongMenuAdapter searchSongMenuAdapter;

    private String query;
    private int page = 1;
    private int pageSize = 20;

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
        initRec();
        searchSongMenuAdapter.setItemListener(this);
        query = ((SearchActivity) getContext()).getQuery();
        initData();
    }

    private void initData() {
        RetrofitManager.getInstance(HostType.HOT_TAG_SEARCH)
                .getSearchSongMenuObservable(query, page, pageSize)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<SearchSongMenu>>() {
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
                    public void onNext(List<SearchSongMenu> searchSongMenuList) {
                        searchSongMenuAdapter.setList(searchSongMenuList);
                        searchSongMenuAdapter.notifyDataSetChanged();


                    }
                });
    }

    private void initRec() {

        recSongMenuMusic.setLayoutManager(new LinearLayoutManager(getContext()));
        recSongMenuMusic.setAdapter(searchSongMenuAdapter);
    }

    @Override
    protected View getSuccessView() {
        return successView;
    }


    @Override
    public void onClick(SearchSongMenu eb,int position) {
        Intent intent = new Intent(getContext(), MusicListActivity.class);
        SongMenuIntro songMenuIntro = new SongMenuIntro(eb.getSpecialid(), eb.getCollectcount(), eb.getIntro()
                , eb.getSongcount(), eb.getPlaycount(), eb.getNickname(), eb.getImgurl(), eb.getSpecialname(), eb.getSlid());
        intent.putExtra(SONG_MENU_VIEW, new NormalMusicListView(songMenuIntro));
        intent.putExtra(MUSIC_LIST_MODEL, new MusicListModelImpl());
        intent.putExtra(SONG_MENU, songMenuIntro);
        Bundle bundle = new Bundle();

        bundle.putInt("page", 1);
        bundle.putInt("pageSize", 100);
        bundle.putInt("specialid", songMenuIntro.getSpecialid());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
