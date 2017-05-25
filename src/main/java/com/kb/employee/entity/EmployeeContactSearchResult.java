package com.kb.employee.entity;

import java.util.Date;

/**
 * Created by garlapati on 3/25/2017.
 */
public class EmployeeContactSearchResult {

    private String contactId;
    private String contactStatus;
    private String contactType;
    private String contactClass;
    private String contactDate;
    private String assignedDate;
    private String assignedTo;

    public String getContactClass() {
        return contactClass;
    }

    public void setContactClass(String contactClass) {
        this.contactClass = contactClass;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getContactStatus() {
        return contactStatus;
    }

    public void setContactStatus(String contactStatus) {
        this.contactStatus = contactStatus;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContactDate() {
        return contactDate;
    }

    public void setContactDate(String contactDate) {
        this.contactDate = contactDate;
    }

    public String getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}
