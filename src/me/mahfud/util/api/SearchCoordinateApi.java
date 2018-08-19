package me.mahfud.util.api;

import me.mahfud.model.City;
import me.mahfud.util.parser.CityListParser;

import java.util.List;

public class SearchCoordinateApi {

    private String query;

    public SearchCoordinateApi(String query) {
        this.query = query;
    }

    public List<City> getResult() {
        String apiResult = new ApiCall().getApiResult("location/search/?lattlong=" + query);

        System.out.println(apiResult);
        return new CityListParser(apiResult).getListCity();
    }
}
