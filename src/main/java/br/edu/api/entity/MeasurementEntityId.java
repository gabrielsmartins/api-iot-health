package br.edu.api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class MeasurementEntityId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="CVPATIENTID", referencedColumnName="CVPATIENTID")
	private PatientEntity patient;
	
	@Column(name="CDDATETIME", nullable=false)
	private LocalDateTime dateTime;
	
	

	public MeasurementEntityId(PatientEntity patient, LocalDateTime dateTime) {;
		this.patient = patient;
		this.dateTime = dateTime;
	}
	
	

	public MeasurementEntityId() {

	}


	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	

}
