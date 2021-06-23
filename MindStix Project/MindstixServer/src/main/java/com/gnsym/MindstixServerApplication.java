package com.gnsym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MindstixServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MindstixServerApplication.class, args);
	}

}
