package com.example.administrator.customviewdemo.CustomView.ScrollConflit;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by jiasheng on 2016/12/7.
 * email 898478073@qq.com
 * Description: CustomViewDemo
 */


public class MyScrollView extends ScrollView {


    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // 内部拦截法：内部拦截法是指点击事件先经过子View处理，
// 如果子View需要此事件就直接消耗掉，否则就交给父容器进行处理，
// 这样就可以解决滑动冲突的问题。
// 内部拦截法需要配合requestDisallowInterceptTouchEvent()方法，
// 来确定子View是否允许父布局拦截事件。
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                int scrollY = getScrollY();
                if (scrollY == 0) {
//                    允许父View进行事件拦截
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
//                  禁止父View进行事件拦截
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
        }
        Log.e("showme",getScrollY()+" "+getTop());
        return super.onTouchEvent(ev);
    }
}
