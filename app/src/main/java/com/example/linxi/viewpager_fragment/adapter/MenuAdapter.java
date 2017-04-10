package com.example.linxi.viewpager_fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by linxi on 2017/3/31.
 */

public class MenuAdapter extends BaseAdapter {
	protected ArrayList<MenuItem> mList=new ArrayList<MenuItem>();
	protected Context mContext;
	protected LayoutInflater mInflater;

	public MenuAdapter(Context mContext) {
		this.mContext = mContext;
		mInflater=LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		int ret=0;
		if (mList!=null){
			ret=mList.size();
		}
		return ret;
	}

	@Override
	public Object getItem(int position) {
		MenuItem item=null;
		if (mList!=null&&mList.size()>position){
			item=mList.get(position);
		}
		return item;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//convertView=mInflater.inflate()
		return null;
	}
}
