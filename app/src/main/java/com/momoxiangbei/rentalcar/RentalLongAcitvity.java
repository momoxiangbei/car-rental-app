package com.momoxiangbei.rentalcar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.momoxiangbei.rentalcar.utils.DateTimePickDialogUtil;

/**
 * Created by Administrator on 2015/11/6.
 */
public class RentalLongAcitvity extends BaseTitleActivity implements View.OnClickListener {

    private TextView tv_next;
    private EditText et_date;
    private String initStartDateTime = "2016年2月1日 12:00";
    private String initEndDateTime = "2016年2月1日 12:00";

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_rental_long);
    }

    public static void startActivity(Activity mActivit) {
        Intent intent = new Intent(mActivit, RentalLongAcitvity.class);
        mActivit.startActivity(intent);
    }

    @Override
    public void initView() {
        super.initView();
        right.setVisibility(View.INVISIBLE);
        title.setText("长租");
        tv_next = (TextView) findViewById(R.id.tv_next);
        et_date = (EditText) findViewById(R.id.et_date);
    }

    @Override
    public void initListeners() {
        super.initListeners();
        tv_next.setOnClickListener(this);
        et_date.setOnClickListener(this);
    }

    @Override
    public void initParams() {

    }

    @Override
    public void onClick(View v) {
        if (v == tv_next){
            RentalLongSelectAcitvity.startActivity(this);
        }else if (v == et_date){
            DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(
                    RentalLongAcitvity.this, initEndDateTime);
            dateTimePicKDialog.dateTimePicKDialog(et_date);
        }
    }
}
