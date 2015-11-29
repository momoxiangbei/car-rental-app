package com.momoxiangbei.rentalcar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.momoxiangbei.rentalcar.base.AppConfig;
import com.momoxiangbei.rentalcar.net.ServiceOpera;
import com.momoxiangbei.rentalcar.response.BaseResponse;
import com.momoxiangbei.rentalcar.utils.ToastUtil;
import com.momoxiangbei.rentalcar.utils.Utility;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by Administrator on 2015/11/4.
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_login;
    private TextView tv_register;
    private EditText et_phone;
    private EditText et_pwd;
    private EditText et_id_card;
    private EditText et_name;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_register);
    }

    @Override
    public void initView() {
        tv_login = (TextView) findViewById(R.id.tv_login);
        tv_register = (TextView) findViewById(R.id.tv_register);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        et_id_card = (EditText) findViewById(R.id.et_id_card);
        et_name = (EditText) findViewById(R.id.et_name);
    }

    @Override
    public void initParams() {
        tv_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
    }

    @Override
    public void initListeners() {

    }

    @Override
    public void onClick(View v) {
        if(v == tv_register){

            String phone = et_phone.getText().toString().trim();
            String pwd = et_pwd.getText().toString().trim();
            String id_card = et_id_card.getText().toString().trim();
            String name = et_name.getText().toString().trim();

            if (TextUtils.isEmpty(phone)){
                ToastUtil.showToast("请输入手机号码");
                return;
            }
            if (!Utility.isValidPhone(phone)){
                ToastUtil.showToast("请输入有效的手机号码");
                return;
            }
            if (TextUtils.isEmpty(name)){
                ToastUtil.showToast("请输入姓名");
                return;
            }
            if (TextUtils.isEmpty(pwd)){
                ToastUtil.showToast("请输入密码");
                return;
            }
            if (TextUtils.isEmpty(id_card)){
                ToastUtil.showToast("请输入身份证号码");
                return;
            }
            if (!Utility.isIDCard(id_card)){
                ToastUtil.showToast("请输入有效的身份证号码");
                return;
            }


            handRegister(phone,name,id_card,pwd);


        }else if (v == tv_login){
            LoginActivity.startActivity(this,false);
            finish();
        }
    }

    private void handRegister(final String phone, String name, String id_card, final String pwd) {

        OkHttpClient mOkHttpClient = new OkHttpClient();
        FormEncodingBuilder builder = new FormEncodingBuilder();
        builder.add("phoneName", phone);
        builder.add("name", name);
        builder.add("cardNum", id_card);
        builder.add("password", pwd);

        Request request = new Request.Builder()
                .url(AppConfig.BASEURL+"mgr/user/register")
                .post(builder.build())
                .build();

        com.squareup.okhttp.Call call = mOkHttpClient.newCall(request);
        call.enqueue(new com.squareup.okhttp.Callback()
        {
            @Override
            public void onFailure(Request request, IOException e)
            {

            }

            @Override
            public void onResponse(final com.squareup.okhttp.Response response) throws IOException
            {

                String result = response.body().string();
                if (result.equals("0")){
                    AppConfig.PHONE = phone;
                    AppConfig.PASSWORD = pwd;
                    MainActivity.startActivity(mContext);
                    finish();
                }else if (result.equals("-1")){
                    ToastUtil.showToast("此手机号码已经注册");
                }else {
                    ToastUtil.showToast("注册失败");
                }

            }
        });
    }



}
