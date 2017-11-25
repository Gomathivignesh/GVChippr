package com.hc.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"sentFrom", "sentTo", "sentFromEmail"})
public class GiftUserInfo extends BaseObject implements Serializable{

	private static final long serialVersionUID = 1L;

	int sentFrom;
	List<String> sentTo;
	String sentFromEmail;
	
	public int getSentFrom() {
		return sentFrom;
	}
	public void setSentFrom(int sentFrom) {
		this.sentFrom = sentFrom;
	}
	public List<String> getSentTo() {
		return sentTo;
	}
	public void setSentTo(List<String> sentTo) {
		this.sentTo = sentTo;
	}
	public String getSentFromEmail() {
		return sentFromEmail;
	}
	public void setSentFromEmail(String sentFromEmail) {
		this.sentFromEmail = sentFromEmail;
	}
	
}
