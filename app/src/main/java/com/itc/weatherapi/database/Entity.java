package com.itc.weatherapi.database;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.itc.weatherapi.model.Main;

@androidx.room.Entity(tableName = "list")
public class Entity {
    public static final String TABLE_NAME = "list";

    @PrimaryKey()
    private int id;
    @ColumnInfo(name = "main")
    private Double main;
    @ColumnInfo(name = "weather")
    private String weather;
    @ColumnInfo(name = "nama")
    private String nama;
    @ColumnInfo(name = "sys")
    private String sys;

    public int getId() {
        return id;
    }

    public Double getMain() {
        return main;
    }

    public String getWeather() {
        return weather;
    }

    public String getNama() {
        return nama;
    }

    public String getSys() {
        return sys;
    }

    public Entity(int id, Double main, String weather, String nama, String sys) {
        this.id = id;
        this.main = main;
        this.weather = weather;
        this.nama = nama;
        this.sys = sys;
    }
    @Ignore
    public Entity(Double main, String weather, String nama, String sys) {
        this.main = main;
        this.weather = weather;
        this.nama = nama;
        this.sys = sys;
    }
}
