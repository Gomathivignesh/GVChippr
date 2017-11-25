package com.hc.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hc.enums.PurchaseMethodEnums;
import com.hc.enums.PaymentTypeEnums;

@XmlRootElement
@XmlType(propOrder = {"userId", "resetRequestOn", "resetOn", "resetToken", "email", "pwd"})
public class ResetPassword extends BaseObject implements Serializable{

	private static final long serialVersionUID = 1L;

	int userId;
	Date resetRequestOn;
	Date resetOn;
	String resetToken;
	String email;
	String pwd;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getResetRequestOn() {
		return resetRequestOn;
	}
	public void setResetRequestOn(Date resetRequestOn) {
		this.resetRequestOn = resetRequestOn;
	}
	public Date getResetOn() {
		return resetOn;
	}
	public void setResetOn(Date resetOn) {
		this.resetOn = resetOn;
	}
	public String getResetToken() {
		return resetToken;
	}
	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}	
	
}
