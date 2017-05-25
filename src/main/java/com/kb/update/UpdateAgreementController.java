package com.kb.update;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kb.common.repository.RidgeSARepository;

@Controller
public class UpdateAgreementController {
	
    @Autowired
    private RidgeSARepository ridgeSARepository;

	@RequestMapping(value = "/activateUser/{saId}", method = RequestMethod.POST)
	public String activateUser(@PathVariable("saId") String saId, Model model) {
		
		ridgeSARepository.activateSAStatus("20",new Date(), saId);
		model.addAttribute("updateFlag", "activate");
		return "agreementcreated";
	}
}
