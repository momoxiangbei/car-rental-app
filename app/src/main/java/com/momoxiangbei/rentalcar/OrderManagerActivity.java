package com.momoxiangbei.rentalcar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.momoxiangbei.rentalcar.adapter.OrderManagerAdapter;
import com.momoxiangbei.rentalcar.response.OrderDetail;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/4.
 */
public class OrderManagerActivity extends BaseTitleActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private OrderManagerAdapter mOrderManagerAdapter;
    private ArrayList<OrderDetail> list;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, OrderManagerActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initView() {
        super.initView();
        right.setText("筛选");
        title.setText("订单管理");

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        initDate();
        mOrderManagerAdapter = new OrderManagerAdapter(mContext,list);
        mRecyclerView.setAdapter(mOrderManagerAdapter);

    }

    private void initDate() {
        list = new ArrayList<OrderDetail>();
        for (int i = 0;i < 10 ;i++){
            OrderDetail mOderDeatail = new OrderDetail();
            mOderDeatail.order_num = "num" + i;
            list.add(mOderDeatail);
        }

    }


    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_order_manager);
    }

    @Override
    public void initParams() {

    }

    @Override
    public void initListeners() {
        super.initListeners();
        right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
