package com.company.ulrictodmancloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class UlricTodmanCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UlricTodmanCloudConfigServerApplication.class, args);
	}

}
