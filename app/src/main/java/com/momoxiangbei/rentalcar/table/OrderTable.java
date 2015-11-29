package com.momoxiangbei.rentalcar.table;

import org.litepal.crud.DataSupport;

/**
 * Created by maidou on 2015/11/29.
 */
public class OrderTable  extends DataSupport {

    public String position;
    public String data;
    public String data_back;
    public String car_type;
    public String extra;
    public String note;
    public int rental_type;


    public void setRental_type(int rental_type) {
        this.rental_type = rental_type;
    }

    public int getRental_type() {
        return rental_type;
    }

    public String getPosition() {
        return position;
    }

    public String getData() {
        return data;
    }

    public String getData_back() {
        return data_back;
    }

    public String getCar_type() {
        return car_type;
    }

    public String getExtra() {
        return extra;
    }

    public String getNote() {
        return note;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setData_back(String data_back) {
        this.data_back = data_back;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
