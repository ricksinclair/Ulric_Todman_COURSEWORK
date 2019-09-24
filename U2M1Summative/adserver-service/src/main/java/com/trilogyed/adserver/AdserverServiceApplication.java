package com.trilogyed.adserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdserverServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdserverServiceApplication.class, args);
	}

}
