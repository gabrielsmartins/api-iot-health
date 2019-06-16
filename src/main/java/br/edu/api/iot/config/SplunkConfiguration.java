package br.edu.api.iot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.splunk.HttpService;
import com.splunk.SSLSecurityProtocol;
import com.splunk.Service;
import com.splunk.ServiceArgs;

@Configuration
public class SplunkConfiguration {

	@Bean
	public Service serviceSplunk() {
		HttpService.setSslSecurityProtocol(SSLSecurityProtocol.TLSv1_2);

		ServiceArgs loginArgs = new ServiceArgs();
		loginArgs.setUsername("admin");
		loginArgs.setPassword("changeme");
		loginArgs.setHost("localhost");
		loginArgs.setPort(8089);
		loginArgs.setApp("api-iot-health");
		return Service.connect(loginArgs);
	}
}
