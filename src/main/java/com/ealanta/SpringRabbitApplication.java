package com.ealanta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringRabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitApplication.class, args);
	}	
}
