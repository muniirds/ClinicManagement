package com.htc.patient.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patientmanagement")
public class Patient {
	public Patient(long patientId, String patientFirstName, String patientLastName, long phoneNumber) {
		super();
		this.patientId = patientId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.phoneNumber = phoneNumber;
	}

	public Patient() {
		super();
	}

	@Id
	private long patientId;
	private String patientFirstName;
	private String patientLastName;
	private long phoneNumber;

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientFirstName=" + patientFirstName + ", patientLastName="
				+ patientLastName + ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patientFirstName == null) ? 0 : patientFirstName.hashCode());
		result = prime * result + (int) (patientId ^ (patientId >>> 32));
		result = prime * result + ((patientLastName == null) ? 0 : patientLastName.hashCode());
		result = prime * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (patientFirstName == null) {
			if (other.patientFirstName != null)
				return false;
		} else if (!patientFirstName.equals(other.patientFirstName))
			return false;
		if (patientId != other.patientId)
			return false;
		if (patientLastName == null) {
			if (other.patientLastName != null)
				return false;
		} else if (!patientLastName.equals(other.patientLastName))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		return true;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
}
