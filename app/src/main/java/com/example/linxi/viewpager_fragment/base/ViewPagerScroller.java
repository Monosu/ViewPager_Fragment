package com.example.linxi.viewpager_fragment.base;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * Created by linxi on 2017/3/30.
 */

public class ViewPagerScroller extends Scroller {

    private int mScrollerDuration=600;//滑动速度
    public ViewPagerScroller(Context context) {
        super(context);
    }

    public ViewPagerScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        super.startScroll(startX, startY, dx, dy,mScrollerDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        this.mScrollerDuration=duration;
        super.startScroll(startX, startY, dx, dy, mScrollerDuration);
    }
}
