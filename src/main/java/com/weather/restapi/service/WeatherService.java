package com.weather.restapi.service;

import com.weather.restapi.entity.Weather;

import java.util.List;

public interface WeatherService {

    public List<Weather> getWeather();

    public void saveWeather(Weather theWeather);

    public Weather getWeather(int id);

    public void deleteWeather(int id);

}
