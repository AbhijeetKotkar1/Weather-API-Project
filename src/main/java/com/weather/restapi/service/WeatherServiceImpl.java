package com.weather.restapi.service;

import com.weather.restapi.dao.WeatherDAO;
import com.weather.restapi.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherDAO weatherDAO;

    @Override
    public List<Weather> getWeather() {
        return weatherDAO.getWeather();
    }

    @Override
    public void saveWeather(Weather theWeather) {
        weatherDAO.saveWeather(theWeather);
    }

    @Override
    public Weather getWeather(int id) {
        return weatherDAO.getWeather(id);
    }

    @Override
    public void deleteWeather(int id) {
        weatherDAO.deleteWeather(id);
    }
}
