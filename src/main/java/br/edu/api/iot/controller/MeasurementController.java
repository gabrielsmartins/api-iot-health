package br.edu.api.iot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.api.iot.dto.request.MeasurementRequestDto;
import br.edu.api.iot.dto.response.MeasurementResponseDto;
import br.edu.api.iot.entity.MeasurementEntity;
import br.edu.api.iot.exception.MeasurementNotFoundException;
import br.edu.api.iot.mapper.MeasurementMapper;
import br.edu.api.iot.service.MeasurementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/v1")
@Api("API IoT Health - Measurement Documentation")
public class MeasurementController {
	
	@Autowired
	private MeasurementService service;
	
	@Autowired
	private MeasurementMapper mapper;
	
	@PostMapping("/measurement")
	@ApiOperation("Store a new Measurement")
	public ResponseEntity<?> storeMeasurement(@RequestBody MeasurementRequestDto measurementDto) {
		MeasurementEntity measurementEntity = mapper.map(measurementDto);
		service.store(measurementEntity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@GetMapping("/measurement/patient/{id_patient}")
	@ApiOperation("Find Measurements By Patient ID")
	public ResponseEntity<List<MeasurementResponseDto>> findByPatientId(@PathVariable("id_patient") Long  patientId) throws MeasurementNotFoundException {
		List<MeasurementEntity> measurements = service.findByPatientId(patientId);
		List<MeasurementResponseDto> measurementsResponse = mapper.map(measurements);
		return new ResponseEntity<List<MeasurementResponseDto>>(measurementsResponse, HttpStatus.OK);
	}
	


}
