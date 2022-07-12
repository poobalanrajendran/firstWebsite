package com.chainsys.miniproject.pojo;

import java.util.Date;

public class Appointments {

	private int appointment_id; 
	private Date appointment_date; 
	private int doctor_id; 
	private String patient_name; 
	private float fees_collected; 
	private String fees_category;
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	public Date getAppointment_date() {
		return appointment_date;
	}
	public void setAppointment_date(Date appointment_date) {
		this.appointment_date = appointment_date;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public float getFees_collected() {
		return fees_collected;
	}
	public void setFees_collected(float fees_collected) {
		this.fees_collected = fees_collected;
	}
	public String getFees_category() {
		return fees_category;
	}
	public void setFees_category(String fees_category) {
		this.fees_category = fees_category;
	} 
	
}
