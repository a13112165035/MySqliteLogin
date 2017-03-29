package com.example.administrator.mysqlitelr.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.mysqlitelr.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/24.
 */

public class UserActivity extends AppCompatActivity {
    @BindView(R.id.text_tv)
    TextView textTv;
    private int count;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        Intent intent=getIntent();
        String name=intent.getStringExtra("username");
        count = intent.getIntExtra("count", -1);
        textTv.setText("欢迎"+name+"第"+count+"次登陆");
    }
}
