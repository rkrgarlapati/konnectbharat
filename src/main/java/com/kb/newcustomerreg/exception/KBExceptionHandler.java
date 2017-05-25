package com.kb.newcustomerreg.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Controller
@ControllerAdvice
public class KBExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource errorMessageSource;



    /*@ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateCustIDException.class)
    protected ModelAndView handleDuplicateCustomerId(WebRequest request, DuplicateCustIDException e) {

        request.setAttribute("errorMsg",e.getExceptionMsg(),request.SCOPE_REQUEST);

        return new ModelAndView("home", "command",new NewCustomer());

        //return "home";
    }*/

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Throwable.class)
    protected String handleSchoolNotFound(WebRequest request, Exception e) {

        request.setAttribute("errorMsg",e.getCause().getCause(),request.SCOPE_REQUEST);

        return "/error";
    }
}
