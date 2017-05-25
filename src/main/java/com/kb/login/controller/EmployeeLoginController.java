package com.kb.login.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.kb.login.entity.Login;
import com.kb.newcustomerreg.entity.CustomerIdentfication;
import com.kb.newcustomerreg.repository.CustomerIdentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kb.common.entity.RidgeAcct;
import com.kb.common.repository.RidgeAcctRepository;
import com.kb.employee.entity.EmployeeIdentfication;
import com.kb.employee.entity.EmployeeLogin;
import com.kb.employee.repository.EmployeeIdentificationRepository;
import com.kb.login.entity.LoggedInUser;
import com.kb.login.repository.LoggedInUserRepository;

import java.util.List;

@Controller
public class EmployeeLoginController {

    @Autowired
    private LoggedInUserRepository loggedInUserRepository;

    @Autowired
    private EmployeeIdentificationRepository empIdRepository;

    @Autowired
    private RidgeAcctRepository ridgeAcctRespository;

    @Autowired
    private CustomerIdentificationRepository custIdRepository;

    @PostMapping("/emplogin")
    @Transactional
    public ModelAndView loginForm(@ModelAttribute("newEmpLogin") @Valid EmployeeLogin login, Model model, HttpSession sessionObj) {
        String userid = login.getEmp_login_userid();
        String password = login.getEmp_login_password();
        LoggedInUser loggedInPerson = null;
        if (userid != null && password != null) {

            loggedInPerson = loggedInUserRepository.findByWebUseridAndWebPassword(userid, password);

            if (( loggedInPerson != null && StringUtils.isEmpty(loggedInPerson.getPerType())) || loggedInPerson == null) {
                model.addAttribute("errorMsg", "ERROR : Invalid Userid or Password");
                return new ModelAndView("employee_login", "newEmpLogin", new EmployeeLogin());
            }

            EmployeeIdentfication custId = empIdRepository.findByPerId(loggedInPerson.getPerId()).get(0);
            sessionObj.setAttribute("LOGGEDIN_USER", loggedInPerson.getPerName());
            sessionObj.setAttribute("LOGGEDIN_USER_PERID", loggedInPerson.getPerId());
            sessionObj.setAttribute("USER_ROLE", custId.getPerIdNbr());
            sessionObj.setAttribute("USERTYPE", "employee");
        }

        return new ModelAndView("redirect:referralSearch");
    }
}
