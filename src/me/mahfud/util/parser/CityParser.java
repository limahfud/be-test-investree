package me.mahfud.util.parser;


import me.mahfud.model.City;

public class CityParser extends BaseParser {

    private static final String NAME_KEY = "title";
    private static final String LOCATION_TYPE_KEY = "location_type";
    private static final String WOEID_KEY = "woeid";
    private static final String LATT_LONG_KEY = "latt_long";


    public CityParser(String json) {
        super(json);
    }

    public City getCity() {
        return new City(
                getName(),
                getLocationType(),
                getWoeid(),
                getLattLong(),
                null
        );
    }

    private String getName() {
        return getJsonValueString(NAME_KEY);
    }

    private String getLocationType() {
        return getJsonValueString(LOCATION_TYPE_KEY);
    }

    private Integer getWoeid() {
        return getJsonValueInteger(WOEID_KEY);
    }

    private String getLattLong() {
        return getJsonValueString(LATT_LONG_KEY);
    }

    //{"title":"San Francisco","location_type":"City","woeid":2487956,"latt_long":"37.777119, -122.41964"}
}
