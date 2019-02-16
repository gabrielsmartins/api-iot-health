package br.edu.api.iot.service;

import br.edu.api.iot.entity.MeasurementEntity;

public interface IMeasurementService {
	
	public MeasurementEntity store(MeasurementEntity measurement);

}
