package me.mahfud.activity;

public interface ActivityStartable {

    static final String SEARCH_CITY_NAME = "weather search city";
    static final String SEARCH_CITY_COORDINATE = "weather search coordinates";
    static final String REMOVE_CITY = "weather remove";
    static final String SHOW_CITY = "weather show all";
    static final String SAVE_CITY = "weather save";


    public void start(String query);
}

