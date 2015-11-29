package com.momoxiangbei.rentalcar.table;

import org.litepal.crud.DataSupport;

/**
 * Created by maidou on 2015/11/29.
 */
public class UserTable extends DataSupport {
    public String user_phone;
    public String password;

    public String getUser_phone() {
        return user_phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
