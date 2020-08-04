package com.ayush.temp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(final String[] args) {
		try {
			System.out.println("Starting Application.");
			SpringApplication.run(Application.class);
			System.out.println("Started Application.");
		}catch(Exception e) {
			System.out.println("Exception "+e.getMessage());
		}
	}
}
