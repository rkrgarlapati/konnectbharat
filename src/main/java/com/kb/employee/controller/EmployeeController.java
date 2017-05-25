package com.kb.employee.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.kb.customercontact.entity.CustomerContact;
import com.kb.customercontact.repository.CustContactRepository;
import com.kb.employee.entity.*;
import com.kb.newcustomerreg.exception.DuplicateCustIDException;
import com.kb.utility.ValidationEmpContactSearch;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kb.common.entity.RidgeAcct;
import com.kb.common.entity.RidgeSA;
import com.kb.common.repository.RidgeAcctRepository;
import com.kb.common.repository.RidgeSARepository;
import com.kb.matrimony.entity.Matrimony;
import com.kb.matrimony.repository.RidgeSAMatrimonyRepository;
import com.kb.newcustomerreg.entity.Customer;
import com.kb.newcustomerreg.entity.CustomerIdentfication;
import com.kb.newcustomerreg.repository.CustomerIdentificationRepository;
import com.kb.newcustomerreg.repository.CustomerRegisterRepository;
import com.kb.referral.controller.PopulateEditPageData;
import com.kb.rental.entity.Rental;
import com.kb.rental.repository.RidgeSARentalRepository;
import com.kb.sale.entity.Sale;
import com.kb.sale.repository.RidgeSASaleRepository;
import com.kb.utility.GenerateUniqueID;
import com.kb.utility.ValidationUtil;

@Controller
public class EmployeeController {

    @Autowired
    private CustomerRegisterRepository custRegRepository;

    @Autowired
    private CustomerIdentificationRepository custIdRepository;

    @Autowired
    private RidgeAcctRepository ridgeAcctRepository;

    @Autowired
    private ValidationUtil validation;

    @Autowired
    private ValidationEmpContactSearch validationEmpCont;

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

    @Autowired
    private CustContactRepository custContactRepository;

    @RequestMapping(value = "/empregister", method = RequestMethod.GET)
    public ModelAndView empRegistrationForm(Model m) {

        return new ModelAndView("employee_registration", "newEmpRegis", new Employee());
    }

    @Transactional
    @RequestMapping(value = "/newEmpSubmit", method = RequestMethod.POST)
    public ModelAndView newEmpSubmit(Employee employee, Model model, HttpServletRequest request) {

        String cust_id = GenerateUniqueID.INSTANCE.generateRandomNumber(8);
        List<CustomerIdentfication> customerIdentificationList = null;

        try {
            Customer customer = populateEmployeeData(employee, cust_id);
            customerIdentificationList = populateEmployeeIdentficationData(employee, cust_id);

            Customer cust = custRegRepository.findByWebuserid(employee.getEmp_userid());
            if (cust != null) {
                throw new DuplicateCustIDException("This UserID is already registered. Try another.");
            }

            custRegRepository.save(customer);
            custIdRepository.save(customerIdentificationList);
        } catch (Exception exp) {
            request.setAttribute("errorMsg", exp.getMessage());
            return new ModelAndView("employee_registration", "newEmpRegis", employee);
        }
        // return new
        // ModelAndView("employee_login","successRegistration","Successfully
        // Registered..");
        return new ModelAndView("result");
    }

    private List<CustomerIdentfication> populateEmployeeIdentficationData(Employee employee, String cust_id) {

        List<CustomerIdentfication> custIdList = new ArrayList<CustomerIdentfication>();
        CustomerIdentfication custIden = new CustomerIdentfication();
        custIden.setPer_id(cust_id);
        custIden.setId_type_cd("employee");
        custIden.setPerIdNbr(employee.getEmp_accesstype());
        custIden.setPrim_sw("Y");

        custIdList.add(custIden);

        return custIdList;
    }

    private Customer populateEmployeeData(Employee employee, String cust_id) {

        String acct_id = GenerateUniqueID.INSTANCE.generateRandomNumber(8);

        RidgeAcct ridgeAcct = new RidgeAcct();
        ridgeAcct.setAcct_id(acct_id);
        ridgeAcct.setPer_id(cust_id);
        ridgeAcct.setSetup_dt(new Date());

        ridgeAcctRepository.save(ridgeAcct);

        Customer customer = new Customer();
        customer.setPer_id(cust_id);
        customer.setPer_name(employee.getEmp_firstName() + " " + employee.getEmp_lastName());
        customer.setWebuserid(employee.getEmp_userid());
        customer.setWeb_passwd(employee.getEmp_password());
        customer.setPer_or_bus_flg("E");
        customer.setWeb_pwd_hint_flg("so");
        customer.setWeb_passwd_ans("password answer");
        customer.setArea("Area");
        customer.setCity("City");
        customer.setState("State");
        customer.setCreated_by("self");
        customer.setModified_by("self");
        customer.setPer_type("emp");

        return customer;
    }

