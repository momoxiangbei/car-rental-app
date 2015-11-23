package com.momoxiangbei.rentalcar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/11/6.
 */
public class RentalShortSelectActivity extends BaseTitleActivity implements View.OnClickListener {

    private TextView tv_next;

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_short_select);
    }

    public static void startActivity(Activity mActivit) {
        Intent intent = new Intent(mActivit, RentalShortSelectActivity.class);
        mActivit.startActivity(intent);
    }

    @Override
    public void initView() {
        super.initView();
        right.setVisibility(View.INVISIBLE);
        title.setText("短租");

        tv_next = (TextView) findViewById(R.id.tv_next);

    }

    @Override
    public void initListeners() {
        super.initListeners();
        tv_next.setOnClickListener(this);
    }

    @Override
    public void initParams() {

    }

    @Override
    public void onClick(View v) {
        if (v == tv_next){
            OrderDetailActivity.startActivity(this);
        }
    }
}
