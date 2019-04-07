package br.edu.api.iot.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/v1")
@Api("API IoT Health - Patient Documentation")
public class PatientController {
	
	@Autowired
	private PatientService service;
	
	@Autowired
	private PatientMapper mapper;
	
	@PostMapping("/patient")
	@ApiOperation("Store a new Patient")
	public ResponseEntity<?> storePatient(@RequestBody PatientRequestDto patientDto) {
		PatientEntity patient = mapper.map(patientDto);
		patient = service.store(patient);
		return new ResponseEntity<Long>(patient.getId(), HttpStatus.CREATED);
	}
	
	@GetMapping("/patient/{id_patient}")
	@ApiOperation("Find a Patient By Id")
	public ResponseEntity<PatientResponseDto> findPatientById(@PathVariable("id_patient") Long patientId) throws PatientNotFoundException{
		PatientEntity patient = service.findById(patientId);
		ModelMapper mapper = new ModelMapper();
		PatientResponseDto patientResponseDto = mapper.map(patient, PatientResponseDto.class);
		return new ResponseEntity<PatientResponseDto>(patientResponseDto, HttpStatus.OK);
	}
	
	
	@GetMapping("/patient")
	@ApiOperation("Find All Patients")
	public ResponseEntity<List<PatientResponseDto>> findAll() throws PatientNotFoundException{
		List<PatientEntity> patients = service.findAll();	
		ModelMapper mapper = new ModelMapper();
		List<PatientResponseDto> patientsResponseDtp = mapper.map(patients, new TypeToken<List<PatientResponseDto>>() {}.getType());
		return new ResponseEntity<List<PatientResponseDto>>(patientsResponseDtp, HttpStatus.OK);
	}
}
