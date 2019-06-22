package com.example.weijianqiang.stragdy.ocp;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;

import com.example.weijianqiang.stragdy.IImageCache;
import com.example.weijianqiang.stragdy.srp.imageloadertwo.MemoryCache;

/**
 * Created by weijianqiang
 * On 2019/6/23
 * Description:
 */
public class DoubleCache implements IImageCache {
    private static final String TAG = "DoubleCache";

    private MemoryCache memoryCache = new MemoryCache();
    private DiskCache diskCache = new DiskCache();

    @Override
    public void put(String url, Bitmap bitmap) {
        memoryCache.put(url, bitmap);
        diskCache.put(url, bitmap);
    }

    @Override
    public Bitmap get(String url) {
        if (TextUtils.isEmpty(url)) {
            Log.d(TAG, "get: url is empty");
        }
        Bitmap bitmap = memoryCache.get(url);
        if (bitmap == null) {
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }
}
