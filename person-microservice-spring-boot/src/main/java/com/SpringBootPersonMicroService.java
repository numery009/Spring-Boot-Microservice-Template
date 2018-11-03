package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration // Sprint Boot Auto Configuration
@ComponentScan(basePackages = "com")
@EnableSwagger2
public class SpringBootPersonMicroService {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPersonMicroService.class, args);
	}
}
