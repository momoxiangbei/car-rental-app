package com.momoxiangbei.rentalcar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;

import com.momoxiangbei.rentalcar.dialog.WaitDialog;

/**
 * Created by Administrator on 2015/9/8.
 */
public abstract class BaseActivity extends FragmentActivity {

    protected Context mContext;

    public abstract void create(Bundle bundle);

    public abstract void initView();

    public abstract void initParams();

    public abstract void initListeners();


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mContext = this;
        create(bundle);
        initView();
        initParams();
        initListeners();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    //等待框
    private WaitDialog dialog;

    protected void waiting(String msg, boolean cancelable) {
        dialog = new WaitDialog(this);
        dialog.setCancelable(cancelable);

        // Disable the back button
        Dialog.OnKeyListener keyListener = new Dialog.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                return keyCode == KeyEvent.KEYCODE_BACK;
            }
        };
        dialog.setOnKeyListener(keyListener);
        dialog.show();
        dialog.setWaitText(TextUtils.isEmpty(msg) ? "请稍候" : msg);
    }

    public void waiting(String msg) {
        waiting(msg, true);

    }

    public void stopWaiting() {
        if (dialog != null
                && dialog.isShowing()) {
            try {
                dialog.dismiss();
            } catch (Exception e) {
                //activity被系统杀死重启会导致not attached to window manager
                e.printStackTrace();
            }
        }
    }

}
