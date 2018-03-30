package com.popov.example.service;

import com.google.common.collect.ImmutableMap;
import com.popov.example.domain.Forecast;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class OpenWeatherApiClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${application.url}")
    private String url;

    public Forecast findByCityName(@NonNull String city) {
        ResponseEntity<Forecast> response = restTemplate.getForEntity(url, Forecast.class, ImmutableMap.of("city", city));
        log.debug("Successful download weather forecast: "+response.getBody());
        return response.getBody();
    }
}

