package com.example.weijianqiang.stragdy.singleton;

import com.example.weijianqiang.stragdy.IImageCache;

/**
 * Created by weijianqiang
 * On 2019/6/23
 * Description:
 */
public class ImageLoaderConfig {

    private IImageCache imageCache;
    private int threadCount;

    private ImageLoaderConfig(Builder builder){
        this.imageCache = builder.imageCache;
        this.threadCount = builder.threadCount;
    }

    public IImageCache getImageCache() {
        return imageCache;
    }

    public void setImageCache(IImageCache imageCache) {
        this.imageCache = imageCache;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public static class Builder{
        private IImageCache imageCache;
        private int threadCount;

        public Builder addImageCache(IImageCache imageCache){
            this.imageCache = imageCache;
            return this;
        }

        public Builder setThreadCount(int threadCount){
            this.threadCount = threadCount;
            return this;
        }

        public ImageLoaderConfig build(){
            return new ImageLoaderConfig(this);
        }
    }
}
