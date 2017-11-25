package com.hc.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"annualSubscription", "noOfOrders", "giftSubscription", "bonusSubscription", 
					  "amountDue", "transactionId", "emailId"})
public class GiftPurchaseInfoHistory extends BaseObject  implements Serializable{

	private static final long serialVersionUID = 1L;

	int annualSubscription;
	int noOfOrders;
	int giftSubscription;
	int bonusSubscription;
	int amountDue;
	String transactionId;
	String emailId;
	
	public int getAnnualSubscription() {
		return annualSubscription;
	}
	public void setAnnualSubscription(int annualSubscription) {
		this.annualSubscription = annualSubscription;
	}
	public int getNoOfOrders() {
		return noOfOrders;
	}
	public void setNoOfOrders(int noOfOrders) {
		this.noOfOrders = noOfOrders;
	}
	public int getGiftSubscription() {
		return giftSubscription;
	}
	public void setGiftSubscription(int giftSubscription) {
		this.giftSubscription = giftSubscription;
	}
	public int getBonusSubscription() {
		return bonusSubscription;
	}
	public void setBonusSubscription(int bonusSubscription) {
		this.bonusSubscription = bonusSubscription;
	}
	public int getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(int amountDue) {
		this.amountDue = amountDue;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
