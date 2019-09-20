package com.company.motoeurekaserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // enable the features in the Eureka Server starter dependencies- turns our application into a Eureka Server.
public class MotoEurekaServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotoEurekaServiceRegistryApplication.class, args);
	}

}
