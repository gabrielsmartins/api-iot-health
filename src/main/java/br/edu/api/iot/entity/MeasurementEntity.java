package br.edu.api.iot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.api.iot.converter.MeasurementTypeEnumConverter;
import br.edu.api.iot.enumeration.MeasurementTypeEnum;

@Entity
@Table(name="TBMEASUREMENT")
public class MeasurementEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private MeasurementEntityId measurementEntityId;
	
	@Column(name="CVVALUE", nullable=false)
	private Double value;
	
	@Column(name="CVMEASURTYPE", nullable=false)
	@Convert(converter=MeasurementTypeEnumConverter.class)
	private MeasurementTypeEnum measurementType;
	
	@Column(name="CVUNIT", nullable=false)
	private String unit;
	
	

	public MeasurementEntity(MeasurementEntityId measurementEntityId, Double value, MeasurementTypeEnum measurementType, String unit) {
		this.measurementEntityId = measurementEntityId;
		this.value = value;
		this.measurementType = measurementType;
		this.unit = unit;
	}
	
	

	public MeasurementEntity() {

	}


	public MeasurementEntityId getMeasurementEntityId() {
		return measurementEntityId;
	}

	public void setMeasurementEntityId(MeasurementEntityId measurementEntityId) {
		this.measurementEntityId = measurementEntityId;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public MeasurementTypeEnum getMeasurementType() {
		return measurementType;
	}

	public void setMeasurementType(MeasurementTypeEnum measurementType) {
		this.measurementType = measurementType;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	
	
	
}
