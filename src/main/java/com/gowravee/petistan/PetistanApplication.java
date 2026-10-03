package com.gowravee.petistan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:messages.properties")
public class PetistanApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetistanApplication.class, args);
	}

}
