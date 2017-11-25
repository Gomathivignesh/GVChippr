package com.hc.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hc.enums.EmailTypeEnums;

@XmlRootElement
@XmlType(propOrder = {"subject","body","emailType","userEmail"})
public class Email implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String subject;
	private String body;
	private EmailTypeEnums emailType;
	private String userEmail;
	
	public Email() {

	}
	
	public EmailTypeEnums getEmailType() {
		return emailType;
	}

	public void setEmailType(EmailTypeEnums emailType) {
		this.emailType = emailType;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}	

}
