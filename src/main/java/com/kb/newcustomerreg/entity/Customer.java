package com.kb.newcustomerreg.entity;

import com.kb.utility.Constants;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RIDGE_PER")
public class Customer {

	@Id
	private String per_id;
	private String per_name = Constants.EMPTY_STRING;
	private String per_or_bus_flg = Constants.EMPTY_STRING;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date setup_dt = new Date();
	private String emailid = Constants.EMPTY_STRING;
	private String address1 = Constants.EMPTY_STRING;
	private String address2 = Constants.EMPTY_STRING;
	private String area = Constants.EMPTY_STRING;
	private String city = Constants.EMPTY_STRING;
	private String postal = Constants.EMPTY_STRING;
	private String state = Constants.EMPTY_STRING;
	@Column(name = "web_userid")
	private String webuserid = Constants.EMPTY_STRING;
	private String web_passwd = Constants.EMPTY_STRING;
	private String web_pwd_hint_flg = Constants.EMPTY_STRING;
	private String web_passwd_ans = Constants.EMPTY_STRING;
	private String per_type;

	public String getPer_type() {
		return per_type;
	}

	public void setPer_type(String per_type) {
		this.per_type = per_type;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date = new Date();
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified_date = new Date();
	private String created_by = Constants.EMPTY_STRING;
	private String modified_by = Constants.EMPTY_STRING;
	public String getPer_id() {
		return per_id;
	}
	public void setPer_id(String per_id) {
		this.per_id = per_id;
	}
	public String getPer_name() {
		return per_name;
	}
	public void setPer_name(String per_name) {
		this.per_name = per_name;
	}
	public String getPer_or_bus_flg() {
		return per_or_bus_flg;
	}
	public void setPer_or_bus_flg(String per_or_bus_flg) {
		this.per_or_bus_flg = per_or_bus_flg;
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

	public String getWebuserid() {
		return webuserid;
	}

	public void setWebuserid(String webuserid) {
		this.webuserid = webuserid;
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
}
