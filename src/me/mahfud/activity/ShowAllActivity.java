package me.mahfud.activity;

import me.mahfud.model.City;
import me.mahfud.util.file.FileManager;
import me.mahfud.util.printer.CityPrinter;

import java.util.List;

public class ShowAllActivity implements ActivityStartable {

    @Override
    public void start(String query) {
        showCities();
    }

    private void showCities() {
        List<City> cities = FileManager.getInstance().listCitySaved();

        for (City city: cities) {
            new CityPrinter(city).printWeather();
            System.out.println();
        }
    }
}
