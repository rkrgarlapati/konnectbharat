package com.kb.rental.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by garlapati on 11/5/2016.
 */
@Entity
@Table(name = "RIDGE_SA_RENTAL")
public class RidgeSARental {
	
	@Id
	private String sa_id;
	private String usage;
	private String property_area;
	private String floor;
	private Double rent_amount;
	private Double advance;
	private String referred_by;
	private String rent_period;
	private String two_wheeler_parking;
	private String four_wheeler_parking;
	private Double maint_amount;
	private String advance_months;
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
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public Double getRent_amount() {
		return rent_amount;
	}
	public void setRent_amount(Double rent_amount) {
		this.rent_amount = rent_amount;
	}
	public Double getAdvance() {
		return advance;
	}
	public void setAdvance(Double advance) {
		this.advance = advance;
	}
	public String getReferred_by() {
		return referred_by;
	}
	public void setReferred_by(String referred_by) {
		this.referred_by = referred_by;
	}
	public String getRent_period() {
		return rent_period;
	}
	public void setRent_period(String rent_period) {
		this.rent_period = rent_period;
	}
	public String getTwo_wheeler_parking() {
		return two_wheeler_parking;
	}
	public void setTwo_wheeler_parking(String two_wheeler_parking) {
		this.two_wheeler_parking = two_wheeler_parking;
	}
	public String getFour_wheeler_parking() {
		return four_wheeler_parking;
	}
	public void setFour_wheeler_parking(String four_wheeler_parking) {
		this.four_wheeler_parking = four_wheeler_parking;
	}
	public Double getMaint_amount() {
		return maint_amount;
	}
	public void setMaint_amount(Double maint_amount) {
		this.maint_amount = maint_amount;
	}
	public String getAdvance_months() {
		return advance_months;
	}
	public void setAdvance_months(String advance_months) {
		this.advance_months = advance_months;
	}
	public String getAddl_dtls() {
		return addl_dtls;
	}
	public void setAddl_dtls(String addl_dtls) {
		this.addl_dtls = addl_dtls;
	}
}
