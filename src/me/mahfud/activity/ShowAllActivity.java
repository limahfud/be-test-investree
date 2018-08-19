package me.mahfud.activity;

public class ShowAllActivity implements ActivityStartable {

    @Override
    public String getPattern() {
        return "weather show all";
    }

    @Override
    public void start(String query) {
        showCities();
    }

    private void showCities() {
        // TODO showing all cities that had been saved
    }
}
