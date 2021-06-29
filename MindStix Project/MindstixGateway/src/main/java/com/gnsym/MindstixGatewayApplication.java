package com.gnsym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
//@EnableWebSecurity
public class MindstixGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MindstixGatewayApplication.class, args);
	}

}
