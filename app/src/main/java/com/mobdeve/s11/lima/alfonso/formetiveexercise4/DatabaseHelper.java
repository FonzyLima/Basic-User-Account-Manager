package com.mobdeve.s11.lima.alfonso.formetiveexercise4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "accounts.db";
    public static final String TABLE_NAME = "Accounts_Table";
    public static final String COL1 = "ID";
    public static final String COL2 = "USERNAME";
    public static final String COL3 = "NAME";
    public static final String COL4 = "DESCRIPTION";

    public DatabaseHelper(@Nullable Context context){
        super(context,DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "+ "USERNAME TEXT, NAME TEXT, DESCRIPTION TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String username, String name, String desc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,username);
        contentValues.put(COL3,name);
        contentValues.put(COL4,desc);

        long result = db.insert(TABLE_NAME,null,contentValues);

        return result != -1;

    }

    public ArrayList<Users> loadData(){
        ArrayList<Users> dataUsers = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);

        if(data.getCount() != 0){
            while(data.moveToNext()){
                dataUsers.add(new Users(data.getString(1),data.getString(2),data.getString(3),data.getString(0)));
            }
        }

        return dataUsers;
    }
}
