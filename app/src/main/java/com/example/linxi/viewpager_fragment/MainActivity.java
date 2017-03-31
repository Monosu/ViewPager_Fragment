package com.example.linxi.viewpager_fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private LinearLayout ll1;
    private LinearLayout ll2;
    private ImageView iv1;
    private ImageView iv2;
    private FrameLayout f1;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        inits();
        fragmentManager=getSupportFragmentManager();
        setTab(0);

    }
    private void inits(){
        ll1= (LinearLayout) findViewById(R.id.ll1);
        ll2= (LinearLayout) findViewById(R.id.ll2);
        iv1= (ImageView) findViewById(R.id.iv1);
        iv2= (ImageView) findViewById(R.id.iv2);
        f1= (FrameLayout) findViewById(R.id.fl);
        ll1.setOnClickListener(this);
        ll2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll1:
                setTab(0);
                break;
            case R.id.ll2:
                setTab(1);
                break;
            default:
                break;
        }

    }
    private void setTab(int t){
        resetbtn();
       FragmentTransaction transaction=fragmentManager.beginTransaction();
        hide(transaction);
        switch (t){
            case 0:
                iv1.setImageResource(R.drawable.news_selected);
                if (fragment1==null){
                    fragment1=new Fragment1();
                    transaction.add(R.id.fl,fragment1);
                }else {
                    transaction.show(fragment1);
                }
                break;
            case 1:
                iv2.setImageResource(R.drawable.setting_selected);
                if (fragment2==null){
                    fragment2=new Fragment2();
                    transaction.add(R.id.fl,fragment2);
                }else {
                    transaction.show(fragment2);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }
    private void resetbtn(){
        iv1.setImageResource(R.drawable.news_unselected);
        iv2.setImageResource(R.drawable.setting_unselected);
    }
    private void hide(FragmentTransaction transaction){
        if (fragment1!=null){
            transaction.hide(fragment1);
        }
        if (fragment2!=null){
            transaction.hide(fragment2);
        }
    }
}
