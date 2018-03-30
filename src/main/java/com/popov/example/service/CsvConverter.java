package com.popov.example.service;

import com.popov.example.domain.Weather;
import com.popov.example.dto.CsvDTO;
import lombok.NonNull;
import org.springframework.stereotype.Component;


@Component
public class CsvConverter {
    public CsvDTO toCsvDTO(@NonNull Weather weather) {
        CsvDTO dto = new CsvDTO();
        dto.setDate(weather.getDate().toString());
        dto.setDescription(weather.getWeatherPiece().get(0).getDescription());
        dto.setTemp(weather.getMain().getTemp());
        dto.setHumidity(weather.getMain().getHumidity());
        dto.setPressure(weather.getMain().getPressure());
        return dto;
    }
}
