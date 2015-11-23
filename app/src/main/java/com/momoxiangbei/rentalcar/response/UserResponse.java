package com.momoxiangbei.rentalcar.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2015/11/23.
 */
public class UserResponse implements Parcelable{
    public int user_id;
    public String name;
    public String user_phone;
    public int card_classify;
    public String card_num;

    public UserResponse(){

    }

    public UserResponse(Parcel in){
        user_id = in.readInt();
        name = in.readString();
        user_phone = in.readString();
        card_classify = in.readInt();
        card_num = in.readString();
    }

    public static final Creator<UserResponse> CREATOR = new Creator<UserResponse>() {
        @Override
        public UserResponse createFromParcel(Parcel in) {
            return new UserResponse(in);
        }

        @Override
        public UserResponse[] newArray(int size) {
            return new UserResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(user_id);
        dest.writeString(name);
        dest.writeString(user_phone);
        dest.writeInt(card_classify);
        dest.writeString(card_num);
    }

}
