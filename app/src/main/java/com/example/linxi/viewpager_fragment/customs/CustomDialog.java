package com.example.linxi.viewpager_fragment.customs;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.linxi.viewpager_fragment.R;


/**
 * Created by linxi on 2017/4/17.
 */

public class CustomDialog extends Dialog {
    private View mView;
    private TextView mTvTitle;
    private TextView mTvConfirm;
    private TextView mTvCancel;
    private TextView mContentPrefix;
    private EditText mContentInput;
    private View mDividerView;
    private View mEmptyView;
    private Context mContext;

    private View.OnClickListener mConfirmListener;
    private View.OnClickListener mCancelListener;

    public CustomDialog(Context context) {
        super(context, R.style.CustomDialog);
        initView(context);
    }



    public CustomDialog(Context context, int themeResId) {
        super(context, R.style.CustomDialog);
        initView(context);
    }

    public CustomDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, R.style.CustomDialog);
        this.setCancelable(cancelable);
        this.setOnCancelListener(cancelListener);
        initView(context);
    }
    private void initView(Context context) {
        mContext=context;

        //mView= LayoutInflater.from(getContext()).inflate(R.layout.)
    }
}
