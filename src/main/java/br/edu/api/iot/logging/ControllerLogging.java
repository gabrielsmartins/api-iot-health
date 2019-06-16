package br.edu.api.iot.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.splunk.logging.SplunkCimLogEvent;

@Aspect
@Component
public class ControllerLogging {

	private static final Logger LOGGER = LoggerFactory.getLogger("splunk.logger");
	
	private static final String  SUCCESS = "SUCCESS";
	
	private static final String  ERROR = "ERROR";
	
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
		SplunkCimLogEvent event = new SplunkCimLogEvent("Before :" + joinPoint.getSignature().getDeclaringType().getSimpleName(), LocalDateTime.now().format(dateTimeFormatter));
		event.addField("CLASS", joinPoint.getSignature().getDeclaringType());
		event.addField("METHOD", joinPoint.getSignature().getName());
		event.addField("STATUS", SUCCESS);
		LOGGER.info(event.toString());
	}

	@AfterThrowing(pointcut = "restController() && allMethod()", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Exception e) {
		SplunkCimLogEvent event = new SplunkCimLogEvent("Error :" + joinPoint.getSignature().getDeclaringType().getSimpleName(), LocalDateTime.now().format(dateTimeFormatter));
		event.addField("CLASS", joinPoint.getSignature().getDeclaringType().getSimpleName());
		event.addField("METHOD", joinPoint.getSignature().getName());
		event.addField("EXCEPTION", e.getMessage());
		event.addField("CAUSE", e.getCause());
		event.addField("STATUS", ERROR);
		LOGGER.info(event.toString());
	}

	@After("restController() && allMethod()")
	public void after(JoinPoint joinPoint) {
		SplunkCimLogEvent event = new SplunkCimLogEvent("After :" + joinPoint.getSignature().getDeclaringType().getSimpleName(), LocalDateTime.now().format(dateTimeFormatter));
		event.addField("CLASS", joinPoint.getSignature().getDeclaringType());
		event.addField("METHOD", joinPoint.getSignature().getName());
		event.addField("STATUS", SUCCESS);
		LOGGER.info(event.toString());
	}

}
