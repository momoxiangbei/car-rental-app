package com.momoxiangbei.rentalcar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2015/11/6.
 */
public class ChangePwdActivity extends BaseTitleActivity {

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
    }

    @Override
    public void initParams() {

    }
}
