package com.microservice.configurationuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationConfigUsers {

	public static void main(String[] args) 
	{
		SpringApplication.run(ApplicationConfigUsers.class, args);		
	}
	
}
