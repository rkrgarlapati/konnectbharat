package com.kb.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RIDGE_PER_ID")
public class EmployeeIdentfication {
	
	@Id
	@Column(name = "per_id")
	private String perId;
	
	@Column(name = "per_id_nbr")
	private String perIdNbr;

	public String getPerId() {
		return perId;
	}

	public void setPerId(String perId) {
		this.perId = perId;
	}

	public String getPerIdNbr() {
		return perIdNbr;
	}

	public void setPerIdNbr(String perIdNbr) {
		this.perIdNbr = perIdNbr;
	}
}
