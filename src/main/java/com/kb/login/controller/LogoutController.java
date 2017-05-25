package com.kb.login.controller;

import javax.servlet.http.HttpServletRequest;

import com.kb.employee.entity.EmployeeLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kb.login.entity.Login;

@Controller
public class LogoutController {
	
	@GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, Model model) {
        String usertype = (String)request.getSession().getAttribute("USERTYPE");
		request.getSession().invalidate();
		model.addAttribute("logoutSuccessMsg", "You have been logged out successfully");
		if(!StringUtils.isEmpty(usertype) && usertype.equals("customer")) {
            return new ModelAndView("login", "loginAttributes", new Login());
        }

        return new ModelAndView("employee_login", "newEmpLogin", new EmployeeLogin());
    }
}
