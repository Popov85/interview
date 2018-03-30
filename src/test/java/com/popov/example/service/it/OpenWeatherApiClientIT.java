package com.popov.example.service.it;

import com.popov.example.domain.Forecast;
import com.popov.example.service.OpenWeatherApiClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpenWeatherApiClientITConfiguration.class)
public class OpenWeatherApiClientIT {

    private static String CITY = "London";

    @Autowired
    private OpenWeatherApiClient openWeatherApiClient;

    @Test
    public void findByCityNameTest() throws Exception {
        Forecast forecast = openWeatherApiClient.findByCityName(CITY);
        assertNotNull(forecast);
        assertEquals(CITY, forecast.getCity().getName());
        assertNotNull(forecast.getCity());
        assertNotNull(forecast.getList());
        assertThat(forecast.getList().size()).isGreaterThan(0);
    }
}
