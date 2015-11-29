package com.momoxiangbei.rentalcar;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.momoxiangbei.rentalcar.base.AppConfig;
import com.momoxiangbei.rentalcar.net.ServiceOpera;
import com.momoxiangbei.rentalcar.response.BaseResponse;
import com.momoxiangbei.rentalcar.response.User;
import com.momoxiangbei.rentalcar.table.UserTable;
import com.momoxiangbei.rentalcar.utils.ToastUtil;
import com.momoxiangbei.rentalcar.utils.Utility;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.litepal.crud.DataSupport;

import java.io.IOException;


/**
 * Created by Administrator on 2015/11/4.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_login;
    private TextView tv_register;
    private EditText et_phone;
    private EditText et_pwd;

    private static Boolean is_logOut = false;

    public static void startActivity(Context context,Boolean is_logout) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
        is_logOut = is_logout;
    }

    @Override
    public void create(Bundle bundle) {

        setContentView(R.layout.activity_login);
        UserTable user = DataSupport.find(UserTable.class, 1);
        if (user!= null && !user.getUser_phone().equals("0") && user.getPassword()!=null){
            MainActivity.startActivity(mContext);
            finish();
        }
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

            handLogin(phone,pwd);
            
        }else if (v == tv_register){
            RegisterActivity.startActivity(this);
            finish();
        }
    }


    private void handLogin(final String phone, final String pwd) {

        OkHttpClient mOkHttpClient = new OkHttpClient();
        FormEncodingBuilder builder = new FormEncodingBuilder();
        UserTable user = DataSupport.find(UserTable.class, 1);
        builder.add("phoneName", user.getUser_phone());
        builder.add("password", user.getPassword());

        Request request = new Request.Builder()
                .url(AppConfig.BASEURL+"mgr/user/login")
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

                    UserTable user = new UserTable();
                    user.setUser_phone(phone);
                    user.setPassword(pwd);
                    user.save();

                    ContentValues values = new ContentValues();
                    values.put("user_phone", phone);
                    values.put("password", pwd);
                    DataSupport.updateAll(UserTable.class, values);

                    MainActivity.startActivity(mContext);
                    finish();
                }else {
                    ToastUtil.showToast("登录失败");
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (is_logOut){
            ToastUtil.showToast("请先登录！");
        }
    }
}
