package com.example.weijianqiang.stragdy.srp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by weijianqiang
 * On 2019/6/23
 * Description:
 */
public class DiskCache {

    private static final String TAG = "DiskCache";

    //本地缓存路径
    private String cacheDir = "sdcard/cache";

    public void put(String url, Bitmap bitmap){
        if (TextUtils.isEmpty(url) || bitmap == null){
            Log.d(TAG, "put: url or bitmap is null");
            return;
        }

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(cacheDir+url);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
        } catch (Exception e){
            Log.d(TAG, "put: e:"+e);
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                    fileOutputStream = null;
                } catch (IOException e) {

                }
            }
        }
    }

    public Bitmap get(String url){
        return BitmapFactory.decodeFile(cacheDir+url);
    }
}
