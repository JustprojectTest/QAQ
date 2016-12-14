package com.example.administrator.customviewdemo.CustomViewSeries;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jiasheng on 2016/12/12.
 * email 898478073@qq.com
 * Description: CustomViewDemo
 */

public class First extends View implements Runnable {

    private Paint firstPaint;
    private int radius = 0;
    private boolean isScale = false;

    public First(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    public First(Context context) {
        super(context);
        initPaint();
    }

    public First(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    //    初始化画笔
    private void initPaint() {
        firstPaint = new Paint();
        firstPaint.setAntiAlias(true);
         /*
     * 设置画笔样式为描边，圆环嘛……当然不能填充不然就么意思了
     *
     * 画笔样式分三种：
     * 1.Paint.Style.STROKE：描边
     * 2.Paint.Style.FILL_AND_STROKE：描边并填充
     * 3.Paint.Style.FILL：填充
     */
        firstPaint.setStyle(Paint.Style.STROKE);

//        设置颜色
//        firstPaint.setColor(Color.LTGRAY);
        firstPaint.setARGB(255,255,128,110);
        // 生成色彩矩阵
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                2, 0, 0, 0, 0,
                0, 2, 0, 0, 0,
                0, 0, 2, 0, 0,
                0, 0, 0, 1, 0,
        });
        firstPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

//         设置描边的粗细，单位：像素px
//         注意：当setStrokeWidth(0)的时候描边宽度并不为0而是只占一个像素
        firstPaint.setStrokeWidth(10);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(400, 400);
    }

    //    在这里画画
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        绘制圆环
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, firstPaint);
//         刷新View  只能在UI线程工作
//        invalidate();
    }


    @Override
    public void run() {
        while (true) {
            try {
//                缩放
                if (isScale) {
                    radius--;
                    if (radius <= 0) {
                        radius=0;
                        isScale = false;
                    }
                } else {//放大
                    if (radius >=0 && radius < 150) {
                        radius++;
                    } else {
                        isScale = true;
                    }
                }
                postInvalidate();
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
