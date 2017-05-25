package com.kb.rental.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kb.common.entity.RidgeSA;
import com.kb.common.repository.RidgeSARepository;
import com.kb.rental.entity.Rental;
import com.kb.rental.entity.RidgeSARental;
import com.kb.rental.repository.RidgeSARentalRepository;
import com.kb.utility.GenerateUniqueID;

@Controller
public class RentalController {

	@Autowired
	private RidgeSARepository ridgeSARepository;

	@Autowired
	private RidgeSARentalRepository ridgeSARentalRepository;

	@Autowired
	private Rental rental;
	
	@RequestMapping(value = "/rentalFormController", method = RequestMethod.GET)
    public ModelAndView newRenalPage(@RequestParam(value = "type", required = true) String type) {
		
		if(type.equalsIgnoreCase("tenant") || type.equalsIgnoreCase("owner")){
			rental.setAgreement_type(type.toUpperCase());
		} else {
			return new ModelAndView("guest");
		}
		rental.setSa_status_flg("10");
        return new ModelAndView("rental", "rentAttributes",rental);
    }

 	@PostMapping("/rentalForm")
	@Transactional
	public ModelAndView addNewRental(@ModelAttribute("rentAttributes") @Valid Rental rental, BindingResult bindingResult,
									 Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("rental", "rentAttributes",rental);
		}
		 try{
			String sa_id = GenerateUniqueID.INSTANCE.generateRandomNumber(8);
			saveRental(rental,request,sa_id);
			
	 	}catch(Exception ex){
	 		ex.printStackTrace();
	 		this.rental.setAgreement_type(rental.getAgreement_type().toUpperCase());
	    	request.setAttribute("errorMsg", "Error creating Agreement. Please contact Administrator.");
	    	return new ModelAndView("sale", "saleAttributes", this.rental);
	    }
		model.addAttribute("updateFlag", "create"); 
		return new ModelAndView("agreementcreated");
	}
    
	@RequestMapping(value = "/rentalAgreementupdated/{saId}", method = RequestMethod.POST)
	@Transactional
	public String updateRentalSuccess(@ModelAttribute("rentAttributes") @Valid Rental rental,
									Model model,HttpServletRequest request,
									@PathVariable("saId") String saId) {
		model.addAttribute("updateFlag", "update");
		saveRental(rental,request,saId);
		return "agreementcreated";
	}

 	private void saveRental(Rental rental, HttpServletRequest request, String sa_id){

 		HttpSession session = request.getSession();
		String acct_id = (String)session.getAttribute("LOGGEDIN_USER_ACCT_ID");
		
		RidgeSA ridgeSA = new RidgeSA();
		ridgeSA.setSa_id(sa_id);
		ridgeSA.setAcctId(acct_id);
		ridgeSA.setTown_city(rental.getRental_city());
		ridgeSA.setType(rental.getAgreement_type());
		ridgeSA.setList_dt(new Date());
		ridgeSA.setStatusflg(rental.getSa_status_flg());
		ridgeSA.setStart_dt((Date)request.getSession().getAttribute("start_dt"));
		ridgeSA.setEnd_dt(null);
		ridgeSA.setEst_bill_amt(rental.getRental_rent());
		ridgeSA.setExpire_dt(null);
		ridgeSA.setAddress1(rental.getRental_address1());
		ridgeSA.setAddress2(rental.getRental_address2());
		ridgeSA.setArea(rental.getRental_area());
		ridgeSA.setCity(rental.getRental_city());
		ridgeSA.setState(rental.getRental_state());
		ridgeSA.setPostal(rental.getRental_postal());
		ridgeSA.setActual_party_name(rental.getRental_party());
		ridgeSA.setActual_party_contact(rental.getRental_phone());
		ridgeSA.setContact_type("mobile");
		ridgeSA.setRef_amt(rental.getRental_rent());

		ridgeSARepository.save(ridgeSA);

		RidgeSARental ridgeSARent = new RidgeSARental();
		ridgeSARent.setSa_id(sa_id);
		ridgeSARent.setUsage(rental.getUsage());
		ridgeSARent.setProperty_area(rental.getR_prop_area());
		ridgeSARent.setFloor("10");
		ridgeSARent.setRent_amount(rental.getRental_rent());
		ridgeSARent.setAdvance(rental.getRental_advance());
		ridgeSARent.setRent_period(rental.getR_rent_period());
		ridgeSARent.setTwo_wheeler_parking(rental.getR_park_two());
		ridgeSARent.setFour_wheeler_parking(rental.getR_park_four());
		ridgeSARent.setMaint_amount(rental.getR_maintenance());
		ridgeSARent.setAdvance_months(rental.getAdvance_months());
		ridgeSARent.setAddl_dtls(rental.getAddl_dtls());
		ridgeSARentalRepository.save(ridgeSARent);
		
		request.getSession().removeAttribute("start_dt");
 	}
 	
 	@PostMapping("/cancelRentalForm")
    public String cancelRentalForm() {

        return "redirect:guestFormController";
    }
}
