package com.itc.weatherapi.database;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "list")
public class Entity {
    public static final String TABLE_NAME = "list";

    @PrimaryKey()
    private int id;
    @ColumnInfo(name = "nama")
    private String nama;
    @ColumnInfo(name = "coord")
    private String coord;
    @ColumnInfo(name = "main")
    private String main;
    @ColumnInfo(name = "dt")
    private int dt;
    @ColumnInfo(name = "wind")
    private String wind;
    @ColumnInfo(name = "sys")
    private String sys;
    @ColumnInfo(name = "rain")
    private String rain;
    @ColumnInfo(name = "snow")
    private String snow;
    @ColumnInfo(name = "clouds")
    private String clouds;
    @ColumnInfo(name = "weather")
    private String weather;

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getCoord() {
        return coord;
    }

    public String getMain() {
        return main;
    }

    public int getDt() {
        return dt;
    }

    public String getWind() {
        return wind;
    }

    public String getSys() {
        return sys;
    }

    public String getRain() {
        return rain;
    }

    public String getSnow() {
        return snow;
    }

    public String getClouds() {
        return clouds;
    }

    public String getWeather() {
        return weather;
    }

    public Entity(int id, String nama, String coord, String main, int dt, String wind, String sys, String rain, String snow, String clouds, String weather) {
        this.id = id;
        this.nama = nama;
        this.coord = coord;
        this.main = main;
        this.dt = dt;
        this.wind = wind;
        this.sys = sys;
        this.rain = rain;
        this.snow = snow;
        this.clouds = clouds;
        this.weather = weather;
    }

    @Ignore
    public Entity(String nama, String coord, String main, int dt, String wind, String sys, String rain, String snow, String clouds, String weather) {
        this.nama = nama;
        this.coord = coord;
        this.main = main;
        this.dt = dt;
        this.wind = wind;
        this.sys = sys;
        this.rain = rain;
        this.snow = snow;
        this.clouds = clouds;
        this.weather = weather;
    }
}
