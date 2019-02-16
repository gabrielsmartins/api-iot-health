package br.edu.api.iot.dto.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatientRequestDto implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@JsonProperty("name")
	private String name;

	@JsonProperty("weight")
	private Double weight;

	@JsonProperty("height")
	private Double height;
	
	public PatientRequestDto() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
	
	

}
