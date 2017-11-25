package com.hc.payment.model;

import java.io.Serializable;

public class PaymentResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	String responseCode;
	String responseText;
	String transactionId;
	String completeResponse;
	
	public String getCompleteResponse() {
		return completeResponse;
	}
	public void setCompleteResponse(String completeResponse) {
		this.completeResponse = completeResponse;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseText() {
		return responseText;
	}
	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	
	
}
