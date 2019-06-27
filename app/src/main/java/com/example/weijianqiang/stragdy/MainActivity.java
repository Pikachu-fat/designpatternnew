package com.example.weijianqiang.stragdy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.weijianqiang.stragdy.jianzaozhe.BuilderActivity;
import com.example.weijianqiang.stragdy.lod.LODActivity;
import com.example.weijianqiang.stragdy.ocp.OCPActivity;
import com.example.weijianqiang.stragdy.singleton.SingleTonActivity;
import com.example.weijianqiang.stragdy.srp.SRPActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button srp;
    private Button ocp;
    private Button lod;
    private Button single;
    private Button builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        srp = (Button) findViewById(R.id.srp);
        srp.setOnClickListener(this);

        ocp = (Button) findViewById(R.id.ocp);
        ocp.setOnClickListener(this);

        lod = (Button) findViewById(R.id.lod);
        lod.setOnClickListener(this);

        single = (Button) findViewById(R.id.singleton);
        single.setOnClickListener(this);

        builder = (Button) findViewById(R.id.build);
        builder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.srp:
                intent = new Intent(MainActivity.this, SRPActivity.class);
                break;
            case R.id.ocp:
                intent = new Intent(MainActivity.this, OCPActivity.class);
                break;
            case R.id.lod:
                intent = new Intent(MainActivity.this, LODActivity.class);
                break;
            case R.id.singleton:
                intent = new Intent(MainActivity.this, SingleTonActivity.class);
                break;
            case R.id.build:
                intent = new Intent(MainActivity.this, BuilderActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);

    }
}
