package br.edu.api.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBPATIENT")
public class PatientEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CVPATIENTID", nullable = false)
	private Long id;

	@Column(name = "CCNAME", nullable = false)
	private String name;

	@Column(name = "CVWEIGHT", nullable = false)
	private Double weight;

	@Column(name = "CVHEIGHT", nullable = false)
	private Double height;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "measurementEntityId.patient")
	private List<MeasurementEntity> measurements = new LinkedList<>();

	public PatientEntity(Long id, String name, Double weight, Double height) {
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.height = height;
	}

	public PatientEntity() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer addMeasurement(MeasurementEntity measurment) {

		if (!this.measurements.contains(measurment)) {
			this.measurements.add(measurment);
		}

		return this.measurements.size();

	}

	public Integer removeHeartRate(MeasurementEntity measurment) {

		if (this.measurements.contains(measurment)) {
			this.measurements.remove(measurment);
		}

		return this.measurements.size();

	}

}
