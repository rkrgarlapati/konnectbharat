package com.kb.customercontact.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kb.common.entity.RidgeSA;
import com.kb.common.repository.RidgeSARepository;
import com.kb.customercontact.entity.CustomerContact;
import com.kb.customercontact.repository.CustContactRepository;
import com.kb.utility.GenerateUniqueID;

@Controller
public class CustContactController {
	
	@Autowired
	private RidgeSARepository ridgeSARepository;
	
	@Autowired
	private CustContactRepository custContactRepository;
	/**
	 * @param m
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/custContactFormController")
    public ModelAndView custContactForm(Model m) {
		String  communicationId = GenerateUniqueID.INSTANCE.generateRandomNumber(8);
		CustomerContact cust = new CustomerContact();
		cust.setCommunicationId(communicationId);
		ModelAndView model = new ModelAndView("consumer_contact", "custContactAttributes", cust);
		
        return model ;
    }
	/**
	 * 
	 * @param contact
	 * @param bindingResult
	 * @param model
	 * @param request
	 * @return
	 */
	@PostMapping("/cancelContactForm")
    public String cencelContactForm(@Valid CustomerContact contact, BindingResult bindingResult, Model model, HttpServletRequest request) {

        return "redirect:guestFormController";
    }
	/**
	 * 
	 * @param m
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/viewContacts")
    public ModelAndView viewContacts(Model m,HttpServletRequest request,@ModelAttribute("custContactAttributes") CustomerContact customerContact) {
		
		int pageId = (request.getParameter("pageid")==null?1:Integer.parseInt(request.getParameter("pageid")));
		String pageName = null;
		List <CustomerContact> customerList = null;
		switch (pageId) {
		case 1:
			customerList = (List<CustomerContact>) custContactRepository.findAllByOrderByDatetimeDesc();
			m.addAttribute("customerList", customerList);
			pageName =  "Contacts";
			break;
		case 2:
			 customerList = custContactRepository.findBycommunicationclassOrderByDatetimeDesc("CP");
			 m.addAttribute("customerList", customerList);
			pageName =  "Outbound Contacts";
			break;
		case 3:
			customerList =	custContactRepository.findBycommunicationclassOrderByDatetimeDesc("CT");
			 m.addAttribute("customerList", customerList);
			pageName =   "Inbound Contacts";
			break;
		}
		request.setAttribute("pagename", pageName);
        return new ModelAndView("contacts", "command", new CustomerContact());
    }
	/**
	 * 
	 * @param m
	 * @return
	 */
	@GetMapping(value = "/viewAgreements")
    public ModelAndView viewAgreements(Model m,HttpServletRequest request) {
		
		List<RidgeSA> accountDetails = new ArrayList<>();
		String acct_id = (String)request.getSession().getAttribute("LOGGEDIN_USER_ACCT_ID");
		accountDetails = ridgeSARepository.findByAcctId(acct_id);
		m.addAttribute("accountDetails",accountDetails);
        return new ModelAndView("agreements");
    }
	
	@PostMapping(value = "/addNewCustomerContact")
	@Transactional
    public ModelAndView addNewCustomerContact(@ModelAttribute("custContactAttributes") CustomerContact customerContact,Model model) {
		customerContact.setStatus("10");
		custContactRepository.save(customerContact);
		model.addAttribute("updateFlag", "create"); 
		return new ModelAndView("agreementcreated");
	}
	@GetMapping(value = "/editCustContact/{custId}")
    public ModelAndView editCustContact(@PathVariable("custId") String custId,Model model) {
		 CustomerContact customerContact = custContactRepository.findOne(custId);
		//	iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy HH:mm:ss"
		 model.addAttribute("updateFlag", "update");
		 return new ModelAndView("consumer_contact", "custContactAttributes", customerContact);
	}
	
	@PostMapping(value = "/updateCustomerContact")
	@Transactional
    public ModelAndView updateCustomerContact(@ModelAttribute("custContactAttributes") CustomerContact customerContact,Model model) {
		custContactRepository.save(customerContact);
		model.addAttribute("updateFlag", "create"); 
		return new ModelAndView("agreementcreated");
	}
	
}
