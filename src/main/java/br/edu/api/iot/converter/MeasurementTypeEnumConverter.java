package br.edu.api.iot.converter;

import javax.persistence.AttributeConverter;

import br.edu.api.iot.enumeration.MeasurementTypeEnum;


public class MeasurementTypeEnumConverter implements AttributeConverter<MeasurementTypeEnum, Integer>{

	@Override
	public Integer convertToDatabaseColumn(MeasurementTypeEnum measurement) {
		if(measurement == null)
			return null;
		return measurement.getCode();
	}

	@Override
	public MeasurementTypeEnum convertToEntityAttribute(Integer value) {
		return MeasurementTypeEnum.fromValue(value);
	}

}
