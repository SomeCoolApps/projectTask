package com.coolapps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication

public class AppSubjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSubjectApplication.class, args);
	}
}
