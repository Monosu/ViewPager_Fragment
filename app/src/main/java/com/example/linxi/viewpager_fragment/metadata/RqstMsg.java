package com.example.linxi.viewpager_fragment.metadata;

import android.text.TextUtils;

import com.example.linxi.viewpager_fragment.util.AESUtil;
import com.example.linxi.viewpager_fragment.util.DataParserHelper;
import com.example.linxi.viewpager_fragment.util.LeqiApplication;
import com.example.linxi.viewpager_fragment.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by linxi on 2017/3/28.
 */

public class RqstMsg {
    public static final String UPLOAD_FILE_TYPE_PIC="pic";
    public static final String UPLOAD_FILE_TYPE_GPX="gpx";
    public static final String UPLOAD_FILE_TYPE_GPX_PIC="gpxpic";

    private String mDstAdress;
    private String mRqstType;
    private int mTag;
    private int mTimeOut;
    private int mMsgType;
    private String mFileName;
    private Map<String,String>mMutilFilePath;

    private String version="1.2.6";
    private String clientVersion;
    private int platform=0;

    public void addFilePath(String fileType,String filePath){
        if (mMutilFilePath==null){
            mMutilFilePath=new HashMap<String,String>();
        }
        mMutilFilePath.put(fileType,filePath);
    }

    public RqstMsg() {
        mTag=-1;
        clientVersion="153";
        mTimeOut=30000;
    }

    public String toServiceString(Object obj){
        String data=null;
        if (isValidRqst()&&obj!=null){
            ServiceHeader header=this.initMsgHeader();
            ServiceContent<ServiceHeader,Object>buss=new ServiceContent<ServiceHeader, Object>(header,obj);
            data= DataParserHelper.parser(buss);
        }
        return data;
    }

    private ServiceHeader initMsgHeader() {

        ServiceHeader header=new ServiceHeader();

        header.setBusiness(this.getmRqstType());
        header.setSquence(this.getmTag());
        header.setVersion(this.getVersion());
        header.setPlatform(this.getPlatform());
        header.setClientVersion(this.clientVersion);

        String key= AESUtil.getAuthKey(LeqiApplication.applicationContext);
        if (TextUtils.isEmpty(key)){
            return null;
        }
        long timestamp=System.currentTimeMillis();
        header.setTimestamp(timestamp);

        String ne=ne(timestamp);

        String signature=AESUtil.getEncodeSignature(stringSort(new String[]{key,String.valueOf(timestamp),ne}));

        header.setNonce(ne);
        header.setSignature(signature);

        return header;
    }

    private String[] stringSort(String[] strings) {

        List<String>list=new ArrayList<>(strings.length);
        for (int i=0;i<strings.length;i++){
            list.add(strings[i]);
        }
        Collections.sort(list);//默认升序排列
        return list.toArray(strings);
    }

    public static String arrayConvertStr(String[]strings){
        if (strings==null||strings.length<=0){
            return null;
        }
        StringBuffer sb=new StringBuffer();
        int length=strings.length;
        for (int i=0;i <length; i++){
            sb.append(strings[i]);
        }
        return sb.toString();
    }
    private String ne(long timestamp) {
        return UUID.randomUUID().toString()+timestamp;
    }

    private boolean isValidRqst() {
        if (getmTag()<=0|| StringUtil.isEmpty(getmDstAdress())||StringUtil.isEmpty(getmRqstType())){
            return false;
        }else{
            return true;
        }

    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getmDstAdress() {
        return mDstAdress;
    }

    public void setmDstAdress(String mDstAdress) {
        this.mDstAdress = mDstAdress;
    }

    public String getmFileName() {
        return mFileName;
    }

    public void setmFileName(String mFileName) {
        this.mFileName = mFileName;
    }

    public int getmMsgType() {
        return mMsgType;
    }

    public void setmMsgType(int mMsgType) {
        this.mMsgType = mMsgType;
    }

    public Map<String, String> getmMutilFilePath() {
        return mMutilFilePath;
    }

    public void setmMutilFilePath(Map<String, String> mMutilFilePath) {
        this.mMutilFilePath = mMutilFilePath;
    }

    public String getmRqstType() {
        return mRqstType;
    }

    public void setmRqstType(String mRqstType) {
        this.mRqstType = mRqstType;
    }

    public int getmTag() {
        return mTag;
    }

    public void setmTag(int mTag) {
        this.mTag = mTag;
    }

    public int getmTimeOut() {
        return mTimeOut;
    }

    public void setmTimeOut(int mTimeOut) {
        this.mTimeOut = mTimeOut;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
