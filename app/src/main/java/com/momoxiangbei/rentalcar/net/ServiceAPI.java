package com.momoxiangbei.rentalcar.net;

import com.momoxiangbei.rentalcar.response.BaseResponse;
import com.momoxiangbei.rentalcar.response.UserResponse;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Administrator on 2015/11/23.
 */
public interface ServiceAPI  {

    @FormUrlEncoded
    @POST("/user/getuserinfo")
    Call<UserResponse> setUserInfo(
        @Field("user_nickname") String user_phone
    );

    @FormUrlEncoded
    @POST("/user/getuserinfo")
    Call<BaseResponse> verifiedLogin(
         @Field("user_name") String user_phone,
         @Field("user_pwd") String user_pwd
    );

}
