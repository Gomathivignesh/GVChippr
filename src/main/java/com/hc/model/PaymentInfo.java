package com.hc.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hc.enums.PurchaseMethodEnums;
import com.hc.enums.PaymentTypeEnums;

@XmlRootElement
@XmlType(propOrder = {"id", "emailId", "billedAmount", "transactionId", 
					  "otherDetails", "purchaseMethod", "paymentType","giftAmount"})
public class PaymentInfo extends BaseObject implements Serializable{

	private static final long serialVersionUID = 1L;

	String id;
	String emailId;
	String billedAmount;
	String transactionId;
	String otherDetails;
	PurchaseMethodEnums purchaseMethod;
	PaymentTypeEnums paymentType;
	int giftAmount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getBilledAmount() {
		return billedAmount;
	}
	public void setBilledAmount(String billedAmount) {
		this.billedAmount = billedAmount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	public PurchaseMethodEnums getPurchaseMethod() {
		return purchaseMethod;
	}
	public void setPurchaseMethod(PurchaseMethodEnums purchaseMethod) {
		this.purchaseMethod = purchaseMethod;
	}
	public PaymentTypeEnums getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentTypeEnums paymentType) {
		this.paymentType = paymentType;
	}
	public int getGiftAmount() {
		return giftAmount;
	}
	public void setGiftAmount(int giftAmount) {
		this.giftAmount = giftAmount;
	}
	
}
