package br.edu.api.iot.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Measurement Response")
public class MeasurementResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("patient_id")
	private Long patientyId;
	
	@JsonProperty("datetime")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime datetime;
	
	@JsonProperty("measurement_type")
	@ApiModelProperty(dataType = "string", allowableValues = "HEARTRATE, OXYGEN SATURATION, TEMPERATURE", value = "description", notes = "notes")
	private String measurementType;
	
	@JsonProperty("measurement_value")
	private Double measurementValue;
	
	@JsonProperty("measurement_unit")
	private String  measurementUnit;
	
	public MeasurementResponseDto() {
		
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

	public String getMeasurementType() {
		return measurementType;
	}

	public void setMeasurementType(String measurementType) {
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
