package com.example.weijianqiang.stragdy.lod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.weijianqiang.stragdy.R;

public class LODActivity extends AppCompatActivity {

    private static final String TAG = "LODActivity";

    private float diffArea = 2.0f;
    private float diffPprice = 400f;

    private float area = 15f;
    private float price = 2350f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lod);

        findViewById(R.id.lod).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tenent tenent = new Tenent(area,price,diffArea,diffPprice);
                tenent.subInfo();
            }
        });
    }
}
