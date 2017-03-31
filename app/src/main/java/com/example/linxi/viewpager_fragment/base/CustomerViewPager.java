package com.example.linxi.viewpager_fragment.base;

import android.content.Context;
import android.icu.text.NumberFormat;
import android.support.v4.view.ViewPager;
import android.text.method.HideReturnsTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;

import java.lang.reflect.Field;

/**
 * Created by linxi on 2017/3/30.
 */

public class CustomerViewPager extends ViewPager {
    private static final String TAG=CustomerViewPager.class.getSimpleName();
    private boolean b=true;
    private ViewPager viewPager;

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public CustomerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViewPagerScroll();
    }

    private void initViewPagerScroll() {
        Field mScroller=null;
        try {
            mScroller=ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            ViewPagerScroller scroller=new ViewPagerScroller(this.getContext());
            mScroller.set(this,scroller);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
    //???
    public boolean onInterceptTouchEvent(MotionEvent event){
        try {
            if (event.getAction()==MotionEvent.ACTION_UP){
                if (viewPager!=null){
                    viewPager.requestDisallowInterceptTouchEvent(false);
                }
            }else {
                if (viewPager!=null){
                    viewPager.requestDisallowInterceptTouchEvent(true);
                }
            }
            if (this.b){
                return super.onInterceptTouchEvent(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent){
        if (this.b){
            return super.onTouchEvent(paramMotionEvent);
        }
        return false;
    }
    public void setCanTouchScroll(boolean paramBoolean) {
        this.b = paramBoolean;
    }

    public boolean getCanTouchScroll() {
        return b;
    }

}
