package com.momoxiangbei.rentalcar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.momoxiangbei.rentalcar.OrderDetailActivity;
import com.momoxiangbei.rentalcar.R;
import com.momoxiangbei.rentalcar.response.Order;
import com.momoxiangbei.rentalcar.response.OrderDetail;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/6.
 */
public class OrderManagerAdapter extends RecyclerView.Adapter<OrderManagerAdapter.MyViewHolder>{

    private Context mContext;
    private ArrayList<Order> list = new ArrayList<Order>();

    public OrderManagerAdapter(Context mContext,ArrayList<Order> list){

        this.mContext =  mContext;
        this.list = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_order_manager, parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(OrderManagerAdapter.MyViewHolder holder, final int position) {

        holder.tv_order_num.setText(list.get(position).orderId);


        holder.ll_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderDetailActivity.orderId = list.get(position).orderId;
                OrderDetailActivity.startActivity(mContext,false);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_order_num;
        TextView tv_status;
        TextView tv_car_type;
        TextView tv_expense;
        LinearLayout ll_root;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_order_num = (TextView) itemView.findViewById(R.id.tv_order_num);
            tv_status = (TextView) itemView.findViewById(R.id.tv_status);
            tv_car_type = (TextView) itemView.findViewById(R.id.tv_car_type);
            tv_expense = (TextView) itemView.findViewById(R.id.tv_expense);
            ll_root = (LinearLayout) itemView.findViewById(R.id.ll_root);
        }
    }
}