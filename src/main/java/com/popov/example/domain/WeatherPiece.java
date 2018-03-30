package com.popov.example.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class WeatherPiece {
    private long id;
    private String main;
    private String description;
    private String icon;
}
