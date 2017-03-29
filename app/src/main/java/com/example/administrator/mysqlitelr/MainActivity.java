package com.example.administrator.mysqlitelr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mysqlitelr.activity.UserActivity;
import com.example.administrator.mysqlitelr.model.UserModel;
import com.example.administrator.mysqlitelr.utils.DBUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.regist)
    Button regist;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }
    //注册
        public void regist(View View){
            String name= username.getText().toString().trim();
            String pwd=password.getText().toString().trim();
            if(TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)){
                Toast.makeText(this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
            }
            if(DBUtil.isNameExist(name)){
                Toast.makeText(this, "用户名已存在", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                DBUtil.save(new UserModel(0,name,pwd));
            }
        }
        //登陆
    public void login(View View){
        String name= username.getText().toString().trim();
        String pwd=password.getText().toString().trim();
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)){
            Toast.makeText(this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
        }
        boolean userExist= DBUtil.isUserExist(name);
        if(userExist){
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, UserActivity.class);
            intent.putExtra("username",name);
            intent.putExtra("count",DBUtil.getLoginCount(name));
            startActivity(intent);
            DBUtil.setLoginCount(name);
        }else {
            Toast.makeText(this, "用户不存在", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
