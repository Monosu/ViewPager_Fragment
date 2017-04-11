package com.example.linxi.viewpager_fragment.base;

import android.support.v7.view.menu.MenuItemImpl;
import android.view.View;

/**
 * Created by linxi on 2017/4/11.
 */

public interface IMenuItemSelectedListener {
    public void onMenuSelected(View view, MenuItemImpl item, int position);
}
