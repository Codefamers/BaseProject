package com.qhn.bhne.xhmusic.mvp.localMusic;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.application.App;
import com.qhn.bhne.xhmusic.di.scope.ContextLife;
import com.qhn.bhne.xhmusic.mvp.entity.SongMenu;
import com.qhn.bhne.xhmusic.mvp.entity.db.SongInfo;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.BaseFragment;
import com.qhn.bhne.xhmusic.wight.dialog.CustomDialogFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by qhn
 * on 2016/11/9 0009.
 */
public class LocalMusicFragment extends BaseFragment implements LocalMusicContract.View {
    @ContextLife
    @Inject
    Context mContext;
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
    @BindView(R.id.rec_build_menu)
    RecyclerView recBuildMenu;
    @BindView(R.id.rec_collect_menu)
    RecyclerView recCollectMenu;

    @Inject
    LocalMusicPresenter mPresenter;


    Unbinder unbinder;
    private int collectRotateType = CLOCK_WISE;
    private static final int CLOCK_WISE = 868;//顺时针旋转
    private static final int ANTI_CLOCK_WISE = 744;//逆时针
    private static final int BUILD_MENU = 493;
    private static final int COLLECT_MENU = 313;
    private int buildRotateType = CLOCK_WISE;

    @Override
    protected void initInjector() {
        DaggerLocalMusicComponent.builder()
                .applicationComponent(((App) getActivity().getApplication()).getApplicationComponent())
                .localMusicPresenterModule(new LocalMusicPresenterModule(this))
                .build().inject(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_local_music;
    }

    @Override
    protected void initViews(View mFragmentView) {
        //recBuildMenu

    }

    @Override
    protected View getSuccessView() {
        return null;
    }


    @OnClick({R.id.txt_local_music, R.id.txt_recently_play, R.id.txt_manager_download, R.id.txt_my_signer, R.id.txt_my_MV, R.id.img_build_menu_arrow, R.id.txt_build_menu_title, R.id.img_build_menu_more, R.id.img_collect_menu_arrow,
            R.id.txt_collect_menu_title, R.id.txt_collect_menu_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_local_music:
                startActivity(new Intent(getContext(), LocalMusicActivity.class));
                break;
            case R.id.txt_recently_play:
                showClickEvent("最近播放");
                break;
            case R.id.txt_manager_download:
                showClickEvent("下载管理");
                break;
            case R.id.txt_my_signer:
                showClickEvent("我的歌手");
                break;
            case R.id.txt_my_MV:
                showClickEvent("我的MV");
                break;
            case R.id.img_build_menu_arrow:
                showClickEvent("创建的歌单箭头");
                if (buildRotateType == CLOCK_WISE) {
                    buildRotateType = ANTI_CLOCK_WISE;
                } else {
                    buildRotateType = CLOCK_WISE;
                }
                startArrowAnimation(imgBuildMenuArrow, buildRotateType);
                break;
            case R.id.txt_build_menu_title:
                showClickEvent("创建的歌单标题");
                break;
            case R.id.img_build_menu_more:
                popSongMenuManage(BUILD_MENU);
                break;
            case R.id.img_collect_menu_arrow:
                if (collectRotateType == CLOCK_WISE) {
                    collectRotateType = ANTI_CLOCK_WISE;
                } else {
                    collectRotateType = CLOCK_WISE;
                }
                startArrowAnimation(imgCollectMenuArrow, collectRotateType);
                break;
            case R.id.txt_collect_menu_title:
                showClickEvent("收藏的歌单标题");
                break;
            case R.id.txt_collect_menu_more:
                //showClickEvent("收藏的歌单更多操作");
                popSongMenuManage(COLLECT_MENU);

                break;
        }
    }

    //弹出底部菜单
    private void popSongMenuManage(int popType) {
        final BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(getContext());
        final View dialogMenuManage = LayoutInflater.from(getContext()).inflate(R.layout.dialog_manage_song_menu, null);
        LinearLayout llBuildMenu = (LinearLayout) dialogMenuManage.findViewById(R.id.ll_build_song);
        TextView tvMenuTitle = (TextView) dialogMenuManage.findViewById(R.id.tv_menu_title);
        if (popType == BUILD_MENU) {
            llBuildMenu.setVisibility(View.VISIBLE);
            llBuildMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popBuildSongMenuDialog();
                    mBottomSheetDialog.dismiss();
                }
            });
            tvMenuTitle.setText("创建的歌单");
        } else if (popType == COLLECT_MENU) {
            llBuildMenu.setVisibility(View.GONE);
            tvMenuTitle.setText("收藏的歌单");
            tvMenuTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "下个版本更新", Toast.LENGTH_SHORT).show();
                }
            });
        }


        mBottomSheetDialog.setContentView(dialogMenuManage);
        mBottomSheetDialog.show();
    }
    //弹出对话框
    private void popBuildSongMenuDialog() {
        CustomDialogFragment customDialogFragment=new CustomDialogFragment();
        customDialogFragment.setTitle("新建歌单").setPositiveCallback(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mPresenter.addBuildSongMenu();
                Toast.makeText(mContext, "添加菜单成功", Toast.LENGTH_SHORT).show();
            }
        });
        customDialogFragment.setCustomLayoutID(R.layout.item_build_song_menu);
        customDialogFragment.show(getChildFragmentManager());
    }

    private void startArrowAnimation(ImageView imgArrow, int rotateType) {
        ObjectAnimator objectAnimator;
        if (rotateType == CLOCK_WISE) {
            objectAnimator = ObjectAnimator.ofFloat(imgArrow, "rotation", 0, 90);
        } else {
            objectAnimator = ObjectAnimator.ofFloat(imgArrow, "rotation", 90, 0);
        }

        objectAnimator.setDuration(300);
        objectAnimator.start();
    }

    private void showClickEvent(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void setPresenter(LocalMusicContract.Presenter presenter) {

    }

    @Override
    public void showLocalMusicCount(List<SongInfo> songInfoList) {

    }

    @Override
    public void showReccentPlayCount(List<SongInfo> songInfoList) {

    }

    @Override
    public void showDownLoadCount(List<SongInfo> songInfoList) {

    }

    @Override
    public void showMyCollectCount(int num) {

    }

    @Override
    public void updateBuildSongMenu(List<SongMenu> songMenuList) {

    }

    @Override
    public void updateCollectSongMenu(List<SongMenu> songMenuList) {

    }

}
