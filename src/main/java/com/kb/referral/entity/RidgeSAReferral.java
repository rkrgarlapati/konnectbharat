package com.kb.referral.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by garlapati on 11/4/2016.
 */
@Entity
@Table(name = "RIDGE_SA")
public class RidgeSAReferral {
	
	@Id
	private String sa_id;
	@Column(name="acct_id")
	private String acctId;
	private String type;
	private Date list_dt;
	private Date start_dt;
	private String sa_status_flg;
	private String area;
	private String city;
	private String actual_party_name;
	private String actual_party_contact;
	private String contact_type;
	
	public String getSa_id() {
		return sa_id;
	}
	public void setSa_id(String sa_id) {
		this.sa_id = sa_id;
	}
	public String getAcctId() {
		return acctId;
	}
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getList_dt() {
		return list_dt;
	}
	public void setList_dt(Date list_dt) {
		this.list_dt = list_dt;
	}
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
	public String getActual_party_name() {
		return actual_party_name;
	}
	public void setActual_party_name(String actual_party_name) {
		this.actual_party_name = actual_party_name;
	}
	public String getActual_party_contact() {
		return actual_party_contact;
	}
	public void setActual_party_contact(String actual_party_contact) {
		this.actual_party_contact = actual_party_contact;
	}
	public String getContact_type() {
		return contact_type;
	}
	public void setContact_type(String contact_type) {
		this.contact_type = contact_type;
	}
}