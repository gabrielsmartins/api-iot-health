package br.edu.api.iot.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket api(ServletContext servletContext) throws UnknownHostException {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.edu.api.iot.controller"))
				.paths(PathSelectors.any())
				.build()
				.host(InetAddress.getLocalHost().getHostAddress())
			    .pathProvider(new RelativePathProvider(servletContext) {
			        @Override
			        public String getApplicationBasePath() {
			            return "/api-iot-health/v1";
			        }
			    })
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Api IoT Health")
				.version("1.0.0")
				.description("Api para armazenamento de dados de frequência cardíaca, oxigenação e temperatura")
				.build();
	}


}
