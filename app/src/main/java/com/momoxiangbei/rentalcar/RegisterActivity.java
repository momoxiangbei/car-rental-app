package com.momoxiangbei.rentalcar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.momoxiangbei.rentalcar.utils.ToastUtil;
import com.momoxiangbei.rentalcar.utils.Utility;

/**
 * Created by Administrator on 2015/11/4.
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_login;
    private TextView tv_register;
    private EditText et_phone;
    private EditText et_pwd;
    private EditText et_id_card;

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
            if (TextUtils.isEmpty(id_card)){
                ToastUtil.showToast("请输入身份证号码");
                return;
            }
            if (!Utility.isIDCard(id_card)){
                ToastUtil.showToast("请输入有效的身份证号码");
                return;
            }


            handRegister(phone,id_card,pwd);


        }else if (v == tv_login){
            LoginActivity.startActivity(this);
            finish();
        }
    }

    private void handRegister(String phone, String id_card ,String pwd) {
        MainActivity.startActivity(this);
        finish();

    }
}
