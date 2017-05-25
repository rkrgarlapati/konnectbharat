package com.kb.utility;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kb.employee.entity.ReferralSearch;

@Component
public class ValidationUtil implements Validator {

    private String userRole;

    public void setReferralSearchValues(String userRole) {
        this.userRole = userRole;
    }

    static boolean isFieldAvailable(String field) {
        if (!StringUtils.isEmpty(field)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ReferralSearch referral = (ReferralSearch) target;
        if ("Level_1".equalsIgnoreCase(userRole)) {
            if (!isFieldAvailable(referral.getReferralCity())) {
                errors.rejectValue("referralCity", "referralCity", "Plese enter city ");
            }
            if (!isFieldAvailable(referral.getReferralLocation())) {
                errors.rejectValue("referralLocation", "referralLocation", "Please enter location");
            }
        }
        if ("Level_2".equalsIgnoreCase(userRole) || "Level_3".equalsIgnoreCase(userRole)) {
            if (!isFieldAvailable(referral.getReferralCity())) {
                errors.rejectValue("referralCity", "referralCity", "Plese enter city");
            }
        }
    }
}
