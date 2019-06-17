package br.edu.api.iot.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class ControllerLogging {

	private static final Logger LOGGER = LoggerFactory.getLogger("splunk.logger");
	
	private static final String  SUCCESS = "success";
	
	private static final String  ERROR = "error";
	
	@Autowired
	private ObjectMapper mapper;
	
	
	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void restController() {

	}

	@Pointcut("execution(public * *(..))")
	public void allMethod() {

	}

	@Before("restController() && allMethod()")
	public void before(JoinPoint joinPoint) {
		Map<String, Object> properties = new LinkedHashMap<String, Object>();
		properties.put("datetime", LocalDateTime.now().format(dateTimeFormatter));
		properties.put("class", joinPoint.getSignature().getDeclaringType());
		properties.put("method", joinPoint.getSignature().getName());
		properties.put("status", SUCCESS);
		LOGGER.info(toJson(properties));
	}

	@AfterThrowing(pointcut = "restController() && allMethod()", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Exception e) {
		Map<String, Object> properties = new LinkedHashMap<String, Object>();
		properties.put("class", joinPoint.getSignature().getDeclaringType().getSimpleName());
		properties.put("method", joinPoint.getSignature().getName());
		properties.put("exception", e.getMessage());
		properties.put("cause", e.getCause());
		properties.put("status", ERROR);
		LOGGER.info(toJson(properties));
	}

	@After("restController() && allMethod()")
	public void after(JoinPoint joinPoint) {
		Map<String, Object> properties = new LinkedHashMap<String, Object>();
		properties.put("datetime", LocalDateTime.now().format(dateTimeFormatter));
		properties.put("class", joinPoint.getSignature().getDeclaringType());
		properties.put("method", joinPoint.getSignature().getName());
		properties.put("status", SUCCESS);
		LOGGER.info(toJson(properties));
	}
	
	
	private String toJson(Map<String, Object> properties) {
		try {
			return 	mapper.writeValueAsString(properties);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
