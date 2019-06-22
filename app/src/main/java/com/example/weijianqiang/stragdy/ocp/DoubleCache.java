package com.example.weijianqiang.stragdy.ocp;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;

import com.example.weijianqiang.stragdy.srp.imageloadertwo.ImageCache;

/**
 * Created by weijianqiang
 * On 2019/6/23
 * Description:
 */
public class DoubleCache {
    private static final String TAG = "DoubleCache";

    private ImageCache imageCache = new ImageCache();
    private DiskCache diskCache = new DiskCache();

    public void put(String url, Bitmap bitmap) {
        imageCache.put(url, bitmap);
        diskCache.put(url, bitmap);
    }

    public Bitmap get(String url) {
        if (TextUtils.isEmpty(url)) {
            Log.d(TAG, "get: url is empty");
        }
        Bitmap bitmap = imageCache.get(url);
        if (bitmap == null) {
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }
}
