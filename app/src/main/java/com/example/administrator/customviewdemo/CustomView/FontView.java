package com.example.administrator.customviewdemo.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jiasheng on 2016/12/15.
 * email 898478073@qq.com
 * Description: CustomViewDemo
 */

public class FontView extends View {

    private static final String TEXT = "wtf中文ξτβбпшㄎㄊ";

    public FontView(Context context) {
        super(context);
    }

    public FontView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FontView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


}
