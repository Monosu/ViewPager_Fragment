package com.example.linxi.viewpager_fragment.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.Toast;

import de.greenrobot.event.EventBus;

/**
 * 基类
 * Created by linxi on 2017/3/30.
 */

public class BaseActivity extends Activity {
	public final String TAG=getClass().getSimpleName();

	//等待对话框
	protected ProgressDialog progressDialog;

	public static final String INTENT_DATA="intent_data";

	private Handler mHandler=null;

	private EmptyView emptyView=null;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		mHandler=new Handler(getMainLooper()){};

		ActivityHolder.getInstance().putActivity(this);

		//EventBus.getDefault().register(this);
		registerEventBus();

		progressDialog=new ProgressDialog(this);
		progressDialog.setMessage("正在加载中...");
		progressDialog.setCancelable(false);
		initView();
	}

	private void initView() {
		emptyView=new EmptyView(getActivity());
		emptyView.setEmptyViewType(EmptyView.EmptyType.OTHER);
		emptyView.setMessage("正在加载中...");
	}
	public EmptyView getEmptyView(){
		if (emptyView==null)
			initView();
		return emptyView;
	}

	private void registerEventBus(){
		EventBus.getDefault().register(this);
	}

	private void unregisterEventBus(){
		EventBus.getDefault().unregister(this);
	}

	public void showProgressDialog(String message){
		try {
			progressDialog.setMessage(message);
			if (progressDialog!=null&&progressDialog.isShowing()){
                progressDialog.show();
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showProgressDialog(){
		try {
			if (progressDialog!=null&&progressDialog.isShowing()){
                progressDialog.show();
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void dismissProgressDialog() {
		try {
			if (progressDialog != null && progressDialog.isShowing()) {
				progressDialog.dismiss();
			}
		} catch (Exception e) {

		}

	}
	public void setProgressDialogCancelable(boolean flag) {
		try {
			progressDialog.setCancelable(flag);
		} catch (Exception e) {

		}

	}

	protected void showTipDialog(final String tip) {
		if (TextUtils.isEmpty(tip)) {
			return;
		}

	}

	Toast toast;

	protected void showToast(final String tip){
		showToast(tip, Gravity.CENTER);
	}

	private void showToast(final String tip, final int center) {
		onRunonUiThread(new Runnable(){

			@Override
			public void run() {
				if (null!=toast){
					toast.cancel();
				}
				toast=Toast.makeText(BaseActivity.this,tip,Toast.LENGTH_LONG);
				toast.setGravity(center,0,0);
				toast.show();
			}
		});
	}

	private void onRunonUiThread(Runnable runnable) {
		if (null==runnable)
			return;
		mHandler.post(runnable);
	}

	public void notifyGlobalError(int code,String reason){
		Log.e(TAG,"notifyGlobalError | "+code);
	}

	private Context getActivity() {
		return BaseActivity.this;
	}


	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterEventBus();
		ActivityHolder.getInstance().dropActivity(this);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		return super.dispatchTouchEvent(ev);
	}
}
