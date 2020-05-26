package com.example.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    CacheManager mCacheManager;
    String name="Gaurav";
    String surname="Arya";
    EditText name_text,surname_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCacheManager=new CacheManager(MyApplication.getContext());
        name_text=(EditText)findViewById(R.id.edit1);
        surname_text=(EditText)findViewById(R.id.edit2);


    }

    public void addEntry(View view) {

        CachedObject newCachedObject=new CachedObject(name_text.getText().toString(),surname_text.getText().toString(),1,"res",1);
        name_text.setText("");
        surname_text.setText("");
        mCacheManager.addURL(newCachedObject);

    }

    public void FindEntry(View view) {

         CachedObject EntrywithURL=mCacheManager.findURL(name_text.getText().toString());
         Log.d("hey",EntrywithURL.url+" "+EntrywithURL.filePath+" "+EntrywithURL.resourceID);
    }

    public void deleteTable(View view) {
        mCacheManager.deleteTable();
    }

    public void print(View view) {
        mCacheManager.logComplete();
    }
}
