package br.edu.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.api.dto.MeasurementDto;
import br.edu.api.service.MeasurementService;

@RestController
@RequestMapping("/api-iot-health")
public class MeasurementController {
	
	@Autowired
	private MeasurementService service;
	
	@PostMapping("/measurement")
	public ResponseEntity<?> storeMeasurement(@RequestBody MeasurementDto measurementDto) {
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
