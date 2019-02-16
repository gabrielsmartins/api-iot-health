package br.edu.api.iot.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.api.iot.dto.MeasurementDto;
import br.edu.api.iot.entity.MeasurementEntity;
import br.edu.api.iot.entity.MeasurementEntityId;
import br.edu.api.iot.enumeration.MeasurementTypeEnum;

@Configuration
public class ModelMapperConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(new PropertyMap<MeasurementDto, MeasurementEntity>() {

			@Override
			protected void configure() {
				map().setMeasurementEntityId(new MeasurementEntityId());
				map().getMeasurementEntityId().setDateTime(source.getDatetime());
				map().setMeasurementType(MeasurementTypeEnum.fromValue(source.getMeasurementType()));
			}
		});
		
		return mapper;
	}
}
