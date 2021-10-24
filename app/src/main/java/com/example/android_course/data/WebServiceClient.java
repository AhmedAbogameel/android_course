package com.example.android_course.data;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Map;

public class WebServiceClient {
    private final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private final String appId = "be2acbcfe99b5fe0e4e59c3b35c3dd23";
    private final WebServiceInterface webServiceInterface;
    private static WebServiceClient INSTANCE;

    public WebServiceClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
        ).build();
        webServiceInterface = retrofit.create(WebServiceInterface.class);
    }

    public static WebServiceClient getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new WebServiceClient();
        }
        return INSTANCE;
    }

    public Call<Map<Object, Object>> getWeather(double lat, double lng) {
        return webServiceInterface.getWeather(lat, lng, appId);
    }

}