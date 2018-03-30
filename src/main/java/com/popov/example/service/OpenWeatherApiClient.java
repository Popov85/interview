package com.popov.example.service;

import com.google.common.collect.ImmutableMap;
import com.popov.example.domain.Forecast;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.invoke.MethodHandles;

@Component
public class OpenWeatherApiClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${application.url}")
    private String url;

    public Forecast findByCityName(@NonNull String city) {
        ResponseEntity<Forecast> response = restTemplate.getForEntity(url, Forecast.class, ImmutableMap.of("city", city));
        LOGGER.debug("Successful download weather forecast: "+response.getBody());
        return response.getBody();
    }
}

