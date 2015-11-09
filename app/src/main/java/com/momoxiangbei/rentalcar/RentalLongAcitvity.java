package com.momoxiangbei.rentalcar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2015/11/6.
 */
public class RentalLongAcitvity extends BaseTitleActivity {
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
    }


    @Override
    public void initParams() {

    }
}
