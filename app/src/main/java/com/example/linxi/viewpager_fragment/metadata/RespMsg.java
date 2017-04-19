package com.example.linxi.viewpager_fragment.metadata;

/**
 * Created by linxi on 2017/4/19.
 */

public class RespMsg {
    private String mDstAddress;     // Address of msg
    private String mRequestType;    // type of msg
    private String mStrData;
    private int    mTag;            // tag of msg
    private int    mRespCode;
    private String mReason;
    private int mSubCode;
    private String mSubMsg;

    public RespMsg() {
        this.mTag=-1;
        this.mRespCode=-1;
    }

    public String getmDstAddress() {
        return mDstAddress;
    }

    public void setmDstAddress(String mDstAddress) {
        this.mDstAddress = mDstAddress;
    }

    public String getmReason() {
        return mReason;
    }

    public void setmReason(String mReason) {
        this.mReason = mReason;
    }

    public String getmRequestType() {
        return mRequestType;
    }

    public void setmRequestType(String mRequestType) {
        this.mRequestType = mRequestType;
    }

    public int getmRespCode() {
        return mRespCode;
    }

    public void setmRespCode(int mRespCode) {
        this.mRespCode = mRespCode;
    }

    public String getmStrData() {
        return mStrData;
    }

    public void setmStrData(String mStrData) {
        this.mStrData = mStrData;
    }

    public int getmSubCode() {
        return mSubCode;
    }

    public void setmSubCode(int mSubCode) {
        this.mSubCode = mSubCode;
    }

    public String getmSubMsg() {
        return mSubMsg;
    }

    public void setmSubMsg(String mSubMsg) {
        this.mSubMsg = mSubMsg;
    }

    public int getmTag() {
        return mTag;
    }

    public void setmTag(int mTag) {
        this.mTag = mTag;
    }
}
