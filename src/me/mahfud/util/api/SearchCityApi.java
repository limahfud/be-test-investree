package me.mahfud.util.api;

import me.mahfud.model.City;
import me.mahfud.util.parser.CityListParser;

import java.util.List;

public class SearchCityApi {

    private String query;

    public SearchCityApi(String query) {
        this.query = query;
    }

    public List<City> getResult() {
        String apiResult = new ApiCall().geweattApiResult("location/search/?query=" + query);
        return new CityListParser(apiResult).getListCity();
    }


}
