package com.momoxiangbei.rentalcar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.momoxiangbei.rentalcar.base.AppConfig;
import com.momoxiangbei.rentalcar.response.UserResponse;
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
public class ChangePwdActivity extends BaseTitleActivity implements View.OnClickListener {

    private TextView tv_submit;
    private EditText ed_old_pwd;
    private EditText ed_new_pwd;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ChangePwdActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_change_pwd);
    }

    @Override
    public void initView() {
        super.initView();
        left.setVisibility(View.INVISIBLE);
        right.setVisibility(View.INVISIBLE);
        title.setText("修改密码");

        tv_submit = (TextView) findViewById(R.id.tv_submit);
        ed_old_pwd = (EditText) findViewById(R.id.ed_old_pwd);
        ed_new_pwd = (EditText) findViewById(R.id.ed_new_pwd);

    }

    @Override
    public void initParams() {

    }

    @Override
    public void initListeners() {
        super.initListeners();
        tv_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tv_submit){
            String old_pwd = ed_old_pwd.getText().toString().trim();
            String new_pwd = ed_new_pwd.getText().toString().trim();

            if (TextUtils.isEmpty(new_pwd)){
                ToastUtil.showToast("新密码不能为空");
                return;
            }

            OkHttpClient mOkHttpClient = new OkHttpClient();
            FormEncodingBuilder builder = new FormEncodingBuilder();
            UserTable user = DataSupport.find(UserTable.class, 1);
            builder.add("phoneName", user.getUser_phone());
            builder.add("password", user.getPassword());
            builder.add("oldPassword", old_pwd);
            builder.add("newPassword", new_pwd);

            final Request request = new Request.Builder()
                    .url("http://192.168.1.2:8080/mgr/user/updatePassword")
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

                    if (result.equals("0")) {
                        ToastUtil.showToast("修改成功");
                    }else {
                        ToastUtil.showToast("修改失败");
                    }
                }


            });
        }
        }

}
