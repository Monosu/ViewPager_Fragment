package com.example.linxi.viewpager_fragment.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by linxi on 2017/3/30.
 */

public class BaseFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private final String TAG=BaseFragmentPagerAdapter.class.getSimpleName();

    private ArrayList<Fragment>mFragments=new ArrayList<Fragment>();
    private ArrayList<String>mTitle=new ArrayList<String>();

    public BaseFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment,String title){
        if (fragment==null){
            return;
        }
        mFragments=mFragments==null?new ArrayList<Fragment>():mFragments;
        mFragments.add(fragment);

        mTitle=mTitle==null?new ArrayList<String>():mTitle;
        mTitle.add(title);
    }

    public ArrayList<Fragment>getChildFragments(){
        return mFragments;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment ret=null;
        if (mFragments!=null&&mFragments.size()>position){
            ret=mFragments.get(position);
        }
        return ret;
    }

    @Override
    public int getCount() {
        int ret=0;
        if (mFragments!=null){
            ret=mFragments.size();
        }
        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
