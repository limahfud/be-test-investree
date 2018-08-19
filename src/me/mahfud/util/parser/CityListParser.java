package me.mahfud.util.parser;

import me.mahfud.model.City;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CityListParser {
    private String json;

    public CityListParser(String json) {
        this.json = json;
    }

    public List<City> getListCity() {
        String regex = "(\\{[^{]*\\})(,|$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(json);

        List<City> cities = new ArrayList<>();

        while (matcher.find()) {
            String cityJson = matcher.group(0);
            cities.add(new CityParser(cityJson).getCity());
        }

        return cities;
    }

}
