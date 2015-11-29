package com.momoxiangbei.rentalcar;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.momoxiangbei.rentalcar.base.AppConfig;
import com.momoxiangbei.rentalcar.table.UserTable;
import com.momoxiangbei.rentalcar.utils.ToastUtil;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import org.litepal.crud.DataSupport;

import java.io.IOException;

/**
 * Created by Administrator on 2015/11/4.
 */
public class FeedbackActivity extends BaseTitleActivity implements View.OnClickListener {

    private EditText ed_feedback_content;
    private TextView tv_submit;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, FeedbackActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initView() {
        super.initView();
        right.setVisibility(View.INVISIBLE);
        title.setText("问题反馈");

        ed_feedback_content = (EditText) findViewById(R.id.ed_feedback_content);
        tv_submit = (TextView) findViewById(R.id.tv_submit);
    }


    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_feedback);
    }

    @Override
    public void initParams() {

    }

    @Override
    public void initListeners() {
        super.initListeners();
        tv_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tv_submit){

            if (TextUtils.isEmpty(ed_feedback_content.getText().toString().trim())){
                ToastUtil.showToast("请输入反馈内容！");
                return;
            }

            OkHttpClient mOkHttpClient = new OkHttpClient();
            FormEncodingBuilder builder = new FormEncodingBuilder();
            UserTable user = DataSupport.find(UserTable.class, 1);
            builder.add("phoneName", user.getUser_phone());
            builder.add("password", user.getPassword());
            builder.add("content", ed_feedback_content.getText().toString().trim());

            final Request request = new Request.Builder()
                    .url("http://192.168.1.2:8080/mgr/feedback/feedQuestion")
                    .post(builder.build())
                    .build();

            waiting("请稍等...");
            com.squareup.okhttp.Call call = mOkHttpClient.newCall(request);
            call.enqueue(new com.squareup.okhttp.Callback() {
                @Override
                public void onFailure(Request request, IOException e) {

                }

                @Override
                public void onResponse(final com.squareup.okhttp.Response response) throws IOException {
                    stopWaiting();
                    String result = response.body().string();
                    if (result.equals("0")){
                        ToastUtil.showToast("反馈成功！");
                    }else {
                        ToastUtil.showToast("提交失败！");
                    }
                }

            });
        }
    }
}
