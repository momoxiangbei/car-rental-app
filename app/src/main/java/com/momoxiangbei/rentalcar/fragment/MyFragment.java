package com.momoxiangbei.rentalcar.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.momoxiangbei.rentalcar.BaseTitleActivity;
import com.momoxiangbei.rentalcar.FeedbackActivity;
import com.momoxiangbei.rentalcar.MessageActivity;
import com.momoxiangbei.rentalcar.OrderManagerActivity;
import com.momoxiangbei.rentalcar.PersonalDatailActivity;
import com.momoxiangbei.rentalcar.R;
import com.momoxiangbei.rentalcar.RegisterActivity;

/**
 * Created by Administrator on 2015/11/4.
 */
public class MyFragment extends BaseTitleFragment implements View.OnClickListener {

    private RelativeLayout rl_my_message;
    private RelativeLayout rl_my_order;
    private RelativeLayout rl_my_feedback;
    private RelativeLayout rl_my_detail;

    @Override
    public void create(Bundle bundle) {

    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_my;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        title.setText("我的");

        rl_my_message = (RelativeLayout) view.findViewById(R.id.rl_my_message);
        rl_my_order = (RelativeLayout) view.findViewById(R.id.rl_my_order);
        rl_my_feedback = (RelativeLayout) view.findViewById(R.id.rl_my_feedback);
        rl_my_detail = (RelativeLayout) view.findViewById(R.id.rl_my_detail);
    }

    @Override
    public void initParams() {

    }

    @Override
    public void initListeners() {
        rl_my_message.setOnClickListener(this);
        rl_my_order.setOnClickListener(this);
        rl_my_feedback.setOnClickListener(this);
        rl_my_detail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == rl_my_message){
            MessageActivity.startActivity(mActivity);

        }else if (v == rl_my_order){
            OrderManagerActivity.startActivity(mActivity);

        }else if (v == rl_my_feedback){
            FeedbackActivity.startActivity(mActivity);

        }else if (v == rl_my_detail){
            PersonalDatailActivity.startActivity(mActivity);

        }
    }
}
