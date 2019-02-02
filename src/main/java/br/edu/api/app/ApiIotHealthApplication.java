package br.edu.api.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableAutoConfiguration
public class ApiIotHealthApplication extends SpringBootServletInitializer { 

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApiIotHealthApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiIotHealthApplication.class, args);
	}
}
