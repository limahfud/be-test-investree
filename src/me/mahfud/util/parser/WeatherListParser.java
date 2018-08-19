package me.mahfud.util.parser;

import me.mahfud.model.Weather;
import me.mahfud.util.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherListParser {

    private String json;

    public WeatherListParser(String json) {
        this.json = json;
    }

    public List<Weather> getResult() {
        List<Weather> weatherList = new ArrayList<>();

        if (Constant.BLANK_STRING.equals(getConsolidatedWeather())) {
            return weatherList;
        }

        return getListWeather();
    }

    private List<Weather> getListWeather() {
        String regex = "(\\{[^{]*\\})(,|$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(getConsolidatedWeather());

        List<Weather> weatherList = new ArrayList<>();

        while (matcher.find()) {
            String weatherString = matcher.group(0);
            Weather weather = (new WeatherParser(weatherString)).getWeather();
            weatherList.add(weather);
        }

        return weatherList;
    }

    private String getConsolidatedWeather() {
        String regex = "consolidated_weather\":\\[([^\\[]*)\\]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(json);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return Constant.BLANK_STRING;
    }
}
