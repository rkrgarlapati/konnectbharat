package com.kb.employee.entity;

import java.util.Date;

public class RentSaleSearchResult {
	private String saID;
	private String area;
	private String statusFlg;
	private String startDate;
	private String actualPartyName;
	private String actualPartyConotact;
	private Double amount;
	private String mobile;
	public String getSaID() {
		return saID;
	}
	public void setSaID(String saID) {
		this.saID = saID;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getActualPartyName() {
		return actualPartyName;
	}
	public void setActualPartyName(String actualPartyName) {
		this.actualPartyName = actualPartyName;
	}
	public String getActualPartyConotact() {
		return actualPartyConotact;
	}
	public void setActualPartyConotact(String actualPartyConotact) {
		this.actualPartyConotact = actualPartyConotact;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
