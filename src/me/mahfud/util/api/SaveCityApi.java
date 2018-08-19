package me.mahfud.util.api;

import me.mahfud.model.City;

public class SaveCityApi {
    private City city;

    public SaveCityApi(City city) {
        this.city = city;
    }

    public String getResult() {
        return new ApiCall().getApiResult("location/" + city.getWoeid());
    }
}
