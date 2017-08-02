package com.coolapps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppSentenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSentenceApplication.class, args);
	}
}
