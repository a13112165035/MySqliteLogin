package com.example.administrator.mysqlitelr.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.mysqlitelr.app.MyApplication;
import com.example.administrator.mysqlitelr.model.UserModel;
import com.example.administrator.mysqlitelr.sql.MySqliteHelper;


/**
 * Created by Administrator on 2017/3/24.
 */

public class DBUtil {

    static {
        Context content = MyApplication.getAppContext();
        MySqliteHelper helper = new MySqliteHelper(content);
        db = helper.getWritableDatabase();

    }

    private static SQLiteDatabase db;
    private static final String TABLE_NAME = "useli";

    //判断用户是否存在
    public static boolean isUserExist(String username) {
        Cursor cursor = db.query(TABLE_NAME, null, "username=?", new String[]{username}, null, null, null);
        int count = cursor.getCount();
        return count == 0 ? false : true;
    }

    //保存用户
    public static void save(UserModel user) {
        ContentValues values = new ContentValues();
        values.put("username", user.getUsername());
        values.put("password", user.getPassword());
        values.put("count", 0);
        db.insert(TABLE_NAME, null, values);
    }

    //检查用户名是否存在
    public static boolean isNameExist(String name) {

        return isUserExist(name);
    }

    //获取登录次数
    public static int getLoginCount(String name) {
        Cursor cursor = db.query(TABLE_NAME, new String[]{"count"}, "username=?", new String[]{name}, null, null, null);
        cursor.moveToNext();
        int count = cursor.getInt(cursor.getColumnIndex("count"));
        return count;
    }

    public static void setLoginCount(String name) {
        ContentValues values = new ContentValues();
        values.put("count", getLoginCount(name) + 1);
        db.update(TABLE_NAME, values, "username=?", new String[]{name});
    }
}

