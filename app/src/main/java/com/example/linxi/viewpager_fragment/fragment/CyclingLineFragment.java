package com.example.linxi.viewpager_fragment.fragment;

import android.view.View;

import com.example.linxi.viewpager_fragment.base.BaseFragment;
import com.example.linxi.viewpager_fragment.customs.CustomXListView;
import com.example.linxi.viewpager_fragment.datahelper.IDataHelper;

/**
 * Created by linxi on 2017/4/13.
 */

public class CyclingLineFragment extends BaseFragment{
    private static final String TAG = CyclingLineFragment.class.getSimpleName();
    public static final String PARAMS_CATEGORY ="RankingFragment.category" ;
    private IDataHelper mDataHelper;
    private int category;
    private int pageSize=20;
    private long sinceId=0;
    private View mContentView;

    private CustomXListView mRankingList;

}
