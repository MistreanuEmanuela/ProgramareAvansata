package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@EnableJpaRepositories(basePackages = "com.example.demo")
@EntityScan(basePackages = "com.example.demo")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		createPlayer("Giorgica");
		displayGames();
	}

	private static void displayGames() {
		String url = "http://localhost:8082/games";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

		if (response.getStatusCode().is2xxSuccessful()) {
			System.out.println("Game receive successfully");
			System.out.println("Response Body: " + response.getBody());
		} else {
			System.out.println("Failed to create player");
		}
	}


	private static void createPlayer(String playerName) {
		String url = "http://localhost:8082/players";

		RestTemplate restTemplate = new RestTemplate();

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
				.queryParam("playerName", playerName);

		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, String.class);

		if (response.getStatusCode().is2xxSuccessful()) {
			System.out.println("Player created successfully");
			System.out.println("Response Body: " + response.getBody());
		} else {
			System.out.println("Failed to create player");
		}
	}

}
