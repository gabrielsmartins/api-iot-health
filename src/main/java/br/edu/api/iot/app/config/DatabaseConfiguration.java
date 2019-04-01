package br.edu.api.iot.app.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfiguration {

	 @Value("${spring.datasource.url}")
	  private String url;
	 
	 @Value("${spring.datasource.username}")
	  private String username;
	 
	 @Value("${spring.datasource.password}")
	  private String password;
	 

	  @Bean
	  public DataSource dataSource() {
	      HikariConfig config = new HikariConfig();
	      config.setJdbcUrl(url);
	      config.setUsername(username);
	      config.setPassword(password);
	      return new HikariDataSource(config);
	  }
	  
}