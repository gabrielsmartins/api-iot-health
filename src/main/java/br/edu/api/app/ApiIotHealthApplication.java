package br.edu.api.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ApiIotHealthApplication  { 

	public static void main(String[] args) {
		SpringApplication.run(ApiIotHealthApplication.class, args);
	}
}
