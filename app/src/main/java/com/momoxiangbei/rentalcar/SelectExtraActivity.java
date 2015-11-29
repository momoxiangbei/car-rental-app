package com.momoxiangbei.rentalcar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/11/6.
 */
public class SelectExtraActivity extends BaseTitleActivity implements View.OnClickListener {

    private int resultCode = 0;

    private TextView tv_need_one;
    private TextView tv_need_two;
    private TextView tv_need_three;
    private Intent intent;

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_select_extra);

        intent = new Intent();

    }


    @Override
    public void initView() {
        super.initView();
        right.setVisibility(View.INVISIBLE);
        title.setText("选择附加功能");

        tv_need_one = (TextView) findViewById(R.id.tv_need_one);
        tv_need_two = (TextView) findViewById(R.id.tv_need_two);
        tv_need_three = (TextView) findViewById(R.id.tv_need_three);

    }


    @Override
    public void initParams() {


    }

    @Override
    public void initListeners() {
        super.initListeners();
        tv_need_one.setOnClickListener(this);
        tv_need_two.setOnClickListener(this);
        tv_need_three.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tv_need_one){
            intent.putExtra("need", "需要代驾");
            this.setResult(resultCode, intent);
            finish();
        }else if (v == tv_need_two){
            intent.putExtra("need", "需要儿童座椅");
            this.setResult(resultCode, intent);
            finish();
        }else if (v == tv_need_three){
            intent.putExtra("need", "需要加满油");
            this.setResult(resultCode, intent);
            finish();
        }
    }
}
