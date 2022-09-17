package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InsuranceAppApplication {

	public static void main(String[] args) {
		System.out.println("Start");
		SpringApplication.run(InsuranceAppApplication.class, args);
		System.out.println("End");
	}

}
