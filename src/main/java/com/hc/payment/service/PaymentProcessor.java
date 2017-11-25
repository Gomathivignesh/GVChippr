package com.hc.payment.service;

import com.hc.payment.model.PaymentRequest;
import com.hc.payment.model.PaymentResponse;


public interface PaymentProcessor {

	public PaymentResponse processPayment(PaymentRequest request) throws Exception;
	
}
