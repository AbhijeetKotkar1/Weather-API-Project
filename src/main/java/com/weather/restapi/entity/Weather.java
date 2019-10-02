package com.weather.restapi.entity;

public class Weather {

    private int id;
    private String city;
    private int temp;

    public Weather() {

    }

    public Weather(int id, String city, int temp) {
        this.id = id;
        this.city = city;
        this.temp = temp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", temp=" + temp +
                '}';
    }
}
