package com.example.administrator.customviewdemo.MVP.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.customviewdemo.Base.BaseActivity;
import com.example.administrator.customviewdemo.CustomView.Bezier2;
import com.example.administrator.customviewdemo.CustomView.CheckView;
import com.example.administrator.customviewdemo.CustomViewSeries.First;
import com.example.administrator.customviewdemo.R;
import com.example.administrator.customviewdemo.Utils.AppManager;

public class MainActivity extends BaseActivity {

    private Boolean isCheck = false;
    private Boolean BezierControl = false;
//    系列View的第一个
    private First mFirst;

    @Override
    protected int getLayoutId() {
        return R.layout.main;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        AppManager.getAppMannager().addActivity(this);
        mFirst = (First) findViewById(R.id.first);
        new Thread(mFirst).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppMannager().finishActivity(this);
    }

    public void ischeck(View v){
        if(v instanceof CheckView){
            CheckView view =  (CheckView)v;
            isCheck =!isCheck;
            view.setAnimDuration(1000);
            if(isCheck){
                view.check();
            }else {
                view.unCheck();
            }
        }
    }

    public void controlSecondBezier(View v){
        if(v instanceof Bezier2){
            BezierControl =!BezierControl;
            Bezier2 bezier2 = (Bezier2) v;
            bezier2.setMode(BezierControl);
        }
    }

    public void clickToCMatrix(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,CMatrix.class);
        startActivity(intent);
    }

    public void clickToThird(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,PorterDuffXfermodeActivity.class);
        startActivity(intent);
    }
}
