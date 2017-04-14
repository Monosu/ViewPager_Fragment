package com.example.linxi.viewpager_fragment.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.linxi.viewpager_fragment.R;
import com.example.linxi.viewpager_fragment.base.BaseFragmentPagerAdapter;
import com.example.linxi.viewpager_fragment.base.CustomerViewPager;
import com.example.linxi.viewpager_fragment.base.IMenuItemSelectedListener;
import com.example.linxi.viewpager_fragment.base.PagerSlidingTabStrip;
import com.example.linxi.viewpager_fragment.customs.CustomMenu;
import com.example.linxi.viewpager_fragment.fragment.CyclingLineFragment;

import static com.example.linxi.viewpager_fragment.R.styleable.PagerSlidingTabStrip;

/**
 * Created by linxi on 2017/3/30.
 */

public class CyclingLineActivity extends FragmentActivity implements View.OnClickListener {

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
        setContentView(R.layout.activity_ranking);
        //初始化对话框
        mProgressDialog=new ProgressDialog(this);
        mProgressDialog.setMessage("正在加载。。。");
        initView();
        initPagerView();
    }



    private void initView() {
        mRankingPager= (CustomerViewPager) findViewById(R.id.ranking_Pager);
        mPagerTab= (com.example.linxi.viewpager_fragment.base.PagerSlidingTabStrip) findViewById(R.id.tab_strip);

        mTextTitle= (TextView) findViewById(R.id.secondary_page_title_text);
        mBtnBack= (LinearLayout) findViewById(R.id.secondary_page_title_back);
        mBtnMenu= (LinearLayout) findViewById(R.id.secondary_page_title_btn_menu);
        mTxtShareMenu= (TextView) findViewById(R.id.secondary_page_title_btn_right);

        mBtnMenu.setVisibility(View.VISIBLE);

        mBtnMenu.setOnClickListener(this);
        mBtnBack.setOnClickListener(this);
        mTxtShareMenu.setText("分享");
        mTxtShareMenu.setOnClickListener(this);

        mTextTitle.setText("路书");
        mMenu=new CustomMenu(this);

        mMenu.addItem(-1,"发布路书",1);
        mMenu.addItem(-1,"查询路书",2);
        mMenu.addItem(-1,"我的路书",3);

        mMenu.setOnItemSelectedListener(new IMenuItemSelectedListener() {
            @Override
            public void onMenuSelected(View view, MenuItemImpl item, int position) {
                switch (item.getItemId()){
                    case 1:
                        onSubmitRoute();
                        break;
                    case 2:
                        onSearchRoute();
                        break;
                    case 3:
                        onGotoMyCycling();
                        break;
                }
            }
        });
    }
    private void initPagerView() {
        mPagerAdapter=new BaseFragmentPagerAdapter(getSupportFragmentManager());
        Bundle args=new Bundle();
        args.putInt(CyclingLineFragment.PARAMS_CATEGORY,0);

        CyclingLineFragment dayRanking=new CyclingLineFragment();
    }
    private void onGotoMyCycling() {
        startActivity(new Intent(this,TackListActivity.class));
    }

    private void onSearchRoute() {
        startActivity(new Intent(this,CyclingLineSearchActivity.class));
    }

    private void onSubmitRoute() {
        Intent intent=new Intent(this,CyclingLineSelectActivity.class);
        intent.putExtra(CyclingLineSelectActivity.SELECT_TYPE,0);
        startActivityForResult(intent,REQUEST_SELECT_ROUTE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {

    }
}
