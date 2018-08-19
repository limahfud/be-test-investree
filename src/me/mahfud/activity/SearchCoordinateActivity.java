package me.mahfud.activity;

import me.mahfud.model.City;
import me.mahfud.model.Weather;
import me.mahfud.util.api.SearchCityApi;
import me.mahfud.util.api.SearchCoordinateApi;
import me.mahfud.util.api.WeatherCityApi;
import me.mahfud.util.printer.CityPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SearchCoordinateActivity implements ActivityStartable {

    private Scanner scanner;
    private List<City> cityList = new ArrayList<>();

    public SearchCoordinateActivity(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void start(String query) {
        String coordinateQuery = getCoordinateFromQuery(query);

        boolean dataFound = searchCityByCoordinate(coordinateQuery);

        if ( !dataFound ) return;

        int chosenCityNumber = chooseCity();

        showCity(chosenCityNumber);
    }

    private String getCoordinateFromQuery(String query) {
        String strippedQuery = query.replace(ActivityStartable.SEARCH_CITY_COORDINATE, "")
                .trim();

        return strippedQuery.split(" ", 2)[0];
    }

    private boolean searchCityByCoordinate(String coordinate) {
        System.out.println("Searching coordinate: " + coordinate);
        cityList = new SearchCoordinateApi(coordinate).getResult();

        if (cityList.isEmpty()) {
            System.out.println("data not found");
            return false;
        }

        System.out.println("data found");
        for (int i = 0; i < cityList.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, cityList.get(i).getName());
        }

        return true;
    }

    private int chooseCity() {
        System.out.print("Which one that you want to see(in number, ex: 1) ?");

        String chosenIndex = scanner.nextLine();

        return Integer.parseInt(chosenIndex);
    }

    private void showCity(int chosenCityNumber) {
        City city = cityList.get(chosenCityNumber - 1);

        List<Weather> weatherList = new WeatherCityApi(city).getResult();
        city.setWeatherList(weatherList);

        new CityPrinter(city).printWeather();
    }
}
