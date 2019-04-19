package br.edu.api.iot.exception;

public class MeasurementNotFoundException extends Exception {


	private static final long serialVersionUID = 1L;
	
	public MeasurementNotFoundException(String message) {
	   super(message);	
	}

}
