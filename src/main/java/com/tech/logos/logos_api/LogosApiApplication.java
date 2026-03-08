package com.tech.logos.logos_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LogosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogosApiApplication.class, args);
	}

}
