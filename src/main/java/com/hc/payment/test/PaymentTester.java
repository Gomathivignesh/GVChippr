package com.hc.payment.test;

import com.hc.payment.model.PaymentRequest;
import com.hc.payment.model.PaymentResponse;
import com.hc.payment.service.PaymentProcessImpl;

public class PaymentTester {


	public static void main(String args[]) throws Exception{
		
		PaymentRequest request = new PaymentRequest();
		
		request.setCardNumber("4111111111111111");
		request.setExpirationDate("0115");
		request.setAmount("11.12");
		request.setPayeeFirstName("John1");
		request.setPayeeLastName("Doe");
		request.setPayeeAddress("1234 Street");
		request.setPayeeState("WA");
		request.setPayeeZip("98004");
		
		PaymentProcessImpl paymentAPI = PaymentProcessImpl.getInstance();
		PaymentResponse response = paymentAPI.processPayment(request);
		
		System.out.println(response.getResponseCode() + " " + response.getResponseText() + " " + response.getTransactionId());
		
		request = new PaymentRequest();
		
		request.setCardNumber("4111111111111111");
		request.setExpirationDate("0115");
		request.setAmount("12.12");
		request.setPayeeFirstName("John1");
		request.setPayeeLastName("Doe");
		request.setPayeeAddress("1234 Street");
		request.setPayeeState("WA");
		request.setPayeeZip("98004");
		
		response = paymentAPI.processPayment(request);
		
		System.out.println(response.getResponseCode() + " " + response.getResponseText() + " " + response.getTransactionId());
		
		//Invalid card number
		request = new PaymentRequest();
		
		request.setCardNumber("3111111111111111");
		request.setExpirationDate("0115");
		request.setAmount("12.12");
		request.setPayeeFirstName("John1");
		request.setPayeeLastName("Doe");
		request.setPayeeAddress("1234 Street");
		request.setPayeeState("WA");
		request.setPayeeZip("98004");
		
		response = paymentAPI.processPayment(request);
		
		System.out.println(response.getResponseCode() + " " + response.getResponseText() + " " + response.getTransactionId());
		
		//invalid expiration
		
		request = new PaymentRequest();
		
		request.setCardNumber("4111111111111111");
		request.setExpirationDate("0155");
		request.setAmount("12.12");
		request.setPayeeFirstName("John1");
		request.setPayeeLastName("Doe");
		request.setPayeeAddress("1234 Street");
		request.setPayeeState("WA");
		request.setPayeeZip("98004");
		
		response = paymentAPI.processPayment(request);
		
		System.out.println(response.getResponseCode() + " " + response.getResponseText() + " " + response.getTransactionId());
		
		//Invalid addr
		request = new PaymentRequest();
		
		request.setCardNumber("4111111111111111");
		request.setExpirationDate("0115");
		request.setAmount("12.12");
		request.setPayeeFirstName("John1");
		request.setPayeeLastName("Doe");
		request.setPayeeAddress("1034 Street");
		request.setPayeeState("WA");
		request.setPayeeZip("58004");
		
		response = paymentAPI.processPayment(request);
		
		System.out.println(response.getResponseCode() + " " + response.getResponseText() + " " + response.getTransactionId());
	}
}