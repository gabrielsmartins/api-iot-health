package br.edu.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeasurementDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("patient_id")
	private Long patientyId;
	
	@JsonProperty("datetime")
	private LocalDateTime datetime;
	
	@JsonProperty("measurement_type")
	private Integer measurementType;
	
	@JsonProperty("measurement_value")
	private Double measurementValue;
	
	@JsonProperty("measurement_unit")
	private String  measurementUnit;
	
	public MeasurementDto() {
		
	}

	public Long getPatientyId() {
		return patientyId;
	}

	public void setPatientyId(Long patientyId) {
		this.patientyId = patientyId;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public Integer getMeasurementType() {
		return measurementType;
	}

	public void setMeasurementType(Integer measurementType) {
		this.measurementType = measurementType;
	}

	public Double getMeasurementValue() {
		return measurementValue;
	}

	public void setMeasurementValue(Double measurementValue) {
		this.measurementValue = measurementValue;
	}

	public String getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}
	
	

}
