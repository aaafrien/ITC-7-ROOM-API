package com.itc.weatherapi.service;

import com.itc.weatherapi.model.ListItem;
import com.itc.weatherapi.model.WeatherResponses;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherService {
    private Retrofit retrofit = null;

    public WeatherAPI getAPI() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(WeatherAPI.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(WeatherAPI.class);
    }

    public void getWeather(final WeatherListener<List<ListItem>> listener){
        getAPI().getWeather().enqueue(new Callback<WeatherResponses>() {
            @Override
            public void onResponse(Call<WeatherResponses> call, Response<WeatherResponses> response) {
                WeatherResponses data = response.body();

                if (data != null && data.getList() != null) {
                    listener.onSuccess(data.getList());
                }
            }

            @Override
            public void onFailure(Call<WeatherResponses> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}