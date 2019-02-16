package br.edu.api.iot.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.api.iot.dto.request.PatientRequestDto;
import br.edu.api.iot.dto.response.PatientResponseDto;
import br.edu.api.iot.entity.PatientEntity;
import br.edu.api.iot.exception.PatientNotFoundException;
import br.edu.api.iot.mapper.PatientMapper;
import br.edu.api.iot.service.PatientService;

@RestController
@RequestMapping(value="/api-iot-health/patient")
public class PatientController {
	
	@Autowired
	private PatientService service;
	
	@Autowired
	private PatientMapper mapper;
	
	@PostMapping()
	public ResponseEntity<?> storePatient(@RequestBody PatientRequestDto patientDto) {
		PatientEntity patient = mapper.map(patientDto);
		patient = service.store(patient);
		return new ResponseEntity<Long>(patient.getId(), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id_patient}")
	public ResponseEntity<PatientResponseDto> findPatientById(@PathVariable("id_patient") Long patientId) throws PatientNotFoundException{
		PatientEntity patient = service.findById(patientId);
		ModelMapper mapper = new ModelMapper();
		PatientResponseDto patientResponseDto = mapper.map(patient, PatientResponseDto.class);
		return new ResponseEntity<PatientResponseDto>(patientResponseDto, HttpStatus.OK);
	}
}
