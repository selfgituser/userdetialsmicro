package com.ecom.userDetails.userDetailsMicro;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserDetailsMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDetailsMicroApplication.class, args);
	}

}
