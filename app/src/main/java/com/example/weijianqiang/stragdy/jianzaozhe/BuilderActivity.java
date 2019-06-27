package com.example.weijianqiang.stragdy.jianzaozhe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.weijianqiang.stragdy.R;

public class BuilderActivity extends AppCompatActivity {

    private static final String TAG = "BuilderActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder);
        findViewById(R.id.testbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Builder builder = new MacBuilder();
                Director director = new Director(builder);
                Computer computer = director.contretue("英特尔","三星","macOS");
                Log.d(TAG, "onClick: computer:"+computer.toString());
            }
        });
    }
}
