package com.kb.utility;

import com.kb.employee.entity.ContactSearch;
import com.kb.employee.entity.ReferralSearch;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidationEmpContactSearch implements Validator {

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
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContactSearch referral = (ContactSearch) target;
        if ("Level_1".equalsIgnoreCase(userRole)) {
            if (!isFieldAvailable(referral.getContactAssignedTo())) {
                errors.rejectValue("contactAssignedTo", "contactAssignedTo", "Plese enter Assigned To ");
            }
        }
    }
}
