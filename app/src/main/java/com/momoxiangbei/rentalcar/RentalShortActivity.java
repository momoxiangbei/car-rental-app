package com.momoxiangbei.rentalcar;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.momoxiangbei.rentalcar.adapter.SelectPositionAdapter;
import com.momoxiangbei.rentalcar.base.AppConfig;
import com.momoxiangbei.rentalcar.response.OrderDetail;
import com.momoxiangbei.rentalcar.table.OrderTable;
import com.momoxiangbei.rentalcar.table.UserTable;
import com.momoxiangbei.rentalcar.utils.DateTimePickDialogUtil;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2015/11/6.
 */
public class RentalShortActivity extends BaseTitleActivity implements View.OnClickListener {

    private TextView tv_next;
    private EditText et_date;
    private EditText et_data_back;
    private RelativeLayout rl_position;
    private RelativeLayout rl_car_type;
    private TextView tv_position;
    private TextView tv_car_type;


    private String initStartDateTime = "2016年2月1日 12:00";
    private String initEndDateTime = "2016年2月1日 12:00";
    private static String position;
    private static String car_type;

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_rental_short);

        OrderTable order = new OrderTable();
        order.setRental_type(1);
        order.save();

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!TextUtils.isEmpty(AppConfig.position)){
            position = AppConfig.position;
            tv_position.setText(position);

        }
        if (!TextUtils.isEmpty(AppConfig.car_type)){
            car_type = AppConfig.car_type;
            tv_car_type.setText(car_type);

        }

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
        et_date = (EditText) findViewById(R.id.et_date);
        et_data_back = (EditText) findViewById(R.id.et_date_back);
        rl_position = (RelativeLayout) findViewById(R.id.rl_position);
        rl_car_type= (RelativeLayout) findViewById(R.id.rl_car_type);
        tv_position = (TextView) findViewById(R.id.tv_position);
        tv_car_type = (TextView) findViewById(R.id.tv_car_type);

    }

    @Override
    public void initListeners() {
        super.initListeners();
        tv_next.setOnClickListener(this);
        et_date.setOnClickListener(this);
        et_data_back.setOnClickListener(this);
        rl_position.setOnClickListener(this);
        rl_car_type.setOnClickListener(this);
    }

    @Override
    public void initParams() {


    }

    @Override
    public void onClick(View v) {
        if (v == tv_next){
            RentalShortSelectActivity.startActivity(this);
        }else if (v == et_date){
            DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(
                    RentalShortActivity.this, initStartDateTime);
            dateTimePicKDialog.dateTimePicKDialog(et_date);
            AppConfig.date = DateTimePickDialogUtil.dateTime;

            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (v == et_data_back){
            DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(
                    RentalShortActivity.this, initEndDateTime);
            dateTimePicKDialog.dateTimePicKDialog(et_data_back);
            AppConfig.date_back = DateTimePickDialogUtil.dateTime;
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (v == rl_position){

            SelectLocationActivity.startActivity(this);
        }else if (v == rl_car_type){
            SelectCarTypeActivity.startActivity(this);
        }
    }



    @Override
    public void finish() {
        super.finish();

    }



}
