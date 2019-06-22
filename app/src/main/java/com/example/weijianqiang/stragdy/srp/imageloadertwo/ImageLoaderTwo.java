package com.example.weijianqiang.stragdy.srp.imageloadertwo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.example.weijianqiang.stragdy.srp.DiskCache;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by weijianqiang
 * On 2019/6/22
 * Description:
 */
public class ImageLoaderTwo {
    private static final String TAG = "ImageLoaderTwo";

    private static ImageLoaderTwo imageLoaderTwo = null;
    private ExecutorService executorService = null;
    //内存缓存
    private ImageCache imageCache = new ImageCache();

    //本地sd卡缓存
    private DiskCache diskCache = new DiskCache();

    //是否使用本地缓存
    private boolean useDiskCache = false;

    private ImageLoaderTwo() {
        init();
    }

    public static ImageLoaderTwo getInstance() {
        if (imageLoaderTwo == null) {
            imageLoaderTwo = new ImageLoaderTwo();
        }
        return imageLoaderTwo;
    }

    private void init() {
        int maxSize = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxSize / 4;
        executorService = Executors.newFixedThreadPool(cacheSize);
    }

    public void displayImage(final String url, final ImageView imageView) {
        if (TextUtils.isEmpty(url) || imageView == null) {
            Log.d(TAG, "displayImage: url is null");
            return;
        }
        //缓存中查找
        Bitmap bitmap = useDiskCache?diskCache.get(url):imageCache.get(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }

        //缓存中没有网络请求
        imageView.setTag(url);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: 网络请求");
                Bitmap bitmap = downLoadImage(url);
                if (bitmap == null) {
                    return;
                } else if (imageView.getTag().equals(url)) {
                    imageView.setImageBitmap(bitmap);
                    imageCache.put(url, bitmap);
                    if (useDiskCache){
                        diskCache.put(url,bitmap);
                    }
                }
            }
        });
    }

    /**
     * 网络请求下载图片资源
     *
     * @param url
     * @return
     */
    private Bitmap downLoadImage(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }

        Bitmap bitmap = null;
        HttpURLConnection httpURLConnection = null;
        try {
            URL url1 = new URL(url);
            httpURLConnection = (HttpURLConnection) (url1.openConnection());
            bitmap = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                bitmap = null;
            }
        }
        return null;
    }

    private void isUseDiskCache(boolean useDiskCache){
        this.useDiskCache = useDiskCache;
    }

}
