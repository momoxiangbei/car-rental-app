package com.momoxiangbei.rentalcar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/11/4.
 */
public class PersonalDatailActivity extends BaseTitleActivity implements View.OnClickListener {

    private FrameLayout fl_change_pwd;
    private TextView tv_sign_out;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, PersonalDatailActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initView() {
        super.initView();
        title.setText("个人信息");
        fl_change_pwd = (FrameLayout) findViewById(R.id.fl_change_pwd);
        tv_sign_out= (TextView) findViewById(R.id.tv_sign_out);
    }

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_personal_details);
    }

    @Override
    public void initParams() {

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
            LoginActivity.startActivity(this);
        }
    }
}
