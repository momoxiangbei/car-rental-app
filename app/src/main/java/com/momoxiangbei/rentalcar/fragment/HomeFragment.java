package com.momoxiangbei.rentalcar.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.momoxiangbei.rentalcar.R;

/**
 * Created by Administrator on 2015/11/4.
 */
public class HomeFragment extends BaseTitleFragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout sp_refresh;

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
        sp_refresh = (SwipeRefreshLayout) view.findViewById(R.id.sp_refresh);
    }


    @Override
    public void initParams() {

    }

    @Override
    public void initListeners() {
        sp_refresh.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        sp_refresh.setRefreshing(true);
    }
}
