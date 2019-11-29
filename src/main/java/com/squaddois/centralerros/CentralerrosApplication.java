package com.squaddois.centralerros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CentralerrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralerrosApplication.class, args);
	}

}
