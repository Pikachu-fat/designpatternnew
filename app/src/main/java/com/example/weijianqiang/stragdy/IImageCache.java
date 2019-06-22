package com.example.weijianqiang.stragdy;

import android.graphics.Bitmap;

/**
 * Created by weijianqiang
 * On 2019/6/23
 * Description:
 */
public interface IImageCache {

    void put(String url, Bitmap bitmap);
    Bitmap get(String url);
}
