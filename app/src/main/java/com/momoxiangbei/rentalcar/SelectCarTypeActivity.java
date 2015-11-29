package com.momoxiangbei.rentalcar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.momoxiangbei.rentalcar.adapter.SelectCarTypeAdapter;
import com.momoxiangbei.rentalcar.adapter.SelectPositionAdapter;
import com.momoxiangbei.rentalcar.base.AppConfig;
import com.momoxiangbei.rentalcar.response.CarDetail;
import com.momoxiangbei.rentalcar.response.CarDetailListResponse;
import com.momoxiangbei.rentalcar.response.Shop;
import com.momoxiangbei.rentalcar.response.ShopResponse;
import com.momoxiangbei.rentalcar.table.UserTable;
import com.momoxiangbei.rentalcar.utils.ToastUtil;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/6.
 */
public class SelectCarTypeActivity extends BaseTitleActivity {

    private SelectCarTypeAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_select_car_type);
    }

    public static void startActivity(Activity mActivity) {
        Intent intent = new Intent(mActivity, SelectCarTypeActivity.class);
        mActivity.startActivity(intent);
    }

    @Override
    public void initView() {
        super.initView();
        right.setVisibility(View.INVISIBLE);
        title.setText("选择车辆");

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler);

    }


    @Override
    public void initParams() {

        initdata();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));


    }

    private void initdata() {

        OkHttpClient mOkHttpClient = new OkHttpClient();
        FormEncodingBuilder builder = new FormEncodingBuilder();
        UserTable user = DataSupport.find(UserTable.class, 1);
        builder.add("phoneName", user.getUser_phone());
        builder.add("password", user.getPassword());
        if (!TextUtils.isEmpty(AppConfig.shop_id)){
            builder.add("id", AppConfig.shop_id);
        }else {
            ToastUtil.showToast("请先选择取车地点！");
            finish();
        }
        builder.add("type", "0");

        final Request request = new Request.Builder()
                .url("http://192.168.1.2:8080/mgr/car/listCar")
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
                CarDetailListResponse cdlp = gson.fromJson(result, CarDetailListResponse.class);
                if (cdlp != null && cdlp.success) {

                    parseData(cdlp.data);
                }

            }


        });
    }

    private void parseData(ArrayList<CarDetail> carDetail) {
        try {
            mRecyclerView.setAdapter(mAdapter = new SelectCarTypeAdapter(mContext,carDetail));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
