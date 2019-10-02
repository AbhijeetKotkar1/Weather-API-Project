package com.weather.restapi.dao;

import com.weather.restapi.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class WeatherDAOImpl implements WeatherDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Weather> getWeather() {

        String sql = "SELECT * FROM WEATHER_INFORMATION";

        List<Weather> weather = jdbcTemplate.query(
                sql,
                new WeatherMapper());

        return weather;

    }

    @Override
    public void saveWeather(Weather theWeather) {

        jdbcTemplate.update(
                "INSERT INTO WEATHER_INFORMATION (city, temp, id) values(?,?,?)",
                theWeather.getCity(), theWeather.getTemp(), theWeather.getId());
    }

    @Override
    public Weather getWeather(int id) {
        String query = "SELECT * FROM WEATHER_INFORMATION WHERE ID = ?";

        Weather weather = jdbcTemplate.queryForObject(
                query, new Object[]{id}, new WeatherMapper());

        return weather;
    }

    @Override
    public void deleteWeather(int id) {

        String query = "DELETE FROM WEATHER_INFORMATION WHERE ID = " + id;

        jdbcTemplate.update(query);

    }
}

class WeatherMapper implements RowMapper<Weather> {
    @Override
    public Weather mapRow(ResultSet rs, int rowNum) throws SQLException {
        Weather weather = new Weather();

        weather.setCity(rs.getString("city"));
        weather.setId(rs.getInt("id"));
        weather.setTemp(rs.getInt("temp"));

        return weather;
    }
}
