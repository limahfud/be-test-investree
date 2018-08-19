package me.mahfud.activity;

import me.mahfud.model.City;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SaveCityActivity implements ActivityStartable {

    private Scanner scanner;
    private final List<City> cityList = new ArrayList<>();

    public SaveCityActivity(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void start(String query) {
        String nameQuery = getNameFromQuery(query);

        boolean dataFound = searchCityByName(nameQuery);

        if ( !dataFound ) return;

        int chosenCityIndex = chooseCity();

        saveCity(chosenCityIndex);
    }

    private String getNameFromQuery(String query) {
        String strippedQuery = query.replace(ActivityStartable.SAVE_CITY, "")
                .trim();

        return strippedQuery.split(" ", 2)[0];
    }

    private boolean searchCityByName(String name) {
        // TODO get list city based on name
        System.out.println("Searching : " + name);
        cityList.addAll(cities);

        int a=10;

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
        System.out.print("Which one, data that you want to save(in number, ex: 1) ?");

        String chosenIndex = scanner.nextLine();

        return Integer.parseInt(chosenIndex);
    }

    private void saveCity(int choosenCityNumber) {
        City city = cityList.get(choosenCityNumber - 1);

        // TODO save city into files

        System.out.printf("City with name %s has been saved%n", city.getName());

    }

    // Dummy : Delete later
    private ArrayList<City> cities = new ArrayList<>(Arrays.asList(
            new City("San Fransisco", "city", 12123123, "123, 123", null),
            new City("Frankfurt", "city", 12123123, "123, 123", null)
    ));
}
