package com.momoxiangbei.rentalcar.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.momoxiangbei.rentalcar.R;
import com.momoxiangbei.rentalcar.base.AppConfig;
import com.momoxiangbei.rentalcar.response.CarDetail;
import com.momoxiangbei.rentalcar.table.OrderTable;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/6.
 */
public class SelectCarTypeAdapter extends RecyclerView.Adapter<SelectCarTypeAdapter.MyViewHolder>{

    private Context mContext;
    private ArrayList<CarDetail> carDetail;




    public SelectCarTypeAdapter(Context context, ArrayList<CarDetail> carDetail) {
        this.mContext = context;
        this.carDetail = carDetail;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_select_car_type, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position)
    {
        try {
            holder.tv_name.setText(carDetail.get(position).carType);
            holder.tv_extra.setText(carDetail.get(position).memo);
            holder.tv_num.setText(carDetail.get(position).carNumber);
            holder.tv_money.setText(carDetail.get(position).price);
        } catch (Exception e) {
            e.printStackTrace();
        }


        holder.ll_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    AppConfig.car_type = carDetail.get(position).carType;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return carDetail.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv_name;
        TextView tv_num;
        TextView tv_extra;
        TextView tv_money;
        LinearLayout ll_root;

        public MyViewHolder(View view)
        {
            super(view);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_money = (TextView) view.findViewById(R.id.tv_money);
            tv_extra = (TextView) view.findViewById(R.id.tv_extra);
            tv_num = (TextView) view.findViewById(R.id.tv_num);
            ll_root = (LinearLayout) view.findViewById(R.id.ll_root);
        }
    }
}