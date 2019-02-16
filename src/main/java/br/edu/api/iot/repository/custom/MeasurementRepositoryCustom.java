package br.edu.api.iot.repository.custom;

import java.util.List;

import br.edu.api.iot.entity.MeasurementEntity;
import br.edu.api.iot.enumeration.MeasurementTypeEnum;

public interface MeasurementRepositoryCustom {
	
	public List<MeasurementEntity> findByPatientId(Long patientId);
	
	public List<MeasurementEntity> findByPatientIdAndMeasurementType(Long patientId, MeasurementTypeEnum measurementType);

}
