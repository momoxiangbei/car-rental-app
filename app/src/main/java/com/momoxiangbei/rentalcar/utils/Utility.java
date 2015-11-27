package com.momoxiangbei.rentalcar.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/11/27.
 */
public class Utility {

    /**
     * 隐藏软键盘
     */
    public static void hideSoftInputFromWindow(Context context, View view) {
        try {
            InputMethodManager imm = (InputMethodManager) context
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.RESULT_UNCHANGED_SHOWN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 开启软键盘
     */
    public static void showSoftInputFromWindow(Context context, View view) {
        ((InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE))
                .showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }


    /**
     * 是否是有效的手机号
     */
    public static boolean isValidPhone(String phoneNum) {
        if (TextUtils.isEmpty(phoneNum)) {
            return false;
        }
        String reg = "^[0-9]{11}$";
        return phoneNum.matches(reg);
    }

    /**
     * 校验身份证
     */
    public static boolean isIDCard(String idCard) {

        String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";
        if (TextUtils.isEmpty(idCard)) {
            return false;
        }
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

}
