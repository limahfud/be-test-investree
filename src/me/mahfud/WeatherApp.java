package me.mahfud;

import me.mahfud.activity.*;
import me.mahfud.util.Constant;

import java.util.Scanner;

public class WeatherApp {

    private Scanner scanner;

    public WeatherApp() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.print("Weather App > ");
        String command = scan(Constant.BLANK_STRING);
        while (! command.equals("exit")) {
            ActivityStartable activityStartable = getActivity(command);

            if (activityStartable != null) {
                activityStartable.start(command);
            } else {
                System.out.println("Sorry, the command is not found.");
            }

            System.out.print("Weather App > ");
            command = scan(Constant.BLANK_STRING);
        }
    }


    private ActivityStartable getActivity(String command) {
        if (command.startsWith(ActivityStartable.SEARCH_CITY_NAME)) {
            return new SearchCityActivity(scanner);
        }
        if (command.startsWith(ActivityStartable.SEARCH_CITY_COORDINATE)) {
            return new SearchCoordinateActivity(scanner);
        }
        if (command.startsWith(ActivityStartable.SAVE_CITY)) {
            return new SaveCityActivity(scanner);
        }
        if (command.startsWith(ActivityStartable.SHOW_CITY)) {
            return new ShowAllActivity();
        }
        if (command.startsWith(ActivityStartable.REMOVE_CITY)) {
            return new RemoveCityActivity(scanner);
        }

        return null;
    }

    private String scan(String question) {
        System.out.print(question);

        return scanner.nextLine();
    }
}
