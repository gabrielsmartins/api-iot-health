package br.edu.api.converter;

import javax.persistence.AttributeConverter;

import br.edu.api.enumeration.MeasurementTypeEnum;

public class MeasurementTypeEnumConverter implements AttributeConverter<MeasurementTypeEnum, Integer>{

	@Override
	public Integer convertToDatabaseColumn(MeasurementTypeEnum measurement) {
		return measurement.getCode();
	}

	@Override
	public MeasurementTypeEnum convertToEntityAttribute(Integer value) {
		return MeasurementTypeEnum.fromValue(value);
	}

}
