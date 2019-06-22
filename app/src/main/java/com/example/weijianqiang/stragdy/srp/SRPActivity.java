package com.example.weijianqiang.stragdy.srp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.weijianqiang.stragdy.R;
import com.example.weijianqiang.stragdy.srp.imageloaderone.ImageLoaderOne;
import com.example.weijianqiang.stragdy.srp.imageloadertwo.ImageLoaderTwo;

public class SRPActivity extends AppCompatActivity {

    private String URL = "http://e.hiphotos.baidu.com/image/h%3D300/sign=2581bca42f3fb80e13d167d706d02ffb/4034970a304e251fb1a2546da986c9177e3e53c9.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srp);
        final ImageView imageView = (ImageView) findViewById(R.id.imageview);

        findViewById(R.id.testurl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageLoaderOne.getInstance().displayImageByURL(URL,
                        imageView);
            }
        });

        findViewById(R.id.imageloader_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageLoaderTwo.getInstance().displayImage("http://c.hiphotos.baidu.com/image/h%3D300/sign=71b4c9c8f21986185e47e9847aec2e69/7acb0a46f21fbe09a9cc8fbd61600c338644ad8d.jpg", imageView);
            }
        });

    }
}
