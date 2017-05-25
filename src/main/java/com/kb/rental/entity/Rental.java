package com.kb.rental.entity;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Component
public class Rental {
	@NotEmpty
	private String rental_party;
	@NotEmpty
    private String agreement_type;
    private String rental_phone;
    private String rental_address1;
    private String rental_address2;
    private String rental_area;
    private String rental_city;
    private String rental_state;
    private String rental_postal;
    private String usage;
    private String r_prop_area;
    private Double rental_rent;
    private Double rental_advance;
    private String advance_months;
    private String r_rent_period;
    private String r_park_two;
    private String r_park_four;
    private Double r_maintenance;
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

	public String getRental_party() {
        return rental_party;
    }

    public void setRental_party(String rental_party) {
        this.rental_party = rental_party;
    }

    public String getAgreement_type() {
        return agreement_type;
    }

    public void setAgreement_type(String agreement_type) {
        this.agreement_type = agreement_type;
    }

    public String getRental_phone() {
        return rental_phone;
    }

    public void setRental_phone(String rental_phone) {
        this.rental_phone = rental_phone;
    }

    public String getRental_address1() {
        return rental_address1;
    }

    public void setRental_address1(String rental_address1) {
        this.rental_address1 = rental_address1;
    }

    public String getRental_address2() {
        return rental_address2;
    }

    public void setRental_address2(String rental_address2) {
        this.rental_address2 = rental_address2;
    }

    public String getRental_area() {
        return rental_area;
    }

    public void setRental_area(String rental_area) {
        this.rental_area = rental_area;
    }

    public String getRental_city() {
        return rental_city;
    }

    public void setRental_city(String rental_city) {
        this.rental_city = rental_city;
    }

    public String getRental_state() {
        return rental_state;
    }

    public void setRental_state(String rental_state) {
        this.rental_state = rental_state;
    }

    public String getRental_postal() {
        return rental_postal;
    }

    public void setRental_postal(String rental_postal) {
        this.rental_postal = rental_postal;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getR_prop_area() {
        return r_prop_area;
    }

    public void setR_prop_area(String r_prop_area) {
        this.r_prop_area = r_prop_area;
    }

    public Double getRental_rent() {
        return rental_rent;
    }

    public void setRental_rent(Double rental_rent) {
        this.rental_rent = rental_rent;
    }

    public Double getRental_advance() {
        return rental_advance;
    }

    public void setRental_advance(Double rental_advance) {
        this.rental_advance = rental_advance;
    }

    public String getAdvance_months() {
        return advance_months;
    }

    public void setAdvance_months(String advance_months) {
        this.advance_months = advance_months;
    }

    public String getR_rent_period() {
        return r_rent_period;
    }

    public void setR_rent_period(String r_rent_period) {
        this.r_rent_period = r_rent_period;
    }

    public String getR_park_two() {
        return r_park_two;
    }

    public void setR_park_two(String r_park_two) {
        this.r_park_two = r_park_two;
    }

    public String getR_park_four() {
        return r_park_four;
    }

    public void setR_park_four(String r_park_four) {
        this.r_park_four = r_park_four;
    }

    public Double getR_maintenance() {
        return r_maintenance;
    }

    public void setR_maintenance(Double r_maintenance) {
        this.r_maintenance = r_maintenance;
    }
	public String getAddl_dtls() {
		return addl_dtls;
	}
	public void setAddl_dtls(String addl_dtls) {
		this.addl_dtls = addl_dtls;
	}
	@Override
	public String toString() {
		return "Rental [rental_party=" + rental_party + ", agreement_type=" + agreement_type + ", rental_phone="
				+ rental_phone + ", rental_address1=" + rental_address1 + ", rental_address2=" + rental_address2
				+ ", rental_area=" + rental_area + ", rental_city=" + rental_city + ", rental_state=" + rental_state
				+ ", rental_postal=" + rental_postal + ", usage=" + usage + ", r_prop_area=" + r_prop_area
				+ ", rental_rent=" + rental_rent + ", rental_advance=" + rental_advance + ", advance_months="
				+ advance_months + ", r_rent_period=" + r_rent_period + ", r_park_two=" + r_park_two + ", r_park_four="
				+ r_park_four + ", r_maintenance=" + r_maintenance + ", sa_status_flg=" + sa_status_flg + ", start_dt="
				+ start_dt + ", addl_dtls=" + addl_dtls + "]";
	}
	
}
