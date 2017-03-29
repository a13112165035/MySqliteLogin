package com.example.administrator.mysqlitelr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.administrator.mysqlitelr.sql.MySqliteHelper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private SQLiteDatabase db;
    private String name;
    private int count;

    @Before
    public void init(){
      Context context=  InstrumentationRegistry.getTargetContext();
        MySqliteHelper helper=new MySqliteHelper(context);
        db = helper.getWritableDatabase();
    }
    @Test
    public void insert(){
       String insert=  "insert into useli values(5,\"林心\",\"2123\",3)";
       String insert1=  "insert into useli values(6,\"心\",\"293\",3)";
       String insert2=  "insert into useli values(7,\"林\",\"2823\",3)";

        db.execSQL(insert);
        db.execSQL(insert1);
        db.execSQL(insert2);

    }
    @Test
   public void update(){
    /*    String update="update useli set count=2,name=\"刘德华\" where id=1";
        db.execSQL(update);*/
        ContentValues values=new ContentValues();
        values.put("username","小甜甜");
        db.update("useli",values,"id=?",new String[]{"1"});

        }

 @Test
 public void delete(){
     String delete ="delete from useli where id=1";
     db.execSQL(delete);
 }

  @Test
    public void query(){
        Cursor cursor= db.query("useli",new String[]{"count","username"},null,null,null,null,null);
        while (cursor.moveToNext()){
            count = cursor.getInt(cursor.getColumnIndex("count"));
            name = cursor.getString(cursor.getColumnIndex("username"));
            Log.e("db","count=" +count + " name= " +name);
        }
  }
}
