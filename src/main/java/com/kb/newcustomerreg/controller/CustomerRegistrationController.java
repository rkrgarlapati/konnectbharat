package com.kb.newcustomerreg.controller;

import com.kb.common.entity.RidgeAcct;
import com.kb.common.repository.RidgeAcctRepository;
import com.kb.newcustomerreg.entity.Customer;
import com.kb.newcustomerreg.entity.CustomerIdentfication;
import com.kb.newcustomerreg.entity.NewCustomer;
import com.kb.newcustomerreg.exception.DuplicateCustIDException;
import com.kb.newcustomerreg.repository.CustomerIdentificationRepository;
import com.kb.newcustomerreg.repository.CustomerRegisterRepository;
import com.kb.sms.HttpUrlPush;
import com.kb.utility.GenerateUniqueID;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class CustomerRegistrationController {

    @Autowired
    private CustomerRegisterRepository custRegRepository;

    @Autowired
    private CustomerIdentificationRepository custIdRepository;

    @Autowired
    private RidgeAcctRepository ridgeAcctRepository;

    @RequestMapping(value = "/newcustomerRegistration", method = RequestMethod.GET)
    public ModelAndView newregisterPage(Model m) {
        return new ModelAndView("home", "newCustomerRegis", new NewCustomer());
    }

    @PostMapping("/newCustomerRegis")
    @Transactional
    public ModelAndView addNewCustomer(@ModelAttribute("newCustomerRegis") NewCustomer newCustomer,
                                       BindingResult bindingResult, Model model, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            //model.addAttribute("command", model);
            return new ModelAndView("home", "newCustomerRegis", newCustomer);
        }

        String cust_id = GenerateUniqueID.INSTANCE.generateRandomNumber(8);

        Customer customer = populateCustomerData(newCustomer, cust_id);
        model.addAttribute("customer", customer);
        List<CustomerIdentfication> customerIdentificationList = null;

        try {
            customerIdentificationList = populateCustomerIdentficationData(newCustomer, cust_id);
        } catch (DuplicateCustIDException exp) {
            request.setAttribute("errorMsg", exp.getMessage());
            return new ModelAndView("home", "newCustomerRegis", newCustomer);
        }

        try {
            custRegRepository.save(customer);
            custIdRepository.save(customerIdentificationList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*try {
            HttpUrlPush.message(newCustomer.getFirst_name() + " - Welcome to Konnect Bharat. Your account is registered.",
                    newCustomer.getPhone());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        return new ModelAndView("customerSucess");
    }

    private Customer populateCustomerData(NewCustomer newCust, String cust_id) {

        String acct_id = GenerateUniqueID.INSTANCE.generateRandomNumber(8);

        RidgeAcct ridgeAcct = new RidgeAcct();
        ridgeAcct.setAcct_id(acct_id);
        ridgeAcct.setPer_id(cust_id);
        ridgeAcct.setSetup_dt(new Date());
        ridgeAcct.setTown_city(newCust.getCity());
        ridgeAcct.setBranch(newCust.getArea());

        ridgeAcctRepository.save(ridgeAcct);

        Customer customer = new Customer();

        customer.setPer_id(cust_id);
        customer.setPer_name(newCust.getFirst_name() + " " + newCust.getSecond_name());
        customer.setPer_or_bus_flg("P");
        customer.setEmailid(newCust.getEmailid());
        customer.setAddress1(newCust.getAddress1());
        customer.setAddress2(newCust.getAddress2());
        customer.setArea(newCust.getArea());
        customer.setCity(newCust.getCity());
        customer.setState(newCust.getState());
        customer.setPostal(newCust.getPostal());
        customer.setWebuserid(newCust.getPhone());
        customer.setWeb_passwd(newCust.getPassword());
        customer.setWeb_pwd_hint_flg("so");
        customer.setWeb_passwd_ans("password answer");
        customer.setCreated_by(newCust.getFirst_name());
        customer.setModified_by(newCust.getSecond_name());

        return customer;
    }

    private List<CustomerIdentfication> populateCustomerIdentficationData(NewCustomer newCustomer, String cust_id) {

        List<CustomerIdentfication> custIdList = new ArrayList();

        if (!StringUtils.isEmpty(newCustomer.getPhone())) {
            CustomerIdentfication custIden = new CustomerIdentfication();
            custIden.setPer_id(cust_id);
            custIden.setId_type_cd("phone");
            custIden.setPerIdNbr(newCustomer.getPhone());
            custIden.setPrim_sw("Y");
            List perIds = custIdRepository.findByPerIdNbr(newCustomer.getPhone());
            if (perIds == null || perIds.isEmpty()) {
                custIdList.add(custIden);
            } else {
                throw new DuplicateCustIDException(
                        String.format("Already exists a user with phone : %s", (newCustomer.getPhone())));
            }
        }

        if (!StringUtils.isEmpty(newCustomer.getAadharNumber())) {
            CustomerIdentfication custIden = new CustomerIdentfication();
            custIden.setPer_id(cust_id);
            custIden.setId_type_cd("aadhar");
            custIden.setPerIdNbr(newCustomer.getAadharNumber());
            custIden.setPrim_sw("N");

            custIdList.add(custIden);
        }

        if (!StringUtils.isEmpty(newCustomer.getPanNumber())) {
            CustomerIdentfication custIden = new CustomerIdentfication();
            custIden.setPer_id(cust_id);
            custIden.setId_type_cd("pan");
            custIden.setPerIdNbr(newCustomer.getPanNumber());
            custIden.setPrim_sw("N");

            custIdList.add(custIden);
        }

        if (!StringUtils.isEmpty(newCustomer.getLicense())) {
            CustomerIdentfication custIden = new CustomerIdentfication();
            custIden.setPer_id(cust_id);
            custIden.setId_type_cd("license");
            custIden.setPerIdNbr(newCustomer.getLicense());
            custIden.setPrim_sw("N");

            custIdList.add(custIden);
        }

        return custIdList;
    }

}
