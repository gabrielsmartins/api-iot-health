package br.edu.api.iot.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.api.iot.dto.MeasurementDto;
import br.edu.api.iot.entity.MeasurementEntity;
import br.edu.api.iot.entity.PatientEntity;
import br.edu.api.iot.enumeration.MeasurementTypeEnum;
import br.edu.api.iot.repository.PatientRepository;
import br.edu.api.iot.service.MeasurementService;

@RestController
@RequestMapping(value="/api-iot-health/measurement")
public class MeasurementController {
	
	@Autowired
	private MeasurementService service;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping()
	public ResponseEntity<?> storeMeasurement(@RequestBody MeasurementDto measurementDto) {
		MeasurementEntity measurementEntity = mapper.map(measurementDto, MeasurementEntity.class);
		PatientEntity patient = patientRepository.findById(measurementDto.getPatientyId()).get();
		measurementEntity.getMeasurementEntityId().setPatient(patient);
		service.store(measurementEntity);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	


}
