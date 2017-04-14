package com.example.linxi.viewpager_fragment.base;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.greenrobot.event.EventBus;

/**
 * Created by linxi on 2017/4/13.
 */

public class BaseFragment extends Fragment {
    protected final String TAG=getClass().getSimpleName();

    private View mPersistentContentView;
    //等待对话框
    private ProgressDialog mProgressDialog;

    public BaseFragment() {
        super();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerEventBus();

        mProgressDialog=new ProgressDialog(getActivity());
        mProgressDialog.setMessage("正在加载。。。");

    }
    public void showProgressDialog(String message){
        try {
            mProgressDialog.setMessage(message);
            if (mProgressDialog!=null&&!mProgressDialog.isShowing()){
                mProgressDialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showProgressDialog() {
        try {
            if (mProgressDialog != null && !mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }
        } catch (Exception e) {

        }
    }
    public void dismissProgressDialog() {
        try {
            if (mProgressDialog != null && mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void showTipDialog(final String tip){
        if (TextUtils.isEmpty(tip)){
            return;
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Dialog mDialog=new Dialog(getActivity());
                //mDialog.sett

            }
        });
    }

    private void registerEventBus() {
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
