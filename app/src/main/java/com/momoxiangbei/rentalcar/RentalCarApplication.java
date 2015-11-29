package com.momoxiangbei.rentalcar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.litepal.LitePalApplication;
import org.litepal.tablemanager.Connector;

/**
 * Created by Administrator on 2015/11/27.
 */
public class RentalCarApplication extends LitePalApplication {

    private static Context mContext;


    public static Context getInstance() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        SQLiteDatabase db = Connector.getDatabase();

    }
}
