package com.kb.referral.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kb.common.entity.RidgeSA;
import com.kb.common.repository.RidgeSARepository;
import com.kb.matrimony.entity.Matrimony;
import com.kb.matrimony.entity.RidgeSAMatrimony;
import com.kb.matrimony.repository.RidgeSAMatrimonyRepository;
import com.kb.rental.entity.Rental;
import com.kb.rental.entity.RidgeSARental;
import com.kb.rental.repository.RidgeSARentalRepository;
import com.kb.sale.entity.RidgeSASale;
import com.kb.sale.entity.Sale;
import com.kb.sale.repository.RidgeSASaleRepository;

@Controller
public class ReferralController {
	
	@Autowired
	MessageSource ms;
	
	@Autowired
	private PopulateEditPageData populateData;
	
	@Autowired
	private RidgeSARepository ridgeSARepository;
	
    @Autowired
    private RidgeSASaleRepository ridgeSASaleRepository;
    
	@Autowired
	private RidgeSARentalRepository ridgeSARentalRepository;

	@Autowired
	private RidgeSAMatrimonyRepository ridgeSAMatriRepository;
	
	@RequestMapping(value = "/referral", method = RequestMethod.GET)
	public String showReferallPage(Model model,HttpServletRequest request) {
		
		int pageId = (request.getParameter("pageid")==null?1:Integer.parseInt(request.getParameter("pageid")));
		String acct_id = (String)request.getSession().getAttribute("LOGGEDIN_USER_ACCT_ID");
		
		List<RidgeSA> li = new ArrayList<>();
		
		String pageName = null;
		switch (pageId) {
		case 1:
			pageName =   ms.getMessage("page_myreferral",null,  Locale.ENGLISH);
			li = ridgeSARepository.findByAcctId(acct_id);
			break;
		case 2:{
				pageName =   ms.getMessage("page_rental",null,  Locale.ENGLISH);
				String ownerrental[] = new String[]{"OWNER","TENANT"};
				List<String> types = Arrays.asList(ownerrental);
				li = ridgeSARepository.findByAcctIdAndTypeIn(acct_id,types);
			}
			break;
		case 3:{
				pageName =   ms.getMessage("page_sale",null,  Locale.ENGLISH);
				String sellbuy[] = new String[]{"SELL","BUY"};
				List<String> types = Arrays.asList(sellbuy);
				li = ridgeSARepository.findByAcctIdAndTypeIn(acct_id,types);
			}
			break;
		case 4:{
				pageName =   ms.getMessage("page_matrimony",null,  Locale.ENGLISH);
				String bridegroom[] = new String[]{"BRIDE","GROOM"};
				List<String> types = Arrays.asList(bridegroom);
				li = ridgeSARepository.findByAcctIdAndTypeIn(acct_id,types);
			}
			break;
		}
		request.setAttribute("pagename", pageName);
		
		model.addAttribute("referrals", li); 
		
        return "referral";
    }
	
	@RequestMapping(value = "/referral/{type}/{referralvalue}", method = RequestMethod.GET)
	public String fetchReferalDetails(Model model, @PathVariable("type") String type,
										HttpServletRequest request,
										@PathVariable("referralvalue") String saId){
		
		RidgeSA ridgeSA = ridgeSARepository.findOne(saId);
		String page = "";
		
		switch(type){
		
	 	case "OWNER":
		case "TENANT" : 
					Rental rental = populateData.populateRentalEntity(ridgeSARentalRepository,saId, ridgeSA);
					model.addAttribute("rentAttributes", rental);
					page = "rental";
					break;
	 	case "SELL":
		case "BUY" : 
					Sale sale = populateData.populateSaleEntity(ridgeSASaleRepository,saId, ridgeSA);
					model.addAttribute("saleAttributes", sale);
					page = "sale";
					break;
	 	case "BRIDE":
		case "GROOM" : 
					Matrimony matrimony = populateData.populateMatrimonyEntity(ridgeSAMatriRepository,saId, ridgeSA);
					model.addAttribute("matriDOB", matrimony.getDob());
					model.addAttribute("matrimonyAttributes", matrimony);
					page = "matrimony";
					break;
					
			default : page = "default";
		}
		model.addAttribute("saId", saId);
		model.addAttribute("agreement_type", type);
		model.addAttribute("updateFlag", "update");
		model.addAttribute("start_dt", ridgeSA.getStart_dt());
		String statusFlag = ridgeSA.getStatusflg();
		if("10".equals(statusFlag)){
			model.addAttribute("activate", "activate");
		}
		return page;
	}

	
	
	
}
