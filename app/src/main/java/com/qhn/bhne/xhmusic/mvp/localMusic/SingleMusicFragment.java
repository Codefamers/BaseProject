package com.qhn.bhne.xhmusic.mvp.localMusic;


import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.db.DaoMaster;
import com.qhn.bhne.xhmusic.db.DaoSession;
import com.qhn.bhne.xhmusic.db.SongInfoDao;
import com.qhn.bhne.xhmusic.mvp.entity.db.SongInfo;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import me.drakeet.multitype.GlobalMultiTypePool;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by qhn
 * on 2017/4/10.
 */

public class SingleMusicFragment extends BaseFragment {
    @BindView(R.id.rec_local_single_music)
    RecyclerView recLocalSingleMusic;
    @Inject
    DaoSession daoSession;

    @Override
    protected void initInjector() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_signle_music;
    }

    @Override
    protected void initViews(View mFragmentView) {
        recLocalSingleMusic.setLayoutManager(new LinearLayoutManager(getContext()));
        Items items = new Items();
        MultiTypeAdapter adapter = new MultiTypeAdapter(items);
        adapter.register(SongInfo.class, new SingleMusicItemProvider());
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recLocalSingleMusic.addItemDecoration(itemDecoration);
        SongInfoDao songInfoDao = daoSession.getSongInfoDao();
        items.addAll(songInfoDao.loadAll());
        adapter.applyGlobalMultiTypePool(); // <- 使全局的类型加入到局部中来
        recLocalSingleMusic.setAdapter(adapter);
    }

    @Override
    protected View getSuccessView() {
        return null;
    }

}
