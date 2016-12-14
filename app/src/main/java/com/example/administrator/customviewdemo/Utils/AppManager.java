package com.example.administrator.customviewdemo.Utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.util.Stack;

/**
 * Created by jiasheng on 2016/12/5.
 * email 898478073@qq.com
 * Description: 应用程序Activity管理:用于Activity管理和应用程序退出
 */

public class AppManager {
    private static Stack<Activity> activityStack;
    private volatile static AppManager instance;

    private AppManager(){}

//    获取实例
    public static AppManager getAppMannager(){
        if(instance==null){
            synchronized (AppManager.class){
                if(instance==null){
                    instance = new AppManager();
                }
            }
        }
        return instance;
    }

//    添加Activty
    public void addActivity(Activity activity){
        if(activityStack==null){
            activityStack = new Stack<>();
        }
    }

//    获取当前的Activity
    public Activity currentActivity(){
        return activityStack.lastElement();
    }

//    结束当前的Activity
    public void finishActivity(){
        finishActivity(activityStack.lastElement());
    }

//    结束指定的Activity
    public void finishActivity(Activity activity){
        if(activity!=null){
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }


//    结束指定类名的Activity
    public void finishActivity(Class<?> cls){
        for (Activity activity:activityStack) {
            if(activity.getClass().equals(cls)){
                finishActivity(activity);
            }
        }
    }

//    结束所有的Activity
    public void finishAllActivity(){
        for (int i = 0; i < activityStack.size(); i++) {
            if(activityStack.get(i)!=null){
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

//    退出应用程序
    public void AppExit(Context context){
        try {
            finishAllActivity();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityManager.restartPackage(context.getPackageName());
            System.exit(0);
        }catch (Exception e){
            Log.e("showme",e.toString());
        }
    }
}
