package com.kb.employee.entity;

public class ReferralSearch {
	
	private String referralType;
	private String referralCity;
	private String referralLocation;
	private String referralStatus;
	private String referralUserid;
	public String getReferralType() {
		return referralType;
	}
	public void setReferralType(String referralType) {
		this.referralType = referralType;
	}
	public String getReferralCity() {
		return referralCity;
	}
	public void setReferralCity(String referralCity) {
		this.referralCity = referralCity;
	}
	public String getReferralLocation() {
		return referralLocation;
	}
	public void setReferralLocation(String referralLocation) {
		this.referralLocation = referralLocation;
	}
	public String getReferralStatus() {
		return referralStatus;
	}
	public void setReferralStatus(String referralStatus) {
		this.referralStatus = referralStatus;
	}
	public String getReferralUserid() {
		return referralUserid;
	}
	public void setReferralUserid(String referralUserid) {
		this.referralUserid = referralUserid;
	}
	@Override
	public String toString() {
		return "ReferralSearch [referralType=" + referralType + ", referralCity=" + referralCity + ", referralLocation="
				+ referralLocation + ", referralStatus=" + referralStatus + ", referralUserid=" + referralUserid + "]";
	}
}
