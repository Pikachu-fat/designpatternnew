package com.example.weijianqiang.stragdy.singleton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.weijianqiang.stragdy.R;

public class SingleTonActivity extends AppCompatActivity {

    private static final String TAG = "SingleTonActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_ton);

        findViewById(R.id.single).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingleTon.getInstance().showMsg(TAG, "this is test code");
            }
        });
    }
}
