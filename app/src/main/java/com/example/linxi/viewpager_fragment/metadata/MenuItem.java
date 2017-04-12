package com.example.linxi.viewpager_fragment.metadata;

/**
 * Created by linxi on 2017/4/11.
 */

public class MenuItem {
    private String mContentText;
    private int mIconRes;
    private int mId;

    public MenuItem( int resId,String text, int id) {
        mContentText = text;
        mIconRes = resId;
        mId = id;
    }

    public String getmContentText() {
        return mContentText;
    }

    public void setmContentText(String mContentText) {
        this.mContentText = mContentText;
    }

    public int getmIconRes() {
        return mIconRes;
    }

    public void setmIconRes(int mIconRes) {
        this.mIconRes = mIconRes;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }
}
