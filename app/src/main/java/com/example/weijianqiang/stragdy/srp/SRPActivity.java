package com.example.weijianqiang.stragdy.srp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.weijianqiang.stragdy.R;

public class SRPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srp);
        final ImageView imageView = (ImageView) findViewById(R.id.imageview);

        findViewById(R.id.testurl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageLoaderOne.getInstance().displayImageByURL("http://e.hiphotos.baidu.com/image/h%3D300/sign=2581bca42f3fb80e13d167d706d02ffb/4034970a304e251fb1a2546da986c9177e3e53c9.jpg",
                        imageView);
            }
        });

    }
}
