package com.itc.weatherapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.itc.weatherapi.database.Dao;
import com.itc.weatherapi.database.Database;
import com.itc.weatherapi.database.Entity;
import com.itc.weatherapi.model.Clouds;
import com.itc.weatherapi.model.Coord;
import com.itc.weatherapi.model.ListItem;
import com.itc.weatherapi.model.Main;
import com.itc.weatherapi.model.Sys;
import com.itc.weatherapi.model.WeatherItem;
import com.itc.weatherapi.model.Wind;
import com.itc.weatherapi.service.WeatherListener;
import com.itc.weatherapi.service.WeatherService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCheck = findViewById(R.id.bt_check);

        new WeatherService().getWeather(WeatherListener);

        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WeatherFragment.class);
                startActivity(intent);
            }
        });
    }

    WeatherListener<List<ListItem>> WeatherListener = new WeatherListener<List<ListItem>>() {
        @Override
        public void onSuccess(List<ListItem> items) {
            boolean check;

            WeatherItem weatherItem = new WeatherItem();
            Main main = new Main();
            Sys sys = new Sys();

            Database databaseRoom = Database.getInstance(getApplication());
            Dao dao = databaseRoom.dao();

            Log.d("Yeogiiii", String.valueOf(items.size()));

            if (dao.getAllData().isEmpty()) check=true;
            else check=false;
            for (int i = 0; i < items.size(); i++) {
                weatherItem = items.get(i).getWeather().get(i);
                main = items.get(i).getMain();
                sys = items.get(i).getSys();

                Entity entity = new Entity(
                        items.get(i).getId(),
                        main.getTemp(),
                        weatherItem.getMain(),
                        items.get(i).getName(),
                        sys.getCountry()
                );
                if (check) dao.insert(entity);
                else dao.update(entity);
            }
        }

        @Override
        public void onFailed(String msg) {
            Log.d("Isi Error", msg);
        }
    };
}