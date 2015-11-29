package com.momoxiangbei.rentalcar.dialog;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.momoxiangbei.rentalcar.R;
import com.momoxiangbei.rentalcar.adapter.SelectPositionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maidou on 2015/11/29.
 */
public class SelectPositionDialog extends BaseDialog{

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private SelectPositionAdapter mAdapter;
    private static Context mContext;
    private SelectPositionAdapter PositionCallBack;


    public SelectPositionDialog(Context context, int theme) {
        super(context, theme);
        mContext = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_select_postion;
    }

    @Override
    protected void initViews(View root) {

        initData();
        mRecyclerView = (RecyclerView) root.findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//        mRecyclerView.setAdapter(mAdapter = new SelectPositionAdapter(mContext));
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
            }
    }


}






