package com.example.administrator.customviewdemo.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by jiasheng on 2016/12/11.
 * email 898478073@qq.com
 * Description: 画出伞形图
 */

public class Fanned extends View{

    // 颜色表(注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {
            0xFFCCFF00,
            0xFF6495ED,
            0xFFE32636,
            0xFF800000,
            0xFF808000,
            0xFFFF8C69,
            0xFF808080,
            0xFFE6B800,
            0xFF7CFC00};
    // 饼状图初始绘制角度
    private float mStartAngle = 0;
    // 数据
    private ArrayList<Float> mData = new ArrayList<>();
    // 宽高
    private int mWidth, mHeight;
    // 画笔
    private Paint mPaint = new Paint();


    public Fanned(Context context) {
        super(context);
        initData();
    }

    public Fanned(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    public Fanned(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    private void initData(){
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mData.add(60f);
        mData.add(120f);
        mData.add(20f);
        mData.add(40f);
        mData.add(60f);
        mData.add(60f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(300,300);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = h;
        mWidth = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float CurrentAngle = mStartAngle;
        canvas.translate(getWidth()/2,getHeight()/2);
        float r  =  (float) (Math.min(mWidth, mHeight) / 2 * 0.8); // 饼状图半径
        RectF rect = new RectF(-r, -r, r, r);

        for (int i = 0; i < mData.size(); i++) {
            mPaint.setColor(mColors[i]);
            canvas.drawArc(rect, CurrentAngle, mData.get(i), true, mPaint);
            CurrentAngle+=mData.get(i);
        }
    }
}
