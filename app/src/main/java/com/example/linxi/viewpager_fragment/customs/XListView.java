package com.example.linxi.viewpager_fragment.customs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Scroller;

/**
 * Created by linxi on 2017/4/20.
 */

public class XListView extends ListView implements AbsListView.OnScrollListener{
    /**
     * 上次更新的字符串常量，用于作为sharepre的键值
     *
     */
    private static final String UPDATED_AT="updated_at";
    private long lastUpdateTime;//毫秒
    private int mId = -1;//为了防止不同界面的下拉刷新在上次更新时间上互相有冲突，使用id来做区分
    /**
     * 一分钟的毫秒值，用于判断上次的更新时间
     */
    public static final long ONE_MINUTE = 60 * 1000;
    /**
     * 一小时的毫秒值，用于判断上次的更新时间
     */
    public static final long ONE_HOUR = 60 * ONE_MINUTE;

    /**
     * 一天的毫秒值，用于判断上次的更新时间
     */
    public static final long ONE_DAY = 24 * ONE_HOUR;

    /**
     * 一月的毫秒值，用于判断上次的更新时间
     */
    public static final long ONE_MONTH = 30 * ONE_DAY;

    /**
     * 一年的毫秒值，用于判断上次的更新时间
     */
    public static final long ONE_YEAR = 12 * ONE_MONTH;

    private float mLastY=-1;
    private Scroller mScroller;
    private OnScrollListener mScrollerListener;

    public XListView(Context context) {
        super(context);
    }

    public XListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //private

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
