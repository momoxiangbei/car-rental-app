package com.momoxiangbei.rentalcar.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2015/11/6.
 */
public class OrderDetail implements Parcelable {

    public String order_num;
    public Boolean status;
    public String car_type;
    public String expense;

    public OrderDetail(){

    }

    public OrderDetail(Parcel in) {
        order_num = in.readString();
        status = in.readInt() == 1;
        car_type = in.readString();
        expense = in.readString();

    }

    public static final Creator<OrderDetail> CREATOR = new Creator<OrderDetail>() {
        @Override
        public OrderDetail createFromParcel(Parcel in) {
            return new OrderDetail(in);
        }

        @Override
        public OrderDetail[] newArray(int size) {
            return new OrderDetail[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(order_num);
        dest.writeInt(status ? 1 : 0);
        dest.writeString(car_type);
        dest.writeString(expense);

    }
}
