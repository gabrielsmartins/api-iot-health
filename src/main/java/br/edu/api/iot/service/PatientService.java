package br.edu.api.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.api.iot.entity.PatientEntity;
import br.edu.api.iot.repository.PatientRepository;

@Service
public class PatientService implements IPatientService{
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public PatientEntity store(PatientEntity patient) {
		return patientRepository.saveAndFlush(patient);
	}

}
