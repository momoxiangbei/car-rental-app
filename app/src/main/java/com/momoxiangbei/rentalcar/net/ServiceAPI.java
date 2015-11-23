package com.momoxiangbei.rentalcar.net;

import com.momoxiangbei.rentalcar.response.UserResponse;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Administrator on 2015/11/23.
 */
public interface ServiceAPI  {

    @FormUrlEncoded
    @POST("/user/getuserinfo")
    UserResponse setUserInfo(
        @Field("user_nickname") String user_phone
    );

}
