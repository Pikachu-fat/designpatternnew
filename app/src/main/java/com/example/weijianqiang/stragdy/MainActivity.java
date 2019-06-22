package com.example.weijianqiang.stragdy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.weijianqiang.stragdy.ocp.OCPActivity;
import com.example.weijianqiang.stragdy.srp.SRPActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button srp;
    private Button ocp;

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
            default:
                break;
        }
        startActivity(intent);

    }
}
