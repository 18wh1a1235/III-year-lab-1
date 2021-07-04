package com.example.experiment8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper  extends SQLiteOpenHelper {

    public static final String database_name = "userstable";
    public static final String col1 ="name";
    public static final String col2 = "password";
    public static final String col3 = "email";
    public static final String col4 = "gender";
    public static final String col5 = "DOB";
    public static final String col6 = "age";

    public DBHelper(@Nullable Context context) {

        super(context,database_name,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE userstable (email TEXT PRIMARY KEY, name TEXT,password TEXT,age TEXT,gender TEXT, DOB TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS userstable");
        onCreate(db);
    }

    public boolean insertdata(String name,String password,String address,String gender,String DOB,String age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.col1,name);
        cv.put(DBHelper.col2,password);
        cv.put(DBHelper.col3,address);
        cv.put(DBHelper.col4,gender);
        cv.put(DBHelper.col5,DOB);
        cv.put(DBHelper.col6,age);
        long id = db.insert("userstable",null,cv);
        if(id == -1){
            return false;
        }
        return true;
    }
    public boolean isValidLogin(String email,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from userstable where email = ? and password = ?",new String[]{email,pass});
        if(c.getCount()>0){
            return true;
        }
        return false;
    }
}
