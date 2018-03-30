package com.popov.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Data
@Component
public class Weather {
    @JsonProperty("dt")
    private Date date;
    private Main main;
    @JsonProperty("weather")
    private List<WeatherPiece> weatherPiece;
}
