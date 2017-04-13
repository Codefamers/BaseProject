package com.qhn.bhne.xhmusic.wight.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.view.Window;
import android.view.WindowManager;

import com.qhn.bhne.xhmusic.utils.DimenUtil;
import com.qhn.bhne.xhmusic.utils.DisplayUtil;


/**
 * Created by qhn
 * on 2017/3/31 0031.
 */

public class SingleListDialogFragment extends BaseDialogFragment {

    private DialogInterface.OnClickListener mOnClickListener;
    private String[] mItems;
    private int mLastSelect = 0;

    public SingleListDialogFragment setItems(String[] mItems) {
        this.mItems = mItems;
        return this;
    }

    public SingleListDialogFragment setLastSelect(int mLastSelect) {
        this.mLastSelect = mLastSelect;
        return this;
    }


    public SingleListDialogFragment setOnClickListener(DialogInterface.OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
        return this;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        builder.setSingleChoiceItems(mItems, mLastSelect, mOnClickListener);
        dialog = builder.create();
        dialog.show();
        Window window = dialog.getWindow();
        //获取到LayoutParams
        WindowManager.LayoutParams attributes = window.getAttributes();
        //设置宽度
        attributes.width = DisplayUtil.getScreenWidth() * 4 / 5;
        //设置高度
        attributes.height = DisplayUtil.getScreenHeight() * 3 / 5;
        window.setAttributes(attributes);
        return dialog;
    }

    @Override
    public void show(FragmentManager fragmentManager) {
        show(fragmentManager, "SingleListDialogFragment");
    }
}
