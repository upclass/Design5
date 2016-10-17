package com.jash.design5;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

@CoordinatorLayout.DefaultBehavior(MyFAButton.Behavior.class)
public class MyFAButton extends FloatingActionButton {
    public MyFAButton(Context context) {
        super(context);
    }

    public MyFAButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFAButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public static class Behavior extends FloatingActionButton.Behavior {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
            CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) directTargetChild.getLayoutParams();
            CoordinatorLayout.Behavior behavior = params.getBehavior();
            return behavior instanceof AppBarLayout.ScrollingViewBehavior;
        }

        @Override
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
            super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
            if (dyConsumed > 0) {
                child.hide();
            } else {
                child.show();
            }
        }
    }
}
