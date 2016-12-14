package com.example.administrator.customviewdemo.CustomViewSeries;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.icu.util.MeasureUnit;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import com.example.administrator.customviewdemo.R;
import com.example.administrator.customviewdemo.Utils.MeasureUtil;

/**
 * Created by jiasheng on 2016/12/14.
 * email 898478073@qq.com
 * Description: CustomViewDemo
 */

public class EraserView extends View{
    private  static  int MIN_MOVE_DIS = 0;
//

    private Canvas mCanvas;
    private Bitmap fgBitmap,bgBitmap;
    private Paint mPaint;
    private Path mPath;

    private int screenW,screenH;//屏幕宽高
    private float preX,preY;//记录一个触摸事件的位置坐标

    public EraserView(Context context) {
        super(context);
        cal(context);
        init(context);
    }

    public EraserView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        cal(context);
        init(context);
    }

    public EraserView(Context context, AttributeSet attrs) {
        super(context, attrs);
        cal(context);
        init(context);
    }

//    获取屏幕的宽高
    private void cal(Context context){
        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        screenH = screenSize[1];
        screenW = screenSize[0];
    }

//    初始化对象s
    private void init(Context context){
//        系统认为最少滑动距离
        MIN_MOVE_DIS = ViewConfiguration.get(context).getScaledTouchSlop();
//        实例化路径对象
        mPath = new Path();

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG|Paint.DITHER_FLAG);
//        设置混合模式DST_IN
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

        // 设置画笔透明度为0是关键！我们要让绘制的路径是透明的，然后让该路径与前景的底色混合“抠”出绘制路径
        mPaint.setARGB(128, 255, 100, 100);
        // 设置画笔风格为描边
        mPaint.setStyle(Paint.Style.STROKE);

        // 设置路径结合处样式
        mPaint.setStrokeJoin(Paint.Join.ROUND);


//        设置笔触类型
        mPaint.setStrokeCap(Paint.Cap.ROUND);

//        设置描边宽度
        mPaint.setStrokeWidth(50);

//        生成前景图bitmap
        fgBitmap = Bitmap.createBitmap(screenW,screenH, Bitmap.Config.ARGB_8888);



        // 获取背景底图Bitmap
        bgBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.a3);

        // 缩放背景底图Bitmap至屏幕大小
        bgBitmap = Bitmap.createScaledBitmap(bgBitmap, screenW, screenH, true);

        // 将其注入画布
//        mCanvas = new Canvas(fgBitmap);
        mCanvas = new Canvas(fgBitmap);

        // 绘制画布背景为中性灰
        mCanvas.drawColor(0xFF808080);
    }


    @Override
    protected void onDraw(Canvas canvas) {
//        绘制背景
        canvas.drawBitmap(bgBitmap,0,0,null);
//         绘制前景
        canvas.drawBitmap(fgBitmap,0,0,null);

  /*
         * 这里要注意canvas和mCanvas是两个不同的画布对象
         * 当我们在屏幕上移动手指绘制路径时会把路径通过mCanvas绘制到fgBitmap上
         * 每当我们手指移动一次均会将路径mPath作为目标图像绘制到mCanvas上，而在上面我们先在mCanvas上绘制了中性灰色
         * 两者会因为DST_IN模式的计算只显示中性灰，但是因为mPath的透明，计算生成的混合图像也会是透明的
         * 所以我们会得到“橡皮擦”的效果
         */
        mCanvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                mPath.moveTo(x,y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(x-preX);
                float dy = Math.abs(x-preY);
                if(dx >= MIN_MOVE_DIS || dy >= MIN_MOVE_DIS){
//                    mPath.quadTo(preX, preY, (x + preX) / 2, (y + preY) / 2);
                    mPath.lineTo(x,y);
                    preX = x;
                    preY = y;
                }
                break;
        }
        invalidate();
        return true;
    }
}
