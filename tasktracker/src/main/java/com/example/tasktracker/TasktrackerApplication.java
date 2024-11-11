package com.example.tasktracker;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition
@SpringBootApplication
public class TasktrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasktrackerApplication.class, args);
	}

}
