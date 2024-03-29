package com.example.weijianqiang.stragdy.srp.imageloadertwo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.example.weijianqiang.stragdy.IImageCache;
import com.example.weijianqiang.stragdy.singleton.ImageLoaderConfig;

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
    //缓存策略，默认仅内存缓存
    private IImageCache imageCache = new MemoryCache();
    private ImageLoaderConfig imageLoaderConfig;
    private int threadCount;


    private ImageLoaderTwo() {
        init();
    }

    public void preInit(ImageLoaderConfig imageLoaderConfig){
        if (imageLoaderConfig == null){
            return;
        }

        this.imageLoaderConfig = imageLoaderConfig;
        imageCache = imageLoaderConfig.getImageCache();
        threadCount = imageLoaderConfig.getThreadCount();

    }

    /**
     * DCL
     * @return
     */
    public static ImageLoaderTwo getInstance() {
        if (imageLoaderTwo == null) {
            synchronized (ImageLoaderTwo.class){
                if (imageLoaderTwo == null){
                    imageLoaderTwo = new ImageLoaderTwo();
                }
            }
        }
        return imageLoaderTwo;
    }

    private void init() {
        int maxSize = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxSize / 4;
        executorService = Executors.newFixedThreadPool(cacheSize);
    }

    /**
     * 外界调用显示图片
     *
     * @param url       图片地址
     * @param imageView 加载图片的view
     */
    public void displayImage(final String url, final ImageView imageView) {
        if (TextUtils.isEmpty(url) || imageView == null) {
            Log.d(TAG, "displayImage: url is null");
            return;
        }
        //缓存中查找
        Bitmap bitmap = imageCache.get(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        submitLoadRequest(url, imageView);
        //disPlayImage(url,imageView,null,null);
    }

//    public void disPlayImage(String url,ImageView imageView,ImageLoaderConfig imageLoaderConfig,Listener listener){
//        BitmapRequest bitmapRequest = new BitmapRequest(url,imageView,imageLoaderConfig,listener);
//        bitmapRequest.imageLoaderConfig = bitmapRequest.imageLoaderConfig != null?bitmapRequest.imageLoaderConfig:imageLoaderConfig.
//    }


    /**
     * 发动网络请求瞎子啊图片
     *
     * @param url
     * @param imageView
     */
    private void submitLoadRequest(final String url, final ImageView imageView) {
        //测试冲突
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

    public void setImageCache(IImageCache imageCache) {
        this.imageCache = imageCache;
    }

    public interface Listener{
        public void onCompleted();
    }
}
