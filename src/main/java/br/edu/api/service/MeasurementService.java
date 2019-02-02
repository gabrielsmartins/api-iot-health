package br.edu.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.api.entity.MeasurementEntity;
import br.edu.api.repository.MeasurementRepository;

@Service
public class MeasurementService implements IMeasurementService {
	
	@Autowired
	private MeasurementRepository repository;

	@Override
	public MeasurementEntity store(MeasurementEntity measurement) {
		return repository.save(measurement);

	}

}
