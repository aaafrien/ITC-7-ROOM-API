package com.itc.weatherapi.service;

import com.itc.weatherapi.model.WeatherResponses;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherAPI {
    String URL_BASE = "https://api.openweathermap.org/";
    String key = "b2989fcc6c855a9ef6bc3a9f10bc947f";

    @GET("https://api.openweathermap.org/data/2.5/find?lat=37.53&lon=127.02&cnt=10&appid=" + key)
    Call<WeatherResponses> getWeather();
}
