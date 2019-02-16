package br.edu.api.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.api.iot.entity.MeasurementEntity;
import br.edu.api.iot.repository.MeasurementRepository;

@Service
public class MeasurementService implements IMeasurementService {
	
	@Autowired
	private MeasurementRepository repository;

	@Override
	public MeasurementEntity store(MeasurementEntity measurement) {
		return repository.saveAndFlush(measurement);

	}

}
