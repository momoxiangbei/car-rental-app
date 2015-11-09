package com.momoxiangbei.rentalcar.fragment;

import android.os.Bundle;
import android.view.View;

import com.momoxiangbei.rentalcar.R;

/**
 * Created by Administrator on 2015/11/4.
 */
public class HomeFragment extends BaseTitleFragment {
    @Override
    public void create(Bundle bundle) {

    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        title.setText("首页");
    }

    @Override
    public void initParams() {

    }

    @Override
    public void initListeners() {

    }
}