    @RequestMapping(value = "/emploginPage", method = RequestMethod.GET)
    public ModelAndView empLoginForm(Model m) {

        ModelAndView model = new ModelAndView("employee_login", "newEmpLogin", new EmployeeLogin());
        Map<String, Object> modelMap = new HashMap<>();
        model.addAllObjects(modelMap);
        return model;
    }

    @RequestMapping(value = "/referralSearch", method = RequestMethod.GET)
    public ModelAndView referralSearch(ReferralSearch referral, BindingResult bindingResult, HttpServletRequest request,
                                       Model m) {
        String userRole = (String) request.getSession().getAttribute("USER_ROLE");
        ModelAndView model = new ModelAndView("referral_search", "referralSearchForm", new ReferralSearch());
        Map<String, Object> modelMap = new HashMap<>();
        model.addAllObjects(modelMap);
        return model;
    }

    @RequestMapping(value = "/contactSearch", method = RequestMethod.GET)
    public ModelAndView contactSearch(Model m) {

        ModelAndView model = new ModelAndView("contact_search", "contactSearchForm", new ContactSearch());
        Map<String, Object> modelMap = new HashMap<>();
        model.addAllObjects(modelMap);
        return model;
    }

    @PostMapping(value = "/referralSearchSubmit")
    public ModelAndView referralSearchSubmit(@ModelAttribute("referralSearchForm") @Valid ReferralSearch referral,
                                             BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request, Model m) {

        String userRole = (String) request.getSession().getAttribute("USER_ROLE");

        validation.setReferralSearchValues(userRole);
        validation.validate(referral, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ModelAndView("referral_search", "referralSearchForm", referral);
        }

        List<Object[]> ridgeSAList = null;
        request.setAttribute("pagetype", referral.getReferralType());
        if (referral.getReferralType().equals("GROOM") || referral.getReferralType().equals("BRIDE")) {
            if (StringUtils.isEmpty(referral.getReferralUserid())) {
                if (StringUtils.isEmpty(referral.getReferralLocation())) {
                    ridgeSAList = ridgeSARepository.getAgreementDetailsByCityAndTypeForMatrimony(
                            referral.getReferralCity(), referral.getReferralType(), referral.getReferralStatus());
                } else {
                    ridgeSAList = ridgeSARepository.getAgreementDetailsByCityAreaAndTypeForMatrimony(
                            referral.getReferralCity(), referral.getReferralLocation(), referral.getReferralType(), referral.getReferralStatus());
                }
            } else {
                if (StringUtils.isEmpty(referral.getReferralLocation())) {
                    ridgeSAList = ridgeSARepository.getAgreementDetailsByCityAndTypeForMatrimonyWithUserID(
                            referral.getReferralCity(), referral.getReferralType(), referral.getReferralStatus(), referral.getReferralUserid());
                } else {
                    ridgeSAList = ridgeSARepository.getAgreementDetailsByCityAreaAndTypeForMatrimonyWithUserID(
                            referral.getReferralCity(), referral.getReferralLocation(), referral.getReferralType(), referral.getReferralStatus(), referral.getReferralUserid());
                }
            }
            return new ModelAndView("common_searchresult", "searchResultList", getEmpMatrimonySearch(ridgeSAList));
        } else if (referral.getReferralType().equals("TENANT") || referral.getReferralType().equals("OWNER")) {
            if (StringUtils.isEmpty(referral.getReferralUserid())) {
                if (StringUtils.isEmpty(referral.getReferralLocation())) {
                    ridgeSAList = ridgeSARepository.getAgreementDetailsByCityAndTypeForTenant(
                            referral.getReferralCity(), referral.getReferralType(), referral.getReferralStatus());
                } else {
                    ridgeSAList = ridgeSARepository.getAgreementDetailsByCityAreaAndTypeForTenant(
                            referral.getReferralCity(), referral.getReferralLocation(), referral.getReferralType(), referral.getReferralStatus());
                }
            } else {
                if (StringUtils.isEmpty(referral.getReferralLocation())) {
                    ridgeSAList = ridgeSARepository.getAgreementDetailsByCityAndTypeForTenantWithUserID(
                            referral.getReferralCity(), referral.getReferralType(), referral.getReferralStatus(), referral.getReferralUserid());
                } else {
                    ridgeSAList = ridgeSARepository.getAgreementDetailsByCityAreaAndTypeForTenantWithUserID(
                            referral.getReferralCity(), referral.getReferralLocation(), referral.getReferralType(), referral.getReferralStatus(), referral.getReferralUserid());
                }
            }
            return new ModelAndView("common_searchresult", "searchResultList", getEmpRentalSearch(ridgeSAList));
        } else {
            if (StringUtils.isEmpty(referral.getReferralUserid())) {
                if (StringUtils.isEmpty(referral.getReferralLocation())) {
                    ridgeSAList = ridgeSARepository.getAgreementDetailsByCityAndTypeForSale(
                            referral.getReferralCity(), referral.getReferralType(), referral.getReferralStatus());
                } else {
                    ridgeSAList = ridgeSARepository.getAgreementDetailsByCityAreaAndTypeForSale(
                            referral.getReferralCity(), referral.getReferralLocation(), referral.getReferralType(), referral.getReferralStatus());
                }
            } else {
                if (StringUtils.isEmpty(referral.getReferralLocation())) {
                    ridgeSAList = ridgeSARepository.getAgreementDetailsByCityAndTypeForSaleWithUserID(
                            referral.getReferralCity(), referral.getReferralType(), referral.getReferralStatus(), referral.getReferralUserid());
                } else {
                    ridgeSAList = ridgeSARepository.getAgreementDetailsByCityAreaAndTypeForSaleWithUserID(
                            referral.getReferralCity(), referral.getReferralLocation(), referral.getReferralType(), referral.getReferralStatus(), referral.getReferralUserid());
                }
            }
            return new ModelAndView("common_searchresult", "searchResultList", getEmpRentalSearch(ridgeSAList));
        }
    }

