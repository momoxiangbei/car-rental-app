package com.momoxiangbei.rentalcar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.momoxiangbei.rentalcar.response.OrderDetail;
import com.momoxiangbei.rentalcar.response.OrderDetailResponse;
import com.momoxiangbei.rentalcar.table.UserTable;
import com.momoxiangbei.rentalcar.utils.ToastUtil;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import org.litepal.crud.DataSupport;

import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2015/11/4.
 */
public class OrderDetailActivity extends BaseTitleActivity {

    private TextView tv_order_num;
    private TextView tv_status;
    private TextView tv_car_type;
    private TextView tv_car_num;
    private TextView tv_user_name;
    private TextView tv_user_phone;
    private TextView tv_type;
    private TextView tv_data;
    private TextView tv_data_back;
    private TextView tv_shop;
    private TextView tv_position;
    private TextView tv_extra;
    private TextView tv_note;
    private TextView tv_money;
    public static Boolean from_select = false;

    public static String orderId = null;

    public static void startActivity(Context context,Boolean is_from_select) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        context.startActivity(intent);
        from_select = is_from_select;
    }

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_order_detail);

    }


    @Override
    public void initView() {
        super.initView();
        title.setText("订单详情");
        tv_order_num = (TextView) findViewById(R.id.tv_order_num);
        tv_status = (TextView) findViewById(R.id.tv_status);
        tv_car_type = (TextView) findViewById(R.id.tv_car_type);
        tv_car_num = (TextView) findViewById(R.id.tv_car_num);
        tv_user_name= (TextView) findViewById(R.id.tv_user_name);
        tv_user_phone= (TextView) findViewById(R.id.tv_user_phone);
        tv_type= (TextView) findViewById(R.id.tv_type);
        tv_data= (TextView) findViewById(R.id.tv_data);
        tv_data_back= (TextView) findViewById(R.id.tv_data_back);
        tv_shop= (TextView) findViewById(R.id.tv_shop);
        tv_position= (TextView) findViewById(R.id.tv_position);
        tv_extra= (TextView) findViewById(R.id.tv_extra);
        tv_note= (TextView) findViewById(R.id.tv_note);
        tv_money = (TextView) findViewById(R.id.tv_money);
    }

    @Override
    public void initParams() {
        right.setVisibility(View.INVISIBLE);

        if (!from_select){
            initData();
        }else {
            initDataConfig();
        }

    }

    private void initDataConfig() {

    }

    private void initData() {

        OkHttpClient mOkHttpClient = new OkHttpClient();
        FormEncodingBuilder builder = new FormEncodingBuilder();
        UserTable user = DataSupport.find(UserTable.class, 1);
        builder.add("phoneName", user.getUser_phone());
        builder.add("password", user.getPassword());
        if ( orderId !=null ){
            builder.add("orderId", orderId);
        } else {
            ToastUtil.showToast("服务器打瞌睡了！");
            finish();
        }


        final Request request = new Request.Builder()
                .url("http://192.168.1.2:8080/mgr/order/orderDetail")
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
                OrderDetailResponse odr = gson.fromJson(result, OrderDetailResponse.class);
                if (odr != null && odr.success) {

                    paseData(odr.data);
                }
            }


        });
    }

    private void paseData(OrderDetail data) {
        tv_order_num.setText(data.orderId);
        tv_car_type.setText(data.carType);
        tv_car_num.setText(data.carNumber);
        tv_user_name.setText(data.name);
        tv_user_phone.setText(data.phoneName);
        tv_data.setText(data.outTime);
        tv_data_back.setText(data.backTime);
        tv_shop.setText(data.shopName);
        tv_position.setText(data.position);
        tv_extra.setText(data.otherServer);
        tv_note.setText(data.memo);
        tv_money.setText(data.price);

        if (data.type.equals("0")){
            //0是短租 1是长租
            tv_type.setText("短租");
        }else if (data.type.equals("1")){
            tv_type.setText("长租");
        }

        if (data.orderSatus.equals(0)){
            //0未处理 1已处理 2已取车 3订单异常 4 已完成
            tv_status.setText("未处理");
        }else if (data.orderSatus.equals(1)){
            tv_status.setText("已处理");
        }else if (data.orderSatus.equals(1)){
            tv_status.setText("已取车");
        }else if (data.orderSatus.equals(1)){
            tv_status.setText("订单异常");
        }else if (data.orderSatus.equals(1)){
            tv_status.setText("已完成");

        }


    }
}
