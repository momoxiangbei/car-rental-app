package com.momoxiangbei.rentalcar.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.gson.Gson;
import com.momoxiangbei.rentalcar.BaseTitleActivity;
import com.momoxiangbei.rentalcar.MainActivity;
import com.momoxiangbei.rentalcar.R;
import com.momoxiangbei.rentalcar.adapter.RentalFindAdapter;
import com.momoxiangbei.rentalcar.base.AppConfig;
import com.momoxiangbei.rentalcar.response.Car;
import com.momoxiangbei.rentalcar.response.CarListResponse;
import com.momoxiangbei.rentalcar.response.UserResponse;
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
public class HomeFragment extends BaseTitleFragment {

    private SwipeRefreshLayout sp_refresh;
    private RentalFindAdapter mAdapter;
    private RecyclerView mRecycler;
    private  CollapsingToolbarLayout collapsingToolbar;
    private ArrayList<Car> item = new ArrayList<Car>();

    @Override
    public void create(Bundle bundle) {
        item = new ArrayList<Car>();
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

        //给页面设置工具栏
        collapsingToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("乐租伴您出行");
        collapsingToolbar.setCollapsedTitleTextColor(Color.parseColor("#ffffff"));

    }


    @Override
    public void initParams() {

        initItem();
        mAdapter = new RentalFindAdapter(mActivity,item);
        mRecycler.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecycler.setAdapter(mAdapter);



    }

    private void initItem() {

        OkHttpClient mOkHttpClient = new OkHttpClient();
        FormEncodingBuilder builder = new FormEncodingBuilder();
        UserTable user = DataSupport.find(UserTable.class, 1);
        builder.add("phoneName", user.getUser_phone());
        builder.add("password", user.getPassword());
        builder.add("id", "1");

        final Request request = new Request.Builder()
                .url("http://192.168.1.2:8080/mgr/car/list")
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
                CarListResponse clr = gson.fromJson(result, CarListResponse.class);
                if (clr != null && clr.success) {

                    item = clr.cars;

                }
            }


        });
    }


    @Override
    public void initListeners() {

    }


}
