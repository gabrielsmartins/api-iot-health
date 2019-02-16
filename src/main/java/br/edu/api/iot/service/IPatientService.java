package br.edu.api.iot.service;

import java.util.List;

import br.edu.api.iot.entity.PatientEntity;
import br.edu.api.iot.exception.PatientNotFoundException;

public interface IPatientService {

	public PatientEntity store(PatientEntity patient);
	
	public PatientEntity update(PatientEntity patient)  throws PatientNotFoundException;
	
	public PatientEntity findById(Long patientId) throws PatientNotFoundException;
	
	public List<PatientEntity> findAll();
}
