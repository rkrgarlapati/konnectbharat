package com.kb.sale.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Component
public class Sale {

	private String sale_party;
	private String agreement_type;
	private String sale_phone;
	private String sale_address1;
	private String sale_address2;
	private String sale_area;
	private String sale_city;
	private String sale_state;
	private String sale_postal;
	private String usage;
	private String s_prop_area;
	private Double sale_rent;
	private Double sale_amount;
	private String loan;
	private String sale_referal;
	private String sa_status_flg;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	private Date start_dt;
	private String addl_dtls;

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

	public String getSale_party() {
		return sale_party;
	}

	public void setSale_party(String sale_party) {
		this.sale_party = sale_party;
	}

	public String getAgreement_type() {
		return agreement_type;
	}

	public void setAgreement_type(String agreement_type) {
		this.agreement_type = agreement_type;
	}

	public String getSale_phone() {
		return sale_phone;
	}

	public void setSale_phone(String sale_phone) {
		this.sale_phone = sale_phone;
	}

	public String getSale_address1() {
		return sale_address1;
	}

	public void setSale_address1(String sale_address1) {
		this.sale_address1 = sale_address1;
	}

	public String getSale_address2() {
		return sale_address2;
	}

	public void setSale_address2(String sale_address2) {
		this.sale_address2 = sale_address2;
	}

	public String getSale_area() {
		return sale_area;
	}

	public void setSale_area(String sale_area) {
		this.sale_area = sale_area;
	}

	public String getSale_city() {
		return sale_city;
	}

	public void setSale_city(String sale_city) {
		this.sale_city = sale_city;
	}

	public String getSale_state() {
		return sale_state;
	}

	public void setSale_state(String sale_state) {
		this.sale_state = sale_state;
	}

	public String getSale_postal() {
		return sale_postal;
	}

	public void setSale_postal(String sale_postal) {
		this.sale_postal = sale_postal;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getS_prop_area() {
		return s_prop_area;
	}

	public void setS_prop_area(String s_prop_area) {
		this.s_prop_area = s_prop_area;
	}

	public Double getSale_rent() {
		return sale_rent;
	}

	public void setSale_rent(Double sale_rent) {
		this.sale_rent = sale_rent;
	}

	public Double getSale_amount() {
		return sale_amount;
	}

	public void setSale_amount(Double sale_amount) {
		this.sale_amount = sale_amount;
	}

	public String getLoan() {
		return loan;
	}

	public void setLoan(String loan) {
		this.loan = loan;
	}

	public String getSale_referal() {
		return sale_referal;
	}

	public void setSale_referal(String sale_referal) {
		this.sale_referal = sale_referal;
	}

	public String getAddl_dtls() {
		return addl_dtls;
	}

	public void setAddl_dtls(String addl_dtls) {
		this.addl_dtls = addl_dtls;
	}

	@Override
	public String toString() {
		return "Sale [sale_party=" + sale_party + ", agreement_type=" + agreement_type + ", sale_phone=" + sale_phone
				+ ", sale_address1=" + sale_address1 + ", sale_address2=" + sale_address2 + ", sale_area=" + sale_area
				+ ", sale_city=" + sale_city + ", sale_state=" + sale_state + ", sale_postal=" + sale_postal
				+ ", usage=" + usage + ", s_prop_area=" + s_prop_area + ", sale_rent=" + sale_rent + ", sale_amount="
				+ sale_amount + ", loan=" + loan + ", sale_referal=" + sale_referal + ", sa_status_flg=" + sa_status_flg
				+ ", start_dt=" + start_dt + ", addl_dtls=" + addl_dtls + "]";
	}

}
