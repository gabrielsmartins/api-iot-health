package br.edu.api.iot.service;

import java.util.List;

import br.edu.api.iot.entity.MeasurementEntity;
import br.edu.api.iot.enumeration.MeasurementTypeEnum;

public interface IMeasurementService {
	
	public MeasurementEntity store(MeasurementEntity measurement);
	
	public List<MeasurementEntity> findByPatientId(Long patientId);
	
	public List<MeasurementEntity> findByPatientIdAndMeasurementType(Long patientId, MeasurementTypeEnum measurementType);

}
