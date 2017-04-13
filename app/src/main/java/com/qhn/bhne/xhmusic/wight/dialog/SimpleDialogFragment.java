package com.qhn.bhne.xhmusic.wight.dialog;

import android.support.v4.app.FragmentManager;

/**
 * Created by qhn
 * on 2017/3/31 0031.
 */

public class SimpleDialogFragment extends BaseDialogFragment {
    @Override
    public void show(FragmentManager fragmentManager) {
        show(fragmentManager, "SimpleDialogFragment");
    }

}
