package com.momoxiangbei.rentalcar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2015/11/4.
 */
public class LoginActivity extends BaseTitleActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_login);
    }

    @Override
    public void initParams() {

    }
}
