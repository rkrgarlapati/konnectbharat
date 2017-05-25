package com.kb.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Created by garlapati on 11/4/2016.
 */
@Entity
@Table(name = "RIDGE_ACCT")
@IdClass(RidgeAcctPrimaryKey.class)
public class RidgeAcct {
	@Id
	private String acct_id;
	@Id
	@Column(name="per_id")
	private String perId;
	private Date setup_dt;
	private String town_city;
	private String branch;
	public String getAcct_id() {
		return acct_id;
	}
	public void setAcct_id(String acct_id) {
		this.acct_id = acct_id;
	}
	public String getPer_id() {
		return perId;
	}
	public void setPer_id(String per_id) {
		this.perId = per_id;
	}
	public Date getSetup_dt() {
		return setup_dt;
	}
	public void setSetup_dt(Date setup_dt) {
		this.setup_dt = setup_dt;
	}
	public String getTown_city() {
		return town_city;
	}
	public void setTown_city(String town_city) {
		this.town_city = town_city;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
}
