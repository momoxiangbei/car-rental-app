package com.momoxiangbei.rentalcar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextDirectionHeuristic;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/11/6.
 */
public class RentalShortActivity extends BaseTitleActivity implements View.OnClickListener {

    private TextView tv_next;

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_rental_short);
    }

    public static void startActivity(Activity mActivit) {
        Intent intent = new Intent(mActivit, RentalShortActivity.class);
        mActivit.startActivity(intent);
    }

    public static void startActivity(Context mActivit) {
        Intent intent = new Intent(mActivit, RentalShortActivity.class);
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
            RentalShortSelectActivity.startActivity(this);
        }
    }
}
