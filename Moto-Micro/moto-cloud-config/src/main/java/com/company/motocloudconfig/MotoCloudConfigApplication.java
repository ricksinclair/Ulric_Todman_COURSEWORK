package com.company.motocloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer // tells spring to enable the features in the Config Server starter dependencies- turns our application into a Config Server.
public class MotoCloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotoCloudConfigApplication.class, args);
	}

}
