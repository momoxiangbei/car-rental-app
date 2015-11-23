package com.momoxiangbei.rentalcar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2015/11/6.
 */
public class SelectLocationActivity extends BaseTitleActivity {
    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_select_lacation);
    }

    public static void startActivity(Activity mActivity) {
        Intent intent = new Intent(mActivity, SelectLocationActivity.class);
        mActivity.startActivity(intent);
    }

    @Override
    public void initView() {
        super.initView();
        right.setVisibility(View.INVISIBLE);
        title.setText("发现");
    }


    @Override
    public void initParams() {

    }
}
