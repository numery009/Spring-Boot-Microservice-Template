package com.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import javax.validation.constraints.NotNull;

/*
* demonstrates how service-specific properties can be injected
*/
@ConfigurationProperties(prefix = "person.service", ignoreUnknownFields = false)
@Component
public class ServiceProperties {
	
	//Person Change Name
	
	@NotNull // you can also create configurationPropertiesValidator
	private String name = "Person Spring Data JPA Service";
	
	@NotNull // you can also create configurationPropertiesValidator
	private String description = "Person Spring Data JPA Service for demoing Microservices with Database Features";

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
