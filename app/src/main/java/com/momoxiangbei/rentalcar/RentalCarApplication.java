package com.momoxiangbei.rentalcar;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2015/11/27.
 */
public class RentalCarApplication extends Application {

    private static Context mContext;

    public static Context getInstance() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
