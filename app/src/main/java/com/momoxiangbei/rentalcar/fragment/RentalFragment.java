package com.momoxiangbei.rentalcar.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.momoxiangbei.rentalcar.R;
import com.momoxiangbei.rentalcar.RentalFindActivity;
import com.momoxiangbei.rentalcar.RentalLongAcitvity;
import com.momoxiangbei.rentalcar.RentalShortActivity;

/**
 * Created by Administrator on 2015/11/4.
 */
public class RentalFragment extends BaseTitleFragment implements View.OnClickListener {

    private FrameLayout fl_find;
    private FrameLayout fl_short;
    private FrameLayout fl_long;


    @Override
    public void create(Bundle bundle) {

    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_retal;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        title.setText("租车");

        fl_find = (FrameLayout) view.findViewById(R.id.fl_find);
        fl_short = (FrameLayout) view.findViewById(R.id.fl_short);
        fl_long = (FrameLayout) view.findViewById(R.id.fl_long);
    }

    @Override
    public void initParams() {

    }

    @Override
    public void initListeners() {
        fl_find.setOnClickListener(this);
        fl_short.setOnClickListener(this);
        fl_long.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == fl_find){
            RentalFindActivity.startActivity(mActivity);

        }else if (v == fl_short){
            RentalShortActivity.startActivity(mActivity);

        }else if (v == fl_long){
            RentalLongAcitvity.startActivity(mActivity);

        }
    }
}
