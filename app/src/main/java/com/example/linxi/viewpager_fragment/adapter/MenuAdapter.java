package com.example.linxi.viewpager_fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.linxi.viewpager_fragment.R;
import com.example.linxi.viewpager_fragment.metadata.MenuItem;
import com.example.linxi.viewpager_fragment.util.DeviceUtil;

import java.util.ArrayList;

/**
<<<<<<< Updated upstream
 * Created by linxi on 2017/3/31.
 */

public class MenuAdapter extends BaseAdapter {
    protected ArrayList<MenuItem> mList = new ArrayList<MenuItem>();
    protected Context mContext;
    protected LayoutInflater mInflater;

    public MenuAdapter(Context mContext) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (mList != null) {
            ret = mList.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        MenuItem item = null;
        if (mList != null && mList.size() > position) {
            item = mList.get(position);
        }
        return item;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=mInflater.inflate(R.layout.menu_item,null);
        TextView tv= (TextView) convertView.findViewById(R.id.tv_menu_content);
        ImageView icon= (ImageView) convertView.findViewById(R.id.img_menu_icon);

        int w_111= DeviceUtil.dip2px(mContext,104);
        int h=DeviceUtil.dip2px(mContext,40);

        if (position==0){
            convertView.setBackgroundResource(R.drawable.new_menu_item_bg_top);
            h=DeviceUtil.dip2px(mContext,48);
        }else if (position==getCount()-1){
            convertView.setBackgroundResource(R.drawable.new_menu_item_bg_bottom);
            h=DeviceUtil.dip2px(mContext,46);
        }else {
            convertView.setBackgroundResource(R.drawable.new_menu_item_bg_mid);
        }

        AbsListView.LayoutParams p=new AbsListView.LayoutParams(w_111,h);
        convertView.setLayoutParams(p);

        MenuItem item=mList.get(position);

        if (item!=null){
            tv.setText(item.getmContentText());
            if (item.getmIconRes()<=0){
                //不显示
                icon.setVisibility(View.GONE);
            }else {
                icon.setImageResource(item.getmId());
            }
        }
            return convertView;
    }

    public void  addItem(String content,int resId,int id ){
        mList.add(new MenuItem(content,resId,id));
    }
    public void  clear(){
        mList.clear();
    }
}
