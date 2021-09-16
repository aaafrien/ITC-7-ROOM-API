package com.itc.weatherapi.service;

public interface WeatherListener<T> {
    void onSuccess(T items);
    void onFailed(String msg);
}
