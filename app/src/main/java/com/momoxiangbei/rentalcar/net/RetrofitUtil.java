package com.momoxiangbei.rentalcar.net;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Administrator on 2015/11/23.
 */
public class RetrofitUtil {
    private static Retrofit singleton;

    public static <T> T createApi(Class<T> clazz) {
        if (singleton == null) {
            synchronized (RetrofitUtil.class) {
                if (singleton == null) {
                    Retrofit.Builder builder = new Retrofit.Builder();
                    builder.baseUrl("http://api.nuuneoi.com/base/");
                    builder.addConverterFactory(GsonConverterFactory.create());
                    singleton = builder.build();
                }
            }
        }
        return singleton.create(clazz);
    }

    public static void u(){

    }
}
