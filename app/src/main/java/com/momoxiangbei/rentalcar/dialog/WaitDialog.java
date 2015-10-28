package com.momoxiangbei.rentalcar.dialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;

/**
 * Created by Administrator on 2015/9/8.
 */
public class WaitDialog {

    private ProgressDialog mProgressDialog;
    private Activity context;
    private String desc = "请稍候...";
    private Boolean cancelable;

    public WaitDialog(Context context){
        this.context = (Activity) context;
    }

    public void setWaitText(String text){
        desc = TextUtils.isEmpty(text) ? desc : text;
    }

    public void setCancelable(boolean cancelable){
        this.cancelable = cancelable;
    }

    public void show(){
        if (mProgressDialog == null){
            mProgressDialog = ProgressDialog.show(context,null,desc,true,false);
        }
        if (mProgressDialog != null && !mProgressDialog.isShowing() && !context.isFinishing()){
            mProgressDialog.show();
        }
    }

    public boolean isShowing() {
        if (null == mProgressDialog) {
            return false;
        }
        return mProgressDialog.isShowing();
    }

    public void dismiss() {
        if (null != mProgressDialog
                && !context.isFinishing()
                && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener keyListener) {
        if (null != mProgressDialog) {
            mProgressDialog.setOnKeyListener(keyListener);
        }
    }

}
