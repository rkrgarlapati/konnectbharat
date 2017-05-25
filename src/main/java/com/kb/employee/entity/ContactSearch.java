package com.kb.employee.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ContactSearch {

	private String contactStatus;
	private String contactCreateDateFrom;
	private String contactCreateDateTo;
	private String contactAssignedTo;
	private String contactType;
	public String getContactStatus() {
		return contactStatus;
	}
	public void setContactStatus(String contactStatus) {
		this.contactStatus = contactStatus;
	}

	public String getContactCreateDateFrom() {
		return contactCreateDateFrom;
	}

	public void setContactCreateDateFrom(String contactCreateDateFrom) {
		this.contactCreateDateFrom = contactCreateDateFrom;
	}

	public String getContactCreateDateTo() {
		return contactCreateDateTo;
	}

	public void setContactCreateDateTo(String contactCreateDateTo) {
		this.contactCreateDateTo = contactCreateDateTo;
	}

	public String getContactAssignedTo() {
		return contactAssignedTo;
	}
	public void setContactAssignedTo(String contactAssignedTo) {
		this.contactAssignedTo = contactAssignedTo;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

    @Override
    public String toString() {
        return "ContactSearch{" +
                "contactStatus='" + contactStatus + '\'' +
                ", contactCreateDateFrom='" + contactCreateDateFrom + '\'' +
                ", contactCreateDateTo='" + contactCreateDateTo + '\'' +
                ", contactAssignedTo='" + contactAssignedTo + '\'' +
                ", contactType='" + contactType + '\'' +
                '}';
    }
}
