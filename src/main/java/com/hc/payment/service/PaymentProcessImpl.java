package com.hc.payment.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import com.hc.payment.model.PaymentRequest;
import com.hc.payment.model.PaymentResponse;

/*http://developer.authorize.net/guides/AIM/wwhelp/wwhimpl/js/html/wwhelp.htm#href=4_TransResponse.6.2.html*/

public class PaymentProcessImpl implements PaymentProcessor{
	
	private static String loginID;
	private static String transactionId;
	private static PaymentProcessImpl instance = null;
	
	protected PaymentProcessImpl(){
		
	}
	
	public static PaymentProcessImpl getInstance(){
		if(instance == null){
			instance = new PaymentProcessImpl();
		}
		return instance;
	}

	public PaymentResponse processPayment(PaymentRequest request) throws Exception{
		
		String urlString = getSandBoxPaymentUrl();
		
		URL url = new URL(urlString);
		
		Hashtable<String,String> keyValuePair = generateUrlParam(request);
		StringBuffer stringToAppend = constructRequestParams(keyValuePair);
		
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		
		connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		DataOutputStream requestObject = new DataOutputStream( connection.getOutputStream() );
		requestObject.write(stringToAppend.toString().getBytes());
		requestObject.flush();
		requestObject.close();

		BufferedReader rawResponse = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String responseData = rawResponse.readLine();
		rawResponse.close();	                     

		String [] responses = responseData.split("\\|");

		int responseIndex = 1;
		PaymentResponse response = new PaymentResponse();
		response.setCompleteResponse(responseData);
		
		for(Iterator<String> iterator=Arrays.asList(responses).iterator(); iterator.hasNext();) {
			switch(responseIndex){
				case 1:
					response.setResponseCode(iterator.next());
					break;
				case  4:
					response.setResponseText(iterator.next());
					break;
				case 7:
					response.setTransactionId(iterator.next());
					break;
				default:
					iterator.next();
					break;
			}
			responseIndex++;
		}	
		return response;
	}
	
	private Hashtable<String,String> generateUrlParam(PaymentRequest request){
		Hashtable<String,String> params = new Hashtable<String,String>();
		
		params.put ("x_login", loginID);
		params.put ("x_tran_key", transactionId);
		  
		params.put ("x_version", "3.1");
		params.put ("x_delim_data", "TRUE");
		params.put ("x_delim_char", "|");
		params.put ("x_relay_response", "FALSE");

		params.put ("x_type", "AUTH_CAPTURE");
		params.put ("x_method", "CC");
		
		params.put ("x_card_num", request.getCardNumber());
		params.put ("x_exp_date", request.getExpirationDate());

		params.put ("x_amount", request.getAmount());
		params.put ("x_description", "101 Yrs Subscription/Gift Payment");

		params.put ("x_first_name", request.getPayeeFirstName());
		params.put ("x_last_name", request.getPayeeLastName());
		params.put ("x_address", request.getPayeeAddress());
		params.put ("x_state", request.getPayeeState());
		params.put ("x_zip", request.getPayeeZip());
		
		return params;
	}
	
	private StringBuffer constructRequestParams(Hashtable<String,String> paramKeys) throws Exception{
		StringBuffer outputString = new StringBuffer();
		Enumeration<String> keys = paramKeys.keys();
		
		while(keys.hasMoreElements() ) {
		  String key = URLEncoder.encode(keys.nextElement().toString(),"UTF-8");
		  String value = URLEncoder.encode(paramKeys.get(key).toString(),"UTF-8");
		  outputString.append(key + "=" + value + "&");
		}
		return outputString;
	}
	
	private String getSandBoxPaymentUrl(){
		loginID = "48cA6KsK";
		transactionId = "38eH95Q6KW3tb6Zt";
		
		return "https://test.authorize.net/gateway/transact.dll";
	}
	
	private String getProdPaymentUrl(){
		loginID = "2Lx47kGE";
		transactionId = "3U76e62wPGAq4WxR";
		
		return "https://secure.authorize.net/gateway/transact.dll";
	}
	
}
