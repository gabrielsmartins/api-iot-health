package br.edu.api.iot.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.api.iot.dto.request.MeasurementRequestDto;
import br.edu.api.iot.entity.MeasurementEntity;
import br.edu.api.iot.entity.MeasurementEntityId;
import br.edu.api.iot.entity.PatientEntity;
import br.edu.api.iot.enumeration.MeasurementTypeEnum;
import br.edu.api.iot.repository.PatientRepository;

@Component
public class MeasurementMapper {
	
	@Autowired
	private PatientRepository patientRepository;
	
	private ModelMapper mapper;
	
	public MeasurementMapper() {
		mapper = new ModelMapper();
		mapper.addMappings(new PropertyMap<MeasurementRequestDto, MeasurementEntity>() {

			@Override
			protected void configure() {
				map().setMeasurementEntityId(new MeasurementEntityId());
				map().getMeasurementEntityId().setDateTime(source.getDatetime());
				map().setMeasurementType(MeasurementTypeEnum.fromValue(source.getMeasurementType()));
			}
		});
	}
	
	public MeasurementEntity map(MeasurementRequestDto measurementDto) {
		PatientEntity patient = patientRepository.findById(measurementDto.getPatientyId()).get();
		MeasurementEntityId measurementEntityId = new MeasurementEntityId(patient, measurementDto.getDatetime());
		MeasurementTypeEnum measurementType = MeasurementTypeEnum.fromValue(measurementDto.getMeasurementType());
		MeasurementEntity measurement = mapper.map(measurementDto, MeasurementEntity.class);
		measurement.setMeasurementType(measurementType);
		measurement.setMeasurementEntityId(measurementEntityId);
		return measurement;
	}

}
