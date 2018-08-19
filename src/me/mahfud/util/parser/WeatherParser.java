package me.mahfud.util.parser;


import me.mahfud.model.Weather;

public class WeatherParser extends BaseParser {

    private static final String WEATHER_KEY  = "weather_state_name";
    private static final String DATE_KEY     = "applicable_date";
    private static final String MIN_TEMP_KEY = "min_temp";
    private static final String MAX_TEMP_KEY = "max_temp";
    private static final String THE_TEMP_KEY = "the_temp";

    public WeatherParser(String json) {
        super(json);
    }

    public Weather getWeather() {
        return new Weather(getDate(), getWeatherName(), getMinTemp(), getMaxTemp(), getTemp());
    }

    private String getDate() {
        return getJsonValueString(DATE_KEY);
    }

    private String getWeatherName() {
        return getJsonValueString(WEATHER_KEY);
    }

    private int getMinTemp() {
        return (int) Math.round(getJsonValueDouble(MIN_TEMP_KEY));
    }

    private int getMaxTemp() {
        return (int) Math.round(getJsonValueDouble(MAX_TEMP_KEY));
    }

    private int getTemp() {
        return (int) Math.round(getJsonValueDouble(THE_TEMP_KEY));
    }
}

