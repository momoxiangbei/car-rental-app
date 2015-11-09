package com.momoxiangbei.rentalcar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/11/7.
 */
public class LongSelectActivity extends BaseTitleActivity implements View.OnClickListener {

    private TextView tv_next;

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_long_select);
    }

    @Override
    public void initView() {
        super.initView();
        right.setVisibility(View.INVISIBLE);

        tv_next = (TextView) findViewById(R.id.tv_next);
    }

    @Override
    public void initParams() {

    }

    @Override
    public void initListeners() {
        super.initListeners();
        tv_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tv_next){

        }
    }
}
