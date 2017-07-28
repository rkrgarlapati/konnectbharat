package com.kb.matrimony.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.kb.sms.SMSService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.kb.matrimony.entity.Matrimony;
import com.kb.matrimony.entity.RidgeSAMatrimony;
import com.kb.matrimony.repository.RidgeSAMatrimonyRepository;
import com.kb.rental.entity.Rental;
import com.kb.utility.GenerateUniqueID;


@Controller
public class MatrimonyController {

	@Autowired
	private RidgeSARepository ridgeSARepository;
	
	@Autowired
	private RidgeSAMatrimonyRepository ridgeSAMatriRepository;
	
	@Autowired
	private Matrimony matrimony;

	@Autowired
	private SMSService smsService;

	@RequestMapping(value = "/matrimonyFormController", method = RequestMethod.GET)
    public ModelAndView matrimonyForm(@RequestParam(value = "type", required = true) String type) {
        
        if(type.equalsIgnoreCase("BRIDE") || type.equalsIgnoreCase("GROOM")){
        	matrimony.setAgreement_type(type.toUpperCase());
		} else {
			return new ModelAndView("guest");
		}
        matrimony.setSa_status_flg("10");
        return new ModelAndView("matrimony", "matrimonyAttributes", matrimony);
    }
	
	@PostMapping("/matrimonyRegister")
    @Transactional
    public ModelAndView addNewCustomer(@ModelAttribute("newCustomerRegis") Matrimony matrimony,
                                 BindingResult bindingResult, Model model, HttpServletRequest request){
		
		try{
			String sa_id = GenerateUniqueID.INSTANCE.generateRandomNumber(8);
			saveMatrimony(matrimony,request, sa_id, "create");
			HttpSession session = request.getSession();
			String loggedin_user = (String)session.getAttribute("LOGGEDIN_USER");
			String loggedin_user_mobile = (String)session.getAttribute("LOGGEDIN_USER_MOBILE");
			smsService.sendSMS(matrimony.getAgreement_type().toLowerCase(), loggedin_user_mobile, loggedin_user, matrimony.getMatri_party_name());
		}catch(Exception ex){
	 		ex.printStackTrace();
	 		this.matrimony.setAgreement_type(matrimony.getAgreement_type().toUpperCase());
	    	request.setAttribute("errorMsg", "Error creating Agreement. Please contact Administrator.");
	    	return new ModelAndView("matrimony", "matrimonyAttributes", this.matrimony);
	    }
		model.addAttribute("updateFlag", "create");
		return new ModelAndView("agreementcreated");
	}
    
	@RequestMapping(value = "/matrimonyAgreementupdated/{saId}", method = RequestMethod.POST)
	@Transactional
	public String updateMatrimonySuccess(@ModelAttribute("matrimonyAttributes") Matrimony matrimony,
									Model model,HttpServletRequest request,
									@PathVariable("saId") String saId) {
		model.addAttribute("updateFlag", "update");
		saveMatrimony(matrimony,request,saId,"update");
		return "agreementcreated";
	}

	private void saveMatrimony(Matrimony matrimony, HttpServletRequest request, String saId, String flag) {

		String acct_id = (String)request.getSession().getAttribute("LOGGEDIN_USER_ACCT_ID");
		RidgeSA ridgeSA = new RidgeSA();
		
		ridgeSA.setSa_id(saId);
		ridgeSA.setAcctId(acct_id);
		ridgeSA.setTown_city(matrimony.getCity());
		ridgeSA.setType(matrimony.getAgreement_type());
		ridgeSA.setList_dt(new Date());
		//ridgeSA.setStart_dt(new Date());
		ridgeSA.setStatusflg(matrimony.getSa_status_flg());
        ridgeSA.setStart_dt((Date)request.getSession().getAttribute("start_dt"));
		ridgeSA.setEnd_dt(null);
		ridgeSA.setExpire_dt(null);
		ridgeSA.setAddress1(matrimony.getAddress1());
		ridgeSA.setAddress2(matrimony.getAddress2());
		ridgeSA.setArea(matrimony.getArea());
		ridgeSA.setCity(matrimony.getCity());
		ridgeSA.setState(matrimony.getState());
		ridgeSA.setPostal(matrimony.getPostal());
		ridgeSA.setActual_party_name(matrimony.getMatri_party_name());
		ridgeSA.setActual_party_contact(matrimony.getMatri_phone());
		ridgeSA.setContact_type("mobile");

		ridgeSARepository.save(ridgeSA);

		RidgeSAMatrimony ridgeSAMatrimony = new RidgeSAMatrimony();
		ridgeSAMatrimony.setSa_id(saId);
		ridgeSAMatrimony.setCountry(matrimony.getCountry());
		ridgeSAMatrimony.setName(matrimony.getBride_name());
		ridgeSAMatrimony.setDob(matrimony.getDob());
		ridgeSAMatrimony.setEducation(matrimony.getHighest_education());
		ridgeSAMatrimony.setReligion(matrimony.getReligion());
		ridgeSAMatrimony.setCaste(matrimony.getCaste());
		ridgeSAMatrimony.setSubcaste(matrimony.getSub_caste());
		ridgeSAMatrimony.setHeight(matrimony.getHeight());
		ridgeSAMatrimony.setFamily_details(matrimony.getFamily_details());
		ridgeSAMatrimony.setEmployment(matrimony.getEmployment());
		ridgeSAMatrimony.setAddl_dtls(matrimony.getAdditional_details());
		ridgeSAMatrimony.setMarital_status(matrimony.getMarital_status());
		ridgeSAMatrimony.setFood(matrimony.getFood());
		ridgeSAMatrimony.setSmoking(matrimony.getSmoking());
		ridgeSAMatrimony.setDrinking(matrimony.getDrinking());
		ridgeSAMatrimony.setHoroscope(matrimony.getHoroscope_available());

		ridgeSAMatriRepository.save(ridgeSAMatrimony);

		request.getSession().removeAttribute("start_dt");
	}

	@PostMapping("/cancelMatrimonyForm")
    public String cencelMatrimonyForm(@Valid Matrimony rental, BindingResult bindingResult, Model model, HttpServletRequest request) {

        return "redirect:guestFormController";
    }
}
