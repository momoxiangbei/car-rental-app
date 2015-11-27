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
import com.momoxiangbei.rentalcar.RentalShortActivity;
import com.momoxiangbei.rentalcar.response.OrderDetail;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/6.
 */
public class RentalFindAdapter extends RecyclerView.Adapter<RentalFindAdapter.MyViewHolder>{

    private Context mContext;
    private ArrayList<OrderDetail> list = new ArrayList<OrderDetail>();

    public RentalFindAdapter(Context mContext, ArrayList<OrderDetail> list){

        this.mContext =  mContext;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rental_find, parent, false));
        return holder;

    }

    @Override
    public void onBindViewHolder(RentalFindAdapter.MyViewHolder holder, int position) {

        holder.tv_name.setText("宝马520");
        holder.tv_position.setText("杭州江干区下沙新雁公寓13号楼");

        holder.ll_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RentalShortActivity.startActivity(mContext);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 40;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        TextView tv_money;
        TextView tv_position;
        LinearLayout ll_root;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_money = (TextView) itemView.findViewById(R.id.tv_money);
            tv_position = (TextView) itemView.findViewById(R.id.tv_postion);
            ll_root = (LinearLayout) itemView.findViewById(R.id.ll_root);
        }
    }
}