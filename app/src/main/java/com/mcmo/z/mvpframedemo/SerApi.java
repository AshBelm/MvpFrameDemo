package com.mcmo.z.mvpframedemo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SerApi {

    @GET("api/weather/city/{id}")
    Call<ResponseBody> requestBaidu(@Path("id")int id);
}
