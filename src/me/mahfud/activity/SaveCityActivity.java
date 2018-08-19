package me.mahfud.activity;

import me.mahfud.model.City;
import me.mahfud.util.api.SaveCityApi;
import me.mahfud.util.api.SearchCityApi;
import me.mahfud.util.file.FileManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SaveCityActivity implements ActivityStartable {

    private Scanner scanner;
    private List<City> cityList = new ArrayList<>();

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
        System.out.println("Searching :" + name);
        cityList = new SearchCityApi(name).getResult();

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
        String cityWeatherJson = new SaveCityApi(city).getResult();

        String writtenToFile = String.format("%s %s", city.getName(), cityWeatherJson);
        FileManager.getInstance().saveCity(writtenToFile);

        System.out.printf("City with name %s has been saved%n", city.getName());

    }
}
