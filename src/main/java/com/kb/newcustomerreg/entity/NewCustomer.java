package com.kb.newcustomerreg.entity;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class NewCustomer {

	private String per_id;
	String first_name;
	private String second_name;
	private String per_or_bus_flg;
	private String phone;
	private String panNumber;
	private String password;
	private String reenterPassword;
	private String license;
	private String aadharNumber;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date setup_dt = new Date();
	private String emailid;
	private String address1;
	private String address2;
	private String area;
	private String city;
	private String postal;
	private String state;
	private String web_userid;
	private String web_passwd;
	private String web_pwd_hint_flg;
	private String web_passwd_ans;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date = new Date();
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified_date = new Date();
	private String created_by;
	private String modified_by;

	private String id_type_cd;
	private String per_id_nbr;
	private String prim_sw;
	private Date start_dt = new Date();
	private Date end_dt;
	public String getPer_id() {
		return per_id;
	}
	public void setPer_id(String per_id) {
		this.per_id = per_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getSecond_name() {
		return second_name;
	}
	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}
	public String getPer_or_bus_flg() {
		return per_or_bus_flg;
	}
	public void setPer_or_bus_flg(String per_or_bus_flg) {
		this.per_or_bus_flg = per_or_bus_flg;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public Date getSetup_dt() {
		return setup_dt;
	}
	public void setSetup_dt(Date setup_dt) {
		this.setup_dt = setup_dt;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
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
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getWeb_userid() {
		return web_userid;
	}
	public void setWeb_userid(String web_userid) {
		this.web_userid = web_userid;
	}
	public String getWeb_passwd() {
		return web_passwd;
	}
	public void setWeb_passwd(String web_passwd) {
		this.web_passwd = web_passwd;
	}
	public String getWeb_pwd_hint_flg() {
		return web_pwd_hint_flg;
	}
	public void setWeb_pwd_hint_flg(String web_pwd_hint_flg) {
		this.web_pwd_hint_flg = web_pwd_hint_flg;
	}
	public String getWeb_passwd_ans() {
		return web_passwd_ans;
	}
	public void setWeb_passwd_ans(String web_passwd_ans) {
		this.web_passwd_ans = web_passwd_ans;
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
	public String getId_type_cd() {
		return id_type_cd;
	}
	public void setId_type_cd(String id_type_cd) {
		this.id_type_cd = id_type_cd;
	}
	public String getPer_id_nbr() {
		return per_id_nbr;
	}
	public void setPer_id_nbr(String per_id_nbr) {
		this.per_id_nbr = per_id_nbr;
	}
	public String getPrim_sw() {
		return prim_sw;
	}
	public void setPrim_sw(String prim_sw) {
		this.prim_sw = prim_sw;
	}
	public Date getStart_dt() {
		return start_dt;
	}
	public void setStart_dt(Date start_dt) {
		this.start_dt = start_dt;
	}
	public Date getEnd_dt() {
		return end_dt;
	}
	public void setEnd_dt(Date end_dt) {
		this.end_dt = end_dt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReenterPassword() {
		return reenterPassword;
	}

	public void setReenterPassword(String reenterPassword) {
		this.reenterPassword = reenterPassword;
	}
	
	
}
