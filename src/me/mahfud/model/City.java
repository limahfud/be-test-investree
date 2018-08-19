package me.mahfud.model;

import java.util.List;

public class City {

    private String name;
    private String lattLong;
    private Integer woeid;
    private String type;

    private List<Weather> weatherList;
    private String rawWeather = "";

    public City(String name, String type, Integer woeid, String lattLong, List<Weather> weatherList) {
        this.name = name;
        this.lattLong = lattLong;
        this.woeid = woeid;
        this.type = type;
        this.weatherList = weatherList;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public Integer getWoeid() {
        return woeid;
    }

    public String getName() {
        return name;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public String getRawWeather() {
        return rawWeather;
    }

    public void setRawWeather(String rawWeather) {
        this.rawWeather = rawWeather;
    }
}
