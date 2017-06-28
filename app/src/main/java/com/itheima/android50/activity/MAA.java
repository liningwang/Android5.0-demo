package com.itheima.android50.activity;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Administrator on 2016/11/27 0027.
 */

public class MAA extends CoordinatorLayout {

    View mSrc;
    MenuItem mTarget;
    public MAA(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return super.onStartNestedScroll(child, target, nestedScrollAxes);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        Log.d("wang", "dyConsumed" + dyConsumed + " dxConsumed " + dxConsumed
        + " dxUnconsumed " + dxUnconsumed + " dyUnconsumed " + dyUnconsumed);

    }

    //通过实现onTouchEvent就可以实现滑动的同时改变控件的大小了。
    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(target, dx, dy, consumed);
//        if(target != mSrc) {
            View v1 = mTarget.setVisible(true).getActionView();
        v1.setScaleX(1.0f - mSrc.getScaleX());
        v1.setScaleY(1.0f - mSrc.getScaleY());
//            Animator animator = ViewAnimationUtils.createCircularReveal(
//                        v1,
//                        v1.getWidth()/2,
//                        v1.getHeight()/2,
//                        0,
//                        v1.getWidth()
//                        );
//                animator.setInterpolator(new AccelerateDecelerateInterpolator());
//                animator.setDuration(100);
//                animator.start();

            Log.d("wang", "onNestedPreScroll dxConsumed " + dy + " scale x " + mSrc.getScaleX()
            + " dx is " + dx + " dy " + dy + " consumedx " + consumed[0] + " consumedy " + consumed[1]);
//        }
    }
    public void setAniView(View src,MenuItem target){
        mSrc = src;
        mTarget = target;
    }
}
