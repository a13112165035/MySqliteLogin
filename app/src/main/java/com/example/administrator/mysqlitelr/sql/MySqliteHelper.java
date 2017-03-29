package com.example.administrator.mysqlitelr.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/3/24.
 */

public class MySqliteHelper extends SQLiteOpenHelper {

        public MySqliteHelper(Context context) {
        super(context, "zhi.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表
        String ctable = "create table useli(id integer primary key autoincrement,username varchar(20),password varchar(20),count integer)";
        db.execSQL(ctable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
