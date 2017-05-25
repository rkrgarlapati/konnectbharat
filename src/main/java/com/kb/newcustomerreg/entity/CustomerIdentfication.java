package com.kb.newcustomerreg.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Created by garlapati on 10/23/2016.
 */
@Entity
@Table(name = "RIDGE_PER_ID")
@IdClass(CustomerIdentficationId.class)
public class CustomerIdentfication implements Serializable {
	@Id
	private String per_id;
	@Id
	private String id_type_cd;
	@Column(name = "per_id_nbr")
	private String perIdNbr;
	@Id
	private String prim_sw;
	private Date start_dt = new Date();
	private Date end_dt;
	public String getPer_id() {
		return per_id;
	}
	public void setPer_id(String per_id) {
		this.per_id = per_id;
	}
	public String getId_type_cd() {
		return id_type_cd;
	}
	public void setId_type_cd(String id_type_cd) {
		this.id_type_cd = id_type_cd;
	}
	public String getPerIdNbr() {
		return perIdNbr;
	}
	public void setPerIdNbr(String perIdNbr) {
		this.perIdNbr = perIdNbr;
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
	@Override
	public String toString() {
		return "CustomerIdentfication [per_id=" + per_id + ", id_type_cd=" + id_type_cd + ", perIdNbr=" + perIdNbr
				+ ", prim_sw=" + prim_sw + ", start_dt=" + start_dt + ", end_dt=" + end_dt + "]";
	}
	
}
