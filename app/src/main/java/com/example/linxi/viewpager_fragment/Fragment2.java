package com.example.linxi.viewpager_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by linxi on 2017/3/1.
 */

public class Fragment2 extends android.support.v4.app.Fragment implements View.OnClickListener{
    private PopupWindow popupWindow;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment2,container,false);

        button= (Button) view.findViewById(R.id.pop_window);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pop_window:
                //Toast.makeText(getContext(),"点击了",Toast.LENGTH_SHORT).show();
                showPopWindow();
                break;
            case R.id.tv1:
                Toast.makeText(getContext(),"点击了tv1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv2:
                Toast.makeText(getContext(),"点击了tv2",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }
    private void showPopWindow(){
        View contentView=LayoutInflater.from(getContext()).inflate(R.layout.pop_window,null);

        TextView tv1= (TextView) contentView.findViewById(R.id.tv1);
        TextView tv2= (TextView) contentView.findViewById(R.id.tv2);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);

        int loc[]=new int[2];
        button.getLocationOnScreen(loc);
        popupWindow=new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
       // popupWindow.setContentView(contentView);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.showAtLocation(button, Gravity.NO_GRAVITY,loc[0]-30,loc[1]-popupWindow.getHeight());
        //popupWindow.showAsDropDown(button);
    }

}
