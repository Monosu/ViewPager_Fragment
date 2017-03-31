package com.example.linxi.viewpager_fragment.util;

import android.widget.CompoundButton;

import java.text.DecimalFormat;

/**
 * Created by linxi on 2017/3/29.
 */

public class StringUtil {
    private static final String TAG="StringUtil";
    public static String getSystemMsgUrl(String url){
        return url;
    }
    public static String formatFloat(float src,String formatStr){
        String ret=null;
        try {
            DecimalFormat format=new DecimalFormat(formatStr);
            ret=format.format(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
    public static String formatDouble(double src,String formatStr){
        String ret=null;
        try {
            DecimalFormat format=new DecimalFormat(formatStr);
            ret=format.format(src);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }
    public static String getCyclingDuration(long m){
        int mi=60;
        int hh=mi*60;

        long hour=(m)/hh;
        long minute=(m-hour*hh)/mi;
        long second=(m-hour*hh-minute*mi);

        String strHour=hour<10?"0"+hour:""+hour;
        String strMinute=minute<10?"0"+minute:""+minute;
        String strSecond=second<10?"0"+second:""+second;

        return strHour+":"+strMinute+":"+strSecond;
    }
    public static String getDurationStr4Long(long f){
        long hours = f / (60 * 60);
//        long hours = (f % (60 * 60 * 24)) / (60 * 60);
        long minutes = (f % (60 * 60)) / (60);
        long seconds = (f % (60));
        String h = hours < 10 ? "0" + hours : String.valueOf(hours);
        String m = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
        String s = seconds < 10 ? "0" + seconds : String.valueOf(seconds);
        return h + ":" + m + ":" + s;
    }
    public static boolean isEmpty(String str){
        return str==null||str.length()<=0;
    }
}
