package com.momoxiangbei.rentalcar.fragment;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.momoxiangbei.rentalcar.BaseTitleActivity;
import com.momoxiangbei.rentalcar.R;
import com.momoxiangbei.rentalcar.adapter.RentalFindAdapter;

/**
 * Created by Administrator on 2015/11/4.
 */
public class HomeFragment extends BaseTitleFragment {

    private SwipeRefreshLayout sp_refresh;
    private RentalFindAdapter mAdapter;
    private RecyclerView mRecycler;
    private  CollapsingToolbarLayout collapsingToolbar;

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
        mRecycler = (RecyclerView) view.findViewById(R.id.recycler);
//        collapsingToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
    }


//    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
//        return dependency instanceof AppBarLayout;
//    }
//
//    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
//        // check the behavior triggered
//        android.support.design.widget.CoordinatorLayout.Behavior behavior = ((android.support.design.widget.CoordinatorLayout.LayoutParams) dependency.getLayoutParams()).getBehavior();
//        if (behavior instanceof AppBarLayout.Behavior) {
//            // do stuff here
//        }
//    }


    @Override
    public void initParams() {
        mAdapter = new RentalFindAdapter(mActivity,null);
        mRecycler.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecycler.setAdapter(mAdapter);
//        collapsingToolbar.setTitle("Title");


    }

    @Override
    public void initListeners() {

    }


}
