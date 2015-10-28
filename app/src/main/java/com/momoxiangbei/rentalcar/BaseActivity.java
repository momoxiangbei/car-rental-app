package com.momoxiangbei.rentalcar;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

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

}
