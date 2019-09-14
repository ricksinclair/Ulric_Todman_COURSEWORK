package com.trilogyed.ulrictodmanmagiceightballservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UlricTodmanMagicEightBallServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UlricTodmanMagicEightBallServiceApplication.class, args);
	}

}
