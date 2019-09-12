package com.trilogyed.randomgreetingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RandomGreetingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomGreetingServiceApplication.class, args);
	}

}
