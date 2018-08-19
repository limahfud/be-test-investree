package me.mahfud.activity;

import me.mahfud.model.City;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SearchCityActivity implements ActivityStartable {

    private Scanner scanner;
    private final List<City> cityList = new ArrayList<>();

    public SearchCityActivity(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void start(String query) {
        String nameQuery = getNameFromQuery(query);

        boolean dataFound = searchCityByName(nameQuery);

        if ( !dataFound ) return;

        int chosenCityNumber = chooseCity();

        showCity(chosenCityNumber);
    }

    private String getNameFromQuery(String query) {
        String strippedQuery = query.replace(ActivityStartable.SEARCH_CITY_NAME, "")
                .trim();

        return strippedQuery.split(" ", 2)[0];
    }

    private boolean searchCityByName(String name) {
        System.out.println("Searching : " + name);
        cityList.addAll(cities);
        // TODO get list city based on name

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
        System.out.print("Which one that you want to see(in number, ex: 1) ? ");

        String chosenIndex = scanner.nextLine();

        return Integer.parseInt(chosenIndex);
    }

    private void showCity(int chosenCityNumber) {
        City city = cityList.get(chosenCityNumber - 1);

        System.out.println(city.toString());
    }

    // Dummy : Delete later
    private ArrayList<City> cities = new ArrayList<>(Arrays.asList(
            new City("San Fransisco", "city", 12123123, "123, 123", null),
            new City("Frankfurt", "city", 12123123, "123, 123", null)
    ));
}
