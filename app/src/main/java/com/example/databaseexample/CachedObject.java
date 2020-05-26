package com.example.databaseexample;

public class CachedObject {

    public String url;
    public String filePath;
    public int locationType;
    public String resourceID;
    public int isReadOnly;

    CachedObject()
    {
        this.url="";
        this.filePath="";
        this.locationType=0;
        this.resourceID="";
        this.isReadOnly=1;
    }
    CachedObject(String mUrl,String mFilePath,int mLocationType,String mResourceID,int mIsReadOnly)
    {
        this.url=mUrl;
        this.filePath=mFilePath;
        this.locationType=mLocationType;
        this.resourceID=mResourceID;
        this.isReadOnly=mIsReadOnly;
    }

}
