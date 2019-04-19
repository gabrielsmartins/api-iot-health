package br.edu.api.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.edu.api.iot.exception.MeasurementNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MeasurementNotFoundException.class)
	public ResponseEntity<?> handleConflict(MeasurementNotFoundException ex, WebRequest request) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
