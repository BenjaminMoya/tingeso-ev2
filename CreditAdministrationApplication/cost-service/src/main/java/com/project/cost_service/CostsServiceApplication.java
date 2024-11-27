package com.project.cost_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CostsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CostsServiceApplication.class, args);
	}

}
