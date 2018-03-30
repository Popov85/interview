package com.popov.example.service.it;

import com.popov.example.service.OpenWeatherApiClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenWeatherApiClientITConfiguration {

    @Bean
    public OpenWeatherApiClient openWeatherApiClient() {
        return new OpenWeatherApiClient();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(HttpClientBuilder.create().build()));
    }

}
