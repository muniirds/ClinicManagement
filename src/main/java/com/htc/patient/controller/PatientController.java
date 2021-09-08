package com.htc.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.htc.patient.dao.PatientInterface;
import com.htc.patient.entity.Patient;

@RestController
@RequestMapping("/api")
public class PatientController {

	@Autowired
	private PatientInterface patientInterface;

	@GetMapping("/patients/{patientId}")
	public Patient getPatientById(@PathVariable Long patientId) {
		Patient patient = null;

		patient = patientInterface.findById(patientId).get();
		return patient;

	}

	@GetMapping("/patients/{patientFirstName}")
	public Patient findByPatient_first_name(@RequestParam String patientFirstName) {

		return patientInterface.findByPatientfirstname(patientFirstName);
	}

	@GetMapping("/patients/{patientLastName}")
	public Patient findByPatient_last_name(@RequestParam String patientLastName) {

		return patientInterface.findByPatientlastname(patientLastName);
	}

	@GetMapping("/patients/{phoneNumber}")
	public Patient findByPhone_numbwe(@RequestParam Long phoneNumber) {

		return patientInterface.findByPhonenumber(phoneNumber);
	}

	@GetMapping("/patients")
	public List<Patient> getAllPatientss() {
		return patientInterface.findAll();
	}

	@PostMapping("/addpatients")
	public Patient createProduct(@RequestBody Patient patient) {

		return patientInterface.save(patient);
	}

	@PutMapping("/patients/{patientId}")
	Patient replacePatient(@RequestBody Patient newPatient, @PathVariable Long patientId) {

		return patientInterface.findById(patientId).map(patient -> {
			patient.setPhoneNumber(newPatient.getPhoneNumber());
			return patientInterface.save(patient);
		}).orElseGet(() -> {
			newPatient.setPatientId(patientId);
			return patientInterface.save(newPatient);
		});
	}

	@DeleteMapping("/patients/{patientId}")
	void deletePatient(@PathVariable Long patientId) {
		patientInterface.deleteById(patientId);
	}

}
