package com.example.linxi.viewpager_fragment.base;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;


import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.linxi.viewpager_fragment.adapter.MenuAdapter;
import com.example.linxi.viewpager_fragment.metadata.MenuItem;

/**
 * Created by linxi on 2017/3/31.
 */

public abstract class BaseMenu {
    private final String TAG="CustomMenu";
    private Context mContext;

    private PopupWindow mPopupWindow;
    private ListView mListView;
    private MenuAdapter mContentAdapter;
    private IMenuItemSelectedListener mListener;
    private View mMenuView;

    public abstract View onCreateView(Context context);
    public abstract ListView findListView(View view);
    public abstract MenuAdapter onCreateAdapter(Context context);

    public BaseMenu(Context mContext) {
        this.mContext = mContext;
    }

    public void initView(){

        mMenuView=onCreateView(mContext);
        mContentAdapter=onCreateAdapter(mContext);
        mListView=findListView(mMenuView);

        mMenuView.setFocusableInTouchMode(true);

        mListView.setAdapter(mContentAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               MenuItem item = (MenuItem) mContentAdapter.getItem(position);
                if (mListener!=null){

                    //mListener.onMenuSelected(mMenuView,item,position);
                }
                mPopupWindow.dismiss();
            }
        });

        mPopupWindow=new PopupWindow(mMenuView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
    }

    public void addItem(int resId,String text,int id){
        mContentAdapter.addItem(resId,text,id);
        mContentAdapter.notifyDataSetChanged();
    }

    public void  clear(){
        mContentAdapter.clear();
        mContentAdapter.notifyDataSetChanged();
    }

    public void show(View parent){
        mPopupWindow.showAsDropDown(parent);
    }
    public void dismiss(){
        mPopupWindow.dismiss();
    }
    public void  setOnItemSelectedListener(IMenuItemSelectedListener listener){
        mListener=listener;
    }

}
