package com.cineplanet.retocp24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Retocp24Application{

	public static void main(String[] args) {
		SpringApplication.run(Retocp24Application.class, args);
	}

}
