package me.mahfud.model;

public class Weather {
    private String date;
    private String weather;
    private int minTemp;
    private int maxTemp;
    private int temp;

    public Weather(String date, String weather, int minTemp, int maxTemp, int temp) {
        this.date = date;
        this.weather = weather;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
