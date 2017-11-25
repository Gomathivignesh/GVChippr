package com.hc.payment.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement
@XmlType(propOrder = { "cardNumber", "expirationDate","amount", "payeeFirstName","payeeLastName", "payeeAddress","payeeState", "payeeZip"})
public class PaymentRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	String cardNumber;
	String expirationDate;
	String amount;
	
	String payeeFirstName;
	String payeeLastName;
	String payeeAddress;
	String payeeState;
	String payeeZip;
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPayeeFirstName() {
		return payeeFirstName;
	}
	public void setPayeeFirstName(String payeeFirstName) {
		this.payeeFirstName = payeeFirstName;
	}
	public String getPayeeLastName() {
		return payeeLastName;
	}
	public void setPayeeLastName(String payeeLastName) {
		this.payeeLastName = payeeLastName;
	}
	public String getPayeeAddress() {
		return payeeAddress;
	}
	public void setPayeeAddress(String payeeAddress) {
		this.payeeAddress = payeeAddress;
	}
	public String getPayeeState() {
		return payeeState;
	}
	public void setPayeeState(String payeeState) {
		this.payeeState = payeeState;
	}
	public String getPayeeZip() {
		return payeeZip;
	}
	public void setPayeeZip(String payeeZip) {
		this.payeeZip = payeeZip;
	}
	
	
	
}
