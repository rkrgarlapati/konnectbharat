package com.kb.matrimony.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Component
public class Matrimony {

	private Integer matri_user_id;

	private String matri_party_name;
	private String agreement_type;
	private String matri_phone;
	
	private String address1;
	private String address2;
	private String area;
	private String city;
	private String state;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    Date setup_dt = new Date();
	
	private String postal;
	private String country;
	private String bride_name;
	//@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private String dob;
	private String highest_education;
	private String religion;
	private String caste;
	private String sub_caste;
	private String height;
	private String family_details;
	private String employment;
	private String additional_details;
	private String marital_status;
	private String food;
	private String smoking;
	private String drinking;
	private String horoscope_available;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_date = new Date();
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified_date= new Date();
	private String created_by;
	private String modified_by;
	private String sa_status_flg;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start_dt;
	
    public Date getStart_dt() {
		return start_dt;
	}

	public void setStart_dt(Date start_dt) {
		this.start_dt = start_dt;
	}

	public String getSa_status_flg() {
		return sa_status_flg;
	}

	public void setSa_status_flg(String sa_status_flg) {
		this.sa_status_flg = sa_status_flg;
	}

	public Integer getMatri_user_id() {
		return matri_user_id;
	}
	public void setMatri_user_id(Integer matri_user_id) {
		this.matri_user_id = matri_user_id;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getSetup_dt() {
		return setup_dt;
	}
	public void setSetup_dt(Date setup_dt) {
		this.setup_dt = setup_dt;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getBride_name() {
		return bride_name;
	}
	public void setBride_name(String bride_name) {
		this.bride_name = bride_name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getHighest_education() {
		return highest_education;
	}
	public void setHighest_education(String highest_education) {
		this.highest_education = highest_education;
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
	public String getSub_caste() {
		return sub_caste;
	}
	public void setSub_caste(String sub_caste) {
		this.sub_caste = sub_caste;
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
	public String getAdditional_details() {
		return additional_details;
	}
	public void setAdditional_details(String additional_details) {
		this.additional_details = additional_details;
	}
	
	public String getFood() {
		return food;
	}
	public String getMarital_status() {
		return marital_status;
	}
	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
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
	public String getHoroscope_available() {
		return horoscope_available;
	}
	public void setHoroscope_available(String horoscope_available) {
		this.horoscope_available = horoscope_available;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getModified_date() {
		return modified_date;
	}
	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public String getMatri_party_name() {
		return matri_party_name;
	}
	public void setMatri_party_name(String matri_party_name) {
		this.matri_party_name = matri_party_name;
	}
	public String getAgreement_type() {
		return agreement_type;
	}
	public void setAgreement_type(String agreement_type) {
		this.agreement_type = agreement_type;
	}
	public String getMatri_phone() {
		return matri_phone;
	}
	public void setMatri_phone(String matri_phone) {
		this.matri_phone = matri_phone;
	}
	@Override
	public String toString() {
		return "Matrimony [matri_user_id=" + matri_user_id + ", matri_party_name=" + matri_party_name
				+ ", agreement_type=" + agreement_type + ", matri_phone=" + matri_phone + ", address1="
				+ address1 + ", address2=" + address2 + ", area=" + area + ", city=" + city + ", state=" + state
				+ ", setup_dt=" + setup_dt + ", postal=" + postal + ", country=" + country + ", bride_name="
				+ bride_name + ", dob=" + dob + ", highest_education=" + highest_education + ", religion=" + religion
				+ ", caste=" + caste + ", sub_caste=" + sub_caste + ", height=" + height + ", family_details="
				+ family_details + ", employment=" + employment + ", additional_details=" + additional_details
				+ ", marital_status=" + marital_status + ", food=" + food + ", smoking=" + smoking + ", drinking="
				+ drinking + ", horoscope_available=" + horoscope_available + ", created_date=" + created_date
				+ ", modified_date=" + modified_date + ", created_by=" + created_by + ", modified_by=" + modified_by
				+ "]";
	}

	
	
}
