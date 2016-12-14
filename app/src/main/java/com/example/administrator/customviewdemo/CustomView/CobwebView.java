package com.example.administrator.customviewdemo.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jiasheng on 2016/12/11.
 * email 898478073@qq.com
 * Description: CustomViewDemo
 */

public class CobwebView extends View{
    private int count = 6;                //数据个数
    private float angle = (float) (Math.PI*2/count);
    private float radius;                   //网格最大半径
    private int centerX;                  //中心X
    private int centerY;                  //中心Y
    private String[] titles = {"a","b","c","d","e","f"};
    private double[] data = {100,60,60,60,100,70,10,20}; //各维度分值
    private float maxValue = 100;             //数据最大值
    private Paint mainPaint;                //雷达区画笔
    private Paint valuePaint;               //数据区画笔
    private Paint textPaint;                //文本画笔

    public CobwebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CobwebView(Context context) {
        super(context);
        init();
    }

    public CobwebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init(){
        mainPaint = new Paint();
        valuePaint = new Paint();
        textPaint = new Paint();
        mainPaint.setStyle(Paint.Style.STROKE);

        mainPaint.setAntiAlias(true);
        valuePaint.setAntiAlias(true);
        textPaint.setAntiAlias(true);

        mainPaint.setColor(Color.BLUE);
        valuePaint.setColor(Color.YELLOW);
        textPaint.setColor(Color.BLACK);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        radius = Math.min(h, w)/2*0.9f;
        centerX = w/2;
        centerY = h/2;
        postInvalidate();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(600,600);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
//        canvas.translate(getWidth()/2,getHeight()/2);
        drawPolygon(canvas);
        drawLines(canvas);
        drawText(canvas);
        drawRegion(canvas);
    }

//    画蜘蛛网格
    private void drawPolygon(Canvas canvas){
        Path path = new Path();
//        蜘蛛丝键的间距
        float r = radius/(count-1);
        for (int i = 0; i < count; i++) {
            float curR = r*i;//当前的半径
            path.reset();
            for (int j = 0;j < count;j++){
                if(j==0){
                    path.moveTo(centerX+curR,centerY);
                }else {
//                    根据半径 计算出蜘蛛丝上每个点的坐标
                    float x = (float) (centerX+curR*Math.cos(angle*j));
                    float y = (float) (centerY+curR*Math.sin(angle*j));
                    path.lineTo(x,y);
                }
            }
            path.close();
            canvas.drawPath(path,mainPaint);
        }
    }

//    画线
    private void drawLines(Canvas canvas){
        Path path = new Path();
        for (int i = 0; i < count; i++) {
            path.reset();
            path.moveTo(centerX,centerY);
            float x = (float) (centerX+radius*Math.cos(angle* i));
            float y = (float) (centerY+radius*Math.sin(angle*i));
            path.lineTo(x,y);
            canvas.drawPath(path,mainPaint);
        }
    }

//    对于文本的绘制，首先要找到末端的坐标，由于末端和文本有一定距离，
// 给每个末端加上这个距离以后，再绘制文本。
//    另外，当文本在左边时，由于不希望文本和蜘蛛网交叉，
// 我们可以先计算出文本的长度，然后使起始绘制坐标向左偏移这个长度。
//    画文字
    private void drawText(Canvas canvas){
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float fontHeight = fontMetrics.descent - fontMetrics.ascent;
        for (int i = 0; i < count; i++) {
            float x = (float) (centerX+(radius+fontHeight/2)*Math.cos(angle*i));
            float y = (float) (centerY+(radius+fontHeight/2)*Math.sin(angle*i));
            if(angle*i>=0&&angle*i<=Math.PI/2){//第4象限
                canvas.drawText(titles[i], x,y,textPaint);
            }else if(angle*i>=3*Math.PI/2&&angle*i<=Math.PI*2){//第3象限
                canvas.drawText(titles[i], x,y,textPaint);
            }else if(angle*i>Math.PI/2&&angle*i<=Math.PI){//第2象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x-dis,y,textPaint);
            }else if(angle*i>=Math.PI&&angle*i<3*Math.PI/2){//第1象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x-dis,y,textPaint);
            }
        }
    }

//    绘制覆盖区域
    private void drawRegion(Canvas canvas){
        Path path = new Path();
        valuePaint.setAlpha(255);
        for (int i = 0; i < count; i++) {
            double percent = data[i]/maxValue;
            float x = (float) (centerX+radius*Math.cos(angle*i)*percent);
            float y = (float) (centerY+radius*Math.sin(angle*i)*percent);
            if(i==0){
                path.moveTo(x,centerY);
            }else {
                path.lineTo(x,y);
            }
//            绘制小圆点
            canvas.drawCircle(x,y,10,valuePaint);
        }
        valuePaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, valuePaint);
        valuePaint.setAlpha(127);
        //绘制填充区域
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, valuePaint);
    }
}
