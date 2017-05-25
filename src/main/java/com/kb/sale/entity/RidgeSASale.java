package com.kb.sale.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by garlapati on 11/5/2016.
 */
@Entity
@Table(name = "RIDGE_SA_SALE")
public class RidgeSASale {

	@Id
	private String sa_id;
	private String usage;
	private String property_area;
	private String loan;
	private Double amount;
	private String referred_by;
	private String addl_dtls;
	
	public String getSa_id() {
		return sa_id;
	}
	public void setSa_id(String sa_id) {
		this.sa_id = sa_id;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getProperty_area() {
		return property_area;
	}
	public void setProperty_area(String property_area) {
		this.property_area = property_area;
	}
	public String getLoan() {
		return loan;
	}
	public void setLoan(String loan) {
		this.loan = loan;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getReferred_by() {
		return referred_by;
	}
	public void setReferred_by(String referred_by) {
		this.referred_by = referred_by;
	}
	public String getAddl_dtls() {
		return addl_dtls;
	}
	public void setAddl_dtls(String addl_dtls) {
		this.addl_dtls = addl_dtls;
	}
}
