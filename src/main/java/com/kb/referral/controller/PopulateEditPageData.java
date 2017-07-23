package com.kb.referral.controller;

import org.springframework.stereotype.Component;

import com.kb.common.entity.RidgeSA;
import com.kb.matrimony.entity.Matrimony;
import com.kb.matrimony.entity.RidgeSAMatrimony;
import com.kb.matrimony.repository.RidgeSAMatrimonyRepository;
import com.kb.rental.entity.Rental;
import com.kb.rental.entity.RidgeSARental;
import com.kb.rental.repository.RidgeSARentalRepository;
import com.kb.sale.entity.RidgeSASale;
import com.kb.sale.entity.Sale;
import com.kb.sale.repository.RidgeSASaleRepository;

@Component
public class PopulateEditPageData {

	public Rental populateRentalEntity(RidgeSARentalRepository ridgeSARentalRepository, String saId, RidgeSA ridgeSA) {

		RidgeSARental ridgeSARent = ridgeSARentalRepository.findOne(saId);
		Rental rental = new Rental();

		rental.setRental_party(ridgeSA.getActual_party_name());
		rental.setAgreement_type(ridgeSA.getType());
		rental.setRental_phone(ridgeSA.getActual_party_contact());
		rental.setRental_city(ridgeSA.getTown_city());
		rental.setRental_address1(ridgeSA.getAddress1());
		rental.setRental_address2(ridgeSA.getAddress2());
		rental.setRental_area(ridgeSA.getArea());
		rental.setRental_city(ridgeSA.getCity());
		rental.setRental_state(ridgeSA.getState());
		rental.setRental_postal(ridgeSA.getPostal());
		rental.setSa_status_flg(ridgeSA.getStatusflg());
		rental.setStart_dt(ridgeSA.getStart_dt());

		rental.setUsage(ridgeSARent.getUsage());
		rental.setR_prop_area(ridgeSARent.getProperty_area());
		rental.setRental_rent(ridgeSARent.getRent_amount());
		rental.setRental_advance(ridgeSARent.getAdvance());
		rental.setR_rent_period(ridgeSARent.getRent_period());
		rental.setR_park_two(trimValues(ridgeSARent.getTwo_wheeler_parking()));
		rental.setR_park_four(trimValues(ridgeSARent.getFour_wheeler_parking()));
		rental.setR_maintenance(ridgeSARent.getMaint_amount());
		rental.setAdvance_months(ridgeSARent.getAdvance_months());
		rental.setAddl_dtls(ridgeSARent.getAddl_dtls());

		return rental;
	}

	public Matrimony populateMatrimonyEntity(RidgeSAMatrimonyRepository ridgeSAMatriRepository,String saId, RidgeSA ridgeSA) {

		Matrimony matrimony = new Matrimony();
		RidgeSAMatrimony ridgeSAMatrimony = ridgeSAMatriRepository.findOne(saId);

		matrimony.setCity(ridgeSA.getTown_city());
		matrimony.setAgreement_type(ridgeSA.getType());
		matrimony.setAddress1(ridgeSA.getAddress1());
		matrimony.setAddress2(ridgeSA.getAddress2());
		matrimony.setArea(ridgeSA.getArea());
		matrimony.setCity(ridgeSA.getCity());
		matrimony.setState(ridgeSA.getState());
		matrimony.setPostal(ridgeSA.getPostal());
		matrimony.setMatri_party_name(ridgeSA.getActual_party_name());
		matrimony.setMatri_phone(ridgeSA.getActual_party_contact());
		matrimony.setSa_status_flg(ridgeSA.getStatusflg());
		matrimony.setStart_dt(ridgeSA.getStart_dt());

		matrimony.setCountry(ridgeSAMatrimony.getCountry());
		matrimony.setBride_name(ridgeSAMatrimony.getName());
		matrimony.setDob(ridgeSAMatrimony.getDob());
		matrimony.setHighest_education(ridgeSAMatrimony.getEducation());
		matrimony.setReligion(ridgeSAMatrimony.getReligion());
		matrimony.setCaste(ridgeSAMatrimony.getCaste());
		matrimony.setSub_caste(ridgeSAMatrimony.getSubcaste());
		matrimony.setHeight(ridgeSAMatrimony.getHeight());
		matrimony.setFamily_details(ridgeSAMatrimony.getFamily_details());
		matrimony.setEmployment(ridgeSAMatrimony.getEmployment());
		matrimony.setAdditional_details(ridgeSAMatrimony.getAddl_dtls());
		matrimony.setMarital_status(ridgeSAMatrimony.getMarital_status());
		matrimony.setFood(ridgeSAMatrimony.getFood());
		matrimony.setSmoking(ridgeSAMatrimony.getSmoking());
		matrimony.setDrinking(ridgeSAMatrimony.getDrinking());
		matrimony.setHoroscope_available(ridgeSAMatrimony.getHoroscope());

		return matrimony;
	}

	public Sale populateSaleEntity(RidgeSASaleRepository ridgeSASaleRepository,String saId, RidgeSA ridgeSA) {

		RidgeSASale saSale = ridgeSASaleRepository.findOne(saId);
		Sale sale = new Sale();

		sale.setSale_city(ridgeSA.getTown_city());
		sale.setAgreement_type(ridgeSA.getType());
		sale.setSale_rent(ridgeSA.getEst_bill_amt());
		sale.setSale_address1(ridgeSA.getAddress1());
		sale.setSale_address2(ridgeSA.getAddress2());
		sale.setSale_area(ridgeSA.getArea());
		sale.setSale_city(ridgeSA.getCity());
		sale.setSale_postal(ridgeSA.getPostal());
		sale.setSale_party(ridgeSA.getActual_party_name());
		sale.setSale_phone(ridgeSA.getActual_party_contact());
		sale.setSale_rent(ridgeSA.getRef_amt());
		sale.setSale_state(ridgeSA.getState());
		sale.setSa_status_flg(ridgeSA.getStatusflg());
		sale.setStart_dt(ridgeSA.getStart_dt());

		sale.setUsage(saSale.getUsage());
		sale.setProp_type(saSale.getProp_type());
		sale.setS_prop_area(saSale.getProperty_area());
		sale.setLoan(saSale.getLoan());
		sale.setSale_amount(saSale.getAmount());
		sale.setAddl_dtls(saSale.getAddl_dtls());

		return sale;
	}

	String trimValues(String value) {
		String trimmedValue = "";
		if (null != value) {
			trimmedValue = value.trim();
		}
		return trimmedValue;
	}

}
