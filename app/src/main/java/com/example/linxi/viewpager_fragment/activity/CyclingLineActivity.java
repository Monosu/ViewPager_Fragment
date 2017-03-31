package com.example.linxi.viewpager_fragment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.example.linxi.viewpager_fragment.base.BaseFragmentPagerAdapter;
import com.example.linxi.viewpager_fragment.base.CustomerViewPager;

/**
 * Created by linxi on 2017/3/30.
 */

public class CyclingLineActivity extends FragmentActivity {

    private static final String TAG=CyclingLineActivity.class.getSimpleName();
    public static final String PARAMS_RANKING_TYPE="CyclingLineActivity.route.type";
    private CustomerViewPager mRankingPager;
    private PagerSlidingTabStrip mPagerTab;
    private BaseFragmentPagerAdapter mPagerAdapter;

    private LinearLayout mBtnBack;
    private TextView mTextTitle;
    private LinearLayout mBtnMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
