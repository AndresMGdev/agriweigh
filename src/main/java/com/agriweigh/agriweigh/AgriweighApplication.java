package com.agriweigh.agriweigh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.agriweigh.agriweigh.models")
public class AgriweighApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgriweighApplication.class, args);
	}

}
