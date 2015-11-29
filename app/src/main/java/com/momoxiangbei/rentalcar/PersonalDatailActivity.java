package com.momoxiangbei.rentalcar;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.momoxiangbei.rentalcar.response.User;
import com.momoxiangbei.rentalcar.response.UserResponse;
import com.momoxiangbei.rentalcar.table.OrderTable;
import com.momoxiangbei.rentalcar.table.UserTable;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import org.litepal.crud.DataSupport;

import java.io.IOException;

/**
 * Created by Administrator on 2015/11/4.
 */
public class PersonalDatailActivity extends BaseTitleActivity implements View.OnClickListener {

    private FrameLayout fl_change_pwd;
    private TextView tv_sign_out;
    private TextView tv_name;
    private TextView tv_pone;
    private TextView tv_id_card;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, PersonalDatailActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initView() {
        super.initView();
        title.setText("个人信息");
        right.setVisibility(View.GONE);
        fl_change_pwd = (FrameLayout) findViewById(R.id.fl_change_pwd);
        tv_sign_out= (TextView) findViewById(R.id.tv_sign_out);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_pone = (TextView) findViewById(R.id.tv_phone);
        tv_id_card = (TextView) findViewById(R.id.tv_id_card);
    }

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_personal_details);
    }

    @Override
    public void initParams() {

        OkHttpClient mOkHttpClient = new OkHttpClient();
        FormEncodingBuilder builder = new FormEncodingBuilder();
        UserTable user = DataSupport.find(UserTable.class, 1);
        builder.add("phoneName", user.getUser_phone());
        builder.add("password", user.getPassword());

        tv_pone.setText(user.getUser_phone());

        final Request request = new Request.Builder()
                .url("http://192.168.1.2:8080/mgr/user/getUserMessage")
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
                UserResponse person = gson.fromJson(result, UserResponse.class);
                if (person != null && person.success) {
                        parseData(person);
                }
            }


        });
    }

    private void parseData(UserResponse person) {
        try {
            tv_name.setText(person.user.name);
            tv_id_card.setText(person.user.card_num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initListeners() {
        super.initListeners();
        fl_change_pwd.setOnClickListener(this);
        tv_sign_out.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == fl_change_pwd){
            ChangePwdActivity.startActivity(this);
        }else if (v == tv_sign_out){

            ContentValues values = new ContentValues();
            values.put("user_phone", "0");
            DataSupport.updateAll(OrderTable.class, values);

            LoginActivity.startActivity(this,true);
            finish();

        }
    }
}
