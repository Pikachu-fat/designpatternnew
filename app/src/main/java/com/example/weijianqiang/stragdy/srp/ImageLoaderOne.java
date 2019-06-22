package com.example.weijianqiang.stragdy.srp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by weijianqiang
 * On 2019/6/22
 * Description:
 */
public class ImageLoaderOne {
    private static final String TAG = "ImageLoaderOne";
    private static ImageLoaderOne imageLoaderOne;
    //图片缓存
    private LruCache<String, Bitmap> lruCache = null;

    //和可用cpu核数相同的线程池
    private ExecutorService executorServices = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private ImageLoaderOne() {
        init();
    }

    public static ImageLoaderOne getInstance() {
        if (imageLoaderOne == null) {
            imageLoaderOne = new ImageLoaderOne();
        }
        return imageLoaderOne;
    }

    private void init() {
        final int maxSize = (int) (Runtime.getRuntime().maxMemory() / 1024);
        Log.d(TAG, "init: maxSize:"+maxSize);
        final int cacheSize = maxSize / 4;
        lruCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    public void displayImageByURL(final String url, final ImageView view) {
        if (view == null)
            return;

        view.setTag(url);
        executorServices.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downLoadImage(url);
                if (bitmap == null)
                    return;

                if (view.getTag().equals(url)) {
                    view.setImageBitmap(bitmap);
                }
                lruCache.put(url,bitmap);
            }
        });
    }

    /**
     * 下载图片
     * @param url 图片地址
     * @return
     */
    private Bitmap downLoadImage(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }

        HttpURLConnection httpURLConnection = null;
        Bitmap bitmap = null;
        try {
            URL url1 = new URL(url);
            httpURLConnection = (HttpURLConnection) (url1.openConnection());
            bitmap = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            return bitmap;
        } catch (Exception e) {
            Log.d(TAG, "downLoadImage: e:" + e);
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return null;
    }

}
