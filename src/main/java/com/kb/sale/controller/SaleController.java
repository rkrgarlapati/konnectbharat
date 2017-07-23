package com.kb.sale.controller;

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
import com.kb.sale.entity.RidgeSASale;
import com.kb.sale.entity.Sale;
import com.kb.sale.repository.RidgeSASaleRepository;
import com.kb.utility.GenerateUniqueID;

@Controller
public class SaleController {

    @Autowired
    private RidgeSARepository ridgeSARepository;

    @Autowired
    private RidgeSASaleRepository ridgeSASaleRepository;
    
    @Autowired
    private Sale sale;

    @RequestMapping(value = "/saleFormController", method = RequestMethod.GET)
    public ModelAndView newSalePage(@RequestParam(value = "type", required = true) String type) {
    	
    	if(type.equalsIgnoreCase("sell") || type.equalsIgnoreCase("buy")){
    		sale.setAgreement_type(type.toUpperCase());
		} else {
			return new ModelAndView("guest");
		}
    	
    	sale.setSa_status_flg("10");
        return new ModelAndView("sale", "saleAttributes", sale);
    }

    @PostMapping("/saleForm")
    @Transactional
    public ModelAndView addNewSale(@ModelAttribute("saleAttributes") @Valid Sale sale, 
    		Model model, BindingResult bindingResult, HttpServletRequest request) {
    	
        if (bindingResult.hasErrors()) {
            return new ModelAndView("sale", "saleAttributes",sale);
        }
        try{
        	String sa_id = GenerateUniqueID.INSTANCE.generateRandomNumber(8);
        	saveSaleData(sale, request,sa_id, "create");
	        	        
        }catch(Exception ex){
        	sale.setAgreement_type(sale.getAgreement_type().toUpperCase());
        	request.setAttribute("errorMsg", "Error creating Agreement. Please contact Administrator.");
        	return new ModelAndView("sale", "saleAttributes", sale);
        }
        model.addAttribute("updateFlag", "create");
        return new ModelAndView("agreementcreated");
    }
    
	@RequestMapping(value = "/saleAgreementupdated/{saId}", method = RequestMethod.POST)
    @Transactional
	public String updateSaleSuccess(@ModelAttribute("saleAttributes") @Valid Sale sale,
									Model model,HttpServletRequest request,
									@PathVariable("saId") String saId) {
		model.addAttribute("updateFlag", "update");
		saveSaleData(sale,request,saId, "update");
		return "agreementcreated";
	}
	
    public void saveSaleData(Sale sale, HttpServletRequest request, String sa_id, String flag){
    	HttpSession session = request.getSession();
        String acct_id = (String)session.getAttribute("LOGGEDIN_USER_ACCT_ID");
        RidgeSA ridgeSA = new RidgeSA();
        ridgeSA.setSa_id(sa_id);
        ridgeSA.setAcctId(acct_id);
        ridgeSA.setTown_city(sale.getSale_city());
        ridgeSA.setType(sale.getAgreement_type());
        ridgeSA.setList_dt(new Date());
        //ridgeSA.setStart_dt(null);
        ridgeSA.setStatusflg(sale.getSa_status_flg());
        ridgeSA.setStart_dt((Date)request.getSession().getAttribute("start_dt"));
        //ridgeSA.setEnd_dt(null);
        ridgeSA.setEst_bill_amt(sale.getSale_rent());
        //ridgeSA.setExpire_dt(null);
        ridgeSA.setAddress1(sale.getSale_address1());
        ridgeSA.setAddress2(sale.getSale_address2());
        ridgeSA.setArea(sale.getSale_area());
        ridgeSA.setCity(sale.getSale_city());
        ridgeSA.setPostal(sale.getSale_postal());
        ridgeSA.setActual_party_name(sale.getSale_party());
        ridgeSA.setActual_party_contact(sale.getSale_phone());
        ridgeSA.setContact_type("mobile");
        ridgeSA.setRef_amt(sale.getSale_rent());
        ridgeSA.setState(sale.getSale_state());
        ridgeSARepository.save(ridgeSA);

        RidgeSASale ridgeSASale = new RidgeSASale();
        ridgeSASale.setSa_id(sa_id);
        ridgeSASale.setUsage(sale.getUsage());
        ridgeSASale.setProperty_area(sale.getS_prop_area());
        ridgeSASale.setProp_type(sale.getProp_type());
        ridgeSASale.setLoan(sale.getLoan());
        ridgeSASale.setAmount(sale.getSale_amount());
        ridgeSASale.setAddl_dtls(sale.getAddl_dtls());
        ridgeSASaleRepository.save(ridgeSASale);
        
        request.getSession().removeAttribute("start_dt");
    }
    
    @PostMapping("/cancelSaleForm")
    public String cencelSaleForm() {

        return "redirect:guestFormController";
    }
}
