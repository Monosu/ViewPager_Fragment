package com.example.linxi.viewpager_fragment.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by linxi on 2017/3/30.
 */

public class BaseFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private final String TAG=BaseFragmentPagerAdapter.class.getSimpleName();


    public BaseFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
