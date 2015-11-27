package com.momoxiangbei.rentalcar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.momoxiangbei.rentalcar.net.ServiceOpera;
import com.momoxiangbei.rentalcar.response.BaseResponse;
import com.momoxiangbei.rentalcar.utils.ToastUtil;
import com.momoxiangbei.rentalcar.utils.Utility;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by Administrator on 2015/11/4.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_login;
    private TextView tv_register;
    private EditText et_phone;
    private EditText et_pwd;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_login);
    }

    @Override
    public void initView() {
        tv_login = (TextView) findViewById(R.id.tv_login);
        tv_register = (TextView) findViewById(R.id.tv_register);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
    }

    @Override
    public void initParams() {

    }

    @Override
    public void initListeners() {
        tv_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == tv_login){

            String phone = et_phone.getText().toString().trim();
            String pwd = et_pwd.getText().toString().trim();

            //// TODO: 2015/11/27
            handLogin(phone,pwd);

            if (TextUtils.isEmpty(phone)){
                ToastUtil.showToast("请输入手机号码");
                return;
            }
            if (!Utility.isValidPhone(phone)){
                ToastUtil.showToast("请输入有效的手机号码");
                return;
            }
            if (TextUtils.isEmpty(pwd)){
                ToastUtil.showToast("请输入密码");
                return;
            }

            


        }else if (v == tv_register){
            RegisterActivity.startActivity(this);
            finish();
        }
    }

    private void handLogin(String phone, String pwd) {

        //// TODO: 2015/11/27
        MainActivity.startActivity(this);
        finish();

        final BaseResponse mResponse = new BaseResponse();
        final Call<BaseResponse> call = ServiceOpera.serviceAPI.verifiedLogin(phone, pwd);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Response<BaseResponse> response) {

                if (response.body()!=null){
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }


}
