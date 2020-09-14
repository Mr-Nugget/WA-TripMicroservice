package com.wildadventure.trip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients("com.wildadventure")
@EnableDiscoveryClient
public class TripApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripApplication.class, args);
	}
}
