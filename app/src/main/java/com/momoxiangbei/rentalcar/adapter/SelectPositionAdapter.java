package com.momoxiangbei.rentalcar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.momoxiangbei.rentalcar.R;
import com.momoxiangbei.rentalcar.base.AppConfig;
import com.momoxiangbei.rentalcar.response.Shop;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/6.
 */
public class SelectPositionAdapter extends RecyclerView.Adapter<SelectPositionAdapter.MyViewHolder>
{

    private Context mContext;
    private ArrayList<Shop> shop;

    public SelectPositionAdapter(Context mContext, ArrayList<Shop> shop) {
        this.mContext = mContext;
        this.shop = shop;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_select_position, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position)
    {
        try {
            holder.tv_name.setText(shop.get(position).shopName);
            holder.tv_position.setText(shop.get(position).position);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.ll_root.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 try {
                     AppConfig.position = shop.get(position).position;
                     AppConfig.shop_id = shop.get(position).id;

                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
         });
    }

    @Override
    public int getItemCount()
    {
        return shop.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv_name;
        TextView tv_position;
        LinearLayout ll_root;

        public MyViewHolder(View view)
        {
            super(view);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_position = (TextView) view.findViewById(R.id.tv_position);
            ll_root = (LinearLayout) view.findViewById(R.id.ll_root);
        }
    }
}