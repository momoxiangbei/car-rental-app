package com.momoxiangbei.rentalcar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.momoxiangbei.rentalcar.adapter.OrderManagerAdapter;
import com.momoxiangbei.rentalcar.response.CarListResponse;
import com.momoxiangbei.rentalcar.response.Order;
import com.momoxiangbei.rentalcar.response.OrderDetail;
import com.momoxiangbei.rentalcar.response.OrderResponse;
import com.momoxiangbei.rentalcar.table.UserTable;
import com.momoxiangbei.rentalcar.utils.ToastUtil;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/4.
 */
public class OrderManagerActivity extends BaseTitleActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private OrderManagerAdapter mOrderManagerAdapter;
    private ArrayList<Order> item;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, OrderManagerActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_order_manager);
        item = new ArrayList<Order>();
    }


    @Override
    public void initView() {
        super.initView();
        right.setText("筛选");
        title.setText("订单管理");

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

    }




    @Override
    public void initParams() {

        initData();

    }

    private void initData() {

        OkHttpClient mOkHttpClient = new OkHttpClient();
        FormEncodingBuilder builder = new FormEncodingBuilder();
        UserTable user = DataSupport.find(UserTable.class, 1);
        builder.add("phoneName", user.getUser_phone());
        builder.add("password", user.getPassword());


        final Request request = new Request.Builder()
                .url("http://192.168.1.2:8080/mgr/order/list")
                .post(builder.build())
                .build();

        waiting("请稍等...");
        com.squareup.okhttp.Call call = mOkHttpClient.newCall(request);
        call.enqueue(new com.squareup.okhttp.Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(final com.squareup.okhttp.Response response) throws IOException {
                stopWaiting();
                String result = response.body().string();
                Gson gson = new Gson();
                OrderResponse or = gson.fromJson(result, OrderResponse.class);
                if (or != null && or.success) {
                    item = or.data;
                    paseData(item);
                }
            }

        });

    }

    private void paseData(ArrayList<Order> items) {
        mOrderManagerAdapter = new OrderManagerAdapter(mContext, items);
        try {
            mRecyclerView.setAdapter(mOrderManagerAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
