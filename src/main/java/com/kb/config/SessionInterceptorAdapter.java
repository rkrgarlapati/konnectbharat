package com.kb.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * Created by garlapati on 10/20/2016.
 */
@Component
public class SessionInterceptorAdapter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Object user = request.getSession().getAttribute("LOGGEDIN_USER");

		if ((request.getRequestURI().equals("/login") 
				|| request.getRequestURI().equals("/newcustomerRegistration") 
				|| request.getRequestURI().equals("/newCustomerRegis")
				|| request.getRequestURI().equals("/newEmpSubmit")
				|| request.getRequestURI().equals("/emplogin")
				|| request.getRequestURI().equals("/emploginPage")
				|| request.getRequestURI().equals("/empregister")) && 
				(request.getMethod().equals("GET") || request.getMethod().equals("POST"))) {
			return true;
		}
		if (user == null) {
			
			response.sendRedirect("/login");
			return false;
		} 
		
		return true;
	}
}