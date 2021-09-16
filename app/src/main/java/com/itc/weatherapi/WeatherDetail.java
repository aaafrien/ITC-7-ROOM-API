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

    int id;
    Double temp;
    String cuaca, tempat, country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);

        for (int value : textViewId) textViews.add(findViewById(value));

        getData();
        setData();
    }

    private void setData() {
        Log.d("Cek data", "Data di set");
        textViews.get(0).setText(String.valueOf(temp));
        textViews.get(1).setText(cuaca);
        textViews.get(2).setText(tempat);
        textViews.get(3).setText(country);
    }

    private void getData() {
        if (
                getIntent().hasExtra("id") &&
                        getIntent().hasExtra("temp") &&
                        getIntent().hasExtra("cuaca") &&
                        getIntent().hasExtra("tempat") &&
                        getIntent().hasExtra("country")
        ) {
            Log.d("Cek data", "Data isseo");
            id = getIntent().getIntExtra("id",0);
            temp = getIntent().getDoubleExtra("temp", 0);
            cuaca = getIntent().getStringExtra("cuaca");
            tempat = getIntent().getStringExtra("tempat");
            country = getIntent().getStringExtra("country");
        } else {
            Log.d("Cek data", "Gagal");
        }
    }
}