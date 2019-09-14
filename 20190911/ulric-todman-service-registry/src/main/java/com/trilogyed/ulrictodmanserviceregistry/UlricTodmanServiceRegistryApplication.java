package com.trilogyed.ulrictodmanserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UlricTodmanServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(UlricTodmanServiceRegistryApplication.class, args);
	}

}
