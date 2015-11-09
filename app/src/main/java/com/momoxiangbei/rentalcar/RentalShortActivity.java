package com.momoxiangbei.rentalcar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2015/11/6.
 */
public class RentalShortActivity extends BaseTitleActivity {
    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_rental_short);
    }

    public static void startActivity(Activity mActivit) {
        Intent intent = new Intent(mActivit, RentalShortActivity.class);
        mActivit.startActivity(intent);
    }

    @Override
    public void initView() {
        super.initView();
        right.setVisibility(View.INVISIBLE);
        title.setText("短租");
    }

    @Override
    public void initParams() {

    }
}
