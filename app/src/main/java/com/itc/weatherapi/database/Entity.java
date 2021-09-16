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
    @ColumnInfo(name = "nama")
    private String nama;
    @ColumnInfo(name = "main")
    private Double main;
    @ColumnInfo(name = "sys")
    private String sys;
    @ColumnInfo(name = "weather")
    private String weather;

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public Double getMain() {
        return main;
    }

    public String getSys() {
        return sys;
    }

    public String getWeather() {
        return weather;
    }

    public Entity(int id, String nama, Double main, String sys, String weather) {
        this.id = id;
        this.nama = nama;
        this.main = main;
        this.sys = sys;
        this.weather = weather;
    }

    @Ignore
    public Entity(String nama, Double main, String sys, String weather) {
        this.nama = nama;
        this.main = main;
        this.sys = sys;
        this.weather = weather;
    }
}