    private List<RentSaleSearchResult> getEmpRentalSearch(List<Object[]> ridgeSAList) {
        List<RentSaleSearchResult> list = new ArrayList<>();
        try {

            RentSaleSearchResult rs = null;
            for (Object[] elements : ridgeSAList) {
                rs = new RentSaleSearchResult();
                rs.setSaID(getString(elements[0]));
                rs.setArea(getString(elements[1]));
                rs.setStatusFlg(getString(elements[2]));
                rs.setStartDate(getString(elements[3]));
                rs.setActualPartyName(getString(elements[4]));
                rs.setActualPartyConotact(getString(elements[5]));
                rs.setAmount(((elements[6] == null) ? Double.valueOf(0.0) : Double.valueOf(String.valueOf(elements[6]))));
                rs.setMobile(getString(elements[7]));

                list.add(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private List<MatrimonySearchResult> getEmpMatrimonySearch(List<Object[]> ridgeSAList) {
        List<MatrimonySearchResult> list = new ArrayList<>();
        try {

            MatrimonySearchResult msr = null;
            for (Object[] elements : ridgeSAList) {
                msr = new MatrimonySearchResult();
                msr.setSaID(getString(elements[0]));
                msr.setArea(getString(elements[1]));
                msr.setStatusFlg(getString(elements[2]));
                msr.setStartDate(getString(elements[3]));
                msr.setActualPartyName(getString(elements[4]));
                msr.setActualPartyConotact(getString(elements[5]));
                msr.setDob(getString(elements[6]));
                msr.setReligion(getString(elements[7]));
                msr.setEmployment(getString(elements[8]));
                msr.setMobile(getString(elements[9]));

                list.add(msr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private String getDateString(Date date) {
        String value = "";
        if (date != null) {
            value = date.toString();
        }

        return value;
    }

    @PostMapping(value = "/contactSearchSubmit")
    public ModelAndView performContactSearch(@ModelAttribute("contactSearchForm") @Valid ContactSearch conSearch, BindingResult bindingResult, HttpServletRequest request) {
        request.setAttribute("pagetype", "contact");

        String userRole = (String) request.getSession().getAttribute("USER_ROLE");

        validationEmpCont.setReferralSearchValues(userRole);
        validationEmpCont.validate(conSearch, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ModelAndView("contact_search", "contactSearchForm", conSearch);
        }

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fromDate = null;
        Date toDate = null;
        try {
            fromDate = df.parse(conSearch.getContactCreateDateFrom());
            toDate = df.parse(conSearch.getContactCreateDateTo());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Object[]> contactList = null;

        if (StringUtils.isEmpty(conSearch.getContactAssignedTo()) && StringUtils.isEmpty(conSearch.getContactType())) {
            contactList = custContactRepository.getStatusAndDatetimeBetween(conSearch.getContactStatus(),
                    fromDate, toDate);
        } else if (StringUtils.isEmpty(conSearch.getContactType())) {
            contactList = custContactRepository.getStatusAndAssignedToAndDatetimeBetween(conSearch.getContactStatus(),
                    conSearch.getContactAssignedTo(), fromDate, toDate);
        } else if (StringUtils.isEmpty(conSearch.getContactAssignedTo())) {
            contactList = custContactRepository.getStatusAndContactTypeAndDatetimeBetween(conSearch.getContactStatus(),
                    conSearch.getContactType(), fromDate, toDate);
        } else {
            contactList = custContactRepository.getStatusAndAssignedToAndCommunicationclassAndDatetimeBetween(conSearch.getContactStatus(),
                    conSearch.getContactAssignedTo(), conSearch.getContactType(), fromDate, toDate);
        }

        return new ModelAndView("common_searchresult", "searchResultList", getEmpContactSearch(contactList));
    }

    private List<EmployeeContactSearchResult> getEmpContactSearch(List<Object[]> ridgeSAList) {
        List<EmployeeContactSearchResult> list = new ArrayList<>();
        try {

            EmployeeContactSearchResult rs = null;
            for (Object[] elements : ridgeSAList) {
                rs = new EmployeeContactSearchResult();
                rs.setContactId(getString(elements[0]));
                rs.setContactStatus(getString(elements[1]));
                rs.setContactClass(getString(elements[2]));
                rs.setContactType(getString(elements[3]));
                rs.setContactDate(getString(elements[4]));
                rs.setAssignedDate(getString(elements[5]));
                rs.setAssignedTo(getString(elements[6]));

                list.add(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public String getString(Object obj) {
        String value = "";
        if (obj != null) {
            value = obj.toString();
        }

        return value;
    }

    @GetMapping(value = "/getDrilldownPg/{page}/{referralvalue}")
    public String getDrilldownPg(Model model, @PathVariable("page") String pageType,
                                 @PathVariable("referralvalue") String saId, HttpServletRequest request) {

        RidgeSA ridgeSA = ridgeSARepository.findOne(saId);
        String page = "";
        if (!"contact".equals(pageType)) {
            if (pageType.equals("TENANT") || pageType.equals("OWNER")) {
                Rental rental = populateData.populateRentalEntity(ridgeSARentalRepository, saId, ridgeSA);
                model.addAttribute("rentAttributes", rental);
                page = "emp_rentalform";
            } else if (pageType.equals("SELL") || pageType.equals("BUY")) {
                Sale sale = populateData.populateSaleEntity(ridgeSASaleRepository, saId, ridgeSA);
                model.addAttribute("saleAttributes", sale);
                page = "emp_saleform";
            } else {
                Matrimony matrimony = populateData.populateMatrimonyEntity(ridgeSAMatriRepository, saId, ridgeSA);
                model.addAttribute("matrimonyAttributes", matrimony);
                model.addAttribute("matriDOB", matrimony.getDob());
                page = "emp_matriform";
            }
            request.getSession().setAttribute("LOGGEDIN_USER_ACCT_ID", ridgeSA.getAcctId());
            model.addAttribute("saId", saId);
            model.addAttribute("agreement_type", pageType);
            model.addAttribute("updateFlag", "update");
            model.addAttribute("start_dt", ridgeSA.getStart_dt());
            String statusFlag = ridgeSA.getStatusflg();
            if ("10".equals(statusFlag)) {
                model.addAttribute("activate", "activate");
            }
        } else {
            CustomerContact customerContact = custContactRepository.findOne(saId);
            model.addAttribute("custContactAttributes", customerContact);
            page = "emp_customer_contact";
        }

        request.setAttribute("ispopup", "true");

        return page;
    }
}
