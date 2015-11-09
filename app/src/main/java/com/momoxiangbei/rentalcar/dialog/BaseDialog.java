package com.momoxiangbei.rentalcar.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.momoxiangbei.rentalcar.utils.ScreenUtil;


/**
 * @author zhangqy email:1319203686@qq.com
 * @version V1.0
 * @Title: BaseDialog.java
 * @Package com.wallpaper.store.dialog
 * @Description: 所有对话框的基类
 * @category dialog
 * @date 2014年12月31日 上午11:47:38
 */
public abstract class BaseDialog extends Dialog {

    private double perWidth = 0.76;
    private boolean canceledOnTouchOutside = true;
    private boolean canceled = true;

    private View root;
    protected Context context;

    /**
     * 设置点击返回键是否dismiss
     */
    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    /**
     * 设置点击外部是否dismiss
     */
    public void setCancelOnTouchOutside(boolean canceledOnTouchOutside) {
        this.canceledOnTouchOutside = canceledOnTouchOutside;
    }

    /**
     * 设置宽度百分比
     *
     * @param perWidth
     */
    public void setPerWidth(double perWidth) {
        this.perWidth = perWidth;
    }

    public BaseDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setGravity(Gravity.CENTER);
        root = LayoutInflater.from(context).inflate(getLayout(), null);
        initViews(root);
        setContentView(root);
        setCanceledOnTouchOutside(canceledOnTouchOutside);
        setCancelable(canceled);
        screenAdapter();
    }

    /**
     * 获取布局
     *
     * @return
     */
    abstract protected int getLayout();

    /**
     * 初始化views
     *
     * @param root
     */
    abstract protected void initViews(View root);

    /**
     * 屏幕宽度适配
     */
    protected void screenAdapter() {
        if (null == context) {
            return;
        }
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = ScreenUtil.per2px(context.getResources(), perWidth);
        getWindow().setAttributes(params);
    }
}
