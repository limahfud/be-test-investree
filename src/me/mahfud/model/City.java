package me.mahfud.model;

import java.util.List;

public class City {

    private String name;
    private String lattLong;
    private Integer woeid;
    private String type;

    private List<Weather> weatherList;

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

    public String getName() {
        return name;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }


    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", lattLong='" + lattLong + '\'' +
                ", woeid=" + woeid +
                ", type='" + type + '\'' +
                ", weatherList=" + weatherList +
                '}';
    }
}
