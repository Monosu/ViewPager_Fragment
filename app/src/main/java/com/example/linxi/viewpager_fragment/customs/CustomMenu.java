package com.example.linxi.viewpager_fragment.customs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.linxi.viewpager_fragment.R;
import com.example.linxi.viewpager_fragment.adapter.MenuAdapter;
import com.example.linxi.viewpager_fragment.base.BaseMenu;

/**
 * Created by linxi on 2017/4/12.
 */

public class CustomMenu extends BaseMenu {
    public CustomMenu(Context mContext) {
        super(mContext);
    }

    @Override
    public View onCreateView(Context context) {
        View view= LayoutInflater.from(context).inflate(R.layout.menu_view,null);
        return view;
    }

    @Override
    public ListView findListView(View view) {
        ListView listView= (ListView) view.findViewById(R.id.lv_menu);
        return listView;
    }

    @Override
    public MenuAdapter onCreateAdapter(Context context) {
        MenuAdapter adapter=new MenuAdapter(context);
        return adapter;
    }
}
