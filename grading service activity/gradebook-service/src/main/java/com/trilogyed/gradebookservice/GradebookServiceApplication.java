package com.trilogyed.gradebookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GradebookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradebookServiceApplication.class, args);
	}

}
