package com.popov.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class City {
    private long id;
    private String name;
    @JsonProperty("coord")
    private Coordinate coordinate;
    private String country;
    private double population;
}
