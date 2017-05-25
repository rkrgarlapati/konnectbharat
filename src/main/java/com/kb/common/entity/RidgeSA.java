package com.kb.common.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Created by garlapati on 11/4/2016.
 */
@Entity
@Table(name = "RIDGE_SA")
public class RidgeSA implements Serializable{
	@Id
	private String sa_id;
	@Column(name="acct_id")
	private String acctId;
	private String town_city;
	private String type;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date list_dt;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start_dt;
	@Column(name="sa_status_flg")
	private String statusflg;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end_dt;
	private Double est_bill_amt;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expire_dt;
	private String address1;
	private String address2;
	private String area;
	private String city;
	private String state;
	private String postal;
	private String actual_party_name;
	private String actual_party_contact;
	private String contact_type;
	private Double ref_amt;
	
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
	public String getTown_city() {
		return town_city;
	}
	public void setTown_city(String town_city) {
		this.town_city = town_city;
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
	public String getStatusflg() {
		return statusflg;
	}
	public void setStatusflg(String statusflg) {
		this.statusflg = statusflg;
	}
	public Date getEnd_dt() {
		return end_dt;
	}
	public void setEnd_dt(Date end_dt) {
		this.end_dt = end_dt;
	}
	public Double getEst_bill_amt() {
		return est_bill_amt;
	}
	public void setEst_bill_amt(Double est_bill_amt) {
		this.est_bill_amt = est_bill_amt;
	}
	public Date getExpire_dt() {
		return expire_dt;
	}
	public void setExpire_dt(Date expire_dt) {
		this.expire_dt = expire_dt;
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
	public Double getRef_amt() {
		return ref_amt;
	}
	public void setRef_amt(Double ref_amt) {
		this.ref_amt = ref_amt;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "RidgeSA [sa_id=" + sa_id + ", acctId=" + acctId + ", town_city=" + town_city + ", type=" + type
				+ ", list_dt=" + list_dt + ", start_dt=" + start_dt + ", statusflg=" + statusflg + ", end_dt="
				+ end_dt + ", est_bill_amt=" + est_bill_amt + ", expire_dt=" + expire_dt + ", address1=" + address1
				+ ", address2=" + address2 + ", area=" + area + ", city=" + city + ", state=" + state + ", postal="
				+ postal + ", actual_party_name=" + actual_party_name + ", actual_party_contact=" + actual_party_contact
				+ ", contact_type=" + contact_type + ", ref_amt=" + ref_amt + "]";
	}
	
}
