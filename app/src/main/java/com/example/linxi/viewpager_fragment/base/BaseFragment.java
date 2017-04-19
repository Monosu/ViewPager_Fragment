package com.example.linxi.viewpager_fragment.base;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.linxi.viewpager_fragment.R;
import com.example.linxi.viewpager_fragment.customs.CustomDialog;

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
               CustomDialog mDialog=new CustomDialog(getActivity());
                mDialog.setContent(tip);
                mDialog.setContentColor(getActivity().getResources().getColor(R.color.color_gray));
                mDialog.setInputEnable(false);
                mDialog.setCancelInvisible();
                mDialog.show();
            }
        });
    }

    private void registerEventBus() {
        EventBus.getDefault().register(this);
    }
    private void unregisterEventBus() {
        // 注册监听骑行状态变化
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(Object event) {
        // TODO
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    protected View setContentViewPersistent(LayoutInflater inflater,int layoutId){
        if (mPersistentContentView==null){
            mPersistentContentView=inflater.inflate(layoutId,null);
        }
        return mPersistentContentView;
    }

    protected View getPersistentContentView() {
        if (mPersistentContentView == null) {
            //Logs.e(TAG, "getPersistentContentView | persistent content view is null!");
        }
        return mPersistentContentView;
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
        mPersistentContentView = null;
        unregisterEventBus();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public boolean onBackPressed() {
        return false;
    }

    Toast toast;
    protected void showToast(final String tip) {

        if (TextUtils.isEmpty(tip))
            return;

        showToast(tip, Gravity.CENTER);
    }
    protected void showToast(final String tip, final int gravity) {
        if (getActivity() == null || TextUtils.isEmpty(tip)) {
            //Logs.e(TAG, "get activity failed.");
            return;
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (null != toast) {
                    toast.cancel();
                }
                toast = Toast.makeText(getActivity(), tip, Toast.LENGTH_SHORT);
                toast.setGravity(gravity, 0, 0);
                toast.show();
            }
        });
    }

    public void notifyGlobalError(int code, String reason) {
       // Logs.e(TAG, "notifyGlobalError | " + code);
        EventBus.getDefault().post(new EventGlobalError(code, reason));
    }



    public Fragment getRootFragment() {
        Fragment fragment = getParentFragment();

        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment;
    }
}
