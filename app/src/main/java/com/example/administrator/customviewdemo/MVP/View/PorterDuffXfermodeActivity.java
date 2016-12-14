package com.example.administrator.customviewdemo.MVP.View;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.administrator.customviewdemo.Base.BaseActivity;
import com.example.administrator.customviewdemo.CustomViewSeries.DisInView;
import com.example.administrator.customviewdemo.CustomViewSeries.PorterDuffXfermodeView;
import com.example.administrator.customviewdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiasheng on 2016/12/13.
 * email 898478073@qq.com
 * Description: CustomViewDemo
 */

public class PorterDuffXfermodeActivity extends BaseActivity{
    private PorterDuffXfermodeView mView;
    private DisInView mDisInView;
    private ListView mListView;
    private ArrayList<PorterDuff.Mode> mList = new ArrayList<>();
    private ArrayList<String> mList2 = new ArrayList<>();
    private ArrayList<Map<String,String>> mList3= new ArrayList();

    @Override
    protected int getLayoutId() {
        return R.layout.porterduffxfermode_layout;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        mView = (PorterDuffXfermodeView) findViewById(R.id.PorterDuffXfermodeView);
        mDisInView = (DisInView) findViewById(R.id.disView);
        mListView = (ListView) findViewById(R.id.mode_list);
        initData();
    }

    private void initData(){
        mList.add(PorterDuff.Mode.ADD);
        mList.add(PorterDuff.Mode.CLEAR);
        mList.add(PorterDuff.Mode.DARKEN);
        mList.add(PorterDuff.Mode.DST);
        mList.add(PorterDuff.Mode.DST_ATOP);
        mList.add(PorterDuff.Mode.DST_IN);
        mList.add(PorterDuff.Mode.DST_OUT);
        mList.add(PorterDuff.Mode.DST_OVER);
        mList.add(PorterDuff.Mode.LIGHTEN);
        mList.add(PorterDuff.Mode.MULTIPLY);
        mList.add(PorterDuff.Mode.OVERLAY);
        mList.add(PorterDuff.Mode.SCREEN);
        mList.add(PorterDuff.Mode.SRC);
        mList.add(PorterDuff.Mode.SRC_ATOP);
        mList.add(PorterDuff.Mode.SRC_IN);
        mList.add(PorterDuff.Mode.SRC_OUT);
        mList.add(PorterDuff.Mode.SRC_OVER);
        mList.add(PorterDuff.Mode.XOR);

        mList2.add("ADD");
        mList2.add("CLEAR");
        mList2.add("DARKEN");
        mList2.add("DST");
        mList2.add("DST_ATOP");
        mList2.add("DST_IN");
        mList2.add("DST_OUT");
        mList2.add("DST_OVER");
        mList2.add("LIGHTEN");
        mList2.add("MULTIPLY");
        mList2.add("OVERLAY");
        mList2.add("SCREEN");
        mList2.add("SRC");
        mList2.add("SRC_ATOP");
        mList2.add("SRC_IN");
        mList2.add("SRC_OUT");
        mList2.add("SRC_OVER");
        mList2.add("XOR");

//        在Android的PorterDuff.Mode类中列举了他们制定的规则：
//
//        android.graphics.PorterDuff.Mode. SRC :只绘制源图像
//
//        android.graphics.PorterDuff.Mode. DST :只绘制目标图像
//
//        android.graphics.PorterDuff.Mode. DST_OVER :在源图像的顶部绘制目标图像
//
//        android.graphics.PorterDuff.Mode. DST_IN :只在源图像和目标图像相交的地方绘制目标图像
//
//        android.graphics.PorterDuff.Mode. DST_OUT :只在源图像和目标图像不相交的地方绘制目标图像
//
//        android.graphics.PorterDuff.Mode. DST_ATOP :在源图像和目标图像相交的地方绘制目标图像，在不相交的地方绘制源图像
//
//        android.graphics.PorterDuff.Mode. SRC_OVER :在目标图像的顶部绘制源图像
//
//        android.graphics.PorterDuff.Mode. SRC_IN :只在源图像和目标图像相交的地方绘制源图像
//
//        android.graphics.PorterDuff.Mode. SRC_OUT :只在源图像和目标图像不相交的地方绘制源图像
//
//        android.graphics.PorterDuff.Mode. SRC_ATOP :在源图像和目标图像相交的地方绘制源图像，在不相交的地方绘制目标图像
//
//        android.graphics.PorterDuff.Mode. XOR :在源图像和目标图像重叠之外的任何地方绘制他们，而在不重叠的地方不绘制任何内容
//
//        android.graphics.PorterDuff.Mode. LIGHTEN :获得每个位置上两幅图像中最亮的像素并显示
//
//        android.graphics.PorterDuff.Mode. DARKEN :获得每个位置上两幅图像中最暗的像素并显示
//
//        android.graphics.PorterDuff.Mode. MULTIPLY :将每个位置的两个像素相乘，除以255，然后使用该值创建一个新的像素进行显示。结果颜色=顶部颜色*底部颜色/255
//
//        android.graphics.PorterDuff.Mode. SCREEN :反转每个颜色，执行相同的操作（将他们相乘并除以255），然后再次反转。结果颜色=255-(((255-顶部颜色)*(255-底部颜色))/255)

        for (int i = 0; i < mList2.size(); i++) {
            Map<String,String> map = new HashMap<>();
            map.put("name",mList2.get(i));
            mList3.add(map);
        }

//        参数context：上下文，比如this。关联SimpleAdapter运行的视图上下文
//        参数data：Map列表，列表要显示的数据，这部分需要自己实现，如例子中的getData()，类型要与上面的一致，每条项目要与from中指定条目一致
//        参数resource：ListView单项布局文件的Id,这个布局就是你自定义的布局了，你想显示什么样子的布局都在这个布局中。这个布局中必须包括了to中定义的控件id
//        参数 from：一个被添加到Map上关联每一个项目列名称的列表，数组里面是列名称
//        参数 to：是一个int数组，数组里面的id是自定义布局中各个控件的id，需要与上面的from对应

        SimpleAdapter adapter = new SimpleAdapter(this,mList3,R.layout.item,new String[]{"name"},new int[]{R.id.showtext});
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                mView.setMODE(mList.get(position));
//                mView.invalidate();
                mDisInView.setMode(mList.get(position));
                mDisInView.invalidate();
            }
        });
    }
}
