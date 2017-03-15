package com.qhn.bhne.xhmusic.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.mvp.ui.activities.LocalMusicActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by qhn
 * on 2016/11/9 0009.
 */
public class LocalMusicFragment extends BaseFragment {
    @BindView(R.id.txt_local_music)
    TextView txtLocalMusic;
    @BindView(R.id.txt_recently_play)
    TextView txtRecentlyPlay;
    @BindView(R.id.txt_manager_download)
    TextView txtManagerDownload;
    @BindView(R.id.txt_my_signer)
    TextView txtMySigner;
    @BindView(R.id.txt_my_MV)
    TextView txtMyMV;
    @BindView(R.id.img_build_menu_arrow)
    ImageView imgBuildMenuArrow;
    @BindView(R.id.txt_build_menu_title)
    TextView txtBuildMenuTitle;
    @BindView(R.id.img_build_menu_more)
    ImageView imgBuildMenuMore;
    @BindView(R.id.img_collect_menu_arrow)
    ImageView imgCollectMenuArrow;
    @BindView(R.id.txt_collect_menu_title)
    TextView txtCollectMenuTitle;
    @BindView(R.id.txt_collect_menu_more)
    ImageView txtCollectMenuMore;

    @Override
    protected void initInjector() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_local_music;
    }

    @Override
    protected void initViews(View mFragmentView) {

    }

    @Override
    protected View getSuccessView() {
        return null;
    }


    @OnClick({R.id.txt_local_music, R.id.txt_recently_play, R.id.txt_manager_download, R.id.txt_my_signer, R.id.txt_my_MV,R.id.img_build_menu_arrow, R.id.txt_build_menu_title, R.id.img_build_menu_more, R.id.img_collect_menu_arrow,
            R.id.txt_collect_menu_title, R.id.txt_collect_menu_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_local_music:
                startActivity(new Intent(getContext(), LocalMusicActivity.class));
                break;
            case R.id.txt_recently_play:
                break;
            case R.id.txt_manager_download:
                break;
            case R.id.txt_my_signer:
                break;
            case R.id.txt_my_MV:
                break;
            case R.id.img_build_menu_arrow:
                break;
            case R.id.txt_build_menu_title:
                break;
            case R.id.img_build_menu_more:
                break;
            case R.id.img_collect_menu_arrow:
                break;
            case R.id.txt_collect_menu_title:
                break;
            case R.id.txt_collect_menu_more:
                break;
        }
    }




}
