package me.mahfud.activity;


import me.mahfud.model.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveCityActivity implements ActivityStartable {

    private Scanner scanner;
    private final List<City> cityList = new ArrayList<>();

    public RemoveCityActivity(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void start(String query) {

        boolean dataFound = loadCity();

        if ( !dataFound ) return;

        int chosenCityNumber = chooseCity();

        removeCity(chosenCityNumber);
    }

    private boolean loadCity() {

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
        System.out.print("Which one, data that you want to remove(in number, ex: 1) ?");

        String chosenIndex = scanner.nextLine();

        return Integer.parseInt(chosenIndex);
    }

    private void removeCity(int chosenCityNumber) {
        City city = cityList.get(chosenCityNumber - 1);

        // TODO action remove city from database
        System.out.printf("City with name %s has been removed%n", city.getName());
    }
}
