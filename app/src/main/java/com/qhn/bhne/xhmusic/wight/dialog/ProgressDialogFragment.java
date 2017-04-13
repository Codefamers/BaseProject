package com.qhn.bhne.xhmusic.wight.dialog;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import static android.app.ProgressDialog.STYLE_SPINNER;

/**
 * Created by penneryu on 16/5/16.
 */
public class ProgressDialogFragment extends DialogFragment {

    private boolean mIsShow;

    private int mProgressStyle = STYLE_SPINNER;


    private String mTitle = "加载中...";


    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FragmentActivity activity = getActivity();
        ProgressDialog dialog = new ProgressDialog(activity);
        dialog.setIndeterminate(true);
        dialog.setMessage(mTitle);
        dialog.setProgressStyle(mProgressStyle);
        setCancelable(false);
        return dialog;
    }

    public void show(FragmentManager fragmentManager) {
        if (!mIsShow) {
            mIsShow = true;
            show(fragmentManager, "progress_dialog");
        }
    }

    public void setProgressStyle(int style) {
        mProgressStyle = style;
    }

    public ProgressDialog getProgressDialog() {
        return (ProgressDialog) super.getDialog();
    }

    @Override
    public void onStart() {
        super.onStart();
        mIsShow = false;
    }

    @Override
    public void dismiss() {
        dismissAllowingStateLoss();
    }

    @Override
    public void dismissAllowingStateLoss() {
        if (isAdded()) {
            super.dismissAllowingStateLoss();
        }
    }
}
