package com.popov.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
public class Coordinate {
    @JsonProperty("lat")
    private double latitude;
    @JsonProperty("lon")
    private double longitude;
}
