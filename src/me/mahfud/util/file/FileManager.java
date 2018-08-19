package me.mahfud.util.file;

import me.mahfud.model.City;
import me.mahfud.model.Weather;
import me.mahfud.util.parser.WeatherListParser;
import me.mahfud.util.printer.CityPrinter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private final static String FILENAME = "cities.txt";
    private static FileManager fileManager = null;

    public static FileManager getInstance() {
        if (fileManager == null) fileManager = new FileManager();

        return fileManager;
    }

    public void saveCity(String city) {
        removeCity(city);
        appendCity(city);
    }

    public void appendCity(String city) {
        try {
            FileWriter fileWriter = new FileWriter(FILENAME, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(city);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '" + FILENAME + "'");
        }
    }

    public void removeCity(String city) {
        String line;

        try {
            FileReader fileReader = new FileReader(FILENAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            ArrayList<String> cities = new ArrayList<>();

            int i = 1;
            while((line = bufferedReader.readLine()) != null) {
                if (line.startsWith(city.split(" ", 2)[0])) continue;
                cities.add(line);
            }
            bufferedReader.close();

            FileWriter fileWriter = new FileWriter(FILENAME);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String cityLine: cities) {
                bufferedWriter.write(cityLine);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private List<String> readCity() {
        String line;
        ArrayList<String> cities = new ArrayList<>();


        try {
            FileReader fileReader = new FileReader(FILENAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            while((line = bufferedReader.readLine()) != null) {
                cities.add(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return cities;
    }

    public List<City> listCitySaved() {
        List<String> citiesData = readCity();
        List<City> cities = new ArrayList<>();

        for (String data: citiesData) {
            String[] arrayData = data.split(" ", 2);
            String cityName = arrayData[0];
            String cityJson = arrayData[1];

            List<Weather> weatherList = new WeatherListParser(cityJson).getResult();
            City city = new City(cityName, "city", 1, "", weatherList);

            cities.add(city);
        }
        return cities;
    }
}
