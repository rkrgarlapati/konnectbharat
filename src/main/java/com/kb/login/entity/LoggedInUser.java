package com.kb.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RIDGE_PER")
public class LoggedInUser{
	
	@Id
	@Column(name="per_id")
	private String perId;
	
	@Column(name="per_name")
	private String perName;
	
	@Column(name="web_userid")
	private String webUserid;

	@Column(name="web_passwd")
	private String webPassword;

	@Column(name="per_type")
	private String perType;

	public String getPerType() {
		return perType;
	}

	public void setPerType(String perType) {
		this.perType = perType;
	}

	public String getWebUserid() {
		return webUserid;
	}

	public void setWebUserid(String webUserid) {
		this.webUserid = webUserid;
	}

	public String getPerId() {
		return perId;
	}

	public void setPerId(String perId) {
		this.perId = perId;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getWebPassword() {
		return webPassword;
	}

	public void setWebPassword(String webPassword) {
		this.webPassword = webPassword;
	}

	@Override
	public String toString() {
		return "LoggedInUser [perId=" + perId + ", perName=" + perName + ", webPassword=" + webPassword + "]";
	}
}