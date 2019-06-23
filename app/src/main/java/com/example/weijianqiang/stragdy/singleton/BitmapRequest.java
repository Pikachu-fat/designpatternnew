package com.example.weijianqiang.stragdy.singleton;

import android.widget.ImageView;

import com.example.weijianqiang.stragdy.srp.imageloadertwo.ImageLoaderTwo;

/**
 * Created by weijianqiang
 * On 2019/6/23
 * Description:
 */
public class BitmapRequest {
    public String url;
    public ImageView imageView;
    public ImageLoaderConfig imageLoaderConfig;
    public ImageLoaderTwo.Listener listener;

    public BitmapRequest(String url, ImageView imageView, ImageLoaderConfig imageLoaderConfig, ImageLoaderTwo.Listener listener){
        this.url = url;
        this.imageView = imageView;
        this.imageLoaderConfig = imageLoaderConfig;
        this.listener = listener;
    }
}
