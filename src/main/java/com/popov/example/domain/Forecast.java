package com.popov.example.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;
import java.util.List;

@Data
@ToString
@Component
public class Forecast {
    private City city;
    private List<Weather> list;
}
