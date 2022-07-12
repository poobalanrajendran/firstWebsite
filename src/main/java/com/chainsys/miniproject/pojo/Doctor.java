package com.chainsys.miniproject.pojo;

import java.util.Date;

public class Doctor {
	private int doctor_id;    
	private String doctor_name;               
	        
	 
	private Date date;  
	private String doctor_speciality; 
	private  long phone_no; 
	private String city;
	private float standard_fees;
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public Date getdate() {
		return date;
	}
	public void setdate(Date hire_date) {
		this.date = hire_date;
	}
	public String getDoctor_speciality() {
		return doctor_speciality;
	}
	public void setDoctor_speciality(String doctor_speciality) {
		this.doctor_speciality = doctor_speciality;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	public float getStandard_fees() {
		return standard_fees;
	}
	public void setStandard_fees(float standard_fees) {
		this.standard_fees = standard_fees;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
