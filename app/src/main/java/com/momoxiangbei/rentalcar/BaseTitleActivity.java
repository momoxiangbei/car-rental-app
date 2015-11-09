package com.momoxiangbei.rentalcar;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/11/4.
 */
public abstract class BaseTitleActivity extends BaseActivity {

    protected RelativeLayout left;
    protected TextView title;
    protected TextView right;

    @Override
    public void initView() {
        left = (RelativeLayout) findViewById(R.id.left);
        title = (TextView) findViewById(R.id.title);
        right = (TextView) findViewById(R.id.right);
    }

    @Override
    public void initListeners() {
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
