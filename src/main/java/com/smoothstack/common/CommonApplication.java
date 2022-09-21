package com.smoothstack.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication()
@ConfigurationPropertiesScan()
public class CommonApplication {

	public static void main(String[] args) {

		SpringApplication.run(CommonApplication.class, args);
	}
}
