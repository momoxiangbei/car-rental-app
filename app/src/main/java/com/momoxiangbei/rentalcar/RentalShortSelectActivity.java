package com.momoxiangbei.rentalcar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.momoxiangbei.rentalcar.base.AppConfig;
import com.momoxiangbei.rentalcar.response.OrderDetailResponse;
import com.momoxiangbei.rentalcar.table.UserTable;
import com.momoxiangbei.rentalcar.utils.ToastUtil;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import org.litepal.crud.DataSupport;

import java.io.IOException;

/**
 * Created by Administrator on 2015/11/6.
 */
public class RentalShortSelectActivity extends BaseTitleActivity implements View.OnClickListener {

    private TextView tv_next;
    private RelativeLayout lr_extra;
    private TextView tv_need;
    private EditText et_note;

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_short_select);
    }

    public static void startActivity(Activity mActivit) {
        Intent intent = new Intent(mActivit, RentalShortSelectActivity.class);
        mActivit.startActivity(intent);
    }

    @Override
    public void initView() {
        super.initView();
        right.setVisibility(View.INVISIBLE);
        title.setText("短租");

        tv_next = (TextView) findViewById(R.id.tv_next);
        lr_extra = (RelativeLayout) findViewById(R.id.lr_extra);
        tv_need = (TextView) findViewById(R.id.tv_need);
        et_note = (EditText) findViewById(R.id.et_note);

    }

    @Override
    public void initListeners() {
        super.initListeners();
        tv_next.setOnClickListener(this);
        lr_extra.setOnClickListener(this);
    }

    @Override
    public void initParams() {

    }

    @Override
    public void onClick(View v) {
        if (v == tv_next){
            submitData();

        }else if (v == lr_extra){
            Intent intent = new Intent(RentalShortSelectActivity.this, SelectExtraActivity.class);
            startActivityForResult(intent,0);
        }
    }

    private void submitData() {
        AppConfig.car_note = et_note.getText().toString().trim();

        OkHttpClient mOkHttpClient = new OkHttpClient();
        FormEncodingBuilder builder = new FormEncodingBuilder();
        UserTable user = DataSupport.find(UserTable.class, 1);
        builder.add("phoneName", user.getUser_phone());
        builder.add("password", user.getPassword());
        if ( AppConfig.shop_id !=null ){
            builder.add("shopId", AppConfig.shop_id);
        } else {
            ToastUtil.showToast("请选择租车地点！");
            finish();
        }

        if ( AppConfig.date !=null ){
            builder.add("outTime", AppConfig.date);
        } else {
            ToastUtil.showToast("请选择租车日期！");
            finish();
        }

        if ( AppConfig.date_back !=null ){
            builder.add("backTime", AppConfig.date_back);
        } else {
            ToastUtil.showToast("请选择换车日期！");
            finish();
        }

        if ( AppConfig.car_type !=null ){
            builder.add("carType", AppConfig.car_type);
        } else {
            ToastUtil.showToast("请选择租车类型！");
            finish();
        }

        builder.add("memo", AppConfig.car_note);

        builder.add("type", "0");

        builder.add("otherServer", AppConfig.car_extra);


        final Request request = new Request.Builder()
                .url("http://192.168.1.2:8080/mgr/car/rentCar")
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
                ToastUtil.showToast("访问接口");
                Log.d("momo", result);
//                OrderDetailActivity.startActivity(mContext, true);

            }


        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 0:
                Bundle b = data.getExtras();
                tv_need.setText(b.getString("need"));
                AppConfig.car_extra = b.getString("need");
                break;
            default:
                break;
        }
    }
}
