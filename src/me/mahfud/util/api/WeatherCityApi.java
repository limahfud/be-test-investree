package me.mahfud.util.api;

import me.mahfud.model.City;
import me.mahfud.model.Weather;
import me.mahfud.util.parser.WeatherListParser;

import java.util.List;

public class WeatherCityApi {
    private City city;

    public WeatherCityApi(City city) {
        this.city = city;
    }

    public List<Weather> getResult() {
        String apiResult = new ApiCall().getApiResult("location/" + city.getWoeid());

        return new WeatherListParser(apiResult).getResult();
    }
}
