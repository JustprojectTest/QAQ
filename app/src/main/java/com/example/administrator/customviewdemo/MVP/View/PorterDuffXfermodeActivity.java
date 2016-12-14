package com.example.administrator.customviewdemo.MVP.View;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.administrator.customviewdemo.Base.BaseActivity;
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
                mView.setMODE(mList.get(position));
                mView.invalidate();
            }
        });
    }
}
