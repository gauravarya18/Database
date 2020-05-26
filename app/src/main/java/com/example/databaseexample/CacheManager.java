package com.example.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class CacheManager extends SQLiteOpenHelper {


    private static final String tableName = "CacheTable";
    private static final String urlCol = "Col0";
    private static final String filePathCol= "Col1";
    private static final String locationTypeCol = "Col2";
    private static final String resourceIdCol = "Col3";
    private static final String isReadOnlyCol = "Col4";
    private DatabaseHelper mData;


    public CacheManager(Context context) {
        super(context, tableName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + tableName +
//                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " (" +
                urlCol +" TEXT,"  +
                filePathCol +" TEXT,"  +
                locationTypeCol +" INTEGER,"  +
                resourceIdCol +" TEXT,"  +
                isReadOnlyCol +" INTEGER)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + sqLiteDatabase);
        onCreate(sqLiteDatabase);
    }


    private long addEntry(CachedObject mCachedObject,SQLiteDatabase db) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(this.urlCol,mCachedObject.url);
        contentValues.put(this.filePathCol,mCachedObject.filePath);
        contentValues.put(this.locationTypeCol,mCachedObject.locationType);
        contentValues.put(this.resourceIdCol,mCachedObject.resourceID);
        contentValues.put(this.isReadOnlyCol,mCachedObject.isReadOnly);

        long result = db.insert(this.tableName, null, contentValues);
        return result;
    }


    private Cursor getData(SQLiteDatabase db){

        String query = "SELECT * FROM " + tableName;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    private CachedObject DeleteURL(String mURL,SQLiteDatabase db)
    {
        Cursor cursor=this.getData(db);
        CachedObject mCachedObject=new CachedObject();
        String query = "DELETE FROM " + tableName + " WHERE "
                + urlCol + " = '" + mURL + "'" ;
        if(cursor.moveToLast())
            while(true)
            {
                if(cursor.getString(0).matches(mURL))
                {
                    mCachedObject.url=mURL;
                    mCachedObject.filePath=cursor.getString(1);
                    mCachedObject.locationType=cursor.getInt(2);
                    mCachedObject.resourceID=cursor.getString(3);
                    mCachedObject.isReadOnly=cursor.getInt(4);

                    db.execSQL(query);
                    break;
                }
                if(!cursor.moveToPrevious())
                    break;
            }

        return mCachedObject;
    }
    public void addURL(CachedObject mCachedObject)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        CachedObject tempCachedObject=DeleteURL(mCachedObject.url,db);
        long result=addEntry(mCachedObject,db);
        Log.d("hey",Long.toString(result));
    }

    public CachedObject findURL(String mURL)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        CachedObject finalCachedObject=DeleteURL(mURL,db);
        addEntry(finalCachedObject,db);
        return finalCachedObject;
    }
    public void deleteTable()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ tableName);
    }

    public void logComplete()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=this.getData(db);

        for(cursor.moveToLast();;)
        {
            Log.d("hey1",cursor.getString(0)+" "+cursor.getString(1));
            if(!cursor.moveToPrevious())
                break;

        }
    }


}
