package me.mahfud.util.printer;

import me.mahfud.model.City;
import me.mahfud.model.Weather;

import java.util.List;

public class CityPrinter {
    private static final int COLUMN_LENGTH = 15;

    private List<Weather> weatherList;
    private String name;
    
    
    public CityPrinter(City city) {
        this.name = city.getName();
        this.weatherList = city.getWeatherList();
    }
    public void printWeather() {
        System.out.print(String.format("Weather for city %s%n", name));

        System.out.print(padRight("Date") + " : ");
        weatherList.forEach(weather -> System.out.print(padRight(weather.getDate())));
        System.out.println();

        System.out.print(padRight("Weather") + " : ");
        weatherList.forEach(weather -> System.out.print(padRight(weather.getWeather())));
        System.out.println();

        System.out.print(padRight("Min. temp") + " : ");
        weatherList.forEach(weather -> System.out.print(padRight(weather.getMaxTemp()+"°")));
        System.out.println();

        System.out.print(padRight("Max. temp") + " : ");
        weatherList.forEach(weather -> System.out.print(padRight(weather.getMinTemp()+"°")));
        System.out.println();

        System.out.print(padRight("Temp") + " : ");
        weatherList.forEach(weather -> System.out.print(padRight(weather.getTemp()+"°")));
        System.out.println();
    }

    private String padRight(String s) {
        return String.format("%1$-" + COLUMN_LENGTH + "s", s);
    }
}
