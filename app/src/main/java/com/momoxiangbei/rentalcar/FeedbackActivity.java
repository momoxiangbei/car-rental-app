package com.momoxiangbei.rentalcar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2015/11/4.
 */
public class FeedbackActivity extends BaseTitleActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, FeedbackActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_feedback);
    }

    @Override
    public void initParams() {

    }
}
