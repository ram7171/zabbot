package com.osqure.zabbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ZabbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZabbotApplication.class, args);
	}

}

