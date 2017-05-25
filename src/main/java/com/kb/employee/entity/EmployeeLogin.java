package com.kb.employee.entity;

public class EmployeeLogin {
	
	String emp_login_userid;
	String emp_login_password;
	
	public String getEmp_login_userid() {
		return emp_login_userid;
	}
	public void setEmp_login_userid(String emp_login_userid) {
		this.emp_login_userid = emp_login_userid;
	}
	public String getEmp_login_password() {
		return emp_login_password;
	}
	public void setEmp_login_password(String emp_login_password) {
		this.emp_login_password = emp_login_password;
	}
	@Override
	public String toString() {
		return "EmployeeLogin [emp_login_userid=" + emp_login_userid + ", emp_login_password=" + emp_login_password
				+ "]";
	}
	
	
}
