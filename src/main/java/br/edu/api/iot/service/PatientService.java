package br.edu.api.iot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.edu.api.iot.entity.PatientEntity;
import br.edu.api.iot.exception.PatientNotFoundException;
import br.edu.api.iot.repository.PatientRepository;

@Service
public class PatientService implements IPatientService{
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public PatientEntity store(PatientEntity patient) {
		return patientRepository.saveAndFlush(patient);
	}

	@Override
	public PatientEntity update(PatientEntity patient)  throws PatientNotFoundException{
		Optional<PatientEntity> optionalPatient = patientRepository.findById(patient.getId());
		if(!optionalPatient.isPresent())
			throw new PatientNotFoundException("Patient Not Found");
		PatientEntity patientFound = optionalPatient.get();
		patientFound = patient;
		return patientRepository.saveAndFlush(patientFound);
	}

	@Override
	@Cacheable(value="patient")
	public PatientEntity findById(Long patientId)  throws PatientNotFoundException {
		Optional<PatientEntity> optionalPatient = patientRepository.findById(patientId);
		if(!optionalPatient.isPresent())
			throw new PatientNotFoundException("Patient Not Found");
		return optionalPatient.get();
	}

	@Override
	@Cacheable(value="patients")
	public List<PatientEntity> findAll() {
		List<PatientEntity> patients = patientRepository.findAll();
		return patients;
	}

}
