package com.itc.weatherapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class WeatherFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_fragment);

        FragmentManager mFragmentManager = getSupportFragmentManager();
        WeatherMenu mweatherMenu = new WeatherMenu();
        Fragment weatherMenu = mFragmentManager.findFragmentByTag(WeatherMenu.class.getSimpleName());

        if (!(weatherMenu instanceof WeatherMenu)) {
            mFragmentManager.beginTransaction()
                    .add(R.id.fl_mainFrame, mweatherMenu, WeatherMenu.class.getSimpleName())
                    .commit();
        }
    }
}