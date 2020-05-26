package com.example.databaseexample;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;


public class DatabaseHelper {




//    private static final String TAG = "DatabaseHelper";
//    public static final String TABLE_NAME = "people_table";
//    public static final String COL1 = "ID";
//    public static final String COL2 = "key";
//    public static final String COL3 = "Value";
//    CacheManager m;
//
//
//    public DatabaseHelper(Context context) {
//        super(context, TABLE_NAME, null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String createTable = "CREATE TABLE " + TABLE_NAME +
////                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                " (" +
//                COL2 +" TEXT,"  +
//                COL3 +" TEXT)";
//        db.execSQL(createTable);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
//       // m=new CacheManager(Activity.getApplicationContext);
//    }
//
//    private long addEntry(CachedObject mCachedObject,SQLiteDatabase db) {
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(this.COL2,mCachedObject.st1);
//        contentValues.put(this.COL3,mCachedObject.str2);
//        long result = db.insert(this.TABLE_NAME, null, contentValues);
//
//        return result;
//    }
//
//
//    private Cursor getData(SQLiteDatabase db){
//
//        String query = "SELECT * FROM " + TABLE_NAME;
//        Cursor data = db.rawQuery(query, null);
//        return data;
//    }
//
//    private CachedObject DeleteURL(String mURL,SQLiteDatabase db)
//    {
//        Cursor cursor=this.getData(db);
//        //cursor.moveToLast();
//        CachedObject mCachedobject=new CachedObject("","");
//        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
//                + COL2 + " = '" + mURL + "'" ;
//        if(cursor.moveToLast())
//        while(true)
//        {
//            if(cursor.getString(0).matches(mURL))
//            {
//                mCachedobject.st1=mURL;
//                mCachedobject.str2=cursor.getString(1);
//                db.execSQL(query);
//                break;
//            }
//            if(!cursor.moveToPrevious())
//                break;
//        }
//
//        return mCachedobject;
//    }
//    public void AddURL(CachedObject mCachedObject)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        CachedObject tempCachedObject=DeleteURL(mCachedObject.st1,db);
//        long result=addEntry(mCachedObject,db);
//        Log.d("hey",Long.toString(result));
//    }
//
//    public CachedObject FindURL(String mURL)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        CachedObject finalCachedObject=DeleteURL(mURL,db);
//        addEntry(finalCachedObject,db);
//        return finalCachedObject;
//    }
//    public void delete()
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("delete from "+ TABLE_NAME);
//    }
//
//    public void logComplete()
//    {
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor=this.getData(db);
//
//        for(cursor.moveToLast();;)
//        {
//            Log.d("hey1",cursor.getString(0)+" "+cursor.getString(1));
//            if(!cursor.moveToPrevious())
//                break;
//
//        }
//    }
}
