package com.qhn.bhne.baseproject.listener;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by qhn
 * on 2017/2/21 0021.
 */

public interface UrlToBitmapListener {
    void onSuccess(Drawable drawable);
    void onBitmap(Bitmap bitmap);
}
