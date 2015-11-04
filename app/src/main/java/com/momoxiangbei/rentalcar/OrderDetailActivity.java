package com.momoxiangbei.rentalcar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2015/11/4.
 */
public class OrderDetailActivity extends BaseTitleActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_order_detail);
    }

    @Override
    public void initParams() {

    }
}
