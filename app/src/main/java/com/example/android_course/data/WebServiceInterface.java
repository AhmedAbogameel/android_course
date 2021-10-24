package com.example.android_course.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

public interface WebServiceInterface {

    @GET("weather")
    public Call<Map<Object, Object>> getWeather(@Query("lat") double lat, @Query("lon") double lng, @Query("appid") String appId);

}
