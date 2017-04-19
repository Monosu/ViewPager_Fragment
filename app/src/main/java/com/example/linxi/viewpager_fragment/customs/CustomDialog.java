package com.example.linxi.viewpager_fragment.customs;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.linxi.viewpager_fragment.R;
import com.example.linxi.viewpager_fragment.util.ScreenHelper;


/**
 * Created by linxi on 2017/4/17.
 */

public class CustomDialog extends Dialog implements View.OnClickListener {
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

        mView= LayoutInflater.from(getContext()).inflate(R.layout.dialog_with_input,null);
        super.setContentView(mView);

        mTvTitle= (TextView) findViewById(R.id.dialog_content_title);
        mEmptyView=findViewById(R.id.empty_view);
        mContentPrefix= (TextView)mView.findViewById(R.id.dialog_content_prefix);
        mContentInput= (EditText) mView.findViewById(R.id.dialog_content_input);
        mTvConfirm= (TextView) mView.findViewById(R.id.dialog_select_confirm);
        mTvCancel = (TextView) mView.findViewById(R.id.dialog_select_cancel);
        mDividerView = mView.findViewById(R.id.dialog_btn_divider);

        mTvConfirm.setOnClickListener(this);
        mTvCancel.setOnClickListener(this);
        fitWidth();
    }

    private void fitWidth() {
        Window dialogWindow = this.getWindow();
        WindowManager.LayoutParams params = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER);
        int screenWidth = ScreenHelper.getScreenWidth();
        if(screenWidth == 0) {
            WindowManager wm = (WindowManager) getContext()
                    .getSystemService(Context.WINDOW_SERVICE);

            screenWidth = wm.getDefaultDisplay().getWidth();
        }
        params.width = (int) ((float)screenWidth * 0.75f);
        dialogWindow.setAttributes(params);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dialog_select_confirm:
                if (mConfirmListener!=null){
                    mConfirmListener.onClick(v);
                }
                dismiss();
                break;
            case R.id.dialog_select_cancel:
                if (mCancelListener!=null){
                    mCancelListener.onClick(v);
                }
                dismiss();
                break;
        }

    }

    public void setDialogTitleVisible() {
        mEmptyView.setVisibility(View.GONE);
        mTvTitle.setVisibility(View.VISIBLE);
    }

    public void setDialogTitle(String text) {
        mTvTitle.setText(text);
    }

    @Override
    public void setContentView(View view){ }

    /**
     * 设置取消按钮不可见
     */
    public void setCancelInvisible(){
        mTvCancel.setVisibility(View.GONE);
        mDividerView.setVisibility(View.GONE);
    }

    public void setContentPrefix(CharSequence msg){
        mContentPrefix.setText(msg);
    }

    public void setPositiveText(String text) {
        mTvConfirm.setText(text);
    }

    public void setNegativeText(String text) {
        mTvCancel.setText(text);
    }

    /**
     * 确定按钮监听
     * @param listener
     */
    public void setOnPositiveListener(View.OnClickListener listener){
//        mTvConfirm.setOnClickListener(listener);
        mConfirmListener = listener;
    }

    /**
     * 取消按钮监听
     * @param listener
     */
    public void setOnNegativeListener(View.OnClickListener listener){
//        mTvCancel.setOnClickListener(listener);
        mCancelListener = listener;
    }

    /**
     * 输入框可见性
     * @param value
     */
    public void setInputEnable(boolean value){
        if (value){
            mContentInput.setVisibility(View.VISIBLE);
        } else {
            mContentInput.setVisibility(View.GONE);
        }
    }

    /**
     * 设置对话框内容
     * @param content
     */
    public void setContent(String content){
        mContentPrefix.setText(content);
    }

    public TextView getContentTxt() {
        return mContentPrefix;
    }

    public TextView getTitleTxt() {
        return mTvTitle;
    }
    /**
     * 设置内容文本颜色
     * @param color
     */
    public void setContentColor(int color){
        mContentPrefix.setTextColor(color);
    }

    /**
     * 获取输入内容
     * @return
     */
    public String getInput(){
        return mContentInput.getText().toString();
    }

    /**
     * 设置默认值
     * @param hint
     */
    public void setHint(String hint){
        mContentInput.setHint(hint);
    }

    /**
     * 获取输入框默认值
     * @return
     */
    public String getHint(){
        return mContentInput.getHint().toString();
    }
}
