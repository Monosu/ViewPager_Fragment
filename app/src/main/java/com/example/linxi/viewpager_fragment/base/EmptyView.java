package com.example.linxi.viewpager_fragment.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.linxi.viewpager_fragment.R;

/**
 * Created by linxi on 2017/3/30.
 */
public class EmptyView extends LinearLayout {

	public enum EmptyType{
		FRIEND_DETAIL,
		MY_DETAIL,
		NORMAL,
		OTHER
	}

	private LinearLayout mTitleLayout;
	private TextView mMessage;
	private TextView mTitle;
	private ImageView mImageView;

	public EmptyView(Context context) {
		super(context);
		init(context);
	}

	public EmptyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}


	private void init(Context context) {
		View view= LayoutInflater.from(context).inflate(R.layout.empty_view,null);
		mTitleLayout= (LinearLayout) view.findViewById(R.id.exception_title_layout);
		this.mTitle= (TextView) view.findViewById(R.id.exception_title);
		this.mImageView= (ImageView) view.findViewById(R.id.exception_progressbar);
		this.mMessage= (TextView) view.findViewById(R.id.exception_message);
		addView(view);
	}
	public void setOnClickListener(OnClickListener listener){
		if (listener!=null&&mTitleLayout!=null){
			mTitleLayout.setOnClickListener(listener);
		}
	}

	public void setEmptyViewType(EmptyType type){
		switch (type){
			case FRIEND_DETAIL:
				if (mImageView!=null){
					mImageView.setVisibility(View.GONE);
				}
				if (mTitleLayout!=null){
					mTitleLayout.setVisibility(View.GONE);
				}
				break;
			case MY_DETAIL:
				if (mImageView!=null){
					mImageView.setVisibility(View.GONE);
				}
				if (mTitleLayout!=null){
					mTitleLayout.setVisibility(View.VISIBLE);
				}
				break;
			case NORMAL:
				if (mTitleLayout!=null){
					mTitleLayout.setVisibility(View.GONE);
				}
				if (mImageView!=null){
					mImageView.setVisibility(View.VISIBLE);
				}
					break;
			case OTHER:
				if (mTitleLayout!=null){
					mTitleLayout.setVisibility(View.GONE);
				}
				if (mImageView!=null){
					mImageView.setVisibility(View.GONE);
				}
		}
	}

	public void setTitle(String title){
		if (mTitle!=null){
			mTitle.setText(title);
		}
	}

	public void setMessage(String message){
		if (mTitle!=null){
			mMessage.setText(message);
		}
	}

	public TextView getTVMessage() {
		return mMessage;
	}

	public TextView getTVTitle() {
		return mTitle;
	}
}
