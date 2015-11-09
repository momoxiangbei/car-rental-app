package com.momoxiangbei.rentalcar.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

/**
 * @author zhangqy email:1319203686@qq.com
 * @version V1.0
 * @Title: ScreenUtil.java
 * @Package com.wallpaper.store.utility
 * @Description: 屏幕相关工具
 * @category utility
 * @date 2014年12月31日 上午11:53:12
 */
public final class ScreenUtil {

    private static final String TAG = ScreenUtil.class.getSimpleName();

    private static final Point screenSize = new Point();

    /**
     * 获取屏幕信息
     */
    @SuppressLint("NewApi")
    public static Point getScreenSize(Context ctt) {
        if (ctt == null) {
            return screenSize;
        }
        if (screenSize.x > 0 && screenSize.y > 0) {
            return screenSize;
        }

        WindowManager wm = (WindowManager) ctt.getSystemService(Context.WINDOW_SERVICE);
        if (wm != null) {
            DisplayMetrics mDisplayMetrics = new DisplayMetrics();
            Display diplay = wm.getDefaultDisplay();
            if (diplay != null) {
                if (Build.VERSION.SDK_INT > 16) {// Build.VERSION_CODES.JELLY_BEAN
                    diplay.getRealMetrics(mDisplayMetrics);
                } else {
                    diplay.getMetrics(mDisplayMetrics);
                }
                int W = mDisplayMetrics.widthPixels;
                int H = mDisplayMetrics.heightPixels;
                if (W * H > 0 && (W > screenSize.x || H > screenSize.y)) {
                    screenSize.set(W, H);
                }
            }
        }
        return screenSize;
    }

    public static int dpToPx(Resources res, int dp) {
        if (null == res) {
            return 0;
        }
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                res.getDisplayMetrics());
    }

    public static int dip2px(Resources res, float dipValue) {
        if (null == res) {
            return 0;
        }
        final float scale = res.getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Resources res, float pxValue) {
        if (null == res) {
            return 0;
        }
        final float scale = res.getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 百分比转换为实际的像素值（宽度）
     *
     * @param per
     * @return
     */
    public static int per2px(Resources res, double per) {
        if (null == res) {
            return 0;
        }
        if (per < 0 || per > 1) {
            return 0;
        }
        DisplayMetrics dm = res.getDisplayMetrics();
        return (int) Math.ceil(dm.widthPixels * per);
    }

    /**
     * 百分比转换为实际的像素值（高度）
     *
     * @param per
     * @return
     */
    public static int perH2px(Resources res, double per) {
        if (null == res) {
            return 0;
        }
        if (per < 0 || per > 1) {
            return 0;
        }
        DisplayMetrics dm = res.getDisplayMetrics();
        return (int) Math.ceil(dm.heightPixels * per);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
