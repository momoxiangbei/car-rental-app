package com.momoxiangbei.rentalcar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.momoxiangbei.rentalcar.adapter.RentalFindAdapter;

/**
 * Created by Administrator on 2015/11/6.
 */
public class RentalFindActivity extends BaseTitleActivity {

    private RentalFindAdapter mAdapter;
    private RecyclerView mRecycler;

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_rental_find);
    }

    public static void startActivity(Activity mActivity) {
        Intent intent = new Intent(mActivity, RentalFindActivity.class);
        mActivity.startActivity(intent);
    }

    @Override
    public void initView() {
        super.initView();
        right.setVisibility(View.INVISIBLE);
        title.setText("发现");

        mRecycler = (RecyclerView) findViewById(R.id.recycler);
    }


    @Override
    public void initParams() {
        mAdapter = new RentalFindAdapter(this,null);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapter(mAdapter);
    }
}
