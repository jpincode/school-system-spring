package com.jpdevv.school_system;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolSystemApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("School System Application has started successfully!");
	}

}
