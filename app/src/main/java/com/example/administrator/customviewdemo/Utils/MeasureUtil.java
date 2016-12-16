package com.example.administrator.customviewdemo.Utils;

import android.app.Activity;
import android.util.DisplayMetrics;
/**
 * 获取屏幕尺寸
 *
 * @param activity
 *            Activity
 * @return 屏幕尺寸像素值，下标为0的值为宽，下标为1的值为高
 */
public final class MeasureUtil {
	/**
	 * ��ȡ��Ļ�ߴ�
	 * 
	 * @param activity
	 *            Activity123
	 * @return
	 */
	public static int[] getScreenSize(Activity activity) {
		DisplayMetrics metrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		return new int[] { metrics.widthPixels, metrics.heightPixels };
	}
}
