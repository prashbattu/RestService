package com.sync.pb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
@EnableCircuitBreaker
@SpringBootApplication
public class WbtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WbtestApplication.class, args);
	}
}
