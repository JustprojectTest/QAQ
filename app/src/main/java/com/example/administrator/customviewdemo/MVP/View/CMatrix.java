package com.example.administrator.customviewdemo.MVP.View;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import com.example.administrator.customviewdemo.Base.BaseActivity;
import com.example.administrator.customviewdemo.CustomViewSeries.ColorMatrixView;
import com.example.administrator.customviewdemo.R;

/**
 * Created by jiasheng on 2016/12/13.
 * email 898478073@qq.com
 * Description: CustomViewDemo
 */

public class CMatrix extends BaseActivity {
    private EditText[] ets = new EditText[20];
    private float[] carray = new float[20];
    private ColorMatrixView sv;
    private GridLayout gl;
    private int mEtWidth;//每一个小编辑框的宽度
    private int mEtHeight;//每一个小编辑框的高度


    @Override
    protected int getLayoutId() {
        return R.layout.cmatrix;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        sv = (ColorMatrixView) findViewById(R.id.MyImage);
        gl = (GridLayout) findViewById(R.id.glay);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        mEtWidth = metrics.widthPixels / 5;
        mEtHeight = 200;
        initGrid();
        initMatrix();
    }

    private void initGrid() {
        for (int i = 0; i < 20; i++) {
            EditText et = new EditText(this);
            gl.addView(et, mEtWidth, mEtHeight);
            ets[i] = et;
        }
    }

    private void initMatrix() {
        for (int i = 0; i < 20; i++) {
            if (i % 6 == 0) {
                ets[i].setText(String.valueOf(1));
            } else {
                ets[i].setText(String.valueOf(0));
            }
        }
    }

    /*
    * 用来获取编辑框中的值
    */
    private void getMatrix() {
        for (int i = 0; i < 20; i++) {
            carray[i] = Float.valueOf(ets[i].getText().toString());
        }
    }

    public void change(View v){
        getMatrix();
        sv.setArray(carray);
        sv.invalidate();
    }
    public void restore(View v){
        initMatrix();
        getMatrix();
        sv.setArray(carray);
        sv.invalidate();
    }
}
