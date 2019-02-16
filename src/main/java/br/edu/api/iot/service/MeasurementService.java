package br.edu.api.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.api.iot.entity.MeasurementEntity;
import br.edu.api.iot.enumeration.MeasurementTypeEnum;
import br.edu.api.iot.repository.MeasurementRepository;

@Service
public class MeasurementService implements IMeasurementService {
	
	@Autowired
	private MeasurementRepository repository;

	@Override
	public MeasurementEntity store(MeasurementEntity measurement) {
		return repository.saveAndFlush(measurement);

	}

	@Override
	public List<MeasurementEntity> findByPatientId(Long patientId) {
		List<MeasurementEntity> measurements = repository.findByPatientId(patientId);
		return measurements;
	}

	@Override
	public List<MeasurementEntity> findByPatientIdAndMeasurementType(Long patientId, MeasurementTypeEnum measurementType) {
		List<MeasurementEntity> measurements = repository.findByPatientIdAndMeasurementType(patientId, measurementType);
		return measurements;
	}

}
