package me.mahfud.activity;

import me.mahfud.model.City;

import java.util.ArrayList;
import java.util.List;

public class SearchCoordinateActivity implements ActivityStartable {

    private final List<City> cityList = new ArrayList<>();

    @Override
    public String getPattern() {
        return "weather search coordinate";
    }

    @Override
    public void start(String query) {
        String coordinateQuery = getCoordinateFromQuery(query);

        boolean dataFound = searchCityByCoordinate(coordinateQuery);

        if (dataFound) {
            int choosenCityNumber = chooseCity();

            showCity(choosenCityNumber);
        }
    }

    private String getCoordinateFromQuery(String query) {
        // TODO returning string part of coordinate
        return "";
    }

    private boolean searchCityByCoordinate(String coordinate) {

        // TODO get list city based on coordinate

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

        // TODO accept input from user and evaluate it as choosen city
        return 0;
    }

    private void showCity(int choosenCityNumber) {
        City city = cityList.get(choosenCityNumber - 1);
        // TODO city get number
    }
}
