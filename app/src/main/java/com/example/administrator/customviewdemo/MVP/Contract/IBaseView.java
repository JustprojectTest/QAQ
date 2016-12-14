package com.example.administrator.customviewdemo.MVP.Contract;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by jiasheng on 2016/12/7.
 * email 898478073@qq.com
 * Description: CustomViewDemo
 */

public interface IBaseView<T> {
    void setPresenter(T presenter);
}
