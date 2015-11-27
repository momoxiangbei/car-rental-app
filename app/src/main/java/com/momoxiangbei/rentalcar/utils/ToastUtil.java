package com.momoxiangbei.rentalcar.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.momoxiangbei.rentalcar.RentalCarApplication;

/**
 * Created by Administrator on 2015/11/27.
 */
public final class ToastUtil {

    private static Toast toast = null;
    private static Handler handlerResult = new Handler(Looper.getMainLooper());

    public static synchronized void showToast(final String str) {
        handlerResult.post(new Runnable() {
            @Override
            public void run() {
                if (toast == null) {
                    toast = Toast.makeText(RentalCarApplication.getInstance(), str, Toast.LENGTH_SHORT);
                } else {
                    toast.setText(str);
                }
                toast.show();
            }
        });
    }

    public static synchronized void showToast(final int resId) {
        handlerResult.post(new Runnable() {
            @Override
            public void run() {
                if (toast == null) {
                    toast = Toast.makeText(RentalCarApplication.getInstance(), resId, Toast.LENGTH_SHORT);
                } else {
                    toast.setText(resId);
                }
                toast.show();
            }
        });
    }

    public static synchronized void showToastLong(final String str) {
        handlerResult.post(new Runnable() {
            @Override
            public void run() {
                if (toast == null) {
                    toast = Toast.makeText(RentalCarApplication.getInstance(), str, Toast.LENGTH_LONG);
                } else {
                    toast.setText(str);
                }
                toast.show();
            }
        });

    }

    public static synchronized void showToastLong(final int resId) {
        handlerResult.post(new Runnable() {
            @Override
            public void run() {
                if (toast == null) {
                    toast = Toast.makeText(RentalCarApplication.getInstance(), resId, Toast.LENGTH_LONG);
                } else {
                    toast.setText(resId);
                }
                toast.show();
            }
        });

    }

    public static void showTipDialog(Context context, String tip) {
        new AlertDialog.Builder(context)
                .setMessage(tip).setNegativeButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();

    }

}
