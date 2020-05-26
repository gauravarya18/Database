package com.example.databaseexample;

import android.app.Application;

public class MyApplication extends Application {
    private static MyApplication mContext;
    //private static CacheManager mCacheManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        //mCacheManager=new CacheManager(mContext);
    }

    public static MyApplication getContext() {

        return mContext;
    }
}
