package com.jpdevv.schoolsys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpdevv.schoolsys.presentation.view.Menu;

@SpringBootApplication
public class SchoolSystemApplication implements CommandLineRunner {
	@Autowired
	private Menu menu;
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("School System Application has started successfully!");
		menu.displayMainMenu();
	}

}
