package com.qhn.bhne.xhmusic.wight.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;

/**
 * Created by qhn
 * on 2017/4/1 0001.
 */

public abstract class BaseDialogFragment extends DialogFragment {
    protected String mTitle;
    protected String mMessage;
    protected String mConfirmText;
    protected String mCancelText;
    protected DialogInterface.OnClickListener positiveCallback;
    protected DialogInterface.OnClickListener negativeCallback;
    protected AlertDialog dialog;
    protected AlertDialog.Builder builder;

    public String getTitle() {
        return mTitle;
    }

    public BaseDialogFragment setTitle(String mTitle) {
        this.mTitle = mTitle;
        return this;
    }

    public String getMessage() {
        return mMessage;
    }

    public BaseDialogFragment setMessage(String mMessage) {
        this.mMessage = mMessage;
        return this;
    }

    public String getConfirmText() {
        return mConfirmText;
    }

    public BaseDialogFragment setConfirmText(String mConfirmText) {
        this.mConfirmText = mConfirmText;
        return this;
    }

    public String getCancelText() {
        return mCancelText;
    }

    public BaseDialogFragment setCancelText(String mCancelText) {
        this.mCancelText = mCancelText;
        return this;
    }

    public DialogInterface.OnClickListener getPositiveCallback() {
        return positiveCallback;
    }

    public BaseDialogFragment setPositiveCallback(DialogInterface.OnClickListener positiveCallback) {
        this.positiveCallback = positiveCallback;
        return this;
    }

    public DialogInterface.OnClickListener getNegativeCallback() {
        return negativeCallback;
    }

    public BaseDialogFragment setNegativeCallback(DialogInterface.OnClickListener negativeCallback) {
        this.negativeCallback = negativeCallback;
        return this;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        builder = new AlertDialog.Builder(getActivity());
        if (!TextUtils.isEmpty(getTitle())) {
            builder.setTitle(mTitle);
        }
        if (!TextUtils.isEmpty(getMessage())) {
            builder.setMessage(mMessage);
        }
        mConfirmText = mConfirmText == null ? "确定" : mConfirmText;
        mCancelText = mCancelText == null ? "取消" : mCancelText;
        builder.setPositiveButton(mConfirmText, positiveCallback);
        builder.setNegativeButton(mCancelText, negativeCallback);
        dialog = builder.create();
        return dialog;
    }

    public abstract void show(FragmentManager fragmentManager);

}
