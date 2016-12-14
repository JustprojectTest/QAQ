package com.example.administrator.customviewdemo.CustomViewSeries;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.example.administrator.customviewdemo.R;

/**
 * Created by jiasheng on 2016/12/13.
 * email 898478073@qq.com
 * Description: CustomViewDemo
 */

public class ColorMatrixView extends ImageView{

    private Paint firstPaint;
    private int radius = 0;
    private boolean isScale = false;
    private Bitmap mBitmap;



    private float [] array=new float[20];
    private float mAngle;
    private DisplayMetrics mDm;


    public float[] getArray() {
        return array;
    }

    public void setArray(float[] array) {
        this.array = array;
    }

    public ColorMatrixView(Context context) {
        super(context);
        initPaint();
    }

    public ColorMatrixView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    public ColorMatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }


    private void initPaint() {
        mDm = new DisplayMetrics();
        mDm = getContext().getResources().getDisplayMetrics();
        firstPaint = new Paint();
        firstPaint.setAntiAlias(true);
        mBitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.test);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        setMeasuredDimension(mDm.widthPixels,heightMeasureSpec);
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        ColorMatrix cm = new ColorMatrix();
        cm.set(array);
//        ColorMatrixColorFilter、LightingColorFilter和PorterDuffColorFilter，
// 也就是说我们在setColorFilter(ColorFilter filter)的时候可以直接传入这三个子类对象作为参数
        firstPaint.setColorFilter(new ColorMatrixColorFilter(cm));
//        ColorMatrixColorFilter
//        色彩矩阵颜色过滤器 用矩阵过滤颜色
//        LightingColorFilter (int mul, int add)
//        ！mul全称是colorMultiply意为色彩倍增，而add全称是colorAdd意为色彩添加
//         PorterDuffColorFilter
//        这个构造方法也接受两个值，一个是16进制表示的颜色值这个很好理解，
//        而另一个是PorterDuff内部类Mode中的一个常量值，这个值表示混合模式
        canvas.drawBitmap(mBitmap, 0, 0, firstPaint);
    }

}
