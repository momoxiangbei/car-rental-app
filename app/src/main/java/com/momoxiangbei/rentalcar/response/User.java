package com.momoxiangbei.rentalcar.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by maidou on 2015/11/28.
 */
public class User implements Parcelable {

    public String name;
    public String user_phone;
    public String password;
    public String card_num;

    public User(){

    }

    public User(Parcel in) {
        name = in.readString();
        user_phone = in.readString();
        card_num = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(user_phone);
        dest.writeString(card_num);
    }
}
