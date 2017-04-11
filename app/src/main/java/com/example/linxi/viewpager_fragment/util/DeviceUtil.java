package com.example.linxi.viewpager_fragment.util;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.linxi.viewpager_fragment.Person;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by linxi on 2017/4/11.
 */

public final class DeviceUtil {

    //无效的IMEI值
    private static final String INVALID_IMEI="0000000000000";
    public static final String DEFAULT_SERIAL="unknow_serial";

    private final static String KEY_DEVICE_SERIAL="KEY_DEVICE_SERIAL";

    //操作系统版本号
    private static String mOSVersion= Build.VERSION.RELEASE;
    //设备版本
    private static String mProduct= Build.DEVICE;
    //设备型号
    private static String mModel= Build.MODEL;
    //设备厂商
    private static String mManufact=Build.MANUFACTURER;

    private static String mImei;
    private static String mImsi;

    //屏幕分辨率
    private static int mScreenWidthPixels;
    private static int mScreenHeightPixels;

    //屏幕尺寸
    private static float mScreenWidthInches;
    private static float mScreenHeightInches;

    public static String getmOSVersion() {
        return mOSVersion;
    }

    public static String getmModel() {
        return mModel;
    }

    public static String getmManufact() {
        return mManufact;
    }

    public static String getmProduct() {
        return mProduct;
    }

    /**
     * 获取设备IMEI号
     */
    public static String getImei(Context appcontext){
        if (mImei!=null||appcontext==null){
            return mImei;
        }
        TelephonyManager telephonyManager= (TelephonyManager) appcontext.getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager!=null){
            mImei=telephonyManager.getDeviceId();
        }
        if (INVALID_IMEI.equals(mImei)){
            mImei=null;
        }
        return mImei;
    }

    /**
     * 获取设备唯一串号
     */
    public static String getSerial(Context appContext){
        String serial=DEFAULT_SERIAL;
        if (appContext==null){
            return DEFAULT_SERIAL;
        }
        String imei=getImei(appContext);
        String wifiMac=((WifiManager)appContext.getSystemService(Context.WIFI_SERVICE)).getConnectionInfo().getMacAddress();
        BluetoothAdapter bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        String btMac=null;
        if (bluetoothAdapter!=null){
            btMac=bluetoothAdapter.getAddress();
        }
        String str="";
        if (TextUtils.isEmpty(imei)){
            str=wifiMac+";"+btMac;
        }else {
            str=imei+";"+wifiMac+";"+btMac;
        }
        serial=getMD5(str);
        return serial;
    }

    private static String getMD5(String source) {
        if (source==null){
            return null;
        }
        String s=null;
        char hexDigits[]={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try{
            java.security.MessageDigest md=java.security.MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            byte tmp[]=md.digest();
            char str[]=new char[16*2];
            int k=0;
            for (int i=0;i<16;i++){
                byte byte0=tmp[i];
                str[k++]=hexDigits[byte0>>>4&0xf];
                str[k++]=hexDigits[byte0&0xf];
            }
            s=new String(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 获取设备的Imsi号
     *
     * @param appContext
     * @return imsi号
     */
    public static String getImsi(Context appContext) {
        if (mImsi != null || appContext == null) {
            return mImsi;
        }
        TelephonyManager telephonyManager = (TelephonyManager) appContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager != null) {
            mImsi = telephonyManager.getSubscriberId();
        }
        return mImsi;
    }

    /**
     * 获取屏幕宽度的像素数
     *
     * @return int 屏幕宽度（像素数）
     */
    public static int getScreenWidthPixels(Context context) {
        if (mScreenWidthPixels > 0 || context == null) {
            return mScreenWidthPixels;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        // getSize方法是API 13 引入的
        if (android.os.Build.VERSION.SDK_INT >= 13) {
            Point p = new Point();
            windowManager.getDefaultDisplay().getSize(p);
            mScreenWidthPixels = p.x;
            mScreenHeightPixels = p.y;
        } else {
            mScreenWidthPixels = windowManager.getDefaultDisplay().getWidth();
            mScreenHeightPixels = windowManager.getDefaultDisplay().getHeight();
        }
        return mScreenWidthPixels;
    }

    /**
     * 获取屏幕高度的像素数
     *
     * @return int 屏幕高度（像素数）
     */
    public static int getScreenHeightPixels(Context context) {
        if (mScreenHeightPixels > 0 || context == null) {
            return mScreenHeightPixels;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= 13) {
            Point p = new Point();
            windowManager.getDefaultDisplay().getSize(p);
            mScreenWidthPixels = p.x;
            mScreenHeightPixels = p.y;
        } else {
            mScreenWidthPixels = windowManager.getDefaultDisplay().getWidth();
            mScreenHeightPixels = windowManager.getDefaultDisplay().getHeight();
        }
        return mScreenHeightPixels;
    }

    /**
     * 获取屏幕宽度的物理尺寸
     *
     * @return int 屏幕宽度
     */
    public static float getScreenWidthInches(Activity activity) {
        if (mScreenWidthInches > 0 || activity == null) {
            return mScreenWidthInches;
        }
        DisplayMetrics m = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(m);
        mScreenWidthInches = m.widthPixels / m.xdpi;
        return mScreenWidthInches;
    }

    /**
     * 获取屏幕高度的物理尺寸
     *
     * @return int 屏幕高度
     */
    public static float getScreenHeightInches(Activity activity) {
        if (mScreenHeightInches > 0 || activity == null) {
            return mScreenHeightInches;
        }
        DisplayMetrics m = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(m);
        mScreenHeightInches = m.heightPixels / m.ydpi;
        return mScreenHeightInches;
    }

    /**
     * 提示
     *
     * @param tip
     */
    public static void showToast(final String tip, final Activity context) {
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, tip, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     *
     * @param pxValue
     * @param scale
     *            （DisplayMetrics类中属性density）
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param dipValue
     * @param scale
     *            （DisplayMetrics类中属性density）
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @param fontScale
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @param fontScale
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 获取当前的版本号
     *
     * @param context
     * @return
     */
    public static String getVersionName(final Context context) {
        if (null == context)
            return null;

        PackageManager manager = context.getPackageManager();
        if (null == manager)
            return null;

        try {
            PackageInfo packInfo = manager.getPackageInfo(context.getPackageName(), 0);
            if (null != packInfo)
                return packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取软件版本号
     *
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) {
        int versionCode = 0;
        try {
            // 获取软件版本号，对应AndroidManifest.xml下android:versionCode
            versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }


    /**
     * 获取渠道号，参数在manifest.xml中的  <meta-data android:value="HF_DAHON_01" android:name="app_channel"></meta-data>
     *
     * @param context
     * @return
     */
    public static String getChannelValue(final Context context) {
        ApplicationInfo appInfo;
        String channel = "MADAO";
        try {
            appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            String temp = appInfo.metaData.getString("app_channel");
            if (!TextUtils.isEmpty(temp))
                channel = temp;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return channel;
    }
}
