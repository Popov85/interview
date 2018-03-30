package com.popov.example;

import com.google.common.collect.ImmutableList;
import com.popov.example.service.CsvConverter;
import com.popov.example.service.CsvWriter;
import com.popov.example.service.OpenWeatherApiClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@SpringBootApplication
public class ExampleApplication implements CommandLineRunner {

	@Autowired
	private CsvWriter csvWriter;

	@Autowired
	private OpenWeatherApiClient openWeatherApiClient;

	@Autowired
	private CsvConverter csvConverter;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate(new HttpComponentsClientHttpRequestFactory(HttpClientBuilder.create().build()));
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(ExampleApplication.class)
		.bannerMode(Banner.Mode.OFF)
		.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		String cityName = args[0].trim();
		String fileName = cityName+".csv";
		csvWriter.write(fileName, openWeatherApiClient.findByCityName(cityName).getList().stream()
					.map(csvConverter::toCsvDTO)
					.collect(collectingAndThen(toList(), ImmutableList::copyOf)));
	}
}
