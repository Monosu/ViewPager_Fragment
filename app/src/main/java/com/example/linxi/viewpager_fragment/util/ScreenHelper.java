package com.example.linxi.viewpager_fragment.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;

/**
 * Created by linxi on 2017/4/18.
 */

public class ScreenHelper {
    private static ScreenHelper mInstance;

    private static int mScreenWidth;
    private static int mScreenHeight;
    private static float mDensity;

    // 屏幕缩放比率
    private static float mScale = 1;

    private ScreenHelper(Activity context) {
        Display display = context.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);

        mDensity = displayMetrics.density;
        mScreenWidth = displayMetrics.widthPixels;
        mScreenHeight = displayMetrics.heightPixels;

        // 屏幕缩放比率
        mScale = 720 / (float)mScreenWidth;
    }

    public static ScreenHelper createInstance(Activity context) {
        if (mInstance == null) {
            mInstance = new ScreenHelper(context);
        }
        return mInstance;
    }

    public static ScreenHelper getInstance() {
        return mInstance;
    }

    public static int getScreenWidth() {
        return mScreenWidth;
    }

    public static int getScreenHeight() {
        return mScreenHeight;
    }

    public static float getScreenDensity() {
        return mDensity;
    }

    public static float getScale() {
        return mScale;
    }

    /**
     * 截屏(不带状态栏)
     * @param activity
     * @return
     */
    public static Bitmap takeScreenShot(Activity activity, int ignorHeight) {
        // View是你需要截图的View
        View view = activity.getWindow().getDecorView();
        view.destroyDrawingCache();

        view.setDrawingCacheEnabled(true);
//        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache(true);
        // 获取状态栏高度
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        System.out.println(statusBarHeight);
        // 去掉标题栏
        int minH = Math.min(b1.getHeight(), mScreenHeight);
        int h = minH  - statusBarHeight-ignorHeight;
        h = h<statusBarHeight ? statusBarHeight:h;
        try {
            Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, mScreenWidth, h);
            return b;
        } catch(Exception e) {
            e.printStackTrace();
            return b1;
        }

    }

    public static Bitmap takeViewShot(View view) {
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = view.getDrawingCache(true);

        return bitmap;
    }

    /**
     * dp转px
     * @param dp
     * @return
     */
    public int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, LeqiApplication.applicationContext
                .getResources().getDisplayMetrics());
    }

    public static int dp2px(Context context, float dipValue) {
        if(null == context)
            return 0;
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}