package com.weather.restapi.dao;

import com.weather.restapi.entity.Weather;

import java.util.List;

public interface WeatherDAO {

    public List<Weather> getWeather();

    public void saveWeather(Weather theWeather);

    public Weather getWeather(int id);

    public void deleteWeather(int id);

}
