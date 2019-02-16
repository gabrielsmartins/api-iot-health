package br.edu.api.iot.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.api.iot.dto.PatientDto;
import br.edu.api.iot.entity.PatientEntity;
import br.edu.api.iot.service.PatientService;

@RestController
@RequestMapping(value="/api-iot-health/patient")
public class PatientController {
	
	@Autowired
	private PatientService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping()
	public ResponseEntity<?> storePatient(@RequestBody PatientDto patientDto) {
		PatientEntity patient = mapper.map(patientDto, PatientEntity.class);
		patient = service.store(patient);
		return new ResponseEntity<Long>(patient.getId(), HttpStatus.CREATED);
	}

}
