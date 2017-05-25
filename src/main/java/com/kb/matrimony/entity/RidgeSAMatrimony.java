package com.kb.matrimony.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "RIDGE_SA_MATRIMONY")
public class RidgeSAMatrimony {

	@Id
	private String sa_id;
	private String country;
	private String name;
	//@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private String dob;
	private String education;
	private String religion;
	private String caste;
	private String subcaste;
	private String height;
	private String family_details;
	private String employment;
	private String addl_dtls;
	private String marital_status;
	private String food;
	private String smoking;
	private String drinking;
	private String horoscope;
	
	public String getSa_id() {
		return sa_id;
	}
	public void setSa_id(String sa_id) {
		this.sa_id = sa_id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	public String getSubcaste() {
		return subcaste;
	}
	public void setSubcaste(String subcaste) {
		this.subcaste = subcaste;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getFamily_details() {
		return family_details;
	}
	public void setFamily_details(String family_details) {
		this.family_details = family_details;
	}
	public String getEmployment() {
		return employment;
	}
	public void setEmployment(String employment) {
		this.employment = employment;
	}
	public String getAddl_dtls() {
		return addl_dtls;
	}
	public void setAddl_dtls(String addl_dtls) {
		this.addl_dtls = addl_dtls;
	}
	public String getMarital_status() {
		return marital_status;
	}
	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	public String getDrinking() {
		return drinking;
	}
	public void setDrinking(String drinking) {
		this.drinking = drinking;
	}
	public String getHoroscope() {
		return horoscope;
	}
	public void setHoroscope(String horoscope) {
		this.horoscope = horoscope;
	} 
}
