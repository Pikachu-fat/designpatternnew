package com.example.weijianqiang.stragdy.srp.imageloadertwo;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;

/**
 * Created by weijianqiang
 * On 2019/6/22
 * Description:
 */
public class ImageCache {

    private static final String TAG = "ImageCache";
//    private static ImageCache imageCache = null;

    //图片缓存器
    LruCache<String, Bitmap> lruCache = null;

    public ImageCache() {
        init();
    }

//    public static ImageCache getInstance() {
//        if (imageCache == null) {
//            imageCache = new ImageCache();
//        }
//        return imageCache;
//    }

    private void init() {
        lruCache = new LruCache<String, Bitmap>(Runtime.getRuntime().availableProcessors()) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    public void put(String url, Bitmap bitmap) {
        if (TextUtils.isEmpty(url) || bitmap == null) {
            return;
        }
        lruCache.put(url, bitmap);
    }

    public Bitmap get(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        return lruCache.get(url);
    }

}
