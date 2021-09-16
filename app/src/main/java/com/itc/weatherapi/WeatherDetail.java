package com.itc.weatherapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherDetail extends AppCompatActivity {
    ArrayList<TextView> textViews = new ArrayList<>();
    private int[] textViewId = {
            R.id.tv_temp,
            R.id.tv_cuaca,
            R.id.tv_tempat,
            R.id.tv_country
    };

    Double temp;
    String cuaca, tempat, country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);

        for (int value : textViewId) textViews.add(findViewById(value));

        if (
                getIntent().hasExtra("id") &&
                        getIntent().hasExtra("nama") &&
                        getIntent().hasExtra("coord") &&
                        getIntent().hasExtra("main") &&
                        getIntent().hasExtra("dt") &&
                        getIntent().hasExtra("wind") &&
                        getIntent().hasExtra("country") &&
                        getIntent().hasExtra("rain") &&
                        getIntent().hasExtra("snow") &&
                        getIntent().hasExtra("clouds") &&
                        getIntent().hasExtra("weather")
        ) {
            Log.d("Cek data", "Data isseo");
            temp = getIntent().getStringExtra("main");
            cuaca = getIntent().getStringExtra("weather");
            tempat = getIntent().getStringExtra("nama");
            country = getIntent().getStringExtra("country");
        } else {
            Log.d("Cek data", "Data gagal");
        }

        Log.d("Cek data", "Data di set");
        textViews.get(0).setText(temp);
        textViews.get(1).setText(cuaca);
        textViews.get(2).setText(tempat);
        textViews.get(3).setText(country);
    }
}