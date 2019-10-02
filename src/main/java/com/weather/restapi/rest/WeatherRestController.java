package com.weather.restapi.rest;

import com.weather.restapi.entity.Weather;
import com.weather.restapi.service.WeatherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WeatherRestController {

    @Autowired
    private WeatherService weatherService;

    @ApiOperation(value = "Returns all cities weather information")
    @GetMapping("/weather")
    public List<Weather> getWeather() {

        return weatherService.getWeather();

    }

    @ApiOperation(value = "Returns weather of specific city")
    @GetMapping("/weather/{id}")
    public Weather getWeather(@PathVariable int id) {

        Weather theWeather = weatherService.getWeather(id);

        return theWeather;
    }

    @ApiOperation(value = "Insert weather information of a new city")
    @PostMapping("/weather")
    public Weather addWeather(@RequestBody Weather theWeather) {

        weatherService.saveWeather(theWeather);

        return theWeather;

    }

    @ApiOperation(value = "Update weather information of a city")
    @PutMapping("/weather")
    public Weather updateWeather(@RequestBody Weather theWeather) {

        weatherService.saveWeather(theWeather);

        return theWeather;

    }

    @ApiOperation(value = "Delete weather information of a city")
    @DeleteMapping("/weather/{id}")
    public String deleteWeather(@PathVariable int id) {

        weatherService.deleteWeather(id);

        return "Deleted customer with id: " + id;
    }

}
