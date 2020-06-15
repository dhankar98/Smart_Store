package com.example.retail.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.retail.model.ItemModel;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "items.db";
    public static final String TABLE_NAME = "items_table";
    public static final String id = "id";
    public static final String name = "name";
    public static final String desc1= "desc1";
    public static final String price= "price";
    public static final String discount= "discount";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,desc1 TEXT,price TEXT,discount TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(ItemModel items) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(name,items.getName());
        contentValues.put(desc1,items.getDesc());
        contentValues.put(price,items.getPrice());
        contentValues.put(discount,items.getDiscount());

        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public ArrayList<ItemModel> getAllData() {
        ArrayList<ItemModel> itemlist = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);

        while(res.moveToNext()) {
           String id = res.getString(0);   //0 is the number of id column in your database table
            String name1 = res.getString(1);
            String desc2 = res.getString(2);
            String price1 = res.getString(3);
            String discount1 = res.getString(4);

            ItemModel item = new ItemModel( name1,desc2,price1,discount1);
            itemlist.add(item);
        }
        return itemlist;
    }
}
