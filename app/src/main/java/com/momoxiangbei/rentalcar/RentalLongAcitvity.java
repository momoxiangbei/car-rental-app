package com.momoxiangbei.rentalcar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.momoxiangbei.rentalcar.utils.DateTimePickDialogUtil;
import com.momoxiangbei.rentalcar.utils.ToastUtil;

/**
 * Created by Administrator on 2015/11/6.
 */
public class RentalLongAcitvity extends BaseTitleActivity implements View.OnClickListener {

    private TextView tv_next;
    private EditText et_date;

    private RelativeLayout rl_car_type;
    private RelativeLayout rl_position;


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
        rl_car_type = (RelativeLayout) findViewById(R.id.rl_car_type);
        rl_position = (RelativeLayout) findViewById(R.id.rl_position);
    }

    @Override
    public void initListeners() {
        super.initListeners();
        tv_next.setOnClickListener(this);
        et_date.setOnClickListener(this);
        rl_car_type.setOnClickListener(this);
        rl_position.setOnClickListener(this);
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

        }else if (v == rl_position){

            SelectLocationActivity.startActivity(this);

        }else if (v == rl_car_type){

            SelectCarTypeActivity.startActivity(this);
        }
    }


}
