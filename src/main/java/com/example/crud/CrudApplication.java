package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class CrudApplication {


	public static void main(String[] args) throws Exception {
		SpringApplication springApplication = new SpringApplication(CrudApplication.class);
		springApplication.run(args);
	}
}

