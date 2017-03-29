package com.example.administrator.mysqlitelr.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/3/24.
 */

public class MyApplication extends Application{
    private static Application instance;

    public static Context getAppContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }
}
