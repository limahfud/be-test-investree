package me.mahfud.activity;


import me.mahfud.model.City;

import java.util.ArrayList;
import java.util.List;

public class RemoveCityActivity implements ActivityStartable {

    private final List<City> cityList = new ArrayList<>();

    @Override
    public String getPattern() {
        return "weather remove";
    }

    @Override
    public void start(String query) {
        String queryName = getNameFromQuery(query);

        boolean dataFound = searchCityByName(queryName);

        if (dataFound) {
            int choosenCityNumber = chooseCity();

            saveCity(choosenCityNumber);
        }
    }

    private String getNameFromQuery(String query) {
        return "";
    }

    private boolean searchCityByName(String queryName) {

        if (cityList.isEmpty()) {
            System.out.println("data not found");
            return false;
        }

        for (int i = 0; i < cityList.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, cityList.get(i).getName());
        }

        return true;
    }

    private int chooseCity() {
        System.out.print("Which one that you want to see(in number, ex: 1) ?");

        return 0;
    }

    private void saveCity(int choosenCityNumber) {
        City city = cityList.get(choosenCityNumber - 1);
        // TODO city get number
    }
}
