package com.example.linxi.viewpager_fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import java.lang.reflect.Field;

/**
 * Created by linxi on 2017/3/1.
 */

public class Fragment1 extends android.support.v4.app.Fragment {
    private PagerSlidingTabStrip tabs;
    private DisplayMetrics dm;

    private oneFragment oneFragment;
    private twoFragment twoFragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1,null);
        setOverflowShowingAlways();
        dm=getResources().getDisplayMetrics();
        ViewPager viewPager= (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(0);//设置viewpager的缓存界面数，默认缓存2
        tabs= (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        viewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));
        tabs.setViewPager(viewPager);
        setTabValue();
        return view;
    }
    private void setTabValue(){
        // 设置Tab是自动填充满屏幕的
        tabs.setShouldExpand(true);
        // 设置Tab的分割线是透明的
        tabs.setDividerColor(android.R.color.transparent);
        // 设置Tab底部线的高度
        tabs.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,1,dm));
        // 设置Tab Indicator的高度
        tabs.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,3,dm));
        // 设置Tab标题文字的大小
        tabs.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,16,dm));
        // 设置Tab Indicator的颜色
        tabs.setIndicatorColor(Color.parseColor("#d83737"));//#d83737   #d83737(绿)
        // 设置选中Tab文字的颜色 (这是我自定义的一个方法)
        //tabs.setSelectedTextColor(Color.parseColor("#ffffff"));
        // 取消点击Tab时的背景色
        tabs.setTabBackground(0);


    }

    public class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        private final String[] titles = { "TAB1", "TAB2"};

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position){
                case 0:
                    if (oneFragment==null){
                        oneFragment=new oneFragment();
                    }return oneFragment;
                case 1:
                    if(twoFragment==null){
                        twoFragment=new twoFragment();

                    }return twoFragment;
                default:
                    return null;

            }

        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }


     private void setOverflowShowingAlways() {
               try {
                   ViewConfiguration config = ViewConfiguration.get(getParentFragment().getActivity());
                     Field menuKeyField = ViewConfiguration.class
                             .getDeclaredField("sHasPermanentMenuKey");
                      menuKeyField.setAccessible(true);
                     menuKeyField.setBoolean(config, false);
                 } catch (Exception e) {
                      e.printStackTrace();
                    }
           }




}
