package com.example.administrator.customviewdemo.CustomView.ScrollConflit;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by jiasheng on 2016/12/7.
 * email 898478073@qq.com
 * Description: CustomViewDemo
 */

public class ScrollConflictView extends LinearLayout{
    private int mMove;
    private int yDown, yMove;
    private int distance = 0;
    private boolean isIntercept = false;
    private ScrollView mScrollView;

    public ScrollConflictView(Context context) {
        super(context);
    }

    public ScrollConflictView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollConflictView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                yDown = y;
                break;
            case MotionEvent.ACTION_MOVE:
                if(isIntercept && (yMove - yDown)>0 && mScrollView.getScrollY() == 0){
                    yMove = y;
                    mMove = yMove - yDown;
                    distance += mMove;
                    layout(getLeft(),getTop() + mMove,getRight(),getBottom()+mMove);
                }
                break;
            case MotionEvent.ACTION_UP:
                layout(getLeft(), getTop() - distance, getRight(), getBottom() - distance);
                distance = 0;
                isIntercept = false;
                break;
        }
        Log.e("showme",isIntercept+"");
        return true;
    }


//    解决滑动冲突 外部拦截法
//    外部拦截法：外部拦截法是指点击事件先经过父容器的拦截处理，如果父容器需要处理此事件就进行拦截，
//    如果不需要此事件就不拦截，这样就可以解决滑动冲突的问题。
//    外部拦截法需要重写父容器的onInterceptTouchEvent()方法，在内部做相应的拦截即可。



    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int y = (int) ev.getY();
        mScrollView = (ScrollView) getChildAt(1);
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                yDown = y;
                break;
            case MotionEvent.ACTION_MOVE:
                yMove = y;
//                上滑
                if(yMove - yDown < 0){
                    isIntercept = false;
//                    下滑
                }else if(yMove - yDown > 0  && mScrollView.getScrollY() == 0 ){
                    isIntercept = true;
                    mMove = 0;
                }
                break;
            case MotionEvent.ACTION_UP:
                isIntercept = false;
                break;
        }
        Log.e("showme",isIntercept+"");
        return isIntercept;
    }
}
