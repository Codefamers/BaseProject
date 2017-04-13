package com.qhn.bhne.xhmusic.wight.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by qhn
 * on 2017/4/13.
 */

public class CustomDialogFragment extends DialogFragment {
    protected String mTitle;
    protected String mMessage;
    protected String mConfirmText;
    protected String mCancelText;
    protected DialogInterface.OnClickListener positiveCallback;
    protected DialogInterface.OnClickListener negativeCallback;
    protected AlertDialog dialog;
    protected AlertDialog.Builder builder;
    private int customLayoutID;
    private View customView;

    public void setCustomLayoutID(int customLayoutID) {
        this.customLayoutID = customLayoutID;
    }


    public String getTitle() {
        return mTitle;
    }

    public CustomDialogFragment setTitle(String mTitle) {
        this.mTitle = mTitle;
        return this;
    }

    public String getMessage() {
        return mMessage;
    }

    public CustomDialogFragment setMessage(String mMessage) {
        this.mMessage = mMessage;
        return this;
    }

    public String getConfirmText() {
        return mConfirmText;
    }

    public CustomDialogFragment setConfirmText(String mConfirmText) {
        this.mConfirmText = mConfirmText;
        return this;
    }

    public String getCancelText() {
        return mCancelText;
    }

    public CustomDialogFragment setCancelText(String mCancelText) {
        this.mCancelText = mCancelText;
        return this;
    }

    public DialogInterface.OnClickListener getPositiveCallback() {
        return positiveCallback;
    }

    public CustomDialogFragment setPositiveCallback(DialogInterface.OnClickListener positiveCallback) {
        this.positiveCallback = positiveCallback;
        return this;
    }

    public DialogInterface.OnClickListener getNegativeCallback() {
        return negativeCallback;
    }

    public CustomDialogFragment setNegativeCallback(DialogInterface.OnClickListener negativeCallback) {
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

        if (customLayoutID == 0) {
            customView = LayoutInflater.from(getActivity()).inflate(android.R.layout.select_dialog_item, null);
        } else {
            customView = LayoutInflater.from(getActivity()).inflate(customLayoutID, null);
        }
        builder.setView(customView);
        dialog = builder.create();
        return dialog;
    }

    public void show(FragmentManager fragmentManager) {
        show(fragmentManager, "CustomDialogFragment");
    }
}
