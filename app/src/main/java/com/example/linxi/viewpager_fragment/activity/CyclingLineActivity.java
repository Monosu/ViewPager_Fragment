package com.example.linxi.viewpager_fragment.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.linxi.viewpager_fragment.R;
import com.example.linxi.viewpager_fragment.base.BaseFragmentPagerAdapter;
import com.example.linxi.viewpager_fragment.base.CustomerViewPager;
import com.example.linxi.viewpager_fragment.base.PagerSlidingTabStrip;
import com.example.linxi.viewpager_fragment.customs.CustomMenu;

import static com.example.linxi.viewpager_fragment.R.styleable.PagerSlidingTabStrip;

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
    private CustomMenu mMenu;
    private TextView mTxtShareMenu;
    private ProgressDialog mProgressDialog;

    private static final int REQUEST_SELECT_ROUTE=0X0011;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        //setContentView();
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
