package br.edu.api.iot.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.edu.api.iot.dto.request.PatientRequestDto;
import br.edu.api.iot.entity.PatientEntity;

@Component
public class PatientMapper {
	
	private ModelMapper mapper;
	
	public PatientMapper() {
		mapper = new ModelMapper();
	}
	
	public PatientEntity map(PatientRequestDto patientDto) {
		PatientEntity patient = mapper.map(patientDto, PatientEntity.class);
		return patient;
	}
	
	

}
