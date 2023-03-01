package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.example.demo"})
@SpringBootApplication
public class EmployeeRegistration {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRegistration.class, args);
	}

}
