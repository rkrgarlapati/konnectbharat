package com.kb.login.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kb.common.entity.RidgeAcct;
import com.kb.common.repository.RidgeAcctRepository;
import com.kb.login.entity.LoggedInUser;
import com.kb.login.entity.Login;
import com.kb.login.repository.LoggedInUserRepository;
import com.kb.newcustomerreg.entity.CustomerIdentfication;
import com.kb.newcustomerreg.repository.CustomerIdentificationRepository;

@Controller
public class CustomerLoginController {

    @Autowired
    private CustomerIdentificationRepository custIdRepository;

    @Autowired
    private LoggedInUserRepository loggedInUserRepository;

    @Autowired
    private RidgeAcctRepository ridgeAcctRespository;

    @GetMapping("/login")
    public ModelAndView loginForm(Model m) {

        return new ModelAndView("login", "loginAttributes", new Login());
    }

    @PostMapping("/custlogin")
    @Transactional
    public ModelAndView loginForm(Login login, BindingResult bindingResult,
                                  Model model, HttpSession sessionObj) {

        String userid = login.getUserId();
        String password = login.getPassword();
        LoggedInUser loggedInPerson = null;

        if (userid != null && password != null) {

            loggedInPerson = loggedInUserRepository.findByWebUseridAndWebPassword(userid, password);

            if (( loggedInPerson != null && !StringUtils.isEmpty(loggedInPerson.getPerType())) || loggedInPerson == null) {
                model.addAttribute("errorMsg", "ERROR : Invalid Userid or Password");
                return new ModelAndView("login", "loginAttributes", new Login());
            }
        }

        sessionObj.setAttribute("LOGGEDIN_USER", loggedInPerson.getPerName());
        sessionObj.setAttribute("LOGGEDIN_USER_MOBILE", userid);

        RidgeAcct ridgeAcct = ridgeAcctRespository.findByPerId(loggedInPerson.getPerId());

        sessionObj.setAttribute("LOGGEDIN_USER_ACCT_ID", ridgeAcct.getAcct_id());
        sessionObj.setAttribute("LOGGEDIN_USER_PERID", loggedInPerson.getPerId());
        sessionObj.setAttribute("USERTYPE", "customer");

        return new ModelAndView("redirect:guestFormController");
    }
}
