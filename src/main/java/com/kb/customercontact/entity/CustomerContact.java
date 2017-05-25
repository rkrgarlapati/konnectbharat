package com.kb.customercontact.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "RIDGE_CUSTOMER_CONTACT")
public class CustomerContact {
    @Id
    @Column(name = "COMMUNICATION_ID")
    private String communicationId;
    @Column(name = "AGREEMENT_ID")
    private String agreementId;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_TIME")
    private Date datetime;
    @Column(name = "COMMUNICATION_CLASS")
    private String communicationclass;
    @Column(name = "COMMUNICATION_TYPE")
    private String communicationtype;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "PRIORITY")
    private String priority;
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "ASSIGNED_TO")
    private String assignedTo;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ASSIGNED_DATE")
    private Date assignedDate;


    public String getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(String communicationId) {
        this.communicationId = communicationId;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getCommunicationclass() {
        return communicationclass;
    }

    public void setCommunicationclass(String communicationclass) {
        this.communicationclass = communicationclass;
    }

    public String getCommunicationtype() {
        return communicationtype;
    }

    public void setCommunicationtype(String communicationtype) {
        this.communicationtype = communicationtype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    @Override
    public String toString() {
        return "CustomerContact{" +
                "communicationId='" + communicationId + '\'' +
                ", agreementId='" + agreementId + '\'' +
                ", datetime=" + datetime +
                ", communicationClass='" + communicationclass + '\'' +
                ", communicationtype='" + communicationtype + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", comments='" + comments + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                ", assignedDate=" + assignedDate +
                '}';
    }
}
