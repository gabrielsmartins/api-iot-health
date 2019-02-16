package br.edu.api.app.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"br.edu.api.iot.*"})
@EntityScan(basePackages= {"br.edu.api.iot.entity"})
@EnableJpaRepositories(basePackages= {"br.edu.api.iot.repository"})
public class ApiIotHealthApplication  { 

	public static void main(String[] args) {
		SpringApplication.run(ApiIotHealthApplication.class, args);
	}
}
